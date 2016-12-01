<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página do Usuário</title>
</head>

<body>
    <h2>PARABÉNS! Você agora é membro da comunidade do Chat Insper</h2>
    <p>Bem vindo, ${usuarioLogado}</p>
	<img src="getImage?login=${usuarioLogado}" width="200" height="200" align="lower"/>
	<a href="ChatInsper"><b><font size="5" color="blue"><p align="left">Entrar no Bate Papo</font></b></p></a>
	<a href="logout"><font size="5" color="red"><p align="justify">Sair do sistema</font></p></a>
</body>
</html>