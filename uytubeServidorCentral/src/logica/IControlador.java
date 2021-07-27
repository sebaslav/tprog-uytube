/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Set;

import datatypes.DataCategoria;
import datatypes.DataComentarios;
import datatypes.DataIngresoComentario;
import datatypes.DataLista;
import datatypes.DataPair;
import datatypes.DataUsuario;
import datatypes.DataVideo;
import excepciones.NoExisteInstanciaException;
import excepciones.NombreRepetidoException;
import excepciones.PrivacidadInvalidaException;
import excepciones.RedundanciaException;

/**
 *
 * @author Seba de la gente
 */
public interface IControlador {
    
    public Set<String> getCategorias();
    
    public Set<String> buscarUsuarios(String query);
    
    public Set<DataPair> buscarVideos(String query);
    
    public Set<DataPair> buscarListas(String query);
    
    public void confirmarAltaDeVideo(String usuario, DataVideo datos) throws NoExisteInstanciaException, NombreRepetidoException;

    public void confirmarAltaDeUsuario(DataUsuario datos) throws NombreRepetidoException, NoExisteInstanciaException;

    public Set<String> getVideos(String usuario) throws NoExisteInstanciaException;

    public DataVideo getDataVideo(String usuario, String video) throws NoExisteInstanciaException;

    public Set<String> getListas(String usuario) throws NoExisteInstanciaException;
    
    public DataLista getDataLista(String usuario, String lista) throws NoExisteInstanciaException;

    public DataUsuario getDataUsuario(String usuario) throws NoExisteInstanciaException;

    public void confirmarModificarVideo(String usuario, String video, DataVideo datos) throws NoExisteInstanciaException, NombreRepetidoException, PrivacidadInvalidaException;
    
    public void confirmarSeguirUsuario(String sigue, String aSeguir) throws NoExisteInstanciaException, RedundanciaException;

    public void confirmarNoSeguirUsuario(String sigue, String aNoSeguir) throws RedundanciaException, NoExisteInstanciaException;

    public void confirmarValorarVideo(String usuario, String video, String valorador, Boolean gusta) throws NoExisteInstanciaException, RedundanciaException;

    public DataComentarios getDataComentarios(String usuario, String video) throws NoExisteInstanciaException;

    public void confirmarComentarVideo(String usuario, String video, String comentador, DataIngresoComentario datos) throws NoExisteInstanciaException;

    public void confirmarAltaDeCategoria(String categoria) throws NombreRepetidoException;

    public DataCategoria getDataCategoria(String categoria) throws NoExisteInstanciaException;

    public void confirmarAgregarVideo(String usuarioV, String video, String usuarioL, String lista) throws NoExisteInstanciaException, RedundanciaException;

    public void confirmarQuitarVideo(String usuarioV, String video, String usuarioL, String lista) throws NoExisteInstanciaException, RedundanciaException;
    
    public void confirmarCrearListaD(String nombre) throws NombreRepetidoException;

    public void confirmarCrearListaP(String usuario, String nombre, Boolean privado) throws NoExisteInstanciaException, NombreRepetidoException, PrivacidadInvalidaException;

    public Set<String> getListasParticulares(String usuario) throws NoExisteInstanciaException;

    public void confirmarModificarLista(String usuario, String listaP, Boolean privado) throws NoExisteInstanciaException, PrivacidadInvalidaException;

    public void confirmarModificarUsuario(String usuario, DataUsuario datos) throws NoExisteInstanciaException;


}
