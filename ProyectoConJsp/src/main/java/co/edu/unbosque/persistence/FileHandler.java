package co.edu.unbosque.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import co.edu.unbosque.model.EstudianteDto;

public class FileHandler {
	private FileWriter writer;
	private BufferedWriter bWriter;
	private ArrayList<String> auxList;
	private ArrayList<EstudianteDto> lista;
	private File f;
	private Scanner sc;
	private String RUTA= "estudiantes.csv";

	public FileHandler() {
		this.lista = new ArrayList<>();
		this.auxList = new ArrayList<>();
		this.f = new File(RUTA);
	}

	public void escribirDatos(ArrayList<EstudianteDto> lista) throws IOException {
		
		this.writer = new FileWriter(f, false);
		for (int i = 0; i < lista.size(); i++) {
			this.writer.write(lista.get(i).toString() + "\n");
		}
		this.writer.close();
	}

	public ArrayList<EstudianteDto> leerDatos() throws IOException {
		try {
			this.sc = new Scanner(f);
			while(this.sc.hasNextLine()) {
				this.auxList.add(this.sc.nextLine());
			}
			this.sc.close();
			for(int i= 0;i<this.auxList.size();i++) {
				String datos = this.auxList.get(i);
				String[] a = datos.split(";");
				this.lista.add(new EstudianteDto(a[0], a[1], a[2], a[3], a[4], Integer.parseInt(a[5]), Long.parseLong(a[6])));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fallo al leer el archivo");
		}
		return this.lista;
		
	}

	public ArrayList<EstudianteDto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<EstudianteDto> lista) {
		this.lista = lista;
	}
	
}
