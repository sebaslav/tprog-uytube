/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashSet;

import datatypes.DataLista;
import datatypes.DataPair;

/**
 *
 * @author Seba de la gente
 */
public class ListaDefecto extends Lista {
	
	public ListaDefecto(String nom) {
        setNombre(nom);
        setPrivado(true);
        setAutor(null);
        setVideos(new HashSet<>());
    }

    @Override
    public DataLista getDataLista() {
        DataLista data = new DataLista();
        data.setNombre(getNombre());
        data.setPrivado(getPrivado());
        data.setAutor(getAutor().getNickname());
        data.setTipo("Defecto");
        getVideos()
            .forEach(v -> 
                    data.getVideos()
                            .add(new DataPair(v.getNickname(), v.getNombre())));
        return data;
    }
    
    
    
}
