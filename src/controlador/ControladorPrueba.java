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
        Metodos metodos = new Metodos(workbook.getIndices());
        metodos.insercion();
        ArrayList<Indice> listaOrdenada = metodos.getIndices();
        Filtro filtro = new Filtro(">=", 1.0, listaOrdenada);
        filtro.busquedaBinaria();
        ArrayList<Indice> listaResultados = filtro.filtrar();
        
//        Filtro f = new Filtro(">=", 12, a);
//        f.busquedaBinaria();
//        ArrayList<Indice> lista = f.filtrar();
        for(int i=0; i<listaResultados.size(); i++){
            System.out.println("Valor: " +listaResultados.get(i).getValor() + " ");
        }
//    }
        
        
    }
    
    
}
