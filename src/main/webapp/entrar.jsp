<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Entrar</title>
</head>
<body>

	<%-- inclusão dinâmica --%>
	<jsp:include page="cabecalho.jsp" flush="true">
		<jsp:param name="titulo" value="Entrada de parâmetros"/>
	</jsp:include>
	
	<form action="guardar.jsp" method="get">
	
		Id: <input type="text" name="id"><br>
		Nome: <input type="text" name="nome"><br>
		Fone: <input type="text" name="fone"><br>
		E-mail: <input type="text" name="email"><br>
	
		<button type="submit">Guardar</button>
	</form>

</body>
</html>