
function IndexController($scope,$timeout,servicioInformeSus,servicioSmsSend) {
	
	$scope.altasHoy=0;
	$scope.bajasHoy=0;
	$scope.mensajesHoy=0;
	$scope.cobrosHoy=0;
	
	var timeIntervalInSec = 5;
	
	var refreshDates = function() {
//		var hoyDia=hoy();
		var hoyDia="04/04/2015";
//	alert("dia de hoy "+hoyDia);
	
//	var hoy="04/04/2015";
		
		servicioInformeSus.query({id: 1,fecha:hoyDia},function (data,status) {
//	    	$scope.InformeSusA = data;
	    	$scope.altasHoy=data.length;
	    });
		
		servicioInformeSus.query({id: 2,fecha:hoyDia},function (data,status) {
//	    	$scope.InformeSusB = data;
	    	$scope.bajasHoy=data.length;
	    });
		
		servicioSmsSend.query({fecha:hoyDia},function (data,status) {
//			$scope.InformeSmsSend = data
			$scope.mensajesHoy==data.length;
	    });
//		$scope.altasHoy=$scope.InformeSusA.leng;
//		$scope.bajasHoy=$scope.bajasHoy+1;
//		$scope.mensajesHoy=$scope.mensajesHoy+1;
		$scope.cobrosHoy=$scope.cobrosHoy+1;
	    $timeout(refreshDates, 4000000000000);
	};
	
	refreshDates();

};





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



function InformeMensajesController($scope, servicioInformeSus,servicioClub,servicioOperador,servicioCanal,servicioSmsSend) {
	
	
	
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.deleteEntry = function(SuscriptionDTO) {
		SuscriptionDTO.$remove(function() {
			$scope.newsEntries = servicioInformeSus.query();
		});
	};
	
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
		{
			$scope.tipoClub=0;
		}
		if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
		{
			$scope.operadorID=0;
		}
		
		if(angular.isUndefined($scope.fecha) || $scope.fecha == null )
		{
			$scope.fecha="";
		}
		
		$scope.newsEntries = servicioSmsSend.query({clubID: $scope.tipoClub, operadorID:$scope.operadorID,fecha:$scope.fecha},function (data,status) {
	    	$scope.newsEntry = data
	        $scope.buscando = false;
	    });
	};
	
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};


function InformeMensajesDiaController($scope, servicioInformeSus,servicioClub,servicioOperador,servicioCanal,servicioSmsSend) {
	
	
	
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	$scope.fecha="04/04/2015";
	$scope.buscando=true;
	$scope.newsEntries = servicioSmsSend.query({fecha:$scope.fecha},function (data,status) {
    	$scope.newsEntry = data
        $scope.buscando = false;
    });
	
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
		{
			$scope.tipoClub=0;
		}
		if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
		{
			$scope.operadorID=0;
		}
		
		if(angular.isUndefined($scope.fecha) || $scope.fecha == null )
		{
			$scope.fecha="";
		}
		
		$scope.newsEntries = servicioSmsSend.query({clubID: $scope.tipoClub, operadorID:$scope.operadorID,fecha:$scope.fecha},function (data,status) {
	    	$scope.newsEntry = data
	        $scope.buscando = false;
	    });
	};
	
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};



function InformeSubAltaController($scope, servicioInformeSus,servicioClub,servicioOperador,servicioCanal) {
	
	$scope.canales = servicioCanal.query();
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.deleteEntry = function(SuscriptionDTO) {
		SuscriptionDTO.$remove(function() {
			$scope.newsEntries = servicioInformeSus.query();
		});
	};
	
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
		{
			$scope.tipoClub=0;
		}
		if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
		{
			$scope.operadorID=0;
		}
		
		if(angular.isUndefined($scope.idCanal) || $scope.idCanal == null )
		{
			$scope.idCanal=0;
		}
		
		if(angular.isUndefined($scope.fecha) || $scope.fecha == null )
		{
			$scope.fecha="";
		}
		
		$scope.newsEntries = servicioInformeSus.query({id: 1,clubID: $scope.tipoClub, operadorID:$scope.operadorID,idCanal:$scope.idCanal,fecha:$scope.fecha},function (data,status) {
	    	$scope.newsEntry = data
	        $scope.buscando = false;
	    });
	};
	
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};



