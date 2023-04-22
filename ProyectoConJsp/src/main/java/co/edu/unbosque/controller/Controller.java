package co.edu.unbosque.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import co.edu.unbosque.model.EstudianteDao;
import co.edu.unbosque.persistence.FileHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EstudianteDao dao = new EstudianteDao();

	private String nombre;
	private String fecha;
	private String colegio;
	private String carrera;
	private int estrato;
	private long cedula;
	private String hom;
	private String homologado;
	private String photo = "";

	private String admin = "admin";
	private String registrarse = "registrarse";
	private String listar = "Listar";
	private String modificar = "modificar";

	private String pathFiles = "src/main/webapp/img/";
	private File uploads = new File(pathFiles);
	private String[] extens = { ".ico", ".png", ".jpg", ".jpeg" };

	public Controller() {
		try {
			this.dao.setLista(this.dao.getArchivo().leerDatos());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (req.getParameter(this.admin) != null && req.getParameter(this.admin).equals("Administrar")) {
				resp.sendRedirect("administrador.jsp");

			} else if (req.getParameter(this.registrarse) != null
					&& req.getParameter(this.registrarse).equals("Registrar estudiante")) {
				resp.sendRedirect("registrarse.jsp");

			} else if (req.getParameter(listar) != null && req.getParameter(listar).equals("Listar")) {
				PrintWriter salida = resp.getWriter();
				salida.println("<html>");
				salida.println("<head>");
				salida.println("<title>Informacion guardada</title>");
				salida.println("<meta charset=\"UTF-8\">");
				salida.println(
						"<link href=\"https://fonts.googleapis.com/css2?family=Secular+One&display=swap\" rel=\"stylesheet\">");
				salida.println("<link href=\"styles/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
				salida.println("<link\r\n"
						+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css\"\r\n"
						+ "	rel=\"stylesheet\"\r\n"
						+ "	integrity=\"sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp\"\r\n"
						+ "	crossorigin=\"anonymous\">");
				salida.println("<script\r\n"
						+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js\"\r\n"
						+ "	integrity=\"sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N\"\r\n"
						+ "	crossorigin=\"anonymous\"></script>");
				salida.println("<body class=\"body3\">");
				salida.println("<br>");
				salida.println("<h1 class=\"titulos\">Personas en tabla</h1>");
				salida.println("<h2>" + "<table class=\"table table-success table-striped\">\r\n" + "  <thead>\r\n"
						+ "    <tr>\r\n" + "      <th scope=\"col\">Nombre</th>\r\n"
						+ "      <th scope=\"col\">Colegio</th>\r\n" + "      <th scope=\"col\">Fecha</th>\r\n"
						+ "      <th scope=\"col\">Carrera</th>\r\n" + "      <th scope=\"col\">Homologado</th>\r\n"
						+ "  <th scope=\"col\">Estrato</th>\r\n" + "  <th scope=\"col\">Cedula</th>\r\n"
						+ "  <th scope=\"col\">Imagen</th>\r\n" + "    </tr>\r\n" + "  </thead>\r\n" + "  <tbody>\r\n"
						+ dao.mostrar(req) + "  </tbody>\r\n" + "</table>");
				salida.println("</body>");
				salida.println("</html>");
				salida.close();
			}
		} catch (Exception e) {
			resp.sendRedirect("index.jsp");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if (req.getParameter(this.registrarse) != null
					&& req.getParameter(this.registrarse).equals("registrarse")) {
				this.nombre = req.getParameter("nombre");
				this.fecha = req.getParameter("fecha");
				this.colegio = req.getParameter("colegio");
				this.carrera = req.getParameter("carrera");
				this.estrato = Integer.parseInt(req.getParameter("estrato"));
				this.cedula = Long.parseLong(req.getParameter("cedula"));
				this.hom = req.getParameter("homologado");

				if (this.hom.equals("1")) {
					this.homologado = "Si";

				} else if (this.hom.equals("2")) {
					this.homologado = "No";

				}
				saveCustomer(req, resp);
				String ruta = this.photo.substring(this.photo.lastIndexOf("\\") + 1);
				this.dao.crear(this.nombre, this.colegio, this.fecha, this.carrera, this.homologado,this.estrato, this.cedula, ruta);
				generarAviso(req, resp, "Registrado correctamente");
				
			} else if (req.getParameter(this.modificar) != null
					&& req.getParameter(this.modificar).equals("modificar")) {
				this.nombre = req.getParameter("nombre");
				this.fecha = req.getParameter("fecha");
				this.colegio = req.getParameter("colegio");
				this.carrera = req.getParameter("carrera");
				this.estrato = Integer.parseInt(req.getParameter("estrato"));
				this.cedula = Long.parseLong(req.getParameter("cedula"));
				this.hom = req.getParameter("homologado");

				if (this.hom.equals("1")) {
					this.homologado = "Si";

				} else if (this.hom.equals("2")) {
					this.homologado = "No";

				}
				saveCustomer(req, resp);
				String ruta = this.photo.substring(this.photo.lastIndexOf("\\") + 1);
					
				this.dao.actualizar(this.nombre, this.colegio, this.fecha, this.carrera, this.homologado,this.estrato, this.cedula, ruta);
				
				generarAviso(req, resp, "Creado correctamente");
				
			}

		} catch (Exception e) {
			System.out.println("F");
			e.printStackTrace();

		}

	}

	private String saveCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			Part part = req.getPart("file");

			if (part == null) {
				System.out.println("No ha seleccionado un archivo");
				return "";
			}

			if (isExtension(part.getSubmittedFileName(), extens)) {
				this.photo = saveFile(part, uploads);
				return "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Ya existe";

		}
		return "Guardado Correctamente";
	}

	private String saveFile(Part part, File pathUploads) {
		String pathAbsolute = "";

		try {

			Path path = Paths.get(part.getSubmittedFileName());
			String fileName = path.getFileName().toString();
			InputStream input = part.getInputStream();

			if (input != null) {
				File file = new File(pathUploads, fileName);
				pathAbsolute = file.getAbsolutePath();
				Files.copy(input, file.toPath());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pathAbsolute;
	}

	private boolean isExtension(String fileName, String[] extensions) {
		for (String et : extensions) {
			if (fileName.toLowerCase().endsWith(et)) {
				return true;
			}
		}

		return false;
	}

	public void generarAviso(HttpServletRequest req, HttpServletResponse resp, String aviso) throws IOException {
		PrintWriter salida = resp.getWriter();
		salida.println("<html>");
		salida.println("<head>");
		salida.println("<title>Informacion guardada</title>");
		salida.println("<meta charset=\"UTF-8\">");
		salida.println(
				"<link href=\"https://fonts.googleapis.com/css2?family=Secular+One&display=swap\" rel=\"stylesheet\">");
		salida.println("<link href=\"styles/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
		salida.println("<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp\"\r\n"
				+ "	crossorigin=\"anonymous\">");
		salida.println("<script\r\n"
				+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "	integrity=\"sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N\"\r\n"
				+ "	crossorigin=\"anonymous\"></script>");
		salida.println("</head>");
		salida.println("<body>");
		salida.println("<div class=\"contenedor\">");
		salida.println("<h1 class=\"titulos  text-center\">" + aviso + "</h1>");
		salida.println("</div>");
		salida.println("</body>");
		salida.println("</html>");
		salida.close();
	}
}
