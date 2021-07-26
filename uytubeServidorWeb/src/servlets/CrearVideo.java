package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DataVideo;
import excepciones.NoExisteInstanciaException;
import excepciones.NombreRepetidoException;
import logica.Fabrica;

/**
 * Servlet implementation class CrearVideo
 */
@WebServlet("/CrearVideo")
public class CrearVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearVideo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public DataVideo cargarDataV(HttpServletRequest request) {
    	DataVideo dataV = new DataVideo();
    	dataV.setNombre(request.getParameter("nombre"));
    	dataV.setDescripcion(request.getParameter("descripcion"));
    	dataV.setDuracion(request.getParameter("duracion"));
    	LocalDate fecha = LocalDate.now();
    	dataV.setFechaPub(fecha);
    	dataV.setUrl(request.getParameter("url"));
    	String categoria = null;
    	if (!request.getParameter("categoria").isEmpty()) {
    		categoria = request.getParameter("categoria");
    	}
    	dataV.setCategoria(categoria);
    	return dataV;
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
			request.getRequestDispatcher("/WEB-INF/video/crearVideo.jsp").forward(request, response);
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
				Fabrica.getInstancia().getIControlador().confirmarAltaDeVideo(usuario, cargarDataV(request));
				response.sendRedirect("/app/ver-video?usuario="+usuario+"&video="+request.getParameter("nombre"));
			} catch (NombreRepetidoException|NoExisteInstanciaException e) {
				request.setAttribute("error", e.getMessage());
				request.setAttribute("categorias", Fabrica.getInstancia().getIControlador().getCategorias());
				request.getRequestDispatcher("/WEB-INF/video/crearVideo.jsp").forward(request, response);
			}
		}
	}

}
