<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<script src="scripts/script.js"></script>
</head>
<body>
	<div class="contenedor2">
	
		<h1 class="titulos">Modificar</h1>
		
		<form id="formulario" class= "formulario" action="http://localhost:8080/ProyectoConJsp/ingresarPersona" method="POST">
			
			<h5 class="titulos2 text-center">Ingrese la Cedula del estudiante</h5>
			<input type="number" class="ingresar text-center" id="input" name="cedula" value="cedula"placeholder="  " max="9999999999" min="9999999" required> 
			
			<br>
			
			<h5 class="titulos2 text-center">Ingrese su nombre completo</h5>
			<input type="text" class="ingresar text-center" id="input" name="nombre" placeholder=" " min="1" max="125" required> 
			
			<br>
			<label for="input" class="infoimp text-center">Solo se admiten letras</label>
			
			<br>
			
			<h5 class="titulos2 text-center">Inserte la fecha de solicitud</h5>
			<input class="ingresar text-center" type="date"  name="fecha" value="fecha"class="text-success" required> <br>

			<br>

			<h5 class="titulos2 text-center">Ingrese el nombre del colegio donde se graduo</h5>
			<input type="text" class="ingresar text-center" id="input" name="colegio" placeholder="  " required>
			
			<br>
			
			<label for="input " class="infoimp text-center">Solo se admiten letras</label>
			
			<br>
			
			<h5 class="titulos2 text-center">Seleccione la carrera que desea estudiar</h5>
			<select id ="carreras" class="desplegables text-center" aria-label="Default select example" name="carrera" required>
				<option value="" selected disabled>Selecione</option>
				<option value="Arquitectura">Arquitectura</option>
				<option value="Administración de Empresas">Administración de Empresas</option>
				<option value="Administración de Negocios Sostenibles - Modalidad Virtual">Administración de Negocios Sostenibles - Modalidad Virtual</option>
				<option value="Administración de Producción y Logística Internacional - Modalidad Virtual">Administración de Producción y Logística Internacional - Modalidad Virtual</option>
				<option value="Arte Dramático">Arte Dramático</option>
				<option value="Artes Plásticas">Artes Plásticas</option>
				<option value="Bioingeniería">Bioingeniería</option>
				<option value="Biología">Biología</option>
				<option value="Ciencia Política y Gobierno">Ciencia Política y Gobierno</option>
				<option value="Contaduría Pública - Modalidad Virtual">Contaduría Pública - Modalidad Virtual</option>
				<option value="Derecho">Derecho</option>
				<option value="Diseño de Comunicación">Diseño de Comunicación</option>
				<option value="Diseño Industrial">Diseño Industrial</option>
				<option value="Economía - Modalidad Virtual">Economía - Modalidad Virtual</option>
				<option value="Enfermería">Enfermería</option>
				<option value="Estadística">Estadística</option>
				<option value="Filosofía">Filosofía</option>
				<option value="Finanzas - Modalidad">Finanzas - Modalidad Virtual</option>
				<option value="Formación Musical</">Formación Musical</option>
				<option value="Ingeniería Ambiental">Ingeniería Ambiental</option>
				<option value="Ingeniería de Sistemas">Ingeniería de Sistemas</option>
				<option value="Ingeniería Electrónica">Ingeniería Electrónica</option>
				<option value="Ingeniería Industrial">Ingeniería Industrial</option>
				<option value="Instrumentación Quirúrgica">Instrumentación Quirúrgica</option>
				<option value="Intérprete Profesional de la Lengua de Señas Colombiana - Modalidad Virtual">Intérprete Profesional de la Lengua de Señas Colombiana - Modalidad Virtual</option>
				<option value="Licenciatura en Bilingüismo con Énfasis en la Enseñanza del Inglés">Licenciatura en Bilingüismo con Énfasis en la Enseñanza del Inglés</option>
				<option value="Licenciatura en Educación Infantil">Licenciatura en Educación Infantil</option>
				<option value="Marketing y Transformación Digital - Modalidad Virtual">Marketing y Transformación Digital - Modalidad Virtual</option>
				<option value="Matemáticas">Matemáticas</option>
				<option value="Medicina">Medicina</option>
				<option value="Negocios Internacionales">Negocios Internacionales</option>
				<option value="Odontología">Odontología</option>
				<option value="Optometría">Optometría</option>
				<option value="Psicología">Psicología</option>
				<option value="Química Farmacéutica">Química Farmacéutica</option>
			</select>
			<br>
			<h1 class="infoimp text-center" id="mostrar">Valor Carrera</h1>
			<br>

			<h5 class="titulos2 text-center">Seleccione su estrato</h5>
			<select class="desplegables text-center" aria-label="Default select example" name="estrato" required>
				<option value="" selected disabled>Seleccione</option>
				<option value="1">Uno</option>
				<option value="2">Dos</option>
				<option value="3">Tres</option>
				<option value="4">Cuatro</option>
				<option value="5">Cinco</option>
				<option value="6">Seis</option>
			</select>

			<br>

			<h5 class="titulos2 text-center">Marque la casilla si está homologado</h5>	
			<select class="desplegables text-center" aria-label="Default select example" name="homologado" required>
				<option value="" selected disabled>Seleccione</option>
				<option value="1">Homologado</option>
				<option value="2">No homologado</option>
			</select>
			
			<br>
			
			<input class="desplegables" type="file" name="imagen" accept="image/*" required>
			
		</form>
	</div>
	
	<form id="listar" action="http://localhost:8080/ProyectoConJsp/ingresarPersona" method="get">
		<input class="botones" type="submit" value="Listar" name="Listar">
	</form>
	
	<div class="contenedor4">
		<br>
		<input name="modificar" class="botones" type="submit" value="modificar" form="formulario">
	</div>
	<br>
	</body>
	
</html>