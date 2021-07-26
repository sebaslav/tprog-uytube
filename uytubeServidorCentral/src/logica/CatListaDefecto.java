/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Seba de la gente
 */
public class CatListaDefecto {
    
    private String nombre;
    private final Set<ListaDefecto> listas;
    
    public CatListaDefecto(String nombre) {
        this.nombre = nombre;
        listas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public Set<ListaDefecto> getListas() {
        return listas;
    }

    public void addListaDefecto(ListaDefecto lista) {
        listas.add(lista);
    }
    
    
    
}
