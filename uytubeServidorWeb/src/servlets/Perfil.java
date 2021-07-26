package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DataUsuario;
import excepciones.NoExisteInstanciaException;
import logica.Fabrica;

/**
 * Servlet implementation class Perfil
 */
@WebServlet("/Perfil")
public class Perfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Perfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = (String) request.getParameter("usuario");
		if (usuario == null) {
			response.sendRedirect("/app/home");
		} else {
			request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
			try {
				DataUsuario dataU = Fabrica.getInstancia().getIControlador().getDataUsuario(usuario);
				request.setAttribute("usrPerfil", dataU);
				request.getRequestDispatcher("/WEB-INF/usuario/perfil.jsp").forward(request, response);
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
