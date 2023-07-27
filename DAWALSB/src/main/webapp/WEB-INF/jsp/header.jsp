<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta http-equiv="Cache-control" content="no-cache">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">		
		<link rel="stylesheet" href="./css/menu/menu.css">
		<link rel="stylesheet" href="./css/home/homeStyle.css">
		<link rel="stylesheet" href="./css/comum.css">
		<title>Info Atlas</title>
		<link rel="icon" type="image/png" sizes="96x96" href="./img/favicon/favicon-96x96.png">
</head>
<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="./js/menu/menu.js"></script>

<input type="hidden" id="urlBackEnd" value=${urlBackEnd}>
<input type="hidden" id="urlFrontEnd" value="<%=request.getContextPath()%>">
<div class='dashboard'>
    <div class="dashboard-nav bg-azul">
        <header>
        	<a href="#!" id="menuId" class="menu-toggle">
        		<i class="fas fa-bars"></i>
        	</a>
        	<a href="#" class="brand-logo">
        		<h4 style="color: #fff;">
        			MENU
				</h4>
        	</a>
		</header>
        <nav class="dashboard-nav-list">
        	<a href="./" class="dashboard-nav-item active">
        		<i class="fas fa-home"></i>
				Home 
			</a>
			<a href="./cadastroMunicipio" class="dashboard-nav-item active">
        		<i class="fas fa-exchange-alt"></i>
				De-para de municípios 
			</a>
			<a href="./responsabilidadeSinal" class="dashboard-nav-item active">
				<i class="fas fa-signal"></i>
				Resp. de sinal 
			</a>
            <div class="nav-item-divider"></div>
            <a href="./logout" class="dashboard-nav-item">
            	<i class="fas fa-sign-out-alt"></i> 
            	Sair 
			</a>
        </nav>
    </div>
    <div class='dashboard-app'>
        <header class='dashboard-toolbar bg-azul'>
        	<a id="headMenuId" href="#!" class="menu-toggle">
       			<i class="fas fa-bars branco"></i>	
			</a>
			<a href="#" class="brand-logo">
        		<div style="color: #fff;">
	        		<a href="./"><img src="img/logo.svg" style="width: 77px; height: 44px;"
					alt="logonInfoAtlas"></a>
        			INFO ATLAS
				</div>
        	</a>
		</header>
        <div class='dashboard-content' style="margin-top: 30px;">
