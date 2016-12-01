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
      
      <c:forEach items="${tarefas}" var="tarefa">
         <tr>
  
 			<td><div align="center">${tarefa.usuario}</div></td>
            <td>${tarefa.mensagem}</td>
           <!-- <td>${tarefa.id}</td>-->

         </tr>
      </c:forEach>
   </table>
</body>
</html>	   
</body>
</html>
