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
    int index_columna;
    
    public ExcelReader(int index_columna){
        //Cargando el woorbook del archivo de excel.
        this.index_columna = index_columna;
        try {
            workbook =
                Workbook.getWorkbook(new 
                    File("C:\\Users\\MariaJose\\Documents\\Fmat\\3° semestre\\ED\\1 proyecto\\Banco_De_Mexico.xls"));
                    //File("C:\\Users\\Luis\\Documents\\3erSemestreLIS\\Estructura de Datos\\Banco_De_Mexico.xls));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error de IO");
        } catch (BiffException ex) {
            JOptionPane.showMessageDialog(null, "Error diferente");
        }
           
        Sheet sheet = workbook.getSheet(0); 
        indices = new ArrayList<Indice>();
        
        //Llenado del ArrayList.
        for(int i = 18; i < sheet.getRows(); i++){
            Cell celdaValor = sheet.getCell(index_columna, i);
            Cell celdaFecha = sheet.getCell(0, i);
            Indice in;
            try{
               in = new Indice(
                    Double.valueOf(celdaValor.getContents()), 
                    celdaFecha.getContents());
               indices.add(in); 
            }catch (NumberFormatException e){
                System.out.println("Campo sin valor");
            }
        }
        
    }

    /**
     * @return the indices
     */
    public ArrayList<Indice> getIndices() {
        return indices;
    }
    
    
}
