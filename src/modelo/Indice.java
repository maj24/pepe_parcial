/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author MariaJose
 */
public class Indice {
    public int indice;
    private String fecha;

    public Indice(int indice, String fecha) {
        this.indice = indice;
        this.fecha = fecha;
    }

    /**
     * @return the indice
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }
    
    
}
