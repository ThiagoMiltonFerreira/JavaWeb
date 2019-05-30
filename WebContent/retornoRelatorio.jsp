<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@import java.io.BufferedReader;%>
<%@import java.io.BufferedWriter;%>
<%@import java.io.File;%>
<%@import java.io.FileNotFoundException;%>
<%@import java.io.FileReader;%>
<%@import java.io.FileWriter;%>
<%@import java.io.IOException;%>
<%@import java.nio.file.Files;%>
<%@import java.nio.file.Path;%>
<%@import java.nio.file.Paths;%>
<%@import java.util.ArrayList;%>
<%@import java.util.List;%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Relatorio</title>
</head>
<body>
<%
//List<String> lista = new ArrayList<String>();
//List lista =  request.getParameter("retornoRelatorio");
FileReader fr = new FileReader("F:\\Arquivos HD\\Java Web\\workspaces\\ProjetoCarteiraWeb\\carteiraWewbJsp\\arquivo.txt");
BufferedReader br = new BufferedReader(fr);
String dadosDoBanco[] = new String[10];
int cont = 0;
String str;
while((str = br.readLine()) != null)
{
            //System.out.println(str + "\n");
        	//System.out.println(dadosDoBanco[cont]);
dadosDoBanco[cont] = str;        	
cont++;
        	
}  

out.print("<h1>"+request.getParameter("retornoRelatorio")+"<h1>");


%>








</body>
</html>