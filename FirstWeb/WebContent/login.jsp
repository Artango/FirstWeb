<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="stylelogin.css" />
<title>Insert title here</title>
</head>
<body>
<form action="loginController" method = "POST">
<fieldset>

<h2>Entrez votre login de session : </h2>
<label> Login: </label><input type="text" value="" name="login"/><br/> <%-- champs d'entrées précédés de l'indication de quoi y entrer, le type est donné par une string "text" --%>
<input type = "submit" value="enregistrer" name="action"/><%-- insertion d'un bouton de soumission de réponse (submit) sur lequel est marqué enregistrer et dont l'action est référencée par le mot "action" --%>
<%-- <span style="color:red">${erreurlogin}</span>
<span style="color:green">${successlogin} ${login}</span> --%>
</fieldset>
</form>
</body>
</html>