/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import datatypes.DataComentario;
import datatypes.DataComentarios;
import datatypes.DataIngresoComentario;
import datatypes.DataVideo;
import excepciones.NoExisteInstanciaException;

/**
 *
 * @author Seba de la gente
 */
public class Video {
    
    private String nombre;
    private String descripcion;
    private String duracion;
    private LocalDate fechaPub;
    private String url;
    private Boolean privado;
    private Canal autor;
    private Categoria categoria;
    private final Set<Lista> listas;
    private final Set<Usuario> gustan;
    private final Set<Usuario> noGustan;
    private final List<Comentario> comentarios;
    
    public Video(DataVideo data) {
        nombre = data.getNombre();
        descripcion = data.getDescripcion();
        duracion = data.getDuracion();
        fechaPub = data.getFechaPub();
        url = data.getUrl();
        privado = true;
        autor = null;
        categoria = null;
        listas = new HashSet<>();
        gustan = new HashSet<>();
        noGustan = new HashSet<>();
        comentarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    

    public LocalDate getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(LocalDate fechaPub) {
        this.fechaPub = fechaPub;
    }

    

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    

    public Boolean getPrivado() {
        return privado;
    }

    public void setPrivado(Boolean privado) {
        this.privado = privado;
    }

    

    public Canal getAutor() {
        return autor;
    }

    public void setAutor(Canal autor) {
        this.autor = autor;
    }

    public String getNickname() {
        return autor.getNickname();
    }
    
    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCategoria() {
        this.categoria = null;
    }
    
    public Boolean hayCategoria() {
        return categoria != null;
    }
    
    

    public Set<Lista> getListas() {
        return listas;
    }

    public void addLista(Lista lista) {
        listas.add(lista);
    }
    
    public void removeLista(Lista lista) {
        listas.remove(lista);
    }
    
    

    public Set<Usuario> getGustan() {
        return gustan;
    }

    

    public Set<Usuario> getNoGustan() {
        return noGustan;
    }

    public void valorar(Usuario usuario, Boolean gusta) {
        if (gusta) {
            gustan.add(usuario);
            noGustan.remove(usuario);
        } else {
            gustan.remove(usuario);
            noGustan.add(usuario);
        }
    }
    
    

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public Comentario crearComentario(DataIngresoComentario data) throws NoExisteInstanciaException {
        Comentario comentario;
        if (data.getComentarioPadre() == null) {
        	comentario = new Comentario(data);
            comentarios.add(comentario);
        }
        else {
        	Comentario cPadre;
            Integer[] ruta = data.getComentarioPadre();
            Integer ind = ruta[0];
            if (ind > comentarios.size())
        		throw new NoExisteInstanciaException("Ruta no valida. No se encontro el comentario padre");
            if (ruta.length == 1) {
            	cPadre = comentarios.get(ind-1);
            } 
            else {
            	Integer[] sub = Arrays.copyOfRange(ruta, 1, ruta.length);
            	cPadre = comentarios.get(ind-1).getComentario(sub);
            }
            comentario = new Comentario(data);
            cPadre.addComentario(comentario);
        }
        return comentario;
    }
    
    public DataComentarios getDataComentarios() {
        DataComentarios data = new DataComentarios();
        for (int i=0; i<comentarios.size(); i++) {
        	String indice = String.valueOf(i+1);
        	Comentario com = comentarios.get(i);
        	DataComentario dataC = com.getDataComentario(indice);
        	data.getComentarios().add(dataC);
        }
        data.setVideo(nombre);
        return data;
    }
    
    public DataVideo getDataVideo() {
        DataVideo data = new DataVideo();
        data.setNombre(nombre);
        data.setAutor(autor.getNickname());
        data.setDescripcion(descripcion);
        data.setDuracion(duracion);
        data.setFechaPub(fechaPub);
        data.setUrl(url);
        data.setPrivado(privado);
        if (categoria != null)
            data.setCategoria(categoria.getNombre());
        data.setComentarios(this.getDataComentarios());
        gustan.forEach(u -> data.getGustan().add(u.getNickname()));
        noGustan.forEach(u -> data.getNoGustan().add(u.getNickname()));
        return data;
    }
    
    public void modificar(DataVideo data) {
        nombre = data.getNombre();
        descripcion = data.getDescripcion();
        duracion = data.getDuracion();
        fechaPub = data.getFechaPub();
        url = data.getUrl();
        privado = data.getPrivado();
    }
    
    
    
}
