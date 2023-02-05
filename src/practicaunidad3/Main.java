/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaunidad3;

import controlador.grafo.GrafoNoDirigidoEtiquetado;
import vista.FrmGrafo;

/**
 *
 * @author Iván González
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GrafoNoDirigidoEtiquetado gnde = new GrafoNoDirigidoEtiquetado(5, String.class);

        System.out.println("GRAFO INICIAL");
        System.out.println(gnde.toString());

        gnde.etiquetarVertice(1, "Campoverde");
        gnde.etiquetarVertice(2, "Intriago");
        gnde.etiquetarVertice(3, "Gonzalez");
        gnde.etiquetarVertice(4, "Chimbo");
        gnde.etiquetarVertice(5, "Nivelo");

        try {
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(5), gnde.obtenerEtiqueta(2), 10.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(1), gnde.obtenerEtiqueta(2), 10.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(1), gnde.obtenerEtiqueta(4), 15.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(5), 15.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(4), 15.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(3), 15.0);
            System.out.println("GRAFO CON VERTICES Y ARISTAS");
            System.out.println(gnde.toString());
            System.out.println("CAMINO MINIMO");
            gnde.caminoMinimo(1, 5).imprimir();
            new FrmGrafo(null, true, gnde, 2).setVisible(true);
        } catch (Exception e) {
            System.out.println("Error en grafo etiquetado " + e);
        }
    }

}
