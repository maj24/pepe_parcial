/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 * Clase que puede filtrar los elementos de una lista ordenada de forma ascendente o descendente
 * a partir de un criterio y un valor introducidos por el usuario.
 * @author MariaJose
 */
public class Filtro {
    String criterio;
    double valor;
    ArrayList<Indice> listaOrdenada;
    ArrayList<Indice> listaFiltrada;
    int indexInf;
    int indexSup;

    /**
     * Constructor de la clase Filtro
     * @param criterio Criterio de ordenamiento.
     * @param valor Valor a partir del cual se mostrarán los resultados.
     * @param listaOrdenada Lista a ser filtrada.
     */
    public Filtro(String criterio, double valor, ArrayList<Indice> listaOrdenada) {
        this.listaFiltrada = new ArrayList<>();
        this.criterio = criterio;
        this.valor = valor;
        this.listaOrdenada = listaOrdenada;
    }
    
    /**
     * Busca la posición del valor en la lista ordenada de forma ascendente.
     */
    public void busquedaBinaria_ascendente(){
        int inicio=0;
        int fin=listaOrdenada.size()-1;
        int mitad = (listaOrdenada.size()) / 2;
        
        while(inicio<=fin){
            // Si el elemento en la posición mitad coincide con valor, se
            //identifica el rango de las posiciones cuyo elemento también coincide
            // y sale del ciclo.
            if(listaOrdenada.get(mitad).getValor() == (valor)){ 
                fin = mitad;
                inicio = mitad;
                while(fin >=0 && valor == listaOrdenada.get(fin).getValor())
                    --fin;
                while(inicio < listaOrdenada.size() && listaOrdenada.get(inicio).getValor() == valor)
                    inicio++;
                break;
            }
            else { 
                //Si el elemento en la mitad del rango es mayor que el valor buscado,
                //se acota la búsqueda con los elementos menores que el.
                if(listaOrdenada.get(mitad).getValor() > valor){
                    fin = mitad-1;
                    mitad = (fin + inicio)/2;
                }
                else{
                    //En caso contrario, se acota la búsqueda con los elementos mayores 
                    //que el elemento de la mitad
                    inicio = mitad+1;
                    mitad = (fin + inicio)/2;
                }
            }
        }
        indexInf = fin;
        indexSup = inicio;
    }
    
    /**
     * Busca la posición del valor en la lista ordenada de forma descendente.
     */
    public void busquedaBinaria_descendente(){
        int inicio=0;
        int fin=listaOrdenada.size()-1;
        int mitad = (listaOrdenada.size()) / 2;
        
        while(inicio<=fin){
            if(listaOrdenada.get(mitad).getValor() == (valor)){
                fin = mitad;
                inicio = mitad;
                while(fin >=0 && valor == listaOrdenada.get(fin).getValor())
                    --fin;
                while(inicio < listaOrdenada.size() && listaOrdenada.get(inicio).getValor() == valor)
                    inicio++;
                break;
            }
            else {
                if(valor > listaOrdenada.get(mitad).getValor()){
                    fin = mitad-1;
                    mitad = (fin + inicio)/2;
                }
                else{
                    inicio = mitad+1;
                    mitad = (fin + inicio)/2;
                }
            }
        }
        indexInf = fin;
        indexSup = inicio;
    }
    
    /**
     * Selecciona los elementos de la lista ordenada que cumplen con el criterio pedido.
     * @param ascendente Es verdadero si la lista esta ordenada ascendentemente o falso si lo esta descendentemete
     * @return Una lista filtrada con los elementos pedidos.
     */
    public ArrayList<Indice> filtrar(boolean ascendente){
        if(criterio.equals("=")){
            for(int i=indexInf+1; i<indexSup; i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if( (criterio.equals(">")&&ascendente) || (criterio.equals("<")&&!ascendente) ){            
            for(int i=indexSup; i<listaOrdenada.size(); i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if( (criterio.equals(">=")&&ascendente) || (criterio.equals("<=")&&!ascendente) ){
            for(int i=indexInf+1; i<listaOrdenada.size(); i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if( (criterio.equals("<")&&ascendente) || (criterio.equals(">")&&!ascendente) ){
            for(int i=0; i<=indexInf; i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if( (criterio.equals("<=")&&ascendente) || (criterio.equals(">=")&&!ascendente) ){
            for(int i=0; i<indexSup; i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        
        return listaFiltrada;
    }
    
}
