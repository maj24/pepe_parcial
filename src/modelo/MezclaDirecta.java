/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class MezclaDirecta {
    
    ArrayList<Indice> indicesTemporales;
    String F = "F.txt";
    String F1 = "F1.txt";
    String F2 = "F2.txt";
    PrintWriter file = null;
    
    
    public MezclaDirecta(ArrayList<Indice> in) throws FileNotFoundException{
        
        indicesTemporales = in;
    }
    
    public void llamarMezcla(){
        MezclaDirecta(F, F1, F2);
    }
    
    public void llenarArchivo(){       
        try {
            file = new PrintWriter(F);
        } catch (IOException ex) {
            Logger.getLogger(MezclaDirecta.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0; i < indicesTemporales.size(); i++){
            file.flush();
            file.println(indicesTemporales.get(i).getValor());
        }
        llamarMezcla();
          
    }
    
    public void MezclaDirecta(String F, String F1, String F2){
        
        int n = tamañoArchivo(F);
        System.out.println("tamaño: " + n);
        int part = 1;
        
        while(part < n){
            particionar(F, F1, F2, part);
            fusionar(F, F1, F2, part);
            part *= 2;
        }
        
    }
    
    public int tamañoArchivo(String F){
        
        int cont = 0;
        Scanner file = null;
        
        try {
            file = new Scanner(new FileReader(F));
        } catch (FileNotFoundException ex) {
            System.out.println("Error en la apertura del archivo");
        }
        
        while(file.hasNextLine()){
            file.nextLine();
            cont++;
        }
        
        file.close();
        
        return cont;
    }
    
    public void particionar(String F, String F1, String F2, int part){
        System.out.println("particionar\n");
        int k,l;
        Scanner lectura = null;
        PrintWriter escritura1 = null, escritura2 = null;
        
        try {
            lectura = new Scanner(new FileReader(F));
            escritura1 = new PrintWriter(F1);
            escritura2 = new PrintWriter(F2);
            while(lectura.hasNextDouble()){
                k = 0;
                while(k < part){
                   // System.out.println("k\n");
                    if(lectura.hasNextDouble()){
                        escritura1.flush();
                        escritura1.println(lectura.nextDouble());
                        k++;
                    }
                    if(!lectura.hasNext()) break;
                }
                l = 0;
                while(l < part){
                   // System.out.println("l\n");
                    if(lectura.hasNextDouble()){
                        //escritura2.flush();
                        escritura2.println(lectura.nextDouble());
                        l++;
                    }
                    if(!lectura.hasNext()) break;
                }
            }
        
            lectura.close();
            escritura1.close();
            escritura2.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error en los archivos durante la particion");
        }
        
    }
    
    public void fusionar(String F, String F1, String F2, int part){
        System.out.println("fusionar\n");
        int k, l;
        double r1 = 0, r2 = 0;
        boolean b1 = true, b2 = true;
        Scanner File1, File2;
        PrintWriter File;
        try {
            
            File1 = new Scanner(new FileReader(F1));
            File2 = new Scanner(new FileReader(F2));
            File = new PrintWriter(F);
            
            if(File1.hasNextDouble()){
                r1 = File1.nextDouble();
                b1 = false;    
            }
            
            if(File2.hasNextDouble()){
                r2 = File2.nextDouble();
                b2 = false;    
            }
            
            while((File1.hasNextDouble() || !b1) && (File2.hasNextDouble() || !b2)){
                k = 0;
                l = 0;
                while(k < part && !b1 && l < part && !b2){
                    
                    if(r1 <= r2){
                        File.flush();
                        File.println(r1);
                        b1 = true;
                        k++;
                        if(File1.hasNextDouble()){
                            r1 = File1.nextDouble();
                            b1 = false;
                        }
                    }
                    else{
                        File.flush();
                        File.println(r2);
                        b2 = true;
                        l++;
                        if(File2.hasNextDouble()){
                            r2 = File2.nextDouble();
                            b2 = false;
                        }
                    }
                    
                }
                
                //More
                
                if(k < part){
                    while(k < part && !b1){
                        File.flush();
                        File.println(r1);
                        b1 = true;
                        k++;
                        if(File1.hasNextDouble()){
                            r1 = File1.nextDouble();
                            b1 = false;
                        }
                    }
                }
                
                if(l < part){
                    while(l < part && !b2){
                        File.flush();
                        File.println(r2);
                        b2 = true;
                        l++;
                        if(File2.hasNextDouble()){
                            r2 = File2.nextDouble();
                            b2 = false;
                        }
                    }
                }
                
            }
            
            
            if(!b1){
                File.flush();
                File.println(r1);
            }
                
            if(!b2){
                File.flush();
                File.println(r2);
            }
            while(File1.hasNextDouble()){
                File.flush();
                File.println(File1.nextDouble());
            }
            while(File2.hasNextInt()){
                File.flush();
                File.println(File2.nextDouble());
            }
            
            //Cerrando archivos.
            File1.close();
            File2.close();
            File.close();
            
        } catch (Exception ex) {
            System.out.println("Error en los archivos durante la fusion");
        }
        
        
            
    }

    public ArrayList<Indice> getIndicesTemporales() {
        return this.indicesTemporales;
    }

    public void imprimir(){
              
        for(int i=0; i<indicesTemporales.size(); i++){
            System.out.println("Valor: " + indicesTemporales.get(i).getValor() + " ");
        }
        
    }
    
    
}
