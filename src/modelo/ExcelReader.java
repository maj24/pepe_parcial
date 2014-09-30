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
    
    Workbook workbook = null;
    private ArrayList<Indice> indices;
    
    public ExcelReader(){
        try {
            workbook =
                Workbook.getWorkbook(new 
                    File("C:\\Users\\Luis\\Documents\\3erSemestreLIS\\Estructura de Datos"));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IO");
        } catch (BiffException ex) {
            JOptionPane.showMessageDialog(null, "Error diferente");
        }
           
        Sheet sheet = workbook.getSheet(1); 
        indices = new ArrayList<Indice>();
        
        //Llenado del ArrayList.
        for(int i = 3; i < sheet.getRows(); i++){
            Cell celdaValor = sheet.getCell(4, i);
            Cell celdaFecha = sheet.getCell(1,2);
            
            Indice in = new Indice(
                    Double.valueOf(celdaValor.getContents()), 
                    celdaFecha.getContents()
            );
            
            indices.add(in);       
        }
        
    }

    /**
     * @return the indices
     */
    public ArrayList<Indice> getIndices() {
        return indices;
    }
    
    
}
