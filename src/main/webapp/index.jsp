<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Criação do sistema jsp</h1>

	<form action="ServletLogin" method="post">

		<table>

			<tr>

				<td><label>login</label> <input type="text" name="login"></td>
			</tr>

			<tr>

				<td><label>senha</label> <input type="password" name="password"></td>
			</tr>

			<tr>
				<td><input type="submit" name="acessar"></td>
			</tr>

		</table>



	</form>
	<h5>${msg}</h5>

</body>
</html>