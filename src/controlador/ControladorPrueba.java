/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.util.ArrayList;
import modelo.*;

/**
 *
 * @author Luis
 */
public class ControladorPrueba {
    
    
    
    public static void main(String[] args) {
        
        ExcelReader workbook = new ExcelReader();
        //System.out.println("DESORDENADOS");
        //(int i=0; i<workbook.getIndices().size(); i++){
        //    System.out.println("Valor: " +workbook.getIndices().get(i).getValor() + " ");
        //}
        Metodos metodos = new Metodos(workbook.getIndices());
        metodos.insercion();
        
//        System.out.println("ORDENADOS");
//        System.out.println("--------------------------------");
//        for(int i=0; i<metodos.getIndices().size(); i++){
//            System.out.println("Valor: " +metodos.getIndices().get(i).getValor() + " ");
//        }
        ArrayList<Indice> listaOrdenada = metodos.getIndices();
        Filtro filtro = new Filtro("<", 1.0, listaOrdenada);
        filtro.busquedaBinaria();
        ArrayList<Indice> listaResultados = filtro.filtrar();

        for(int i=0; i<listaResultados.size(); i++){
            System.out.println("Valor: " +listaResultados.get(i).getValor() + " ");
        }
        
        
    }
    
    
}
