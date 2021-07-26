package servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DataIngresoComentario;
import excepciones.NoExisteInstanciaException;
import logica.Fabrica;

/**
 * Servlet implementation class Comentar
 */
@WebServlet("/Comentar")
public class Comentar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comentar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/app/home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Home.getUsuarioLogueado(request);
		String usuario = (String) request.getSession().getAttribute("logueado");
		String usrVideo = request.getParameter("usrVideo");
		String nomVideo = request.getParameter("nomVideo");
		String ruta = request.getParameter("ruta");
		LocalDateTime fecha = LocalDateTime.parse(request.getParameter("fechaHora").substring(0, 19));
		String texto = request.getParameter("texto");
		String text = "";
		DataIngresoComentario dataIngCom = new DataIngresoComentario(fecha, texto, ruta);
		if (usuario == null) {
			text = "Por favor logueate";
		} else {
			try {
				Fabrica.getInstancia().getIControlador().confirmarComentarVideo(usrVideo, nomVideo, usuario, dataIngCom);
			} catch (NoExisteInstanciaException e) {
				text = e.getMessage();
			}
		}
		response.getWriter().write(text); 
	}

}
