/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.grafo.GrafoNoDirigidoEtiquetado;
import controlador.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Pais;

/**
 *
 * @author Iván González
 */
public class ModeloTablaBusquedas extends AbstractTableModel {
    
    private GrafoNoDirigidoEtiquetado<Pais> grafo;
    private ListaEnlazada lista;

    public GrafoNoDirigidoEtiquetado<Pais> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<Pais> grafo) {
        this.grafo = grafo;
    }

    public ListaEnlazada getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        return "Busqueda";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Integer auxiliar = null;
        try {
            auxiliar = (Integer) lista.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println("Error al obtener la lista " + e);
        }
        
        switch(columnIndex){
            case 0: return grafo.obtenerEtiqueta(auxiliar);
            default: return null;
        }
    }
    
    
    
    
    
}
