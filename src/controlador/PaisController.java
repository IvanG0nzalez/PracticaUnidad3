/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.grafo.GrafoNoDirigidoEtiquetado;
import controlador.lista.ListaEnlazada;
import modelo.Pais;

/**
 *
 * @author Iván González
 */
public class PaisController {
    
    private ListaEnlazada<Pais> paises = new ListaEnlazada<>();
    private  GrafoNoDirigidoEtiquetado<Pais> grafo;

    private void crearGrafo(){
        grafo = new GrafoNoDirigidoEtiquetado<>(paises.getSize(), Pais.class);
        try {
            for (int i = 0; i < paises.getSize(); i++) {
                grafo.etiquetarVertice((i+1), paises.obtener(i));
            }
        } catch (Exception e) {
        }
    }
    
    public ListaEnlazada<Pais> getPaises() {
        return paises;
    }

    public void setPaises(ListaEnlazada<Pais> paises) {
        this.paises = paises;
    }

    public GrafoNoDirigidoEtiquetado<Pais> getGrafo() {
        if(grafo == null){
            crearGrafo();
        }
        return grafo;
    }

    public void setGrafo(GrafoNoDirigidoEtiquetado<Pais> grafo) {
        this.grafo = grafo;
    }

    @Override
    public String toString() {
        return "PaisController{" + "grafo=" + grafo + '}';
    }
    
    
    
}
