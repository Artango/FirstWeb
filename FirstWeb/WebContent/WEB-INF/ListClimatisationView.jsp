<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListClimatisationView</title>
</head>
<body>
<h1>Liste des climatisation</h1>
<c:if test = "${not empty login}"}><h3>Vous êtes : ${login}</h3><span style="color:red">${erreurlogin}</span></c:if>
<%--<span style="color:red">${erreurio}</span>
<span style="color:red">${erreurclass}</span>--%>
${listClim}
	<c:forEach var = "clim" items="${listClim}">
		<%--il appelle getPression --%>
		${clim.pression}
		${clim.nom}
	</c:forEach>
</body>
</html>