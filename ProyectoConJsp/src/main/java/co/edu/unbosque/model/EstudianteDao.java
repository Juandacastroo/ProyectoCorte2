package co.edu.unbosque.model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import co.edu.unbosque.persistence.FileHandler;

public class EstudianteDao {

	private ArrayList<EstudianteDto> lista;
	private FileHandler archivo;
	private File file = new File("estudiantes.csv");
	

	public EstudianteDao() {
		this.lista = new ArrayList<EstudianteDto>();
		this.archivo = new FileHandler();
	
	}

	public void crear(String nombre, String colegio, String fecha, String carrera, String homologado, int estrato,
			long cedula) {
		this.lista.add(new EstudianteDto(nombre, colegio, fecha, carrera, homologado, estrato, cedula));

		try {
			this.archivo.escribirDatos(lista, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			int estrato, long cedula) {
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
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String mostrar() throws IOException {
		String concatenar = "";
		for (int i = 0; i < lista.size(); i++) {
			String a = "    <tr>\r\n" + "      <th scope=\"row\">" + archivo.getLista().get(i).getNombre()  + "</th>\r\n"
					+ "      <td>" + archivo.getLista().get(i).getColegio() + "</td>\r\n" + "      <td>" + archivo.getLista().get(i).getFecha()
					+ "</td>\r\n" + "      <td>" + archivo.getLista().get(i).getCarrera() + "</td>\r\n" + "      <td>"
					+ archivo.getLista().get(i).getHomologado()  + "</td>\r\n" + "      <td>" + archivo.getLista().get(i).getEstrato()
					+ "</td>\r\n" + "</td>\r\n" + "      <td>"
					+ archivo.getLista().get(i).getCedula()  + "</td>\r\n" + "    </tr>\r\n";
			concatenar = concatenar + a;
		}
		return concatenar;
	}

	public void buscar() {

	}

	public String comprobarExistencia(long cedula) {
		for (int i = 0; i < this.lista.size(); i++) {
			if (this.lista.get(i).getCedula() == cedula) {
				return i + "";
			} else {
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

	public FileHandler getArchivo() {
		return archivo;
	}

	public void setArchivo(FileHandler archivo) {
		this.archivo = archivo;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
