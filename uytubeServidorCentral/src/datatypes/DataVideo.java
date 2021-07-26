/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatypes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Seba de la gente
 */
public class DataVideo {
    
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

    private String duracion;

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    private LocalDate fechaPub;

    public LocalDate getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(LocalDate fechaPub) {
        this.fechaPub = fechaPub;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    private DataComentarios comentarios;

    public DataComentarios getComentarios() {
        return comentarios;
    }

    public void setComentarios(DataComentarios comentarios) {
        this.comentarios = comentarios;
    }

    private final Set<String> gustan;

    public Set<String> getGustan() {
        return gustan;
    }

    private final Set<String> noGustan;

    public Set<String> getNoGustan() {
        return noGustan;
    }

    public DataVideo() {
        nombre = "";
        autor = "";
        descripcion = "";
        duracion = "";
        fechaPub = null;
        url = "";
        privado = true;
        categoria = "";
        comentarios = new DataComentarios();
        gustan = new HashSet<>();
        noGustan = new HashSet<>();
    }
    
}
