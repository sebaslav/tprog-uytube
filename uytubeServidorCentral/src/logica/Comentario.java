/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import datatypes.DataComentario;
import datatypes.DataIngresoComentario;
import excepciones.NoExisteInstanciaException;

/**
 *
 * @author Seba de la gente
 */
public class Comentario {
    
    private LocalDateTime fecha;
    private String texto;
    private Usuario usuario;
    private final List<Comentario> comentarios;
    
    public Comentario(DataIngresoComentario data) {
        fecha = data.getFecha();
        texto = data.getTexto();
        usuario = null;
        comentarios = new ArrayList<>();
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

    public List<Comentario> getComentarios() {
        return comentarios;
    }
    
    public Comentario getComentario(Integer[] ruta) throws NoExisteInstanciaException {
    	Comentario com;
    	Integer indice = ruta[0];
        if (indice > comentarios.size())
    		throw new NoExisteInstanciaException("Ruta no valida. No se encontro el comentario padre");
        if (ruta.length == 1) {
        	com = comentarios.get(indice-1);
        }
        else {
        	Integer[] sub = Arrays.copyOfRange(ruta, 1, ruta.length);
        	com = comentarios.get(indice-1).getComentario(sub);
        }
        return com;
    }
    
    public void addComentario(Comentario comentario) {
    	comentarios.add(comentario);
    }
    
    public DataComentario getDataComentario(String ruta) {
        DataComentario data = new DataComentario();
        data.setTexto(texto);
        data.setFecha(fecha);
        data.setUsuario(usuario.getNickname());
        data.setRuta(ruta);
        for (int i=0; i<comentarios.size(); i++) {
        	String indice = String.valueOf(i+1);
        	String nuevaRuta = ruta.concat(".").concat(indice);
        	Comentario com = comentarios.get(i);
        	DataComentario dataC = com.getDataComentario(nuevaRuta);
        	data.getComentarios().add(dataC);
        }
        return data;
    }
    
    
    
}
