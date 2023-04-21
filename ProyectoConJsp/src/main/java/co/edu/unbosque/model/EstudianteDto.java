package co.edu.unbosque.model;

public class EstudianteDto {
	private String nombre, colegio, fecha, carrera,homologado;
	private int estrato;
	private long cedula;
	
	

	public EstudianteDto(String nombre, String colegio, String fecha, String carrera, String homologado, int estrato,
			long cedula) {
		super();
		this.nombre = nombre;
		this.colegio = colegio;
		this.fecha = fecha;
		this.carrera = carrera;
		this.homologado = homologado;
		this.estrato = estrato;
		this.cedula = cedula;
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



	public String getCarrera() {
		return carrera;
	}



	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}



	public String getHomologado() {
		return homologado;
	}



	public void setHomologado(String homologado) {
		this.homologado = homologado;
	}



	public int getEstrato() {
		return estrato;
	}



	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}



	public long getCedula() {
		return cedula;
	}



	public void setCedula(long cedula) {
		this.cedula = cedula;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 
				 nombre+";"+colegio+";"+fecha+";"+carrera+";"+homologado+";"+estrato+";"+cedula;
	}
	
}
