/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatypes;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Seba de la gente
 */
public class DataCategoria {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private final Set<DataPair> videos;

    public Set<DataPair> getVideos() {
        return videos;
    }

    private final Set<DataPair> listas;

    public Set<DataPair> getListas() {
        return listas;
    }

    private final Set<String> usuarios;

    public Set<String> getUsuarios() {
        return usuarios;
    }

    public DataCategoria() {
        nombre = "";
        videos = new HashSet<>();
        listas = new HashSet<>();
        usuarios = new HashSet<>();
    }
    
}
