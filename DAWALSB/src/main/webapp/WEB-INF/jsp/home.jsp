<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="cache-control" content="max-age=0" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
	<title>Info Atlas</title>
</head>
<body>

	<jsp:include page="./header.jsp"></jsp:include>
	
	${message} User: ${pageContext.request.userPrincipal.name}

	<a href="javascript:formSubmit()"> Logout</a>

	<form action="<%=request.getContextPath()%>/logout" method="POST" id="logoutForm">
				
		<!-- This is added since csrf protection is enabled by default in spring security -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	
	<script src="./externo/serializejson/serializejson.js"></script>
	<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
</body>
</html>
