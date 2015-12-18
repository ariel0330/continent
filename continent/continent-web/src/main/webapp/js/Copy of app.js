angular.module('exampleApp', ['ngRoute', 'ngCookies', 'exampleApp.services',
                              'angularUtils.directives.dirPagination','ui.bootstrap'])
	.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
			
//			$routeProvider.when('/create', {
//				templateUrl: 'partials/create.html',
//				controller: CreateController
//			});
			
			
			$routeProvider.when('/informeSubA', {
				templateUrl: 'partials/InformeSuscripciones/listarA.html',
				controller: InformeSubAltaController
			});
			
			$routeProvider.when('/informeSubB', {
				templateUrl: 'partials/InformeSuscripciones/listarB.html',
				controller: InformeSubBajaController
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
			
			/* Register error provider that shows message on failed requests or redirects to login page on
			 * unauthenticated requests */
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
		    
		    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
		     * as soon as there is an authenticated user */
		    $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
		        return {
		        	'request': function(config) {
		        		var isRestCall = config.url.indexOf('rest') == 0;
		        		if (isRestCall && angular.isDefined($rootScope.authToken)) {
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
		
		 /* Try getting valid user from cookie or go to login page */
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


function IndexController($scope, $modal, $log) {
	
	 $scope.items = ['item1', 'item2', 'item3'];

	  $scope.animationsEnabled = true;

	  $scope.open = function (size) {

	    var modalInstance = $modal.open({
	      animation: $scope.animationsEnabled,
	      templateUrl: 'partials/cliente/crear.html',
	      controller: 'ModalInstanceCtrl',
	      size: size,
	      resolve: {
	        items: function () {
	          return $scope.items;
	        }
	      }
	    });

	    modalInstance.result.then(function (selectedItem) {
	      $scope.selected = selectedItem;
	    }, function () {
	      $log.info('Modal dismissed at: ' + new Date());
	    });
	  };

	  $scope.toggleAnimation = function () {
	    $scope.animationsEnabled = !$scope.animationsEnabled;
	  };
	  
};


//function ModalInstanceCtrl($scope, $modalInstance, items) {
//	
//	$scope.items = items;
//	  $scope.selected = {
//	    item: $scope.items[0]
//	  };
//
//	  $scope.ok = function () {
//	    $modalInstance.close($scope.selected.item);
//	  };
//
//	  $scope.cancel = function () {
//	    $modalInstance.dismiss('cancel');
//	  };
//};




function EditarClienteController($scope, $routeParams, $location, servicioCliente) {

	
	$scope.newsEntry = servicioCliente.get({id: $routeParams.id},function (data,status) {
    	var dataId=''+data.estado;
        $scope.valor = { id: dataId };
    });
	
//	$scope.newsEntry = servicioServicio.get({id: $routeParams.id});
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/clientes');
		});
	};
};
function CrearClienteController($scope, $location, servicioCliente) {
	
	$scope.newsEntry = new servicioCliente();
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/clientes');
		});
	};
};



function InformeSubAltaController($scope, servicioInformeSus,servicioClub,servicioOperador) {
	
	$scope.newsEntries = servicioInformeSus.query({id: 1});
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.deleteEntry = function(SuscriptionDTO) {
		SuscriptionDTO.$remove(function() {
			$scope.newsEntries = servicioInformeSus.query();
		});
	};
	
	$scope.buscar = function() {
		if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
		{
			$scope.tipoClub=0;
		}
		if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
		{
			$scope.operadorID=0;
		}
		
		$scope.newsEntries = servicioInformeSus.query({id: 1,clubID: $scope.tipoClub, operadorID:$scope.operadorID});
	};
	
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};

function InformeSubBajaController($scope, servicioInformeSus,servicioClub,servicioOperador) {
	
	$scope.newsEntries = servicioInformeSus.query({id: 2});
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.deleteEntry = function(SuscriptionDTO) {
		SuscriptionDTO.$remove(function() {
			$scope.newsEntries = servicioInformeSus.query();
		});
	};
	
	$scope.buscar = function() {
		if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
		{
			$scope.tipoClub=0;
		}
		if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
		{
			$scope.operadorID=0;
		}
		
		$scope.newsEntries = servicioInformeSus.query({id: 2,clubID: $scope.tipoClub, operadorID:$scope.operadorID});
	};
	
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};

function ClienteController($scope, servicioCliente) {
	
	$scope.newsEntries = servicioCliente.query();
	
	$scope.deleteEntry = function(ServicioDTO) {
		ServicioDTO.$remove(function() {
			$scope.newsEntries = servicioCliente.query();
		});
	};
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};



function EditarServicioController($scope, $routeParams, $location, servicioServicio) {

	
	$scope.newsEntry = servicioServicio.get({id: $routeParams.id},function (data,status) {
    	var dataId=''+data.estado;
        $scope.valor = { id: dataId };
    });
	
//	$scope.newsEntry = servicioServicio.get({id: $routeParams.id});
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/servicios');
		});
	};
};
function CrearServicioController($scope, $location, servicioServicio) {
	
	$scope.newsEntry = new servicioServicio();
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/servicios');
		});
	};
};
function ServicioController($scope, servicioServicio) {
	
	$scope.newsEntries = servicioServicio.query();
	
	$scope.deleteEntry = function(ServicioDTO) {
		ServicioDTO.$remove(function() {
			$scope.newsEntries = servicioServicio.query();
		});
	};
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};



