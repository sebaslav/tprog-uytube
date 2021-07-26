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
 * Servlet implementation class VerCategoria
 */
@WebServlet("/VerCategoria")
public class VerCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerCategoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String categoria = (String) request.getParameter("categoria");
		if (categoria == null) {
			response.sendRedirect("/app/home");
		} else {
			request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
			try {
				request.setAttribute("categoria", Fabrica.getInstancia().getIControlador().getDataCategoria(categoria));
				request.getRequestDispatcher("/WEB-INF/categoria/verCat.jsp").forward(request, response);
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
