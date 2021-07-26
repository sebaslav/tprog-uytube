package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logica.Fabrica;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buscar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
		String query = request.getParameter("q");
		String opcion = request.getParameter("opcion");
		if (query==null) {
			response.sendRedirect("/app/home");
		} else {
			switch(opcion) {
			case "usuarios": request.setAttribute("res", Fabrica.getInstancia().getIControlador().buscarUsuarios(query));
							 break;
			case "videos": request.setAttribute("res", Fabrica.getInstancia().getIControlador().buscarVideos(query));
						   break;
			case "listas": request.setAttribute("res", Fabrica.getInstancia().getIControlador().buscarListas(query));
						   break;
			default: response.sendRedirect("/app/home");
			}
			request.getRequestDispatcher("/WEB-INF/buscar/buscar.jsp").forward(request, response);
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
