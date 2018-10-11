/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var app = angular.module("myBanqueApp", []);
app.controller("myBanqueController", function ($scope, $http) {
    $scope.compte = null;
    $scope.codeCompte = null;
    $scope.operation = {type: "versement", montant: 0, cpte2: null};
    $scope.pageOperations = [];
    $scope.pageCourante = 0;
    $scope.pageSize = 3;
    $scope.pages = [];
    $scope.errorMsg = "";


    //charger une compte
    $scope.chargerCompte = function () {
        $scope.pageCourante = 0;
        $scope.errorMsg ="";
        var req = {
            method: 'GET',
            url: '/comptes/' + $scope.codeCompte,
            data: ''
        };
        $http(req).then(function (response) {
            $scope.compte = response.data;
        });
        $scope.chargerOperations();
    };


    //charger liste d'operation d'une compte
    $scope.chargerOperations = function () {
        var req = {
            method: 'GET',
            url: '/operations?codeCompte=' + $scope.codeCompte + "&page=" + $scope.pageCourante + "&size=" + $scope.pageSize,
            data: ''
        };
        $http(req).then(function (response) {
            $scope.pageOperations = response.data;
            $scope.pages = new Array(response.data.totalPages);
        });
    };


    $scope.goToPage = function (p) {
        $scope.pageCourante = p;
        $scope.chargerOperations();
    };

    //creer une operation soit versement,verment,retrait
    $scope.saveOperation = function () {
        var params = "";
        if ($scope.operation.type === 'virement') {
            params = "cpte1=" + $scope.codeCompte + "&cpte2=" + $scope.operation.cpte2 + "&montant=" + $scope.operation.montant + "&codeEmp=1";
        } else {
            params = "code=" + $scope.codeCompte + "&montant=" + $scope.operation.montant + "&codeEmp=1";
        }
        var req = ({
            method: 'PUT',
            url: $scope.operation.type,
            data: params,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        });
        $http(req).then(function () {
            $scope.chargerCompte();
        }).catch(function (response) {
            console.log(response.data.message);
            $scope.errorMsg = response.data.message;
        });

    };

});

