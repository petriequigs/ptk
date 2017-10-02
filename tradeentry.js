//=================================================================================
// File........: tradeentry.js
// Description.: AngularJS for multiple trade entry
// Require.....: tradeentry.html
//=================================================================================

function TradeEntry($scope){

    //user ID
    $scope.userID="petrie1";
    
    //trade ID - todo get from singlton
    $scope.tradeID="00001";
    
    $scope.tradeBasics = [
	{text:'Trade Date:', value:'09/2/17'}, 
	{text:'Trade Time:', value:'09:000'},
    ];
    
    $scope.tradeFacts = [
    ];
    
    $scope.Date="";
    $scope.Time="";
    $scope.Symbol="";
    $scope.BuySell="";
    $scope.Price=0.00;
    $scope.OrdInstr="Market";
    $scope.TIF="GFD";
    $scope.Comment="";
    
    
    $scope.addTrade = function(){
	$scope.tradeFacts.push(
	    {
		Symbol: $scope.Symbol, 
		BuySell: $scope.BuySell,
		OrdInstr: $scope.OrdInstr,
		Price: $scope.Price,
		TIF: $scope.TIF,
		Time: Date(), 
		Comment: $scope.Comment
	    }
	);
    }
    


}
