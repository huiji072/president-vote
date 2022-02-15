var myApp = angular.module("myApp", []);
//creating controller for technologies (likes dislikes simple app)
myApp.controller("votesController", function($scope){
	var votes = [
		{ Name:"Musharaf", Likes:"10", Dislikes:"2"},
		{ Name:"Zardari", Likes:"5", Dislikes:"7"},
		{ Name:"Shahbaz Sharif", Likes:"7", Dislikes:"14"},
		{ Name:"Gilani", Likes:"8", Dislikes:"6"}
	];
	$scope.votes = votes;
	$scope.incrementLikes = function(vote){
		vote.Likes++;
	}
	$scope.incrementDislikes = function(vote){
		vote.Dislikes++;
	}
});