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
public class DataIngresoComentario {
    
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    private LocalDateTime fecha;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    private Integer[] comentarioPadre;

    public Integer[] getComentarioPadre() {
        return comentarioPadre;
    }

    public void setComentarioPadre(Integer[] comentarioPadre) {
        this.comentarioPadre = comentarioPadre;
    }
    
    public void setComentarioPadre(String ruta) {
        if (!ruta.equals("")) {
        	List<Integer> lista = new ArrayList<>();
        	Integer inicio = 0;
        	for (int i=0; i<ruta.length(); i++) {
        		if (ruta.charAt(i) == '.') {
        			lista.add(Integer.parseInt(ruta.substring(inicio, i)));
        			inicio = i+1;
        		}
        	}
        	lista.add(Integer.parseInt(ruta.substring(inicio, ruta.length())));
        	Integer[] arr = new Integer[lista.size()];
        	arr = lista.toArray(arr);
        	comentarioPadre = arr;
        }
    }

    public DataIngresoComentario() {
        this.texto = "";
        this.fecha = null;
        this.comentarioPadre = null;
    }
    
    public DataIngresoComentario(LocalDateTime fecha, String texto, String ruta) {
        this.texto = texto;
        this.fecha = fecha;
        setComentarioPadre(ruta);
    }

}
