/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatypes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seba de la gente
 */
public class DataComentarios {
    
    private final List<DataComentario> comentarios;
    
    private String video;
    
    public void setVideo(String video) {
    	this.video = video;
    }
    
    public String getVideo() {
    	return video;
    }

    public List<DataComentario> getComentarios() {
        return comentarios;
    }
    
    public String toString() {
    	return video + " :: " + "Comentarios";
    }

    public DataComentarios() {
    	video = "";
        comentarios = new ArrayList<>();
    }
    
}
