package modelo;

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
    public void burbujaAscendete(){
        
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
    public void burbujaDescendete(){
        
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
    
    public void mergeSort(){
    
    }
    
    public void quickSortAscendente(){
        
        int ini, fin, pos;
        ArrayList pilaMenor = new ArrayList(),
                  pilaMayor = new ArrayList();
        pilaMenor.add(0);
        pilaMayor.add(indices.size() -1);
        
        while(!pilaMenor.isEmpty()){
            
            ini = (Integer)pilaMenor.remove(pilaMenor.size() - 1);
            fin = (Integer)pilaMayor.remove(pilaMayor.size() - 1);
            pos = posicionaQuickSort(ini, fin);
            
            if(ini < pos -1){                
                pilaMenor.add(ini);
                pilaMayor.add(pos - 1);
            }
            
            if(ini > pos + 1){
                pilaMenor.add(pos + 1);
                pilaMayor.add(fin);   
            }
            
        }
        
        
    }
    
    
    public int posicionaQuickSort(int ini, int fin){
        
        int pos;
        int izq, der;
        Indice indiceAuxiliar;
        boolean band;
         
        izq = ini;
        der = fin;
        pos = ini;
        band = true;
        
        while(band == true){
            
            while(indices.get(pos).getValor() <= indices.get(der).getValor() && pos != der){
                der--;
            }
            
            if(pos == der){
                band = false;
            }
            else{
                indiceAuxiliar = indices.get(pos);
                indices.set(pos, indices.get(der));
                indices.set(der, indiceAuxiliar);
                pos = der;
                while(indices.get(pos).getValor() >= indices.get(izq).getValor() && pos != izq){
                    izq = izq + 1;
                }
                
                if(pos == izq){
                    band = false;
                }
                else{
                    indiceAuxiliar = indices.get(pos);
                    indices.set(pos, indices.get(izq));
                    indices.set(izq, indiceAuxiliar);
                    pos = izq;
                }
            }
        }
        return pos;
        
    }
    
}
