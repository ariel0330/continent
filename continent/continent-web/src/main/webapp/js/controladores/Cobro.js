function InformeCobroController($scope, servicioCobro,servicioClub,servicioOperador,servicioCanal,servicioSmsSend) {
	
	
	
	
	$scope.clubes = servicioClub.query();
	
	$scope.operadores = servicioOperador.query();
	
	$scope.deleteEntry = function(SuscriptionDTO) {
		SuscriptionDTO.$remove(function() {
			$scope.newsEntries = servicioCobro.query();
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
		
		$scope.newsEntries = servicioCobro.query({clubID: $scope.tipoClub, operadorID:$scope.operadorID},function (data,status) {
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
