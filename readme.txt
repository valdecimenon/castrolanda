
==== Objetos implícitos JSP: =====
São objetos pontos para várias finalidades.

request
response
out
session
application
page
config
pageConext
Exception

Exemplo:
Cookie[] c = request.getCookies();


===== Principais elementos JSP (tags):

- Diretivas: <%@   %>


- Declarações: <%!  %>
  <%! int contador = 0%>
  
- Expressões: <%=   %>
  <%= contador++ %>
  
  
- Expression Language: ${}
  ${5 >= 4} 
  ${pageContext.request.contextPath}
  ${objeto.nomeAtributo}
  
 - Scriptlet:  <%  %>
  
 - Ações: <jsp:acao ........   />
   São comando java dentro da página
   
   <jsp:include  insere conteúdo de uma nova página na atual
   <jsp:forward  envia o conteúdo e o controle da página atual para outra
   <jsp:params   lista de parâmetros
   <jsp:param
   
   <jsp:useBean
   <jsp:setProperty
   <jsp:getProperty
   <jsp:body
   <jsp:text
   
  - Custom tags: <prefixo:elemento ....
     São tags personalizadas (taglibs)
     JSTL - Java Server Pages Standard Tag Library
