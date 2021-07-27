/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import datatypes.DataCategoria;
import datatypes.DataComentarios;
import datatypes.DataIngresoComentario;
import datatypes.DataLista;
import datatypes.DataPair;
import datatypes.DataUsuario;
import datatypes.DataVideo;
import excepciones.NoExisteInstanciaException;
import excepciones.NombreRepetidoException;
import excepciones.PrivacidadInvalidaException;
import excepciones.RedundanciaException;

/**
 *
 * @author Seba de la gente
 */
public class Controlador implements IControlador {
    
    public Controlador() {}
    
    @Override
    public Set<String> getCategorias() {
        return new HashSet<>(Manejador.getInstancia().getCategorias().keySet());
    }
    
    public Set<String> buscarUsuarios(String query) {
    	Set<String> usuarios = new HashSet<>();
    	for (String us : Manejador.getInstancia().getUsuarios().keySet()) {
    		if (us.toLowerCase().contains(query.toLowerCase()))
    			usuarios.add(us);
    	}
    	return usuarios;
    }
    
    public Set<DataPair> buscarVideos(String query) {
    	Set<DataPair> videos = new HashSet<>();
    	for (Usuario us : Manejador.getInstancia().getUsuarios().values()) {
    		for (String vid : us.getNdeVideos()) {
    			if (vid.toLowerCase().contains(query.toLowerCase())) {
    				DataPair par = new DataPair(us.getNickname(), vid);
    				videos.add(par);
    			}
    		}
    	}
    	return videos;
    }
    
    public Set<DataPair> buscarListas(String query) {
    	Set<DataPair> listas = new HashSet<>();
    	for (Usuario us : Manejador.getInstancia().getUsuarios().values()) {
    		for (String lis : us.getNdeListas()) {
    			if (lis.toLowerCase().contains(query.toLowerCase())) {
    				DataPair par = new DataPair(us.getNickname(), lis);
    				listas.add(par);
    			}
    		}
    	}
    	return listas;
    }
    
    public void confirmarAltaDeVideo(String usuario, DataVideo datos) throws NoExisteInstanciaException, NombreRepetidoException {
    	Usuario user = pedirUsuario(usuario);
    	if (user.getCanal().hayVideo(datos.getNombre()))
    		throw new NombreRepetidoException("El usuario " + usuario + " ya tiene un video llamado " + datos.getNombre());
    	Categoria cat = null;
    	String catString = datos.getCategoria();
    	//if (!catString.equals("")) {
    		//cat = pedirCategoria(catString);
    	//}
    	Video vid = user.getCanal().crearVideo(datos);
    	if (cat != null) {
    		vid.setCategoria(cat);
    		cat.addVideo(vid);
    	}
    }
    
    public void confirmarAltaDeUsuario(DataUsuario datos) throws NombreRepetidoException, NoExisteInstanciaException {
    	for (Usuario u : Manejador.getInstancia().getUsuarios().values()) {
            if (u.getNickname().equals(datos.getNickname()))
                throw new NombreRepetidoException("Ya existe un usuario llamado " + datos.getNickname());
            if (u.getCorreo().equals(datos.getCorreo()))
                throw new NombreRepetidoException("Ya existe un usuario con el correo " + datos.getCorreo());
        }
    	Categoria cat = null;
    	//String catString = datos.getCanal().getCategoria();
    	//if (!catString.equals("")) {
    		//cat = pedirCategoria(catString);
    	//}
    	Usuario user = new Usuario(datos);
    	Manejador.getInstancia().getUsuarios().put(user.getNickname(), user);
    	Canal canal = user.getCanal();
    	canal.setAutor(user);
    	if (cat != null) {
    		cat.addCanal(canal);
    		canal.setCategoria(cat);
    	}
    	Manejador.getInstancia().getCatListasDefecto().values().forEach(cld -> {
        	cld.addListaDefecto(canal.crearListaDefecto(cld.getNombre()));
        });
    }
    
