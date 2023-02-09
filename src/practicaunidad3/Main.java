/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicaunidad3;

import controlador.grafo.GrafoNoDirigidoEtiquetado;
import javax.swing.plaf.metal.MetalIconFactory;
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

        GrafoNoDirigidoEtiquetado gnde = new GrafoNoDirigidoEtiquetado(7, String.class);

//        System.out.println("GRAFO INICIAL");
//        System.out.println(gnde.toString());

        gnde.etiquetarVertice(1, "V1");
        gnde.etiquetarVertice(2, "V2");
        gnde.etiquetarVertice(3, "V3");
        gnde.etiquetarVertice(4, "V4");
        gnde.etiquetarVertice(5, "V5");
        gnde.etiquetarVertice(6, "V6");
        gnde.etiquetarVertice(7, "V7");

        try {
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(7), gnde.obtenerEtiqueta(6), 2.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(7), gnde.obtenerEtiqueta(5), 2.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(7), gnde.obtenerEtiqueta(4), 2.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(7), gnde.obtenerEtiqueta(3), 2.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(7), gnde.obtenerEtiqueta(2), 2.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(7), gnde.obtenerEtiqueta(1), 2.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(6), gnde.obtenerEtiqueta(5), 2.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(6), gnde.obtenerEtiqueta(4), 5.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(6), gnde.obtenerEtiqueta(3), 1.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(6), gnde.obtenerEtiqueta(2), 8.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(6), gnde.obtenerEtiqueta(1), 6.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(5), gnde.obtenerEtiqueta(4), 20.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(5), gnde.obtenerEtiqueta(3), 13.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(5), gnde.obtenerEtiqueta(2), 10.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(5), gnde.obtenerEtiqueta(1), 1.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(4), gnde.obtenerEtiqueta(3), 2.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(4), gnde.obtenerEtiqueta(2), 9.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(4), gnde.obtenerEtiqueta(1), 12.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(2), 50.0);
            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(1), 50.0);
//            gnde.insertarAristaEtiquetada(gnde.obtenerEtiqueta(2), gnde.obtenerEtiqueta(1), 19.0);
//            System.out.println("GRAFO CON VERTICES Y ARISTAS");
//            System.out.println(gnde.toString());
            
//            gnde.caminoMinimoFloyd();
            
            gnde.caminoMinimoDijkstra(2);
//            System.out.println("RECORRIDO PRIMERO ANCHURA");
//            gnde.recorridoPrimeroAnchura(3).imprimir();
            
            new FrmGrafo(null, true, gnde, 2).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
