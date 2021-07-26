package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.NoExisteInstanciaException;
import excepciones.PrivacidadInvalidaException;
import logica.Fabrica;

/**
 * Servlet implementation class CambiarLista
 */
@WebServlet("/CambiarLista")
public class CambiarLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarLista() {
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
		Boolean privado = request.getParameter("privadoLista").equals("publica");
		String text = "";
		if (usuario == null) {
			text = "Por favor logueate";
		} else {
			try {
				Fabrica.getInstancia().getIControlador().confirmarModificarLista(usuario, lista, privado);
			} catch (NoExisteInstanciaException|PrivacidadInvalidaException e) {
				text = e.getMessage();
			}
		}
		response.getWriter().write(text); 
	}

}
