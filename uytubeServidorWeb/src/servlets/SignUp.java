package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DataCanal;
import datatypes.DataUsuario;
import excepciones.NoExisteInstanciaException;
import excepciones.NombreRepetidoException;
import logica.Fabrica;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public DataUsuario cargarDataUsuario(HttpServletRequest request) {
    	DataUsuario dataU = new DataUsuario();
    	dataU.setNickname(request.getParameter("nickname"));
    	dataU.setPassword(request.getParameter("password"));
    	dataU.setNombre(request.getParameter("nombre"));
    	dataU.setApellido(request.getParameter("apellido"));
    	dataU.setCorreo(request.getParameter("correo"));
    	dataU.setImagen(request.getParameter("imagen"));
    	LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
    	dataU.setFechaNac(fecha);
    	DataCanal dataC = new DataCanal();
    	if (request.getParameter("canal").isEmpty())
    		dataC.setNombre(request.getParameter("nickname"));
    	else
    		dataC.setNombre(request.getParameter("canal"));
    	dataC.setDescripcion(request.getParameter("descripcion"));
    	dataC.setPrivado(request.getParameter("privado") != null);
    	dataC.setCategoria("");
    	dataU.setCanal(dataC);
    	return dataU;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getSession().getAttribute("logueado") != null) {
			response.sendRedirect("/app/home");
		} else {
			request.setAttribute("categorias", Fabrica.getInstancia().getIControlador().getCategorias());
			request.getRequestDispatcher("/WEB-INF/usuario/signUp.jsp").forward(request, response);
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
			try {
				Fabrica.getInstancia().getIControlador().confirmarAltaDeUsuario(cargarDataUsuario(request));
				response.sendRedirect("/app/login");
			} catch (NombreRepetidoException|NoExisteInstanciaException e) {
				request.setAttribute("error", e.getMessage());
				request.setAttribute("categorias", Fabrica.getInstancia().getIControlador().getCategorias());
				request.getRequestDispatcher("/WEB-INF/usuario/signUp.jsp").forward(request, response);
			}
		}
	}

}
