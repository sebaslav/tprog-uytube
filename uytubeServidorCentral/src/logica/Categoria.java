/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashSet;
import java.util.Set;

import datatypes.DataCategoria;
import datatypes.DataPair;

/**
 *
 * @author Seba de la gente
 */
public class Categoria {
    
    private String nombre;
    private final Set<Canal> canales;
    private final Set<Video> videos;
    private final Set<ListaParticular> listas;
    
    public Categoria(String nombre) {
        this.nombre = nombre;
        videos = new HashSet<>();
        listas = new HashSet<>();
        canales = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public Set<Canal> getCanales() {
        return canales;
    }

    public void addCanal(Canal canal) {
        canales.add(canal);
    }
    
    public void removeCanal(Canal canal) {
        canales.remove(canal);
    }
    
    

    public Set<Video> getVideos() {
        return videos;
    }

    public void addVideo(Video video) {
        videos.add(video);
    }
    
    public void removeVideo(Video video) {
        videos.remove(video);
    }
    
    

    public Set<ListaParticular> getListas() {
        return listas;
    }

    public void addLista(ListaParticular listaP) {
        listas.add(listaP);
    }
    
    public void removeLista(ListaParticular listaP) {
        listas.remove(listaP);
    }
    
    public DataCategoria getDataCategoria() {
        DataCategoria data = new DataCategoria();
        data.setNombre(nombre);
        videos.forEach(v -> data.getVideos().add(new DataPair(v.getNickname(), v.getNombre())));
        listas.forEach(l -> data.getListas().add(new DataPair(l.getNickname(), l.getNombre())));
        canales.forEach(c -> data.getUsuarios().add(c.getNickname()));
        return data;
    }

    
    
}
