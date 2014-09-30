/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.ArrayList;

/**
 *
 * @author MariaJose
 */
public class Filtro {
    String criterio;
    int valor;
    ArrayList<Indice> listaOrdenada;
    ArrayList<Indice> listaFiltrada;
    int indexInf;
    int indexSup;

    public Filtro(String criterio, int valor, ArrayList<Indice> listaOrdenada) {
        this.listaFiltrada = new ArrayList<>();
        this.criterio = criterio;
        this.valor = valor;
        this.listaOrdenada = listaOrdenada;
    }
    
    public void busquedaBinaria(){
        int indexIzquierdo=0;
        int indexDerecho=listaOrdenada.size()-1;
        int mitad = (listaOrdenada.size()) / 2;
        while(indexIzquierdo<=indexDerecho){
            double num = listaOrdenada.get(mitad).getValor();
            if(num == (valor)){
                //System.out.println(mitad);
                indexDerecho = mitad;
                indexIzquierdo = mitad;
                while(indexDerecho >=0 && valor == listaOrdenada.get(indexDerecho).getValor())
                    --indexDerecho;
                while(indexIzquierdo < listaOrdenada.size() && listaOrdenada.get(indexIzquierdo).getValor() == valor)
                    indexIzquierdo++;
                break;
            }
            else {
                if(valor < listaOrdenada.get(mitad).getValor()){
                    indexDerecho = mitad-1;
                    mitad = (indexDerecho + indexIzquierdo)/2;
                }
                else{
                    indexIzquierdo = mitad+1;
                    mitad = (indexDerecho + indexIzquierdo)/2;
                }
            }
        }
        indexInf = indexDerecho;
        indexSup = indexIzquierdo;
       // System.out.println(indexInf + " " + indexSup);
    }
    
    public ArrayList<Indice> filtrar(){
        if(criterio.equals("=")){
            for(int i=indexInf+1; i<indexSup; i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if(criterio.equals(">")){
            for(int i=indexSup; i<listaOrdenada.size(); i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if(criterio.equals(">=")){
            for(int i=indexInf+1; i<listaOrdenada.size(); i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if(criterio.equals("<")){
            for(int i=0; i<=indexInf; i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        if(criterio.equals("<=")){
            for(int i=0; i<indexSup; i++){
                listaFiltrada.add(listaOrdenada.get(i));
            }
        }
        
        return listaFiltrada;
    }
    
    /// prueba
//    public static void main(String[] args) {
//        ArrayList<Indice> a;
//        a = new ArrayList<>();
//        a.add(new Indice(1, ""));
//        a.add(new Indice(3, ""));
//        a.add(new Indice(6, ""));
//        a.add(new Indice(6, ""));
//        a.add(new Indice(12, ""));
//        a.add(new Indice(24, ""));
//        a.add(new Indice(24, ""));
//        a.add(new Indice(24, ""));
//        a.add(new Indice(24, ""));
//        a.add(new Indice(40, ""));
//
//        Filtro f = new Filtro(">=", 12, a);
//        f.busquedaBinaria();
//        ArrayList<Indice> lista = f.filtrar();
//        for(int i=0; i<lista.size(); i++){
//            System.out.print(lista.get(i).getIndice() + " ");
//        }
//    }
    
}
