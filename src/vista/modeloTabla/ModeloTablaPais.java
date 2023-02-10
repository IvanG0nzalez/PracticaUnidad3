/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Pais;

/**
 *
 * @author Iván González
 */
public class ModeloTablaPais extends AbstractTableModel{
    
    ListaEnlazada<Pais> paises = new ListaEnlazada<>();

    public ListaEnlazada<Pais> getPaises() {
        return paises;
    }

    public void setPaises(ListaEnlazada<Pais> paises) {
        this.paises = paises;
    }
    
    @Override
    public int getRowCount() {
        return paises.getSize();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Capital";
            case 3: return "Territorio";
            case 4: return "PIB";
            default: return null;   
        }
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pais p = null;
        try {
            p = paises.obtener(rowIndex);
        } catch (Exception e) {
            System.out.println(e);
        }
        switch(columnIndex){
            case 0: return (p != null) ? p.getId(): "NO DEFINIDO";
            case 1: return (p != null) ? p.getNombre(): "NO DEFINIDO";
            case 2: return (p != null) ? p.getCapital(): "NO DEFINIDO";
            case 3: return (p != null) ? p.getTerritorio(): "NO DEFINIDO";
            case 4: return (p != null) ? p.getPib(): "NO DEFINIDO";
            default: return null;
                
        }
    }
}