function InformeSubAltaDiarioController($scope, servicioInformeSus,servicioClub,servicioOperador,servicioCanal) {
	
	$scope.canales = servicioCanal.query();
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.fecha="04/04/2015";
	$scope.buscando=true;
	$scope.newsEntries =  servicioInformeSus.query({id: 1,fecha:$scope.fecha},function (data,status) {
    	$scope.newsEntry = data
    	 $scope.buscando = false;
    });
	
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
		{
			$scope.tipoClub=0;
		}
		if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
		{
			$scope.operadorID=0;
		}
		
		if(angular.isUndefined($scope.idCanal) || $scope.idCanal == null )
		{
			$scope.idCanal=0;
		}
		
		if(angular.isUndefined($scope.fecha) || $scope.fecha == null )
		{
			$scope.fecha="";
		}
		
		$scope.newsEntries = servicioInformeSus.query({id: 1,clubID: $scope.tipoClub, operadorID:$scope.operadorID,idCanal:$scope.idCanal,fecha:$scope.fecha},function (data,status) {
	    	$scope.newsEntry = data
	        $scope.buscando = false;
	    });
	};
	
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};


function InformeSubBajaController($scope, servicioInformeSus,servicioClub,servicioOperador,servicioCanal) {
	
$scope.canales = servicioCanal.query();
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.deleteEntry = function(SuscriptionDTO) {
		SuscriptionDTO.$remove(function() {
			$scope.newsEntries = servicioInformeSus.query();
		});
	};
	
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
		{
			$scope.tipoClub=0;
		}
		if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
		{
			$scope.operadorID=0;
		}
		
		if(angular.isUndefined($scope.idCanal) || $scope.idCanal == null )
		{
			$scope.idCanal=0;
		}
		
		if(angular.isUndefined($scope.fecha) || $scope.fecha == null )
		{
			$scope.fecha="";
		}
		
		$scope.newsEntries = servicioInformeSus.query({id: 2,clubID: $scope.tipoClub, operadorID:$scope.operadorID,idCanal:$scope.idCanal,fecha:$scope.fecha},function (data,status) {
	    	$scope.newsEntry = data
	        $scope.buscando = false;
	    });
	};
	
	
	$scope.currentPage = 1;
	$scope.pageSize = 10;
	
	$scope.pageChangeHandler = function(num) {

		console.log('meals page changed to ' + num);

	};
};


