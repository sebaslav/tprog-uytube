/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Set;

import datatypes.DataLista;

/**
 *
 * @author Seba de la gente
 */
public abstract class Lista {
    
	private String nombre;
	private Boolean privado;
	private Canal autor;
	private Set<Video> videos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    

    public Canal getAutor() {
        return autor;
    }

    public void setAutor(Canal autor) {
        this.autor = autor;
    }

    public String getNickname() {
        return autor.getNickname();
    }
    
    

    public Set<Video> getVideos() {
        return videos;
    }
    
    public void setVideos(Set<Video> videos) {
        this.videos = videos;
    }

    public void addVideo(Video video) {
        videos.add(video);
    }
    
    public void removeVideo(Video video) {
        videos.remove(video);
    }
    
    public abstract DataLista getDataLista();
    
}
