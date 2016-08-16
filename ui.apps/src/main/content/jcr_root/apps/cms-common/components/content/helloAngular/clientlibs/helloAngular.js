/**
 * Created on 8/16/16.
 */
var helloAngular = angular.module('helloAngular', []);
helloAngular.controller('HelloAngularController', ['$scope', function ($scope) {
    $scope.greeting = 'AngularJS !!!';
}]);