<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
	@import url('https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap')
	
	
	</style>
    <style type="text/css">
    
    
    form{
    position: absolute;
    
    top: 40%;
    left: 25%;
    right: 25%
    
    }
     h5{
    position: absolute;
    
    top: 30%;
    left: 38%;
  font-family: "Roboto", sans-serif;
  font-weight: 400;
  font-style: normal;
    
    
    }
    
    
    h4{
    position: absolute;
    
    top: 80%;
    left: 30%;
  	font-family: "Roboto", sans-serif;
  	font-weight: 400;
  	font-style: normal;
  	color: red;
    
    
    }
    label{
    font-family: "Roboto", sans-serif;
 	 font-weight: 400;
 	 font-style: normal;
    }
    
    body{
    	background-color: #A9A9A9;
    }
    
    </style>
  </head>
<body>
<h5>Bem Vindo ao JSP</h5>

<form action="ServletLogin" method="post"  class="row g-3">

<input type="hidden" value="<%= request.getAttribute("url")%>" name="url">


<div class="col-md-6">
<label>login</label>
<input class="form-control" type="text" name="login" >
</div>

<div class="col-md-6">
<label>senha</label>
<input  class="form-control" type="password" name="senha" >
</div>


<input class="btn btn-primary" type="submit" value="acessar" >


</form>
<h4>${msg}</h4>

</body>


</html>