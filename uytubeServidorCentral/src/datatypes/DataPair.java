/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatypes;

/**
 *
 * @author Seba de la gente
 */
public class DataPair {

    private final String nickname;

    public String getNickname() {
        return nickname;
    }

    private final String nombre;

    public String getNombre() {
        return nombre;
    }

    public DataPair(String nickname, String nombre) {
        this.nickname = nickname;
        this.nombre = nombre;
    }

}
