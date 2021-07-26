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
import excepciones.PrivacidadInvalidaException;
import logica.Fabrica;

/**
 * Servlet implementation class CambiarVideo
 */
@WebServlet("/CambiarVideo")
public class CambiarVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiarVideo() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public DataVideo cargarDataV(HttpServletRequest request) {
    	DataVideo dataV = new DataVideo();
    	dataV.setNombre(request.getParameter("nombreNuevo"));
    	dataV.setDescripcion(request.getParameter("descripcion"));
    	dataV.setDuracion(request.getParameter("duracion"));
    	LocalDate fecha = LocalDate.parse(request.getParameter("fecha"));
    	dataV.setFechaPub(fecha);
    	dataV.setUrl(request.getParameter("url"));
    	String categoria = null;
    	if (!request.getParameter("categoria").isEmpty()) {
    		categoria = request.getParameter("categoria");
    	}
    	dataV.setCategoria(categoria);
    	dataV.setPrivado(request.getParameter("privado") != null);
    	return dataV;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
		String usuario = (String) request.getSession().getAttribute("logueado");
		String video = request.getParameter("video");
		if (usuario == null) {
			response.sendRedirect("/app/login");
		} else if (video == null) {
			response.sendRedirect("/app/home");
		} else {
			try {
				request.setAttribute("video", Fabrica.getInstancia().getIControlador().getDataVideo(usuario, video));
				request.setAttribute("categorias", Fabrica.getInstancia().getIControlador().getCategorias());
				request.getRequestDispatcher("/WEB-INF/video/cambiarVideo.jsp").forward(request, response);
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
		request.setAttribute("usrLog", Home.getUsuarioLogueado(request));
		String usuario = (String) request.getSession().getAttribute("logueado");
		String video = request.getParameter("nombreViejo");
		if (usuario == null ) {
			response.sendRedirect("/app/login");
		} else {
			try {
				Fabrica.getInstancia().getIControlador().confirmarModificarVideo(usuario, video, cargarDataV(request));
				response.sendRedirect("/app/ver-video?usuario="+usuario+"&video="+request.getParameter("nombreNuevo"));
			} catch (NoExisteInstanciaException|NombreRepetidoException|PrivacidadInvalidaException e) {
				try {
					request.setAttribute("video", Fabrica.getInstancia().getIControlador().getDataVideo(usuario, video));
					request.setAttribute("error", e.getMessage());
					request.setAttribute("categorias", Fabrica.getInstancia().getIControlador().getCategorias());
					request.getRequestDispatcher("/WEB-INF/video/cambiarVideo.jsp").forward(request, response);
				} catch (NoExisteInstanciaException ex) {
					request.setAttribute("error", ex.getMessage());
					request.getRequestDispatcher("/WEB-INF/errorPages/404.jsp").forward(request, response);
				}
			}
		}
	}

}
