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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    public boolean validarUsuario(HttpServletRequest request) {
    	String usuario = request.getParameter("usuario");
    	String password = request.getParameter("password");
    	try {
    		DataUsuario dataU = Fabrica.getInstancia().getIControlador().getDataUsuario(usuario);
    		if (!dataU.getPassword().equals(password)) {
    			request.setAttribute("error", "Contraseña no válida");
    		}
    		return dataU.getPassword().equals(password);
    	} catch (NoExisteInstanciaException e) {
    		request.setAttribute("error", e.getMessage());
    		return false;
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("logueado") != null) {
			response.sendRedirect("/app/home");
		} else {
			request.getRequestDispatcher("/WEB-INF/usuario/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("logueado") != null) {
			response.sendRedirect("/app/home");
		} else {
			if (validarUsuario(request)) {
				String usuario = request.getParameter("usuario");
				request.getSession().setAttribute("logueado", usuario);
				response.sendRedirect("/app/perfil?usuario="+usuario);
			} else {
				request.getRequestDispatcher("/WEB-INF/usuario/login.jsp").forward(request, response);
			}
		}
	}

}
