package co.edu.unbosque.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet{

	/**
	 * 
	 */
	private String admin = "admin";
	private String registrarse = "registrarse";
	private static final long serialVersionUID = 1L;
	public Controller() {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			if(req.getParameter(admin) != null && req.getParameter(admin).equals("Administrador")) {
				resp.sendRedirect("administrador.jsp");
			}else if(req.getParameter(registrarse) != null && req.getParameter(registrarse).equals("Registrarse")){
				resp.sendRedirect("registrarse.jsp");
			}
		} catch (Exception e) {
			resp.sendRedirect("index.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
