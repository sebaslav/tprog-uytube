package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.NoExisteInstanciaException;
import excepciones.NombreRepetidoException;
import excepciones.PrivacidadInvalidaException;
import logica.Fabrica;

/**
 * Servlet implementation class CrearLista
 */
@WebServlet("/CrearLista")
public class CrearLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearLista() {
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
		String usuario = (String) request.getSession().getAttribute("logueado");
		String lista = request.getParameter("nombreLista");
		String text = "";
		if (usuario == null) {
			text = "Por favor logueate";
		} else {
			try {
				Fabrica.getInstancia().getIControlador().confirmarCrearListaP(usuario, lista, request.getParameter("privadoLista") != null);
			} catch (NombreRepetidoException|NoExisteInstanciaException|PrivacidadInvalidaException e) {
				text = e.getMessage();
			}
		}
		response.getWriter().write(text); 
	}

}
