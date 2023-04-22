package co.edu.unbosque.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import co.edu.unbosque.persistence.FileHandler;
import jakarta.servlet.http.HttpServletRequest;

public class EstudianteDao {

	private ArrayList<EstudianteDto> lista;
	private FileHandler archivo;
	

	public EstudianteDao() {
		this.lista = new ArrayList<EstudianteDto>();
		this.archivo = new FileHandler();
	
	}

	public String crear(String nombre, String colegio, String fecha, String carrera, String homologado, int estrato, long cedula, String imagen) {
		String aux = comprobarExistencia(cedula);
		if (aux.equals("No Existe")) {
			this.lista.add(new EstudianteDto(nombre, colegio, fecha, carrera, homologado, estrato, cedula, imagen));
			try {
				this.archivo.escribirDatos(lista);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			return "Ya existe";
		}
		return "Creado Correctamente";
	}

	public boolean eliminar(int cedula) {
		try {
			this.lista.remove(cedula);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizar(String nombre, String colegio, String fecha, String carrera, String homologado,
			int estrato, long cedula, String imagen) {
		String aux = comprobarExistencia(cedula);
		if (aux.equals("No Existe")) {
			return false;
		}
		try {
			int aux2 = Integer.parseInt(aux);
			this.lista.get(aux2).setNombre(nombre);
			this.lista.get(aux2).setFecha(fecha);
			this.lista.get(aux2).setColegio(colegio);
			this.lista.get(aux2).setCarrera(carrera);
			this.lista.get(aux2).setEstrato(estrato);
			this.lista.get(aux2).setHomologado(homologado);
			if(imagen.equals(this.lista.get(aux2).getImagen())) {
				
			}else {
				this.lista.get(aux2).setImagen(imagen);
			}
			try {
				this.archivo.escribirDatos(this.lista);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String mostrar(HttpServletRequest req) throws IOException {
		String concatenar = "";
		for (int i = 0; i < lista.size(); i++) {
			String a = "    <tr>\r\n" + "      <th scope=\"row\">" + archivo.getLista().get(i).getNombre()  + "</th>\r\n"
					+ "      <td>" + archivo.getLista().get(i).getColegio() + "</td>\r\n" + "      <td>" + archivo.getLista().get(i).getFecha()
					+ "</td>\r\n" + "      <td>" + archivo.getLista().get(i).getCarrera() + "</td>\r\n" + "      <td>"
					+ archivo.getLista().get(i).getHomologado()  + "</td>\r\n" + "      <td>" + archivo.getLista().get(i).getEstrato()
					+ "</td>\r\n" + "</td>\r\n" + "      <td>"
					+ archivo.getLista().get(i).getCedula()  + "</td>\r\n" + "<td>" + "<img alt=\"prueba\" width=\"50\" height=\"50\" src=\"" + req.getContextPath() + "/img/" + archivo.getLista().get(i).getImagen() + "\">"+ "</td>\r\n" + "</tr>\r\n";
			concatenar = concatenar + a;
		}
		return concatenar;
	}

	public String eliminar(long cedula, ArrayList<EstudianteDao> lista, String ruta) {
		String aux = comprobarExistencia(cedula);
		if (aux.equals("No Existe")) {
			return "No Existe";
		}else {
			File file = new File(ruta);
			if (file.delete()) {
				this.lista.remove(Integer.parseInt(aux));
			    return "Persona eliminada";
			} else {
			    return "No se pudo eliminar la persona";
			}
		}
	}

	public String comprobarExistencia(long cedula) {
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getCedula() == cedula) {
				return i + "";
			}
		}
		return "No Existe";

	}

	public ArrayList<EstudianteDto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<EstudianteDto> lista) {
		this.lista = lista;
	}

	public FileHandler getArchivo() {
		return archivo;
	}

	public void setArchivo(FileHandler archivo) {
		this.archivo = archivo;
	}
}
