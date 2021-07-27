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
public class DataLista {
    
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

    private Boolean privado;

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private final Set<DataPair> videos;

    public Set<DataPair> getVideos() {
        return videos;
    }

    private final Set<String> categorias;

    public Set<String> getCategorias() {
        return categorias;
    }

    public DataLista() {
        nombre = "";
        autor = "";
        privado = true;
        tipo = "";
        videos = new HashSet<>();
        categorias = new HashSet<>();
    }
    
}
