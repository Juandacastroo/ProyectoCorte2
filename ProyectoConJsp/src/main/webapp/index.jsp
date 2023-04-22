<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Secular+One&display=swap" rel="stylesheet">
<link href="styles/style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Formulario Universidad</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous"></link>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="contenedor">
		<h1 class="titulos">Bienvenido</h1>
			
		<form action="http://localhost:8080/ProyectoConJsp/ingresarPersona"
			method="GET">
			<input class="botones" type="submit" value="Administrar" name="admin"></input>
		</form>
		
		<form action="http://localhost:8080/ProyectoConJsp/ingresarPersona"
			method="GET">
			<input class="botones" type="submit" value="Registrar estudiante" name="registrarse"></input>
		</form>
	</div>
</body>
</html>