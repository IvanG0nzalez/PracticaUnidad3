/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

import controlador.lista.ListaEnlazada;
import java.lang.reflect.Array;
import java.util.HashMap;

/**
 *
 * @author Usuario iTC
 */
public class GrafoDirigidoEtiquetado<E> extends GrafoDirigido {
    protected E etiquetas[];
    protected HashMap<E, Integer> dicVertices;
    private Class<E> clazz;
    
    public GrafoDirigidoEtiquetado(Integer numVert, Class clazz){
        super(numVert);
        this.clazz = clazz;
        etiquetas = (E[]) Array.newInstance(clazz, numVert + 1);
        dicVertices = new HashMap(numVert);
    }
    
    public Boolean existeAristaEtiquetada(E origen, E destino) throws Exception{
        return this.existeArista(obtenerCodigoEtiquetado(origen), obtenerCodigoEtiquetado(destino));
    }
    
    public void insertarAristaEtiquetada(E origen, E destino, Double peso) throws Exception{
        insertarArista(obtenerCodigoEtiquetado(origen), obtenerCodigoEtiquetado(destino), peso);
    }
    
    public void insertarAristaEtiquetada(E origen, E destino) throws Exception{
        insertarArista(obtenerCodigoEtiquetado(origen), obtenerCodigoEtiquetado(destino));
    }
    
    public ListaEnlazada<Adyacencia> adyacentesEtiquetada(E o){
        return adyacentes(obtenerCodigoEtiquetado(o));
    } 
    
    private Integer obtenerCodigoEtiquetado(E etiqueta){
        return dicVertices.get(etiqueta);
    }
    
    public E obtenerEtiqueta(Integer codigo){
        return etiquetas[codigo];
    }
    
    public void etiquetarVertice(Integer codigo, E etiqueta){
        etiquetas[codigo] = etiqueta;
        dicVertices.put(etiqueta, codigo);
    }
    
    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");
        try {
            for(int i = 1; i <= numVertices(); i++){
            grafo.append("Vertice: "+ String.valueOf(i) + " [" + obtenerEtiqueta(i) + "]");
            ListaEnlazada<Adyacencia> lista = adyacentes(i);
            for(int j = 0; j < lista.getSize(); j++){
                Adyacencia a = lista.obtener(j);
                if(a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))){
                    grafo.append(" -- Vertice destino: " + obtenerEtiqueta(a.getDestino()).toString() + " -- SP ");
                } else {
                    grafo.append(" -- Vertice destino: " + obtenerEtiqueta(a.getDestino()).toString() + " -- Peso "+a.getPeso());
                }
            }
            grafo.append("\n");
        }
        } catch (Exception e) {
            grafo.append(e.getMessage());
        }
        return grafo.toString();
    }
}
