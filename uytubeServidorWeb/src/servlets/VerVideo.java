package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.NoExisteInstanciaException;
import logica.Fabrica;

/**
 * Servlet implementation class VerVideo
 */
@WebServlet("/VerVideo")
public class VerVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerVideo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = (String) request.getParameter("usuario");
		String video = (String) request.getParameter("video");
		if ((video == null) || (usuario == null)) {
			response.sendRedirect("/app/home");
		} else {
			request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
			try {
				request.setAttribute("video", Fabrica.getInstancia().getIControlador().getDataVideo(usuario, video));
				request.getRequestDispatcher("/WEB-INF/video/verVideo.jsp").forward(request, response);
			} catch (NoExisteInstanciaException e) {
				request.setAttribute("error", e.getMessage());
				request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
