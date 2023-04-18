<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
</head>
<body>
	<div>
		<h1 class="text-bg-info p-3">Registrarse</h1>
	</div>
	<div>
		<form action="http://localhost:8080/ProyectoConJsp/ingresarPersona"
			method="POST">
			<h5 class="font-weight-bold">Ingrese Su Nombre Completo</h5>
			<div class="form-floating text-secondary">
				<input type="text" class="form-control" id="input" placeholder=" "
					min="1" max="125" required> <label for="input"
					class="form-label">Solo se admiten letras</label>
			</div>

			<br>

			<h5 class="font-weight-bold">Ingrese Su Fecha De Nacimiento</h5>
			<section class="container">
				<div class="row form-group">
					<label for="date" class="col-sm-1 col-form-label text-secondary">*Presione
						El Icono</label>
					<div class="col-sm-4">
						<div class="input-group date" id="datepicker">
							<input type="text" class="form-control"> <span
								class="input-group-append"> <span
								class="input-group-text bg-white"> <i
									class="fa fa-calendar" required></i>
							</span>
							</span>
						</div>
					</div>
				</div>
			</section>

			<br>

			<h5 class="font-weight-bold">Ingrese El Nombre Del Colegio Donde
				Se Graduo</h5>
			<div class="form-floating text-secondary">
				<input type="text" class="form-control" id="input" placeholder="  "
					required> <label for="input" class="form-label">Solo
					se admiten letras</label>
			</div>

			<br>

			<h5 class="font-weight-bold">Seleccione Su Carrera A Cursar</h5>
			<div class="form-floating">
				<select class="form-select" aria-label="Default select example" required>
					<option selected>Selecione Una</option>
					<option value="1">MAMELO</option>
					<option value="2">MUY</option>
					<option value="3">FUERTE</option>
					<option value="4">PROFESOR</option>
					<option value="5">DIEGO</option>
				</select>
			</div>

			<br>

			<h5 class="font-weight-bold">Seleccione Su Estrato</h5>
			<div class="form-floating">
				<select class="form-select" aria-label="Default select example" required>
					<option selected>Seleccione Uno</option>
					<option value="1">Uno</option>
					<option value="2">Dos</option>
					<option value="3">Tres</option>
					<option value="3">Cuatro</option>
					<option value="3">Cinco</option>
					<option value="3">Seis</option>
				</select>
			</div>

			<br>

			<h5 class="font-weight-bold">Marque la Casilla Si Está
				Homologado</h5>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="flexRadioDefault"
					id="flexRadioDefault1"> <label class="form-check-label"
					for="flexRadioDefault1" required> Si Estoy Homologado </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="flexRadioDefault"
					id="flexRadioDefault2" checked> <label
					class="form-check-label" for="flexRadioDefault2" required> No Estoy Homologado </label>
			</div>
			
			<br>
			
			<div>
				<input type="submit" class="bg-primary">
			</div>
		</form>
	</div>


	<script type="text/javascript">
		$(function() {
			$('#datepicker').datepicker();
		});
	</script>

</body>
</html>