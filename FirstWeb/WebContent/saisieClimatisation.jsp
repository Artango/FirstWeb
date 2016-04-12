<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Création climatisation</title>
<link type="text/css" rel="stylesheet" href="styleClimatisation.css" />
<script type="text/javascript" src="jquery.js"></script><%-- besoin de la librairie en javascript --%>
<script type="text/javascript" src="Climatisation.js"></script>
</head>
<body>
 
<form action="ClimatisationController" method = "POST">
<fieldset>

<h2>Entrez les informations de l'appareil : </h2>
<label> Nom de l'appareil: </label><input id="sourceNbID" type="text" value="" name="appareil"/><br/> <%-- champs d'entrées précédés de l'indication de quoi y entrer, le type est donné par une string "text" --%>
<label> Température de l'appareil: </label><input type="text" value="" name="temperature"/><br/>
<span id="nbID" style="color:blue"></span>
<span style="color:red">${appareilErreur}</span>
<label> Pression de l'appareil: </label><input type="text" value="" name="pression"/><br/>
<label> Humidité de l'appareil: </label><input type="text" value="" name="humidite"/><br/>
<input type = "submit" value="enregistrer" name="cmdAction"/><%-- insertion d'un bouton de soumission de réponse (submit) sur lequel est marqué enregistrer et dont l'action est référencée par le mot "action" --%>
<input type = "submit" value="Fin" name="cmdAffiche"/>
<span style="color:red">${sauvegardeErreur}</span><%-- pour afficher les erreurs à partir de la variable erreurs trouvée dans le servlet --%>
</fieldset>
</form>
</body>
</html>