<%@page import="com.softgraf.dao.Contato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%-- Instancia um objeto ContatoDAO --%>
<jsp:useBean id="contato" class="com.softgraf.dao.Contato"/>
<jsp:useBean id="dao"  scope="session" class="com.softgraf.dao.ContatoDAO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeiro JSP</title>
</head>
<body>

	<!-- comentário HTML -->
	<%-- inclusão estática do logo --%>
	<%@ include file="cabecalho.jsp" %>
	
	<%-- comentário: esta é uma declaração JSP --%>
	<%! public final double pi = 3.14; %>
	
	<%-- comentário: este é um scriptlet --%>
	<%
		String mensagem = "Este é um scriptlet";
		String exp = "Exemplo de expressão ou atalho"; 
	%>
	
	<% out.println(mensagem); %>
	
	<% System.out.println("Essa mensagem de scriptlet sai apenas no console"); %>
	
	<br>
	<%= exp %>
	
	<ul>
	
		<%
			List<Contato> contatos = dao.getLista() ;
			for (Contato c : contatos ){				
		%>
		
		<li><%= c.getId() %> | <%= c.getNome() %> | <%= c.getFone() %> | <%= c.getEmail() %> </li>
		
		<%
			}
		%>
		
	</ul>
	
	<a href="entrar.jsp">Entrar Parâmetros</a>
	
	<%@ include file="rodape.jsp" %>

</body>
</html>