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
        
        //Cargamos el archivo de excel.
        ExcelReader workbook = new ExcelReader();
        //Obtenemos el ArrayList desordenado.
        Metodos metodos = new Metodos(workbook.getIndices());
        //Ordenamiento
        metodos.burbujaDescendete();
        ArrayList<Indice> listaOrdenada = metodos.getIndices();
        //Busqueda binaria.
        //Filtro filtro = new Filtro("<", 1.0, listaOrdenada);
        //filtro.busquedaBinaria();
        //Obtenemos los resultados luego de la busqueda binaria.
        //ArrayList<Indice> listaResultados = filtro.filtrar();

//        for(int i=0; i<listaResultados.size(); i++){
//            System.out.println("Valor: " +listaResultados.get(i).getValor() + " ");
//        }
        
        for(int i=0; i<metodos.getIndices().size(); i++){
            System.out.println("Valor: " + metodos.getIndices().get(i).getValor() + " ");
        }
        
        
    }
    
    
}
