$(document).ready(function(){
	$("sourceNbID").blur(function(){//blur =  perte de focus d'un champ
    $.ajax({
       url : 'ClimatisationAjax',
       type : 'GET',
       dataType : 'text', // On désire recevoir du HTML
       success : function(texte, statut){ // code_html contient le HTML renvoyé
           $("#nbID").html(texte);
       }
    });
	})
   
});
/**
 * 
 */