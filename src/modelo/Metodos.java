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
     * @param indices the indices to set
     */
    public void setIndices(ArrayList<Indice> indices) {
        this.indices = indices;
    }
    
     /**
     * 
     */
    public void insercion(){
        
        int k;
        Indice indiceAuxiliar = new Indice();
        double valorAuxiliar;
        for(int i = 1; i < this.indices.size(); i++){
            indiceAuxiliar = indices.get(i);
            valorAuxiliar = indiceAuxiliar.getValor();
            k = i - 1;
            while(k >= 0 && valorAuxiliar < k){
                
                Indice indiceSustituto = indices.get(k);
                indices.set(k + 1, indiceSustituto);
                k--;
                
            }
            indices.set(k + 1, indiceAuxiliar); 
        }
        
    }
    
    public void burbuja(){
        
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
