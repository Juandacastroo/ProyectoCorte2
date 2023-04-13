package co.edu.unbosque.daos;

import java.util.ArrayList;

import co.edu.unbosque.persistence.EstudianteDto;

public class EstudianteDao {

	private ArrayList<EstudianteDto> lista;

	public EstudianteDao() {
		this.lista = new ArrayList<EstudianteDto>();

	}

	public void crear(String nombre, String fecha, String colegio, String carrera, int estrato, int cedula , boolean homologado) {
		this.lista.add(new EstudianteDto(nombre, fecha, colegio, carrera, estrato, cedula, homologado));
	}

	public boolean eliminar(int cedula) {
		try {
			this.lista.remove(cedula);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(String nombre, String fecha, String colegio, String carrera, int estrato, int cedula , boolean homologado) {
		if(comprobarExistencia(cedula).equals("No Existe")) {
			return false;
		}
		try {
			this.lista.get(cedula).setNombre(nombre);
			this.lista.get(cedula).setFecha(fecha);
			this.lista.get(cedula).setColegio(colegio);
			this.lista.get(cedula).setCarrera(carrera);
			this.lista.get(cedula).setEstrato(estrato);
			this.lista.get(cedula).setHomologado(homologado);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void mostrar() {

	}
	public void buscar() {

	}
	public String comprobarExistencia(int cedula) {
		for (int i = 0;i<this.lista.size();i++) {
			if(this.lista.get(i).getCedula()==cedula) {
				return i+"";
			}else {
				return "No existe";
			}
		}
		return "No entró a ninguno";
		
	}

	public ArrayList<EstudianteDto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<EstudianteDto> lista) {
		this.lista = lista;
	}
	
}
