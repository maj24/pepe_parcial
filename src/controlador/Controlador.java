/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import modelo.ExcelReader;
import modelo.Filtro;
import modelo.Indice;
import modelo.Metodos;
import vistas.VistaPrincipal;

/**
 *
 * @author MariaJose
 */
public class Controlador implements ActionListener {
    VistaPrincipal vp;
    
    /**
     * Constructor de la clase Controlador
     * @param vp Objeto de tipo VistaPrincipal
     */
    public Controlador(VistaPrincipal vp){
        this.vp = vp;
        vp.btn_buscar.addActionListener(this);
        vp.btn_limpiar.addActionListener(this);
        vp.rbtn_ascendente.addActionListener(this);
        vp.rbtn_descendente.addActionListener(this);
        vp.rbtn_insercion.addActionListener(this);
        vp.rbtn_burbuja.addActionListener(this);
        vp.rbtn_shellsort.addActionListener(this);
        vp.rbtn_mergesort.addActionListener(this);
        vp.rbtn_quicksort.addActionListener(this);
        vp.rbtn_directa.addActionListener(this);
        vp.rbtn_natural.addActionListener(this);
        vp.combo_indices.addItem("Índice Nacional de Precios al consumidor, Variación acumulada");
        vp.combo_indices.addItem("Índice Nacional de Precios al consumidor, variación anual");
        vp.combo_indices.addItem("Inflación, Subyacente (nueva definición), Mensual");
        vp.combo_indices.addItem("Inflación, Subyacente (nueva definición), Acumulada en el año");
        vp.combo_indices.addItem("Inflación, Subyacente (nueva definición), Anual");
        vp.combo_indices.addItem("nflación, No subyacente (nueva definición), Mensual");
        vp.combo_indices.addItem("Inflación, No subyacente (nueva definición), Acumulada en el año");
        vp.combo_indices.addItem("Inflación, No subyacente (nueva definición), Anual");
        vp.combo_indices.addItem("Índice Nacional de Precios al consumidor Canasta básica, Variación mensual");
        vp.combo_indices.addItem("Índice Nacional de Precios al consumidor Canasta básica, Variación acumulada");
        vp.combo_indices.addItem("Índice Nacional de Precios al consumidor Canasta básica, Variación anual");
        vp.combo_indices.addItem("Inflación, Índice nacional precios productor sin petróleo y sin servicios (INPP), Mensual");
        vp.combo_indices.addItem("Inflación, Índice nacional precios productor sin petróleo y sin servicios (INPP), Acumulada en el año");
        vp.combo_indices.addItem("Índice nacional precios productor sin petróleo y sin servicios (INPP), Anual");
        
        vp.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vp.btn_buscar == e.getSource()){ 
           buscar();
           JOptionPane.showMessageDialog(vp, "Búsqueda completada!");
        } 
        else {
            if(this.vp.rbtn_descendente == e.getSource()){
                vp.rbtn_ascendente.setSelected(false);
            }
            else {
                if(this.vp.rbtn_ascendente == e.getSource()){
                    vp.rbtn_descendente.setSelected(false);
                }
                else {
                    if(this.vp.rbtn_insercion == e.getSource()){
                        vp.rbtn_burbuja.setSelected(false);
                        vp.rbtn_shellsort.setSelected(false);
                        vp.rbtn_mergesort.setSelected(false);
                        vp.rbtn_quicksort.setSelected(false);
                        vp.rbtn_directa.setSelected(false);
                        vp.rbtn_natural.setSelected(false);
                    }
                    else {
                        if(this.vp.rbtn_burbuja == e.getSource()){
                            vp.rbtn_insercion.setSelected(false);
                            vp.rbtn_shellsort.setSelected(false);
                            vp.rbtn_mergesort.setSelected(false);
                            vp.rbtn_quicksort.setSelected(false);
                            vp.rbtn_directa.setSelected(false);
                            vp.rbtn_natural.setSelected(false);
                        }
                        else {
                            if(this.vp.rbtn_shellsort == e.getSource()){
                                vp.rbtn_burbuja.setSelected(false);
                                vp.rbtn_insercion.setSelected(false);
                                vp.rbtn_mergesort.setSelected(false);
                                vp.rbtn_quicksort.setSelected(false);
                                vp.rbtn_directa.setSelected(false);
                                vp.rbtn_natural.setSelected(false);
                            }
                            else {
                                if(this.vp.rbtn_mergesort == e.getSource()){
                                    vp.rbtn_burbuja.setSelected(false);
                                    vp.rbtn_shellsort.setSelected(false);
                                    vp.rbtn_insercion.setSelected(false);
                                    vp.rbtn_quicksort.setSelected(false);
                                    vp.rbtn_directa.setSelected(false);
                                    vp.rbtn_natural.setSelected(false);
                                }
                                else {
                                    if(this.vp.rbtn_quicksort == e.getSource()){
                                        vp.rbtn_burbuja.setSelected(false);
                                        vp.rbtn_shellsort.setSelected(false);
                                        vp.rbtn_mergesort.setSelected(false);
                                        vp.rbtn_insercion.setSelected(false);
                                        vp.rbtn_directa.setSelected(false);
                                        vp.rbtn_natural.setSelected(false);
                                    }
                                    else {
                                        if(this.vp.rbtn_directa == e.getSource()){
                                            vp.rbtn_burbuja.setSelected(false);
                                            vp.rbtn_shellsort.setSelected(false);
                                            vp.rbtn_mergesort.setSelected(false);
                                            vp.rbtn_quicksort.setSelected(false);
                                            vp.rbtn_insercion.setSelected(false);
                                            vp.rbtn_natural.setSelected(false);
                                        }
                                        else {
                                            if(this.vp.rbtn_natural == e.getSource()){
                                                vp.rbtn_burbuja.setSelected(false);
                                                vp.rbtn_shellsort.setSelected(false);
                                                vp.rbtn_mergesort.setSelected(false);
                                                vp.rbtn_quicksort.setSelected(false);
                                                vp.rbtn_directa.setSelected(false);
                                                vp.rbtn_insercion.setSelected(false);
                                            }
                                            else {  // Se preciona "Limpiar"
                                                if(this.vp.btn_limpiar == e.getSource()){
                                                    vp.tf_valor.setText("");
                                                    DefaultTableModel modelo = (DefaultTableModel) vp.tabla_resultados.getModel();
                                                    while(modelo.getRowCount()>0)
                                                        modelo.removeRow(0);                                                 
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void buscar(){
        int index_columna = vp.combo_indices.getSelectedIndex() + 1;
        double valor = Double.parseDouble(vp.tf_valor.getText());
        String signo = vp.combo_signos.getSelectedItem().toString();
        ExcelReader workbook = new ExcelReader(index_columna);
        Metodos metodos = new Metodos(workbook.getIndices());
        if(vp.rbtn_insercion.isSelected()){
            if(vp.rbtn_ascendente.isSelected())
                metodos.insercionAscendente();
            else
                metodos.insercionDescendente();
        } 
        else {
            if(vp.rbtn_burbuja.isSelected()){
                if(vp.rbtn_ascendente.isSelected())
                     metodos.burbujaAscendete();
                else
                     metodos.burbujaDescendete();
            }
        }
         ArrayList<Indice> listaOrdenada = metodos.getIndices();
         Filtro filtro = new Filtro(signo, valor, listaOrdenada);
         filtro.busquedaBinaria();
         ArrayList<Indice> listaResultados = filtro.filtrar();

         // Lena la tabla
         DefaultTableModel modelo = (DefaultTableModel)vp.tabla_resultados.getModel();  
         while(modelo.getRowCount()>0)
         modelo.removeRow(0); 
         Object[] fila=new Object[1];
         for (int i = 0; i <listaResultados.size(); i++) {
             fila[0]=listaResultados.get(i).getValor();
             modelo.addRow(fila);
         }
    }
   
}