function InformeSubBajaDiariaController($scope, servicioInformeSus,servicioClub,servicioOperador,servicioCanal) {
	
	$scope.canales = servicioCanal.query();
		
		$scope.clubes = servicioClub.query();
		
		$scope.operadores = servicioOperador.query();
		
		$scope.fecha="04/04/2015";
		$scope.buscando=true;
		$scope.newsEntries =  servicioInformeSus.query({id: 2,fecha:$scope.fecha},function (data,status) {
	    	$scope.newsEntry = data
	    	 $scope.buscando = false;
	    });
		
		$scope.buscar = function() {
			$scope.buscando=true;
			if(angular.isUndefined($scope.tipoClub) || $scope.tipoClub == null)
			{
				$scope.tipoClub=0;
			}
			if(angular.isUndefined($scope.operadorID) || $scope.operadorID == null )
			{
				$scope.operadorID=0;
			}
			
			if(angular.isUndefined($scope.idCanal) || $scope.idCanal == null )
			{
				$scope.idCanal=0;
			}
			
			if(angular.isUndefined($scope.fecha) || $scope.fecha == null )
			{
				$scope.fecha="";
			}
			
			$scope.newsEntries = servicioInformeSus.query({id: 2,clubID: $scope.tipoClub, operadorID:$scope.operadorID,idCanal:$scope.idCanal,fecha:$scope.fecha},function (data,status) {
		    	$scope.newsEntry = data
		        $scope.buscando = false;
		    });
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

	

		
		 $scope.ocultar = false;	
	$scope.newsEntry = servicioServicio.get({id: $routeParams.id},function (data,status) {
    	var dataId=''+data.estadoBean.idEstado;
        $scope.valor = { id: dataId };
        $scope.ocultar = true;
    });
	
//	$scope.newsEntry = servicioServicio.get({id: $routeParams.id});
	
	$scope.doTheBack = function() {
		  window.history.back();
		};
		
		
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
function ServicioController($scope, servicioServicio,servicioEstados) {
	
	
	
	$scope.servicios = servicioServicio.query();
	
	   $scope.estados=servicioEstados.query();
		
		
		$scope.buscar = function() {
			$scope.buscando=true;
			if(angular.isUndefined($scope.idEstado) || $scope.idEstado == null )
			{
				$scope.idEstado=0;
			}
			
			if(angular.isUndefined($scope.idServicio) || $scope.idServicio == null )
			{
				$scope.idServicio=0;
			}
			
			$scope.newsEntries = servicioServicio.query({idEstado:$scope.idEstado,idServicio:$scope.idServicio},function (data,status) {
		    	$scope.newsEntry = data
		        $scope.buscando = false;
		    });
		};
	
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

	

	 $scope.ocultar = false;
	$scope.newsEntry = servicioClub.get({id: $routeParams.id},function (data,status) {
    	var dataId=''+data.estadoBean.idEstado;
        $scope.valor = { id: dataId };
        $scope.ocultar = true;
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
function ClubController($scope, servicioClub,servicioEstados) {
	
	$scope.clubes = servicioClub.query();
	
   $scope.estados=servicioEstados.query();
	
	
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.idEstado) || $scope.idEstado == null )
		{
			$scope.idEstado=0;
		}
		
		if(angular.isUndefined($scope.idClub) || $scope.idClub == null )
		{
			$scope.idClub=0;
		}
		
		$scope.newsEntries = servicioClub.query({idEstado:$scope.idEstado,idClub:$scope.idClub},function (data,status) {
	    	$scope.newsEntry = data
	        $scope.buscando = false;
	    });
	};
	
	
	
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

	
	$scope.ocultar = false;
	$scope.newsEntry = servicioOperador.get({id: $routeParams.id},function (data,status) {
    	var dataId=''+data.estadoBean.idEstado;
        $scope.valor = { id: dataId };
    	if(angular.isUndefined($scope.valor.id) || $scope.valor.id == null )
    		$scope.ocultar = false;
    	else
    		 $scope.ocultar = true;
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
function OperadorController($scope, servicioOperador,servicioEstados) {
	
	$scope.estados=servicioEstados.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.idEstado) || $scope.idEstado == null )
		{
			$scope.idEstado=0;
		}
		
		if(angular.isUndefined($scope.idOperador) || $scope.idOperador == null )
		{
			$scope.idOperador=0;
		}
		
		$scope.newsEntries = servicioOperador.query({idEstado:$scope.idEstado,idOperador:$scope.idOperador},function (data,status) {
	    	$scope.newsEntry = data
	        $scope.buscando = false;
	    });
	};
	
	
	
//	$scope.newsEntries = servicioOperador.query();
	
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
        $scope.valor = { id: ""+data.roles[0].id+"",  estadoid: ''+data.estadoBean.idEstado };
        $scope.ocultar = true;
    });
	
	$scope.doTheBack = function() {
		  window.history.back();
		};
		
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
function UserController($scope, servicioUsuarios,servicioEstados,servicioPerfil) {
	
//	$scope.buscando=true;
	$scope.estados=servicioEstados.query();
	$scope.perfiles=servicioPerfil.query();
//	$scope.newsEntries = servicioUsuarios.query(function (data,status) {
//	$scope.buscando=false;
//	});
	
	
	$scope.doTheBack = function() {
		  window.history.back();
		};
		
		
	$scope.buscar = function() {
		$scope.buscando=true;
		if(angular.isUndefined($scope.idPerfil) || $scope.idPerfil == null)
		{
			$scope.idPerfil=0;
		}
		if(angular.isUndefined($scope.idEstado) || $scope.idEstado == null )
		{
			$scope.idEstado=0;
		}
		
		$scope.newsEntries = servicioUsuarios.query({idPerfil: $scope.idPerfil, idEstado:$scope.idEstado},
				function (data,status) {
			$scope.buscando=false;
			});
	};
	
	
	
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
