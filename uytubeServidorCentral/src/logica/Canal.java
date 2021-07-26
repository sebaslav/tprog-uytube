/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import datatypes.DataCanal;
import datatypes.DataVideo;

/**
 *
 * @author Seba de la gente
 */
public class Canal {
    
    private String nombre;
    private String descripcion;
    private Boolean privado;
    private Usuario autor;
    private Categoria categoria;
    private final Map<String, Video> videos;
    private final Map<String, Lista> listas;
    
    public Canal(DataCanal data) {
        nombre = data.getNombre();
        descripcion = data.getDescripcion();
        privado = data.getPrivado();
        categoria = null;
        autor = null;
        videos = new HashMap<>();
        listas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getNickname() {
        return autor.getNickname();
    }
    
    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCategoria() {
        this.categoria = null;
    }
    
    public Boolean hayCategoria() {
        return categoria != null;
    }
    
    

    public Map<String, Video> getVideos() {
        return videos;
    }

    public Boolean hayVideo(String video) {
        return videos.containsKey(video);
    }
    
    public Video getVideo(String video) {
        return videos.get(video);
    }
    
    public Video crearVideo(DataVideo datos) {
        Video video = new Video(datos);
        video.setAutor(this);
        videos.put(video.getNombre(), video);
        return video;
    }
    
    

    public Map<String, Lista> getListas() {
        return listas;
    }

    public Boolean hayLista(String lista) {
        return listas.containsKey(lista);
    }
    
    public Lista getLista(String lista) {
        return listas.get(lista);
    }
    
    public void crearListaParticular(String nom, Boolean pri) {
        ListaParticular listaP = new ListaParticular(nom, pri);
        listaP.setAutor(this);
        listas.put(nom, listaP);
    }
    
    public ListaDefecto crearListaDefecto(String nom) {
        ListaDefecto listaD = new ListaDefecto(nom);
        listaD.setAutor(this);
        listas.put(nom, listaD);
        return listaD;
    }
    
    public DataCanal getDataCanal() {
        DataCanal data = new DataCanal();
        data.setNombre(nombre);
        data.setDescripcion(descripcion);
        data.setPrivado(privado);
        data.setAutor(autor.getNickname());
        if (categoria != null)
            data.setCategoria(categoria.getNombre());
        data.getVideos().addAll(videos.keySet());
        data.getListas().addAll(listas.keySet());
        return data;
    }
    
    public void modificar(DataCanal data) {
        nombre = data.getNombre();
        descripcion = data.getDescripcion();
        if (privado == false && data.getPrivado() == true) {
            videos.values().forEach(v -> v.setPrivado(true));
            listas.values().forEach(l -> l.setPrivado(true));
        }
        privado = data.getPrivado();
    }
    
    public Set<String> getNdeVideos() {
        Set<String> res = new HashSet<>(videos.keySet());
        return res;
    }
    
    public Set<String> getNdeListas() {
        Set<String> res = new HashSet<>(listas.keySet());
        return res;
    }
    
    public Set<String> getNdeListasPart() {
        Set<String> res = new HashSet<>();
        listas.values().stream()
                .filter(l -> l instanceof ListaParticular)
                .forEach(l -> res.add(l.getNombre()));
        return res;
    }
    
    

	public void modificarVideo(String video, DataVideo datos) {
		Video vid = videos.get(video);
		videos.remove(video);
		videos.put(datos.getNombre(), vid);
		vid.modificar(datos);
	}
    
}
