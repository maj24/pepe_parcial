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
    private double valor;
    private String fecha;

    public Indice(double valor, String fecha) {
        this.valor = valor;
        this.fecha = fecha;
    }
    
    public Indice(){
    }

    /**
     * @return the indice
     */
    public double getValor() {
        return valor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }
    
    
}
