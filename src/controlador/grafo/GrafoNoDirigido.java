/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

import controlador.grafo.excepciones.VerticeOfSizeException;

/**
 *
 * @author Usuario iTC
 */
public class GrafoNoDirigido extends GrafoDirigido{
    public GrafoNoDirigido(Integer numV){
        super(numV);
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) throws Exception {
        if (o.intValue() <= numVertices && d.intValue() <= numVertices) {
            if (!existeArista(o, d)) {
                numAristas++;
                listaAdyacente[o].insertar(new Adyacencia(d, peso));
                listaAdyacente[d].insertar(new Adyacencia(o, peso));
            }
        } else {
            throw new VerticeOfSizeException();

        }
    }
    
    
}
