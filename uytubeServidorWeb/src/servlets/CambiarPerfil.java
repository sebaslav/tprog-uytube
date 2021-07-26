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
import logica.Fabrica;

/**
 * Servlet implementation class CambiarPerfil
 */
@WebServlet("/CambiarPerfil")
public class CambiarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public DataUsuario cargarDataUsuario(HttpServletRequest request) {
    	DataUsuario dataU = new DataUsuario();
    	dataU.setPassword(request.getParameter("password"));
    	dataU.setNombre(request.getParameter("nombre"));
    	dataU.setApellido(request.getParameter("apellido"));
    	dataU.setImagen(request.getParameter("imagen"));
    	LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
    	dataU.setFechaNac(fecha);
    	DataCanal dataC = new DataCanal();
    	dataC.setNombre(request.getParameter("canal"));
    	dataC.setDescripcion(request.getParameter("descripcion"));
    	dataC.setPrivado(request.getParameter("privado") != null);
    	dataC.setCategoria(request.getParameter("categoria"));
    	dataU.setCanal(dataC);
    	return dataU;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
		if (request.getSession().getAttribute("logueado") == null) {
			response.sendRedirect("/app/login");
		} else {
			request.setAttribute("categorias", Fabrica.getInstancia().getIControlador().getCategorias());
			request.getRequestDispatcher("/WEB-INF/usuario/cambiarPerfil.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
		String usuario = (String) request.getSession().getAttribute("logueado");
		if (usuario == null) {
			response.sendRedirect("/app/login");
		} else {
			try {
				Fabrica.getInstancia().getIControlador().confirmarModificarUsuario(usuario, cargarDataUsuario(request));
				response.sendRedirect("/app/perfil?usuario="+usuario);
			} catch (NoExisteInstanciaException e) {
				request.setAttribute("error", e.getMessage());
				request.setAttribute("categorias", Fabrica.getInstancia().getIControlador().getCategorias());
				request.getRequestDispatcher("/WEB-INF/usuario/cambiarPerfil.jsp").forward(request, response);
			}
		}
	}

}
