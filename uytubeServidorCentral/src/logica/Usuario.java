/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import datatypes.DataUsuario;

/**
 *
 * @author Seba de la gente
 */
public class Usuario {
    
    private String nickname;
    private String password;
    private String nombre;
    private String apellido;
    private String correo;
    private LocalDate fechaNac;
    private String imagen;
    private Canal canal;
    private final Map<String, Usuario> sigueA;
    private final Map<String, Usuario> loSiguen;
    
    public Usuario(DataUsuario datos) {
        nickname = datos.getNickname();
        password = datos.getPassword();
        nombre = datos.getNombre();
        apellido = datos.getApellido();
        correo = datos.getCorreo();
        fechaNac = datos.getFechaNac();
        imagen = datos.getImagen();
        canal = new Canal(datos.getCanal());
        sigueA = new HashMap<>();
        loSiguen = new HashMap<>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

   

    public Map<String, Usuario> getSigueA() {
        return sigueA;
    }
    
    public void addSigueA(Usuario usuario) {
        sigueA.put(usuario.nickname, usuario);
    }
            
    public void removeSigueA(Usuario usuario) {
        sigueA.remove(usuario.nickname);
    }
    
    

    public Map<String, Usuario> getLoSiguen() {
        return loSiguen;
    }

    public void addLoSiguen(Usuario usuario) {
        loSiguen.put(usuario.nickname, usuario);
    }
            
    public void removeLoSiguen(Usuario usuario) {
        loSiguen.remove(usuario.nickname);
    }
    
    public Boolean checkSigue(String nickname) {
        return sigueA.containsKey(nickname);
    }
    
    public DataUsuario getDataUsuario() {
        DataUsuario data = new DataUsuario();
        data.setNickname(nickname);
        data.setPassword(password);
        data.setNombre(nombre);
        data.setApellido(apellido);
        data.setCorreo(correo);
        data.setFechaNac(fechaNac);
        data.setImagen(imagen);
        data.setCanal(canal.getDataCanal());
        sigueA.keySet().forEach(data.getSigueA()::add);
        data.getLoSiguen().addAll(loSiguen.keySet());
        return data;
    }
    
    public void modificar(DataUsuario data) {
    	password = data.getPassword();
        nombre = data.getNombre();
        apellido = data.getApellido();
        fechaNac = data.getFechaNac();
        imagen = data.getImagen();
        canal.modificar(data.getCanal());
    }
    
    public Set<String> getNdeVideos() {
        return canal.getNdeVideos();
    }
    
    public Set<String> getNdeListas() {
        return canal.getNdeListas();
    }
    
    public Set<String> getNdeListasPart() {
        return canal.getNdeListasPart();
    }

    
    
}
