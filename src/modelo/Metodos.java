package modelo;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Metodos {
    
    private ArrayList<Indice> indices;

    public Metodos(ArrayList<Indice> indices){
        this.indices = indices;
    }
    
    /**
     * @return the indices
     */
    public ArrayList<Indice> getIndices() {
        return indices;
    }

    /**
     * @param indices Un ArrayList con los indices.
     */
    public void setIndices(ArrayList<Indice> indices) {
        this.indices = indices;
    }
    
    /**
     * Ordena de forma ascendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de Inserción.
     */
    public void insercionAscendente(){
        
        int k;
        Indice indiceAuxiliar ;
        double valorAuxiliar;
        for(int i = 1; i < this.indices.size(); i++){
            indiceAuxiliar = indices.get(i);
            //valorAuxiliar = indiceAuxiliar.getValor();
            k = i - 1;
            while(k >= 0 && indiceAuxiliar.getValor() < indices.get(k).getValor()){
                Indice indiceSustituto = indices.get(k);
                indices.set(k + 1, indiceSustituto);
                k--;
                
            }
            indices.set(k + 1, indiceAuxiliar); 
        }
        
    }
    
    /**
     * Ordena de forma descendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de Inserción.
     */
    public void insercionDescendente(){
        
        int k, i;
        Indice indiceAuxiliar ;
        double valorAuxiliar;
        for(i = 1; i < this.indices.size(); i++){
            indiceAuxiliar = indices.get(i);
            k = i - 1;
            while(k >= 0 && indiceAuxiliar.getValor() > indices.get(k).getValor()){
                Indice indiceSustituto = indices.get(k);
                indices.set(k + 1, indiceSustituto);
                k--;
                
            }
            indices.set(k + 1, indiceAuxiliar); 
        }
        
    }
    
    /**
     * Ordena de forma ascendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de Burbuja.
     */    
    public void burbujaAscendente(){
        
        int i, j;
        Indice indiceAuxiliar ;
        double valorAuxiliar;
        for(i = 1; i < this.indices.size(); i++){
            for(j = this.indices.size()-1; j >= i; j--){
                if(indices.get(j - 1).getValor() > indices.get(j).getValor()){
                    indiceAuxiliar = indices.get(j - 1);
                    indices.set(j - 1, indices.get(j));
                    indices.set(j, indiceAuxiliar);
                }
            }
        }
        
    }

    /**
     * Ordena de forma descendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de Inserción.
     */
    public void burbujaDescendente(){
        
        int i, j;
        Indice indiceAuxiliar ;
        double valorAuxiliar;
        for(i = 1; i < this.indices.size(); i++){
            for(j = this.indices.size()-1; j >= i; j--){
                if(indices.get(j - 1).getValor() < indices.get(j).getValor()){
                    indiceAuxiliar = indices.get(j - 1);
                    indices.set(j - 1, indices.get(j));
                    indices.set(j, indiceAuxiliar);
                }
            }
        }
        
    }

    /**
     * Ordena de forma ascendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de ShellSort.
     */       
    public void shellSortAscendente(){

        int intervalo, i;
        Indice indiceAuxiliar;
        boolean band;
        intervalo = indices.size();
        
        while(intervalo > 1){
            intervalo /= 2;
            band = true;
            while(band){
                band = false;
                i=0;
                while((intervalo+i)< indices.size()){
                    if(indices.get(i).getValor() > indices.get(i+intervalo).getValor()){
                        indiceAuxiliar = indices.get(i);
                        indices.set(i, indices.get(i+intervalo));
                        indices.set(i + intervalo, indiceAuxiliar);
                        band = true;
                    }
                    i++;
                }        
            }
       }    
        
    }
    
    /**
     * Ordena de forma ascendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de ShellSort.
     */       
    public void shellSortDescendente(){

        int intervalo, i;
        Indice indiceAuxiliar;
        boolean band;
        intervalo = indices.size();
        
        while(intervalo > 1){
            intervalo /= 2;
            band = true;
            while(band){
                band = false;
                i=0;
                while((intervalo+i)< indices.size()){
                    if(indices.get(i).getValor() < indices.get(i+intervalo).getValor()){
                        indiceAuxiliar = indices.get(i);
                        indices.set(i, indices.get(i+intervalo));
                        indices.set(i + intervalo, indiceAuxiliar);
                        band = true;
                    }
                    i++;
                }        
            }
       }    
        
    }
    
    /**
     * Realiza el llamado recursivo a una funcion que ordena un ArrayList 
     * de manera ascendente.
     * @param in Un ArrayList que contiene los indices desordenado de esta clase.
     * @return indices = in El ArrayList ordenado es asignado al  ArrayList de
     * esta clase.
     */     
    public ArrayList<Indice> mergeSortAscendente(ArrayList<Indice> in){
        int n = in.size(),i,m;
        ArrayList<Indice> L1 = new ArrayList<Indice>(),
                L2 = new ArrayList<Indice>();
        if(n>1){
           m = n/2;
           for(i=0;i<m;i++){
             L1.add(in.get(i));
           }
           for(i=m;i<n;i++){
             L2.add(in.get(i));
           }
           in = mergeAscendente(mergeSortAscendente(L1),mergeSortAscendente(L2));
        }
         return indices = in;
    }
    
    /**
     * Ordena de forma ascendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de MergeSort.
     */   
    public ArrayList<Indice> mergeAscendente(ArrayList<Indice> L1,ArrayList<Indice> L2){
        ArrayList<Indice> lista = new ArrayList<Indice>();
        while(!L1.isEmpty() && !L2.isEmpty()){
          if(L1.get(0).getValor() < L2.get(0).getValor()){
             lista.add(L1.get(0));
             L1.remove(0);
             if(L1.isEmpty()){
               lista.addAll(L2);
               L2.clear();
             }
          }
          else{
             lista.add(L2.get(0));
             L2.remove(0);
             if(L2.isEmpty()){
               lista.addAll(L1);
               L1.clear();
             }
          }
        }
        return lista;
    }
    
/**
 * Realiza el llamado recursivo a una funcion que ordena un ArrayList 
 * de manera descendente.
 * @param in Un ArrayList que contiene los indices tomados de esta clase.
 * @return indices = in El ArrayList ordenado es asignado al  ArrayList de
     * esta clase.
 */
    public ArrayList<Indice> mergeSortDescendente(ArrayList<Indice> in){
        int n = in.size(),i,m;
        ArrayList<Indice> L1 = new ArrayList<Indice>(),
                L2 = new ArrayList<Indice>();
        if(n>1){
           m = n/2;
           for(i=0;i<m;i++){
             L1.add(in.get(i));
           }
           for(i=m;i<n;i++){
             L2.add(in.get(i));
           }
           in = mergeDescendente(mergeSortDescendente(L1),mergeSortDescendente(L2));
        }
         return indices = in;
    }
    
    /**
     * Ordena de forma descendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de MergeSort.
     * @return Un ArrayList ordenado.
     */   
    public ArrayList<Indice> mergeDescendente(ArrayList<Indice> L1,ArrayList<Indice> L2){
        ArrayList<Indice> lista = new ArrayList<Indice>();
        while(!L1.isEmpty() && !L2.isEmpty()){
          if(L1.get(0).getValor() > L2.get(0).getValor()){
             lista.add(L1.get(0));
             L1.remove(0);
             if(L1.isEmpty()){
               lista.addAll(L2);
               L2.clear();
             }
          }
          else{
             lista.add(L2.get(0));
             L2.remove(0);
             if(L2.isEmpty()){
               lista.addAll(L1);
               L1.clear();
             }
          }
        }
        return lista;
    }
    
   /**
    * Llama a una funcion recursiva que ordena un ArrayList mediante
    * el método de QuickSort.
    * @return Llamado a una función recursiva.
    */
    public ArrayList<Indice> quickSortAscendente(){
        return quickOrdenaAscendente(0, indices.size() - 1);
    }
    
    /**
     * Ordena de forma ascendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de QuickSort.
     * @param izq
     * @param der
     * @return 
     */
    public ArrayList<Indice> quickOrdenaAscendente(int izq, int der){
        if(izq >= der){
            return indices;
        }
        int i = izq, d = der;
        if(izq != der){
            int pivote;
            Indice aux;   
            pivote = izq;
            while(izq != der){
                while(indices.get(der).getValor() >= indices.get(pivote).getValor() && izq < der){
                    der--;
                }
                while(indices.get(izq).getValor() < indices.get(pivote).getValor() && izq < der){
                    izq++;
                }
                if(izq != der){
                    aux = indices.get(der);
                    indices.set(der, indices.get(izq));
                    indices.set(izq, aux);
                    
                }
                if(izq == der){
                    quickOrdenaAscendente(i, izq - 1);
                    quickOrdenaAscendente(izq + 1, d);
                }
            }
        }else{
            return indices;
        }
        
        return indices;
    }
    /**
     * Llama a una funcion recursiva que ordena un ArrayList mediante
     * el método de QuickSort.
     * @param p
     * @param r 
     */
    public void quickSortDescendente(int p, int r) {
        if (p < r) {
            int q = particion(p, r);
            quickSortDescendente(p, q);
            quickSortDescendente(q + 1, r);
        }
    }
    /**
     * Ordena de forma descendente un ArrayList perteneciente a esta misma clase 
     * mediante el método de QuickSort.
     * @param p El pivote
     * @param r Extremo derecho
     * @return j Nuevo extremo derecho después de una interación.
     */
    public int particion(int p, int r) {
        double x = indices.get(p).getValor(); // pivot
        int i = p;
        int j = r;
        while (true) {

            while (indices.get(i).getValor() > x) {
                i++;
            }

            while (indices.get(j).getValor() < x) {
                j--;
            }
            if (i < j) {
                Indice temp = indices.get(i);
                indices.set(i, indices.get(j));
                indices.set(j, temp);
                i++;
                j--;
            } else {
                return j;
            }
        }
    }
   
    public void mezclaDirectaAscendente() throws FileNotFoundException, IOException{
        
        MezclaDirecta md = new MezclaDirecta(this.indices, true);
        md.llenarArchivo();
        this.indices = md.getIndicesTemporales();
        
    }
    
    public void mezclaDirectaDescendente() throws FileNotFoundException{
        MezclaDirecta md = new MezclaDirecta(this.indices, false);
        md.llenarArchivo();
        this.indices = md.getIndicesTemporales();
    }
    
    public void mezclaNaturalAscendente(){
        
    }
    
    public void mezclaNaturalDescendente(){
        
    }
}