function EditController($scope, $routeParams, $location, NewsService) {

	$scope.newsEntry = NewsService.get({id: $routeParams.id});
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/');
		});
	};
};


function EditarClubController($scope, $routeParams, $location, servicioClub) {

//	$scope.newsEntry = servicioClub.get({id: $routeParams.id});
	
	$scope.newsEntry = servicioClub.get({id: $routeParams.id},function (data,status) {
    	var dataId=''+data.estado;
        $scope.valor = { id: dataId };
    });
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/clubes');
		});
	};
};
function CrearClubController($scope, $location, servicioClub) {
	
	$scope.newsEntry = new servicioClub();
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/clubes');
		});
	};
};
function ClubController($scope, servicioClub) {
	
	$scope.newsEntries = servicioClub.query();
	
	$scope.deleteEntry = function(ClubDTO) {
		ClubDTO.$remove(function() {
			$scope.newsEntries = servicioClub.query();
		});
	};
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};


function EditarOperadorController($scope, $routeParams, $location, servicioOperador) {


	
	$scope.newsEntry = servicioOperador.get({id: $routeParams.id},function (data,status) {
    	var dataId=''+data.estado;
        $scope.valor = { id: dataId };
    });
	
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/operadores');
		});
	};
};
function CrearOperadorController($scope, $location, servicioOperador) {
	
	$scope.newsEntry = new servicioOperador();
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/operadores');
		});
	};
};
function OperadorController($scope, servicioOperador) {
	
	$scope.newsEntries = servicioOperador.query();
	
	$scope.deleteEntry = function(OperadorDTO) {
		OperadorDTO.$remove(function() {
			$scope.newsEntries = servicioOperador.query();
		});
	};
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};


function EditUserController($scope, $routeParams, $location, servicioUsuarios) {
	$scope.ocultar = false;
	$scope.newsEntry = servicioUsuarios.get({id: $routeParams.id},function (data,status) {
    	$scope.newsEntry = data
//    	data.roles[0].id
//    	var dataId=''+data.roles[0].id;
        $scope.valor = { id: ''+data.roles[0].id };
        $scope.ocultar = true;
    });
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/usuarios');
		});
	};
	
	
	
};
function CreateUsuarioController($scope, $location, servicioUsuarios) {
	
	$scope.newsEntry = new servicioUsuarios();
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/usuarios');
		});
	};
};
function UserController($scope, servicioUsuarios) {
	
	$scope.newsEntries = servicioUsuarios.query();
	
	$scope.deleteEntry = function(userDTO) {
		userDTO.$remove(function() {
			$scope.newsEntries = servicioUsuarios.query();
		});
	};
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};





function CreateController($scope, $location, NewsService) {
	
	$scope.newsEntry = new NewsService();
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/');
		});
	};
};

function CreateUsuarioController($scope, $location, servicioUsuarios) {
	
	$scope.newsEntry = new servicioUsuarios();
	
	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/usuarios');
		});
	};
};

function LoginController($scope, $rootScope, $location, $cookieStore, UserService) {
	
	$scope.rememberMe = false;
	
	$scope.login = function() {
		UserService.authenticate($.param({username: $scope.username, password: $scope.password}), function(authenticationResult) {
			var authToken = authenticationResult.token;
			$rootScope.authToken = authToken;
			if ($scope.rememberMe) {
				$cookieStore.put('authToken', authToken);
			}
			UserService.get(function(user) {
				$rootScope.user = user;
				$location.path("/");
			});
		});
	};
};

//function UserController($scope, servicioUsuarios) {
//	
//	$scope.newsEntries = servicioUsuarios.query();
//	
//	$scope.currentPage = 1;
//	$scope.pageSize = 10;
//	
//	$scope.pageChangeHandler = function(num) {
//
//		console.log('meals page changed to ' + num);
//
//	};
//	
//	$scope.deleteEntry = function(userDTO) {
//		userDTO.$remove(function() {
//			$scope.newsEntries = servicioUsuarios.query();
//		});
//	};
//};
var services = angular.module('exampleApp.services', ['ngResource']);

services.factory('UserService', function($resource) {
	
	return $resource('rest/userAuth/:action', {},
			{
				authenticate: {
					method: 'POST',
					params: {'action' : 'authenticate'},
					headers : {'Content-Type': 'application/x-www-form-urlencoded'}
				},
			}
		);
});

services.factory('NewsService', function($resource) {
	
	return $resource('rest/news/:id', {id: '@id'});
});

services.factory('servicioUsuarios', function($resource) {
	
	return $resource('rest/user/:id', {id: '@id'});
});

services.factory('servicioOperador', function($resource) {
	
	return $resource('rest/operador/:id', {id: '@id'});
});

services.factory('servicioClub', function($resource) {
	
	return $resource('rest/club/:id', {id: '@id'});
});

services.factory('servicioServicio', function($resource) {
	
	return $resource('rest/serv/:id', {id: '@id'});
});


services.factory('servicioCliente', function($resource) {
	
	return $resource('rest/cliente/:id', {id: '@id'});
});

services.factory('servicioInformeSus', function($resource) {
	
	return $resource('rest/Infsus/:id', {id: '@id',
		operadorID : 0,
		clubID : 0
		});
});



angular.module('exampleApp').controller('ModalInstanceCtrl', function ($scope, $modalInstance, items) {

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


angular.module('exampleApp').controller('paginaCtrl', function ($scope,$http) {


	$scope.pageChangeHandler = function(num) {

		console.log('going to page ' + num);

	};
	});
