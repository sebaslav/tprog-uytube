/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Seba de la gente
 */
public class Manejador {
    
    private final Map<String, Usuario> usuarios;
    private final Map<String, Categoria> categorias;
    private final Map<String, CatListaDefecto> catListasDefecto;
    private static Manejador instancia;
    
    private Manejador() {
        usuarios = new HashMap<>();
        categorias = new HashMap<>();
        catListasDefecto = new HashMap<>();
    }
    
    public static Manejador getInstancia() {
        if (instancia == null)
            instancia = new Manejador();
        return instancia;
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    

    public Map<String, Categoria> getCategorias() {
        return categorias;
    }

    

    public Map<String, CatListaDefecto> getCatListasDefecto() {
        return catListasDefecto;
    }
    
    
    
    
    
    
    
}
