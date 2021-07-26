/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seba de la gente
 */
public class DataComentario {
    
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private final List<DataComentario> comentarios;

    public List<DataComentario> getComentarios() {
        return comentarios;
    }
    
    public String toString() {
    	return "(" + usuario + ") " + texto + fecha.toString();
    }

    public DataComentario() {
        texto = "";
        fecha = null;
        usuario = "";
        ruta = "";
        comentarios = new ArrayList<>();
    }
    
}
