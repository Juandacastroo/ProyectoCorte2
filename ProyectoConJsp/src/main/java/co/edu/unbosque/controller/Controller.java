package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.EstudianteDao;
import co.edu.unbosque.persistence.FileHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private String nombre;
	private String fecha;
	private String colegio;
	private String carrera;
	private int estrato;
	private long cedula;
	private String hom;
	private String homologado;
	private String admin = "admin";
	private String registrarse = "registrarse";
	private static final long serialVersionUID = 1L;
	private EstudianteDao dao = new EstudianteDao();
	private String listar = "Listar";
	private String modificar ="modificar";
	
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
			} else if (req.getParameter(this.registrarse) != null && req.getParameter(this.registrarse).equals("Registrar estudiante")) {
				resp.sendRedirect("registrarse.jsp");
			}else if(req.getParameter(listar) != null && req.getParameter(listar).equals("Listar")) {
				PrintWriter salida = resp.getWriter();
				salida.println("<html>");
				salida.println("<head>");
				salida.println("<title>Informacion guardada</title>");
				salida.println("<meta charset=\"UTF-8\">");
				salida.println("<link href=\"https://fonts.googleapis.com/css2?family=Secular+One&display=swap\" rel=\"stylesheet\">");
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
				salida.println("<h2>" + "<table class=\"table table-success table-striped\">\r\n" + "  <thead>\r\n" + "    <tr>\r\n"
						+ "      <th scope=\"col\">Nombre</th>\r\n" + "      <th scope=\"col\">Colegio</th>\r\n"
						+ "      <th scope=\"col\">Fecha</th>\r\n" + "      <th scope=\"col\">Carrera</th>\r\n"
						+ "      <th scope=\"col\">Homologado</th>\r\n" + "  <th scope=\"col\">Estrato</th>\r\n"
						+ "  <th scope=\"col\">Cedula</th>\r\n" + "    </tr>\r\n" + "  </thead>\r\n" + "  <tbody>\r\n"
						+ dao.mostrar() + "  </tbody>\r\n" + "</table>");
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
			if(req.getParameter(this.registrarse) != null && req.getParameter(this.registrarse).equals("registrarse")) {
				this.nombre = req.getParameter("nombre");
				System.out.println(this.nombre);
				this.fecha = req.getParameter("fecha");
				System.out.println(this.fecha);

				this.colegio = req.getParameter("colegio");
				System.out.println(this.colegio);

				this.carrera = req.getParameter("carrera");
				System.out.println(this.carrera);

				this.estrato = Integer.parseInt(req.getParameter("estrato"));
				System.out.println(this.estrato);

				this.cedula = Long.parseLong(req.getParameter("cedula"));
				System.out.println(this.cedula);

				this.hom = req.getParameter("homologado");
				System.out.println("" + this.hom);
				
				if(this.hom.equals("1")) {
					this.homologado="Si";
					
				}else if (this.hom.equals("2")){
					this.homologado="No";
					
				}
				
				this.dao.crear(this.nombre, this.colegio, this.fecha, this.carrera, this.homologado, this.estrato, this.cedula);
				PrintWriter salida = resp.getWriter();
				salida.println("<html>");
				salida.println("<head>");
				salida.println("<title>Informacion guardada</title>");
				salida.println("<meta charset=\"UTF-8\">");
				salida.println("<link href=\"https://fonts.googleapis.com/css2?family=Secular+One&display=swap\" rel=\"stylesheet\">");
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
				salida.println("<h1 class=\"titulos  text-center\">Se guardo <br> correctamente</h1>");
				salida.println("</div>");
				salida.println("</body>");
				salida.println("</html>");
				salida.close();

			}else if(req.getParameter(this.modificar) != null && req.getParameter(this.modificar).equals("modificar")) {
				this.nombre = req.getParameter("nombre");
				System.out.println(this.nombre);
				this.fecha = req.getParameter("fecha");
				System.out.println(this.fecha);

				this.colegio = req.getParameter("colegio");
				System.out.println(this.colegio);

				this.carrera = req.getParameter("carrera");
				System.out.println(this.carrera);

				this.estrato = Integer.parseInt(req.getParameter("estrato"));
				System.out.println(this.estrato);

				this.cedula = Long.parseLong(req.getParameter("cedula"));
				System.out.println(this.cedula);

				this.hom = req.getParameter("homologado");
				System.out.println("" + this.hom);
				
				if(this.hom.equals("1")) {
					this.homologado="Si";
					
				}else if (this.hom.equals("2")){
					this.homologado="No";
					
				}
				if(this.dao.actualizar(nombre, colegio, fecha, carrera, homologado, estrato, cedula) == false) {
					PrintWriter salida = resp.getWriter();
					salida.println("<html>");
					salida.println("<head>");
					salida.println("<title>Informacion guardada</title>");
					salida.println("<meta charset=\"UTF-8\">");
					salida.println("<link href=\"https://fonts.googleapis.com/css2?family=Secular+One&display=swap\" rel=\"stylesheet\">");
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
					salida.println("<h1 class=\"titulos  text-center\">Usuario No Encontrado</h1>");
					salida.println("</div>");
					salida.println("</body>");
					salida.println("</html>");
					salida.close();
					
					
				}else {
					this.dao.actualizar(nombre, colegio, fecha, carrera, homologado, estrato, cedula);
					PrintWriter salida = resp.getWriter();
					salida.println("<html>");
					salida.println("<head>");
					salida.println("<title>Informacion guardada</title>");
					salida.println("<meta charset=\"UTF-8\">");
					salida.println("<link href=\"https://fonts.googleapis.com/css2?family=Secular+One&display=swap\" rel=\"stylesheet\">");
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
					salida.println("<h1 class=\"titulos  text-center\">Se guardo <br> correctamente</h1>");
					salida.println("</div>");
					salida.println("</body>");
					salida.println("</html>");
					salida.close();
					
				}
			}
			
		} catch (Exception e) {
			System.out.println("F");
			e.printStackTrace();
			
		}

	}
}
