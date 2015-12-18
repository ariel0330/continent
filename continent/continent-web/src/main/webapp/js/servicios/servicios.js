
var services = angular.module('continentWeb.services', []);

services.factory('UserService', function($resource) {
	
	return $resource('rest/userAuth/:action', {},
			{
				authenticate: {
					method: 'POST',
					params: {'action' : 'authenticate'},
					headers : {'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'}
				},
			}
		);
});



services.factory('servicioSmsSend', function($resource) {
	
	return $resource('rest/smsSend/:id', {id: '@id',
		operadorID : 0,
		clubID : 0,
		fecha:""
	});
	
});



services.factory('servicioCobro', function($resource) {
	
	return $resource('rest/cobro/:id', {id: '@id',
		operadorID : 0,
		clubID : 0
	});
	
});


services.factory('servicioUsuarios', function($resource) {
	
	return $resource('rest/user/:id', {id: '@id',
		idPerfil:0,
		idEstado:0
	});
	
});


services.factory('servicioEstados', function($resource) {
	
	return $resource('rest/estado/:id', {id: '@id'});
});

services.factory('servicioCanal', function($resource) {
	
	return $resource('rest/canal/:id', {id: '@id'});
});


services.factory('servicioOperador', function($resource) {
	
	return $resource('rest/operador/:id', {id: '@id',
		idOperador:0,
		idEstado:0
		});
});

services.factory('servicioClub', function($resource) {
	
	return $resource('rest/club/:id', {id: '@id',
		idClub:0,
		idEstado:0});
});

services.factory('servicioServicio', function($resource) {
	
	return $resource('rest/serv/:id', {id: '@id',
		idServicio:0,
		idEstado:0});
});


services.factory('servicioCliente', function($resource) {
	
	return $resource('rest/cliente/:id', {id: '@id'});
});

services.factory('servicioPerfil', function($resource) {
	
	return $resource('rest/perfil/:id', {id: '@id'});
});

services.factory('servicioInformeSus', function($resource) {
	
	return $resource('rest/Infsus/:id', {id: '@id',
		operadorID : 0,
		clubID : 0,
		idCanal:0,
		fecha:""
		});
});


