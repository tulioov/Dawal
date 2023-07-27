<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Info Atlas</title>
    <link href="./externo/bootstrap-4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="./externo/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="./css/login.css" rel="stylesheet">
    <link href="./css/home/homeStyle.css" rel="stylesheet">
    <link rel="icon" type="image/png" sizes="96x96" href="img/favicon/favicon-96x96.png">
</head>

<body>
    <div class="wrapper fadeInDown container">
        <div id="formContent" style="background-color: #00aeef;">
            <div class="fadeIn first">
                <img src="img/logo.svg" style=" padding-top: 15px; padding-bottom: 0px " alt="Globo" /><br style=" clear: both;" />
                <h1 style=" margin-top: 20px; color: white;" class="font-poppins">Info Atlas </h1>
            </div>
            <form name='loginForm' action="<%=request.getContextPath()%>/loginPage" method='POST'>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                        	<div class="col-md-12">
								<div id="loadingId" class="spinner-border text-light oculta"></div>
		                        <div id="msgId" class="fadeIn alert alert-danger ${error!=null?'':'oculta'}" role="alert">
							  		${error}
								</div>
							</div>
                            <input type="text" id="loginId" class="fadeIn second" name="login" placeholder="Login">
                            <input type="password" id="passwordId" class="fadeIn second" name="password" placeholder="Senha">
                            <input type="submit" id="btnEntrarId" class="fadeIn fourth" value="Entrar" style="background: white; color: #00aeef;">
                            <h2 style="display: block;color: white;"  >Ambiente: ${ambiente}</h2>
                            <h2 style="display: block;color: white;"  >Vers&atilde;o: ${versao}</h2>
                            <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <script src="./externo/jquery-3.6.0/jquery-3.6.0.min.js"></script>
    <script src="./externo/bootstrap-4.6.1/js/bootstrap.bundle.min.js"></script>
    <script src="./js/login/loginController.js"></script>
</body>

</html>