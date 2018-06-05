<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<title>TreinaWeb Spring MVC - Adição de álbuns</title>
		</head>
		<body>
		<h3>Inserção de músicas</h3>
			<c:url var ="actionAdicionar" value="/musicas/adicionar"></c:url>
			<form:form action="${actionAdicionar}" method="post" modelAttribute="musica">	<!-- Form será submetida via post para action albuns/adicionar -->
				<label>Nome:</label>
				<form:input path="nome"/><br/>
				<label>Álbum:</label>
				<form:input path="album"/><br/>
				<input type="submit" value="Salvar"/>
			</form:form>


		</body>
</html>