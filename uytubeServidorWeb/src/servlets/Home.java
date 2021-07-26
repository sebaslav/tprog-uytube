package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DataUsuario;
import excepciones.NoExisteInstanciaException;
import logica.Fabrica;

/**
 * Servlet implementation class Home
 */

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static DataUsuario getUsuarioLogueado(HttpServletRequest req) {
    	String usrLog = (String) req.getSession().getAttribute("logueado");
    	if (usrLog != null) {
    		try {
    			return Fabrica.getInstancia().getIControlador().getDataUsuario(usrLog);
    		} catch (NoExisteInstanciaException e) {
    			req.getSession().removeAttribute("logueado");
    		}
    	}
    	return null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("usrLog", getUsuarioLogueado(request));
		request.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
