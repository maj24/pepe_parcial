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
    
    public void shellSort(){

    }
    
    public void mergeSort(){
    
    }
    
    public void quickSort(){
        
        
    }
    
    public void mezclaDirecta(){
        
    }
    
    public void mezclaNatural(){
        
    }
    
  
    
}
