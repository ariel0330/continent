'use strict';
var continentWeb = angular.module('continentWeb', [ 'ngResource','ngRoute', 'ngCookies','continentWeb.services'
                                                    ,
                                          		'angularUtils.directives.dirPagination','ui.bootstrap']);

continentWeb.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
			
			$routeProvider.when('/informeSubA', {
				templateUrl: 'partials/InformeSuscripciones/listarA.html',
				controller: InformeSubAltaController
			});
			
			$routeProvider.when('/informeSubADiaria', {
				templateUrl: 'partials/InformeSuscripciones/listarA.html',
				controller: InformeSubAltaDiarioController
			});
			
			$routeProvider.when('/informeCobro', {
				templateUrl: 'partials/informeCobro/listar.html',
				controller: InformeCobroController
			});
			
			$routeProvider.when('/informeSms', {
				templateUrl: 'partials/informeSms/listar.html',
				controller: InformeMensajesController
			});
			
			$routeProvider.when('/informeSmsDiaria', {
				templateUrl: 'partials/informeSms/listar.html',
				controller: InformeMensajesDiaController
			});
			
			$routeProvider.when('/informeSubB', {
				templateUrl: 'partials/InformeSuscripciones/listarB.html',
				controller: InformeSubBajaController
			});
			
			$routeProvider.when('/informeSubBDiaria', {
				templateUrl: 'partials/InformeSuscripciones/listarB.html',
				controller: InformeSubBajaDiariaController
			});
			
			
			$routeProvider.when('/crearCliente', {
				templateUrl: 'partials/cliente/crear.html',
				controller: CrearClienteController
			});
			
			$routeProvider.when('/editoCliente/:id', {
				templateUrl: 'partials/cliente/editar.html',
				controller: EditarClienteController
			});

			$routeProvider.when('/clientes', {
				templateUrl: 'partials/cliente/listar.html',
				controller: ClienteController
			});
			
			
			$routeProvider.when('/crearServicio', {
				templateUrl: 'partials/servicio/crear.html',
				controller: CrearServicioController
			});
			
			$routeProvider.when('/editoServicio/:id', {
				templateUrl: 'partials/servicio/editar.html',
				controller: EditarServicioController
			});

			$routeProvider.when('/servicios', {
				templateUrl: 'partials/servicio/listar.html',
				controller: ServicioController
			});
			
			
			$routeProvider.when('/crearClub', {
				templateUrl: 'partials/club/crear.html',
				controller: CrearClubController
			});
			
			$routeProvider.when('/editoClub/:id', {
				templateUrl: 'partials/club/editar.html',
				controller: EditarClubController
			});

			$routeProvider.when('/clubes', {
				templateUrl: 'partials/club/listar.html',
				controller: ClubController
			});
			
			
			$routeProvider.when('/createOperador', {
				templateUrl: 'partials/operador/crear.html',
				controller: CrearOperadorController
			});
			
			$routeProvider.when('/editoperador/:id', {
				templateUrl: 'partials/operador/editar.html',
				controller: EditarOperadorController
			});

			$routeProvider.when('/operadores', {
				templateUrl: 'partials/operador/listar.html',
				controller: OperadorController
			});
			
			$routeProvider.when('/createUsuario', {
				templateUrl: 'partials/usuario/crear.html',
				controller: CreateUsuarioController
			});
			
			$routeProvider.when('/edit/:id', {
				templateUrl: 'partials/edit.html',
				controller: EditController
			});
			
			$routeProvider.when('/editUser/:id', {
				templateUrl: 'partials/usuario/editar.html',
				controller: EditUserController
			});

			$routeProvider.when('/usuarios', {
				templateUrl: 'partials/usuario/listar.html',
				controller: UserController
			});
			
			$routeProvider.when('/login', {
				templateUrl: 'partials/login.html',
				controller: LoginController
			});
			
			$routeProvider.otherwise({
				templateUrl: 'partials/index.html',
				controller: IndexController
			});
			
			$locationProvider.hashPrefix('!');

		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
			        return {
			        	'responseError': function(rejection) {
			        		var status = rejection.status;
			        		var config = rejection.config;
			        		var method = config.method;
			        		var url = config.url;
			      
			        		if (status == 401) {
			        			$location.path( "/login" );
			        		} else {
			        			$rootScope.error = method + " on " + url + " failed with status " + status;
			        		}
			              
			        		return $q.reject(rejection);
			        	}
			        };
			    }
		    );

		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
		        return {
		        	'request': function(config) {
		        		var isRestCall = config.url.indexOf('rest') == 0;
		        		if (isRestCall  && angular.isDefined($rootScope.authToken)) {
		        			var authToken = $rootScope.authToken;
		        			if (exampleAppConfig.useAuthTokenHeader) {
		        				config.headers['X-Auth-Token'] = authToken;
		        			} else {
		        				config.url = config.url + "?token=" + authToken;
		        			}
		        		}
		        		return config || $q.when(config);
		        	}
		        };
		    }
	    );
		   
		} ]
		
	).run(function($rootScope, $location, $cookieStore, UserService) {
		
		/* Reset error when a new view is loaded */
		$rootScope.$on('$viewContentLoaded', function() {
			delete $rootScope.error;
		});
		
		$rootScope.hasRole = function(role) {
			
			if ($rootScope.user === undefined) {
				return false;
			}
			
			if ($rootScope.user.roles[role] === undefined) {
				return false;
			}
			
			return $rootScope.user.roles[role];
		};
		
		$rootScope.logout = function() {
			delete $rootScope.user;
			delete $rootScope.authToken;
			$cookieStore.remove('authToken');
			$location.path("/login");
		};
		
		 /* Retorna el valor del usuario de la cokie  */
		var originalPath = $location.path();
		$location.path("/login");
		var authToken = $cookieStore.get('authToken');
		if (authToken !== undefined) {
			$rootScope.authToken = authToken;
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path(originalPath);
			});
		}
		
		$rootScope.initialized = true;
	});





continentWeb.controller('ModalInstanceCtrl', function ($scope, $modalInstance, items) {

	  $scope.items = items;
	  $scope.selected = {
	    item: $scope.items[0]
	  };

	  $scope.ok = function () {
	    $modalInstance.close($scope.selected.item);
	  };

	  $scope.cancel = function () {
	    $modalInstance.dismiss('cancel');
	  };
	});


continentWeb.controller('paginaCtrl', function ($scope,$http) {


	$scope.pageChangeHandler = function(num) {

		console.log('going to page ' + num);

	};
	});
