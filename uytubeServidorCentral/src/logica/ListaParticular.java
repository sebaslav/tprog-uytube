/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import datatypes.DataLista;
import datatypes.DataPair;

/**
 *
 * @author Seba de la gente
 */
public class ListaParticular extends Lista {
    
    private final Set<Categoria> categorias;
    
    public ListaParticular(String nom, Boolean pri) {
        setNombre(nom);
        setPrivado(pri);
        setAutor(null);
        setVideos(new HashSet<>());
        categorias = new HashSet<>();
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }
    
    public void update(Categoria categoria) {
        Boolean agregar = false;
        Iterator<Video> iter = getVideos().iterator();
        while (!agregar && iter.hasNext()) {
            Video vid = iter.next();
            if (vid.getCategoria() == categoria)
                agregar = true;
        }
        if (agregar)
            this.addCategoria(categoria);
        else
            this.removeCategoria(categoria);
    }

    public void addCategoria(Categoria categoria) {
        categorias.add(categoria);
        categoria.addLista(this);
    }
    
    public void removeCategoria(Categoria categoria) {
        categorias.remove(categoria);
        categoria.removeLista(this);
    }
    
    @Override
    public void addVideo(Video video) {
        if (getVideos().add(video)) {
            video.addLista(this);
            if (video.hayCategoria())
                this.update(video.getCategoria());
        }
    }
    
    @Override
    public void removeVideo(Video video) {
        if (getVideos().remove(video)) {
            video.removeLista(this);
            if (video.hayCategoria())
                this.update(video.getCategoria());
        }
    }
    
    @Override
    public DataLista getDataLista() {
        DataLista data = new DataLista();
        data.setNombre(getNombre());
        data.setPrivado(getPrivado());
        data.setAutor(getAutor().getNickname());
        data.setTipo("Particular");
        getVideos()
            .forEach(v -> 
                    data.getVideos()
                            .add(new DataPair(v.getNickname(), v.getNombre())));
        categorias
            .forEach(c -> 
                    data.getCategorias()
                            .add(c.getNombre()));
        return data;
    }
    
    
    
}
