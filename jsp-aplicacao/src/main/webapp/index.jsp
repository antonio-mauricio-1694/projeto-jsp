<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>mauricio isis lucas</h1>

<form action="ServletLogin" method="post">

<input type="hidden" value="<%= request.getAttribute("url")%>" name="url">
<table>
<tr>
<td>
<label>login</label>
<input type="text" name="login">
</td>
</tr>

<tr>
<td>
<label>senha</label>
<input type="password" name="senha">
</td>
</tr>

<tr>
<td>

<input type="submit" value="enviar">
</td>
</tr>
</table>
</form>
<h4>${msg}</h4>
</body>
</html>