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
 * Servlet implementation class AddVideo
 */
@WebServlet("/AddRemoveVideo")
public class AddRemoveVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRemoveVideo() {
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
		String lista = request.getParameter("lista");
		String video = request.getParameter("video");
		String usrVideo = request.getParameter("usrVideo");
		Boolean add = request.getParameter("add").equals("true");
		String text = "";
		if (usuario == null) {
			text = "Por favor logueate";
		} else {
			try {
				if (add)
					Fabrica.getInstancia().getIControlador().confirmarAgregarVideo(usrVideo, video, usuario, lista);
				else
					Fabrica.getInstancia().getIControlador().confirmarQuitarVideo(usrVideo, video, usuario, lista);
			} catch (NoExisteInstanciaException|RedundanciaException e) {
				text = e.getMessage();
			}
		}
		response.getWriter().write(text);
	}

}
