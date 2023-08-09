<%@page import="java.util.Date"%>
<jsp:useBean id="contato" class="com.softgraf.dao.Contato"/>
<jsp:useBean id="dao" scope="session" class="com.softgraf.dao.ContatoDAO"/>

<%-- Instancia um objeto contato
	scope = "page|session|request|application"
	scope padrão = "page"
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guarda Parâmetros</title>
</head>
<body>

	<h3>Mostrando parâmetros recebidos:</h3>
	ID: ${param.id}<br>
	Nome: ${param.nome}<br>
	Fone: ${param.fone}<br>
	E-mail: ${param.email}<br>
	
	<%
		Integer id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email");
		
		contato.setId(id);
		contato.setNome(nome);
		contato.setFone(fone);
		contato.setEmail(email);
		contato.setData(new Date());
		
		dao.addContato(contato);
		
		out.println("<h3>Total de contatos existentes no dao: " + dao.getLista().size() + "</h3>");
	%>
	
	<h3>Exemplos de Expression Language (EL): </h3>
	${5 >= 4}<br>
	${1 >= (4/2)}<br>
	${100.0 == 100}<br>
	${10 mod 4}<br>
	${empty param.sobrenome}<br>
	${header["host"]}<br>
	${pageContext.request.contextPath}<br>
	
	<a href="index.jsp">index</a>

</body>
</html>