    public Set<String> getVideos(String usuario) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	return user.getNdeVideos();
    }
    
    public DataVideo getDataVideo(String usuario, String video) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	Video vid = pedirVideo(user, video);
    	return vid.getDataVideo();
    }
    
    public Set<String> getListas(String usuario) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	return user.getNdeListas();
    }
    
    public DataLista getDataLista(String usuario, String lista) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	Lista lis = pedirLista(user, lista);
    	return lis.getDataLista();
    }
    
    public DataUsuario getDataUsuario(String usuario) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	return user.getDataUsuario();
    }
    
    public void confirmarModificarVideo(String usuario, String video, DataVideo datos) throws NoExisteInstanciaException, NombreRepetidoException, PrivacidadInvalidaException {
    	Usuario user = pedirUsuario(usuario);
    	Video vid = pedirVideo(user, video);
    	if (!video.equals(datos.getNombre()) && user.getCanal().hayVideo(datos.getNombre()))
    		throw new NombreRepetidoException("El usuario " + usuario + " ya tiene un video llamado " + datos.getNombre());
    	if (user.getCanal().getPrivado() && !datos.getPrivado())
    		throw new PrivacidadInvalidaException("El video no puede ser publico en un canal privado");
    	Categoria nCat = null;
    	String catString = datos.getCategoria();
    	//if (!catString.equals("")) {
    		//nCat = pedirCategoria(catString);
    	//}
    	user.getCanal().modificarVideo(video, datos);
    	Categoria cat = vid.getCategoria();
    	String nom = null;
    	if (cat != null)
    		nom = cat.getNombre();
    	if (!Objects.equals(nom, catString)) {
            if (nCat != null) {
                vid.setCategoria(nCat);
                nCat.addVideo(vid);
            } else
                vid.setCategoria();
            if (cat != null)
                cat.removeVideo(vid);
            for (Lista l : vid.getListas()) {
                if (l instanceof ListaParticular) {
                    if (cat != null)
                        ((ListaParticular) l).update(cat);
                    if (nCat != null)
                        ((ListaParticular) l).update(nCat);
                }
            }
        }
    }
    
    public void confirmarSeguirUsuario(String sigue, String aSeguir) throws NoExisteInstanciaException, RedundanciaException {
    	Usuario uSigue = pedirUsuario(sigue);
    	Usuario uASeguir = pedirUsuario(aSeguir);
    	if (uSigue.checkSigue(aSeguir))
    		throw new RedundanciaException("El usuario " + sigue + " ya esta siguiendo a " + aSeguir);
    	uSigue.addSigueA(uASeguir);
    	uASeguir.addLoSiguen(uSigue);
    }
    
    public void confirmarNoSeguirUsuario(String sigue, String aNoSeguir) throws RedundanciaException, NoExisteInstanciaException {
    	Usuario uSigue = pedirUsuario(sigue);
    	Usuario uANoSeguir = pedirUsuario(aNoSeguir);
    	if (!uSigue.checkSigue(aNoSeguir))
    		throw new RedundanciaException("El usuario " + sigue + " no esta siguiendo a " + aNoSeguir);
    	uSigue.removeSigueA(uANoSeguir);
    	uANoSeguir.removeLoSiguen(uSigue);
    }
    
    public void confirmarValorarVideo(String usuario, String video, String valorador, Boolean gusta) throws NoExisteInstanciaException, RedundanciaException {
    	Usuario user = pedirUsuario(usuario);
    	Usuario uVideo = pedirUsuario(valorador);
    	Video vid = pedirVideo(user, video);
    	if (gusta && vid.getGustan().contains(uVideo))
    		throw new RedundanciaException("Al usuario " + valorador + " ya le gusta este video");
    	if (!gusta && vid.getNoGustan().contains(uVideo))
    		throw new RedundanciaException("Al usuario " + valorador + " ya no le gusta este video");
    	vid.valorar(uVideo, gusta);
    }
    
    public DataComentarios getDataComentarios(String usuario, String video) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	Video vid = pedirVideo(user, video);
    	return vid.getDataComentarios();
    }
    
    public void confirmarComentarVideo(String usuario, String video, String comentador, DataIngresoComentario datos) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	Video vid = pedirVideo(user, video);
    	Usuario uCom = pedirUsuario(comentador);
    	Comentario com = vid.crearComentario(datos);
    	com.setUsuario(uCom);
    }
    
    public void confirmarAltaDeCategoria(String categoria) throws NombreRepetidoException {
    	if (Manejador.getInstancia().getCategorias().containsKey(categoria))
    		throw new NombreRepetidoException("La categoria " + categoria + " ya existe");
    	Manejador.getInstancia().getCategorias().put(categoria, new Categoria(categoria));
    }
    
    public DataCategoria getDataCategoria(String categoria) throws NoExisteInstanciaException {
    	Categoria cat = pedirCategoria(categoria);
    	return cat.getDataCategoria();
    }
    
    public void confirmarAgregarVideo(String usuarioV, String video, String usuarioL, String lista) throws NoExisteInstanciaException, RedundanciaException {
    	Usuario uVid = pedirUsuario(usuarioV);
    	Video vid = pedirVideo(uVid, video);
    	Usuario uLis = pedirUsuario(usuarioL);
    	Lista lis = pedirLista(uLis, lista);
    	if (lis.getVideos().contains(vid))
    		throw new RedundanciaException("La lista ya contiene este video");
    	lis.addVideo(vid);
    	vid.addLista(lis);
    }
    
    public void confirmarQuitarVideo(String usuarioV, String video, String usuarioL, String lista) throws NoExisteInstanciaException, RedundanciaException {
    	Usuario uVid = pedirUsuario(usuarioV);
    	Video vid = pedirVideo(uVid, video);
    	Usuario uLis = pedirUsuario(usuarioL);
    	Lista lis = pedirLista(uLis, lista);
    	if (!lis.getVideos().contains(vid))
    		throw new RedundanciaException("La lista ya no contiene este video");
    	lis.removeVideo(vid);
    	vid.removeLista(lis);
    }
    
    public void confirmarCrearListaD(String nombre) throws NombreRepetidoException {
    	Map<String, CatListaDefecto> clds = Manejador.getInstancia().getCatListasDefecto();
    	if (clds.containsKey(nombre))
    		throw new NombreRepetidoException("La Lista Defecto " + nombre + " ya existe");
    	Collection<Usuario> usuarios = Manejador.getInstancia().getUsuarios().values();
    	for (Usuario uS : usuarios) {
    		if (uS.getCanal().hayLista(nombre))
    			throw new NombreRepetidoException("El usuario " + uS.getNickname() + " ya tiene una lista llamada " + nombre);
    	}
    	CatListaDefecto cld = new CatListaDefecto(nombre);
    	clds.put(nombre, cld);
    	for (Usuario uS : usuarios) {
    		cld.addListaDefecto(uS.getCanal().crearListaDefecto(nombre));
    	}
    }
    
    public void confirmarCrearListaP(String usuario, String nombre, Boolean privado) throws NoExisteInstanciaException, NombreRepetidoException, PrivacidadInvalidaException {
    	Usuario user = pedirUsuario(usuario);
    	if (user.getCanal().hayLista(nombre))
    		throw new NombreRepetidoException("El usuario " + user.getNickname() + " ya tiene una lista llamada " + nombre);
    	if (!privado && user.getCanal().getPrivado())
    		throw new PrivacidadInvalidaException("La lista no puede ser publica en un canal privado");
    	user.getCanal().crearListaParticular(nombre, privado);
    }
    
    public Set<String> getListasParticulares(String usuario) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	return user.getNdeListasPart();
    }
    
    public void confirmarModificarLista(String usuario, String listaP, Boolean privado) throws NoExisteInstanciaException, PrivacidadInvalidaException {
    	Usuario user = pedirUsuario(usuario);
    	if (!user.getCanal().getNdeListasPart().contains(listaP))
    		throw new NoExisteInstanciaException("El usuario " + usuario + " no tiene una lista particular llamada " + listaP);
    	if (!privado && user.getCanal().getPrivado())
    		throw new PrivacidadInvalidaException("La lista no puede ser publica en un canal privado");
    	user.getCanal().getLista(listaP).setPrivado(privado);
    }
    
    public void confirmarModificarUsuario(String usuario, DataUsuario datos) throws NoExisteInstanciaException {
    	Usuario user = pedirUsuario(usuario);
    	Canal canal = user.getCanal();
    	String catString = datos.getCanal().getCategoria();
    	Categoria nCat = null;
    	//if (!catString.equals(""))
    		//nCat = pedirCategoria(catString);
    	String nom = null;
    	Categoria cat = canal.getCategoria();
    	if (cat != null)
    		nom = cat.getNombre();
    	if (!Objects.equals(nom, catString)) {
    		if (cat != null)
    			cat.removeCanal(canal);
    		if (nCat != null) {
    			nCat.addCanal(canal);
    			canal.setCategoria(nCat);
    		} else {
    			canal.setCategoria();
    		}
    	}
    	user.modificar(datos);
    }
    
    public Usuario pedirUsuario(String usuario) throws NoExisteInstanciaException {
    	Usuario uVid = Manejador.getInstancia().getUsuarios().get(usuario);
    	if (uVid == null)
    		throw new NoExisteInstanciaException("El usuario " + usuario + " no existe");
    	return uVid;
    }
    
    public Video pedirVideo(Usuario user, String video) throws NoExisteInstanciaException {
    	Video vid = user.getCanal().getVideo(video);
    	if (vid == null)
    		throw new NoExisteInstanciaException("El usuario " + user.getNickname() + " no tiene un video llamado " + video);
    	return vid;
    }
    
    public Lista pedirLista(Usuario user, String lista) throws NoExisteInstanciaException {
    	Lista lis = user.getCanal().getLista(lista);
    	if (lis == null)
    		throw new NoExisteInstanciaException("El usuario " + user.getNickname() + " no tiene una lista llamada " + lista);
    	return lis;
    }
    
    public Categoria pedirCategoria(String categoria) throws NoExisteInstanciaException {
    	Categoria cat = Manejador.getInstancia().getCategorias().get(categoria);
    	if (cat == null)
    		throw new NoExisteInstanciaException("La categoria " + categoria + " no existe");
    	return cat;
    }
    
}
