
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retorno JSP</title>
</head>
<body>

<%

String retorno = String.valueOf(request.getAttribute("retornoLancamentoVenda"));
//out.print("<h1>"+retorno+"<h1>");

%>

<script type="text/javascript">


alert("<%out.print(retorno);%>");

</script>

<meta http-equiv="refresh" content="1; index.html">
</body>
</html>