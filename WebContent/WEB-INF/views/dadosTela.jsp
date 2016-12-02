<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<html>
<body>
<table border= "10">
      <tr>
         
          <th width =50px> Foto</th>
          <th width = 180px>Usuário</th>
         <th width= 400px>Mensagem</th>
         <!--  <th>Id</th>-->
      </tr>
      
      <c:forEach items="${mensagens_}" var="parametros">
         <tr>
  			<td><img src="getImage?login=${parametros.usuario}" width="50" height="50" /></td>
 			<td><div align="center"><font color="DODGERBLUE">${parametros.usuario}</font></div></td>
            <td>${parametros.mensagem}</td>
          
           <!-- <td>${parametros.id}</td>-->

         </tr>
      </c:forEach>
   </table>
</body>
</html>	   
