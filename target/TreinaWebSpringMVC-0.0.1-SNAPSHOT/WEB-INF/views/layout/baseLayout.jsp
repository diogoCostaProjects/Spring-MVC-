<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
	<head>
		<spring:url value="/resources/js/jquery.min.js" var="jqueryJS"></spring:url>
		<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS"></spring:url>
		<spring:url value="/resources/css/bootstrap	.min.css" var="bootstrapCSS"></spring:url>
		
		<script type="text/javascript" src="${jqueryJS} }"></script> <!-- Arquivos carregados de acordo com o caminho nas variáveis  -->
		<link href="${bootstrapCSS}" rel="stylesheet">
		<script type="text/javascript" src="${bootstrapJS} }"></script>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
	</head>	
	<body>
		
			<tiles:insertAttribute name="header" ignore="false"></tiles:insertAttribute>
		
		
			<tiles:insertAttribute name="body" ignore="false"></tiles:insertAttribute>
		
		
			<tiles:insertAttribute name="footer" ignore="false"></tiles:insertAttribute>
		
	</body>
</html>	