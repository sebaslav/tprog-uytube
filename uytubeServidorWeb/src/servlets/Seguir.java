package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.NoExisteInstanciaException;
import excepciones.RedundanciaException;
import logica.Fabrica;

/**
 * Servlet implementation class Seguir
 */
@WebServlet("/Seguir")
public class Seguir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seguir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/app/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Home.getUsuarioLogueado(request);
		String sigue = (String) request.getSession().getAttribute("logueado");
		String loSiguen = request.getParameter("loSiguen");
		Boolean seguir = !request.getParameter("seguir").equals("Siguiendo");
		String text = "";
		if (sigue == null) {
			text = "Por favor logueate";
		} else {
			try {
				if (seguir) {
					Fabrica.getInstancia().getIControlador().confirmarSeguirUsuario(sigue, loSiguen);
				} else {
					Fabrica.getInstancia().getIControlador().confirmarNoSeguirUsuario(sigue, loSiguen);
				}
			} catch (NoExisteInstanciaException|RedundanciaException e) {
				text = e.getMessage();
			}
		}
		response.getWriter().write(text); 
	}

}
