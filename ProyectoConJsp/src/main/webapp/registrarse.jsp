<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Formulario Universidad</title>
<link
	href="https://fonts.googleapis.com/css2?family=Secular+One&display=swap"
	rel="stylesheet">
<link href="styles/style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
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
	<div class="contenedor2">
	
		<h1 class="titulos">Registrarse</h1>
		
		<form class= "formulario" action="http://localhost:8080/ProyectoConJsp/ingresarPersona" method="POST">
			
			<h5 class="titulos2 text-center">Ingrese su nombre completo</h5>
			<input type="text" class="ingresar text-center" id="input" placeholder=" " min="1" max="125" required> 
			
			<br>
			<label for="input" class="infoimp text-center">Solo se admiten letras</label>
			
			<br>
			
			<h5 class="titulos2 text-center">Inserte la fecha de solicitud</h5>
			<input class="ingresar text-center" type="date" name="fsolicitud" class="text-success"> <br>

			<br>

			<h5 class="titulos2 text-center">Ingrese el nombre del colegio donde se graduo</h5>
			<input type="text" class="ingresar text-center" id="input" placeholder="  " required> 
			
			<br>
			
			<label for="input " class="infoimp text-center">Solo se admiten letras</label>
			
			<br>
			
			<h5 class="titulos2 text-center">Seleccione la carrera que desea estudiar</h5>
			<select class="desplegables text-center" aria-label="Default select example" required>
				<option selected>Selecione</option>
				<option value="1">Arquitectura</option>
				<option value="2">Administración de Empresas</option>
				<option value="3">Administración de Negocios Sostenibles - Modalidad Virtual</option>
				<option value="4">Administración de Producción y Logística Internacional - Modalidad Virtual</option>
				<option value="5">Arte Dramático</option>
				<option value="6">Artes Plásticas</option>
				<option value="7">Bioingeniería</option>
				<option value="8">Biología</option>
				<option value="9">Ciencia Política y Gobierno</option>
				<option value="10">Contaduría Pública - Modalidad Virtual</option>
				<option value="11">Derecho</option>
				<option value="12">Diseño de Comunicación</option>
				<option value="13">Diseño Industrial</option>
				<option value="14">Economía - Modalidad Virtual</option>
				<option value="15">Enfermería</option>
				<option value="16">Estadística</option>
				<option value="17">Filosofía</option>
				<option value="18">Finanzas - Modalidad Virtual</option>
				<option value="19">Formación Musical</option>
				<option value="20">Ingeniería Ambiental</option>
				<option value="21">Ingeniería de Sistemas</option>
				<option value="22">Ingeniería Electrónica</option>
				<option value="23">Ingeniería Industrial</option>
				<option value="24">Instrumentación Quirúrgica</option>
				<option value="25">Intérprete Profesional de la Lengua de Señas Colombiana - Modalidad Virtual</option>
				<option value="26">Licenciatura en Bilingüismo con Énfasis en la Enseñanza del Inglés</option>
				<option value="27">Licenciatura en Educación Infantil</option>
				<option value="28">Marketing y Transformación Digital - Modalidad Virtual</option>
				<option value="29">Matemáticas</option>
				<option value="30">Medicina</option>
				<option value="31">Negocios Internacionales</option>
				<option value="32">Odontología</option>
				<option value="33">Optometría</option>
				<option value="34">Psicología</option>
				<option value="35">Química Farmacéutica</option>
			</select>
			
			<br>

			<h5 class="titulos2 text-center">Seleccione su estrato</h5>
			<select class="desplegables text-center" aria-label="Default select example" required>
				<option selected>Seleccione</option>
				<option value="1">Uno</option>
				<option value="2">Dos</option>
				<option value="3">Tres</option>
				<option value="4">Cuatro</option>
				<option value="5">Cinco</option>
				<option value="6">Seis</option>
			</select>

			<br>

			<h5 class="titulos2 text-center">Marque la casilla si está homologado</h5>	
			<select class="desplegables text-center" aria-label="Default select example" required>
				<option selected>Seleccione</option>
				<option value="1">Homologado</option>
				<option value="2">No homologado</option>
			</select>
			
			<br>
			 
			<input class="botones" type="submit" class="bg-primary">
			
		</form>
	</div>
</body>
</html>