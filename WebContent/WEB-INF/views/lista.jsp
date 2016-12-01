<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<html>
<body>
<table border= "10" width="600">
      <tr>
         
          <th>Usuário</th>
         <th>Mensagem</th>
         <!--  <th>Id</th>-->
      </tr>
      
      <c:forEach items="${mensagens_}" var="parametros">
         <tr>
  
 			<td><div align="center"><font color="DODGERBLUE">${parametros.usuario}</font></div></td>
            <td>${parametros.mensagem}</td>
           <!-- <td>${tarefa.id}</td>-->

         </tr>
      </c:forEach>
   </table>
</body>
</html>	   
</body>
</html>
