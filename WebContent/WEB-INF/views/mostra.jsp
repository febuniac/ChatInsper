<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
    <h3>Alterar tarefa - ${tarefa.id}</h3>
    <form action="alteraTarefa" method="post">
        <input type="hidden" name="id" value="${tarefa.id}"/>
        
        Mensagem:<br/>
        <textarea name="mensagem" cols="80" rows="6">
            ${tarefa.mensagem}
        </textarea>
        <br/>
        
        <!-- Finalizado <input type="checkbox" name="finalizado"
        value="true" ${tarefa.finalizado? 'checked' : '' }/>
        <br/>
        
        Data de finalização:
        <input type="text" name="dataFinalizacao"
        value="<fmt:formatDate value='${tarefa.dataFinalizacao.time}' pattern='dd/MM/yyyy'/>"/>
        <br/>
        
        <input type="submit" value="Alterar"/>-->
    </form>
</body>
</html>