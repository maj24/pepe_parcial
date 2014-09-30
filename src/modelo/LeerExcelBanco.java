/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 *
 * @author Luis Arturo Burgos Varguez
 */
public class LeerExcelBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ArrayList<Indice> indices;
        Workbook workbook = null;
        
        try {
            workbook =
                Workbook.getWorkbook(new 
                    File("C:\\Users\\Luis\\Documents\\3erSemestreLIS\\Estructura de Datos\\Banco_De_Mexico.xls"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IO");
        } catch (BiffException ex) {
            JOptionPane.showMessageDialog(null, "Error diferente");
        }
           
        Sheet sheet = workbook.getSheet(0); 
        indices = new ArrayList<Indice>();
        
        //Llenado del ArrayList.
        for(int i = 18; i < sheet.getRows(); i++){
            Cell celdaValor = sheet.getCell(1, i);
            Cell celdaFecha = sheet.getCell(0, i);
            Indice in;
            try{
               in = new Indice(
                    Double.valueOf(celdaValor.getContents()), 
                    celdaFecha.getContents());
               indices.add(in); 
            }catch (NumberFormatException e){
                System.out.println("Errorz");
            }
            
                  
        }
        
        //Impresion de los elementos en el ArrayList ordenado de forma ascendente.
        for(int j = 0;j < indices.size();j++){
            System.out.println("VALOR: " + indices.get(j).getValor() +
                    "  FECHA: " + indices.get(j).getFecha());
        }

    }
}
