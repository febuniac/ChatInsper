<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<html>
<body>
    <h3>Bem Vindo ao Chat Insper</h3>
    <form action="apagaMensagem" method="post">
    	<input type = "submit" value= "Apagar Mensagens Anteriores">
   </form>
   <form action = "logout" method = "post">
   	<input type = "submit" value= "Logout">
   	</form>


     <div id="loop"></div> 
    <form action="adicionaMensagem" method="post">
    	Message: <br />
    	<textarea name="mensagem" rows="2" cols="37"></textarea><br />
    	<form:errors path="parametros.mensagem" cssStyle="color:red"/><br/>
    	<input type="submit" value="Send">

    </form>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>    
   	<script>
	(function worker() {
		  $.ajax({
		    url: 'Jquery', 
		    success: function(data) {
		      $('#loop').html(data);
		    },
		    complete: function() {
		      
		      setTimeout(worker, 500);
		    }
		  });
		})();
	</script> 
    