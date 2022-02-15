<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<style>

    table{
	width:100%;
	margin:0 0 20px;
	border:2px solid #000;
	border-collapse:collapse;
}
table th,
table td{
	width:20%;
	padding:15px;
	border:2px solid #000;
	text-align:center;
}

</style>

<head>
    <meta charset="UTF-8">
</head>

<body ng-app="myApp">
<table ng-controller="votesController">
    <thead>
    <tr>
        <th>Name</th>
        <th>Likes</th>
        <th>Dislikes</th>
        <th>Like/Dislikes</th>
    </tr>
    </thead>
    <tbody>
    <tr ng-repeat="vote in votes">
        <td>{{vote.Name}}</td>
        <td>{{vote.Likes}}</td>
        <td>{{vote.Dislikes}}</td>
        <td>
            <button type="button" ng-click="incrementLikes(vote)">Like</button>
            <button type="button" ng-click="incrementDislikes(vote)">Dislike</button>
        </td>
    </tr>

    <tr ng-repeat="vote in votes">
        <td>{{vote.Name}}</td>
        <td>{{vote.Likes}}</td>
        <td>{{vote.Dislikes}}</td>
        <td>
            <button type="button" ng-click="incrementLikes(vote)">Like</button>
            <button type="button" ng-click="incrementDislikes(vote)">Dislike</button>
        </td>
    </tr>


    <tr ng-repeat="vote in votes">
        <td>{{vote.Name}}</td>
        <td>{{vote.Likes}}</td>
        <td>{{vote.Dislikes}}</td>
        <td>
            <button type="button" ng-click="incrementLikes(vote)">Like</button>
            <button type="button" ng-click="incrementDislikes(vote)">Dislike</button>
        </td>
    </tr>


    <tr ng-repeat="vote in votes">
        <td>{{vote.Name}}</td>
        <td>{{vote.Likes}}</td>
        <td>{{vote.Dislikes}}</td>
        <td>
            <button type="button" ng-click="incrementLikes(vote)">Like</button>
            <button type="button" ng-click="incrementDislikes(vote)">Dislike</button>
        </td>
    </tr>

    </tbody>
</table>
<script src="presidentJs.js"></script>
</body>

</html>