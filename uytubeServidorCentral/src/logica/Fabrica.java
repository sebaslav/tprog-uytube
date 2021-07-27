/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Seba de la gente
 */
public class Fabrica {
    
    private static Fabrica instancia;
    
    private Fabrica() {}
    
    public static Fabrica getInstancia() {
        if (instancia == null)
            instancia = new Fabrica();
        return instancia;
    }
    
    public IControlador getIControlador() {
        return new Controlador();
    }
    
}
