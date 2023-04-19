package co.edu.unbosque.model;

public class EstudianteDto {
	private String nombre, colegio, fecha, carrera;
	private int estrato, cedula;
	private boolean homologado;

	public EstudianteDto(String nombre, String fecha, String colegio, String carrera, int estrato, int cedula, boolean homologado) {
		this.nombre = nombre;
		this.colegio = colegio;
		this.fecha = fecha;
		this.estrato = estrato;
		this.homologado = homologado;
		this.cedula = cedula;
		this.carrera = carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColegio() {
		return colegio;
	}

	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getEstrato() {
		return estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}

	public boolean isHomologado() {
		return homologado;
	}

	public void setHomologado(boolean homologado) {
		this.homologado = homologado;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
}
