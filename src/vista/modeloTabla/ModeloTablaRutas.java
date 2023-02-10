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
public class ModeloTablaRutas extends AbstractTableModel {
    
    private GrafoNoDirigidoEtiquetado<Pais> gnde;
    private String[] columnas;

    public GrafoNoDirigidoEtiquetado<Pais> getGnde() {
        return gnde;
    }

    public void setGnde(GrafoNoDirigidoEtiquetado<Pais> gnde) {
        this.gnde = gnde;
        crearColumnas();
    }

    @Override
    public int getRowCount() {
        return gnde.numVertices();
    }

    @Override
    public int getColumnCount() {
        return gnde.numVertices() + 1;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return columnas[rowIndex+1];
        } else {
            try {
                if(gnde.existeArista(rowIndex + 1, columnIndex)){
                    return gnde.pesoArista(rowIndex + 1, columnIndex);
                } else {
                    return "-";
                }
            } catch (Exception e) {
                System.out.println("Error en ModeloTablaRutas: " + e);
            }
        }
        return "";
    }
    
    private String[] crearColumnas(){
        columnas = new String[gnde.numVertices() + 1];
        columnas[0] = "-Paises-";
        for (int i = 1; i < columnas.length; i++) {
            columnas[i] = gnde.obtenerEtiqueta(i).toString();
        }
        return columnas;
    }
    
    
    
    
}
