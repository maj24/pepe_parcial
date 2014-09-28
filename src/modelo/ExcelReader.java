/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import jxl.*;
import jxl.read.biff.BiffException;

/**
 *
 * @author Luis
 */
public class ExcelReader {
    
//     public static void main(String[] args) throws BiffException {
//        
//        Workbook workbook = null;
//        
//        try {
//            workbook = 
//                    Workbook.getWorkbook(new 
//                    File("D:\\EstructurasDeDatos\\ProyectoParcial1\\ProyectoParcial1"));
//        } catch (IOException ex) {
//            JOptionPane.showMessageDialog(null, "Error de IO");
//        } catch (BiffException ex) {
//            JOptionPane.showMessageDialog(null, "Error diferente");
//        }
//        
//        Sheet sheet = workbook.getSheet(1); 
//        ArrayList<Escuela> escuelas = new ArrayList<Escuela>();
//       
//        //Llenado del ArrayList.
//        for(int i = 3; i < sheet.getRows(); i++){
//            Cell a1 = sheet.getCell(4, i);
//            Escuela e = new Escuela(
//                    a1.getContents(),
//                    calculaPromedio(i, sheet)
//                    );
//            
//            escuelas.add(e);       
//        }
//        
//        //Ordenando el ArrayList.
//        Collections.sort(escuelas, new Comparator<Escuela>() {
//        @Override
//            public int compare(Escuela  e1, Escuela e2)
//            {
//                return  e1.getPromedio().compareTo(e2.getPromedio());
//            }
//        });
//        
//        //Impresion de los elementos en el ArrayList ordenado de forma ascendente.
//        for(int j = 0;j < escuelas.size();j++){
//            System.out.println("NOMBRE DE LA ESCUELA: " + escuelas.get(j).getNombre() +
//                    "  PROMEDIO: " + escuelas.get(j).getPromedio());
//        }
//    }
//    
//    public static Double calculaPromedio(int i, Sheet sheet){
//        
//        Double promedio = 0.0;
//        //String sd = "S/D";
//  
//        for(int j = 10; j <= 16; j++){          
//            if(j != 14){
//                Cell a1 = sheet.getCell(j, i);
//                try{
//                    promedio += Double.parseDouble(a1.getContents());
//                }catch(NumberFormatException e){
//                    promedio += 0; 
//                }
//            }
//        }
//        
//        return promedio/6;
//        
//    }
//    
    
    
}
