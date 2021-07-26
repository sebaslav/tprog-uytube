/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatypes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Seba de la gente
 */
public class DataUsuario {
    
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    private String password;
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String apellido;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    private LocalDate fechaNac;

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    private String imagen;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    private DataCanal canal;

    public DataCanal getCanal() {
        return canal;
    }

    public void setCanal(DataCanal canal) {
        this.canal = canal;
    }
    
    private final Set<String> sigueA;

    public Set<String> getSigueA() {
        return sigueA;
    }

    private final Set<String> loSiguen;

    public Set<String> getLoSiguen() {
        return loSiguen;
    }

    public DataUsuario() {
        this.nickname = "";
        this.password = "";
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.fechaNac = null;
        this.imagen = "";
        this.canal = new DataCanal();
        this.sigueA = new HashSet<>();
        this.loSiguen = new HashSet<>();
    }
    
}
