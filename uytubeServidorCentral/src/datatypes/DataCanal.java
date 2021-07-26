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
public class DataCanal {
    
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String autor;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private Boolean privado;

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    private String categoria;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private final Set<String> videos;

    public Set<String> getVideos() {
        return videos;
    }

    private final Set<String> listas;

    public Set<String> getListas() {
        return listas;
    }

    public DataCanal() {
        this.nombre = "";
        this.autor = "";
        this.descripcion = "";
        this.privado = true;
        this.categoria = "";
        this.videos = new HashSet<>();
        this.listas = new HashSet<>();
    }

}
