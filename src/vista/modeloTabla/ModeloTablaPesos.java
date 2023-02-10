/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.grafo.GrafoNoDirigidoEtiquetado;
import javax.swing.table.AbstractTableModel;
import modelo.Pais;

/**
 *
 * @author Iván González
 */
public class ModeloTablaPesos extends AbstractTableModel{
    
    private GrafoNoDirigidoEtiquetado<Pais> grafo;
    private Double[][] recorrido;
    private String[] columnas;

    public GrafoNoDirigidoEtiquetado<Pais> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<Pais> grafo) {
        this.grafo = grafo;
        generarColumnas();
    }
    
    @Override
    public int getRowCount() {
        return grafo.numVertices();
    }

    @Override
    public int getColumnCount() {
        return grafo.numVertices() + 1;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return columnas[rowIndex + 1];
        } else {
            try {
                recorrido = grafo.caminoMinimoFloyd();
//                if(recorrido[rowIndex][columnIndex] > 0){
                    return recorrido[rowIndex][columnIndex - 1];
//                } else {
//                    return "--";
//                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return "--";
    }
    
    private String[] generarColumnas(){
        columnas = new String[grafo.numVertices() + 1];
        columnas[0] = "--Paises--";
        for (int i = 1; i < columnas.length; i++) {
            columnas[i] = grafo.obtenerEtiqueta(i).toString();
            System.out.println(grafo.obtenerEtiqueta(i));
        }
        return columnas;
    }
    
}
