/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

import controlador.lista.ListaEnlazada;
import controlador.grafo.excepciones.VerticeOfSizeException;

/**
 *
 * @author Usuario iTC
 */
public class GrafoDirigido extends Grafo {

    protected Integer numVertices;
    protected Integer numAristas;
    protected ListaEnlazada<Adyacencia> listaAdyacente[];

    public GrafoDirigido(Integer numVertices) {
        this.numVertices = numVertices;
        numAristas = 0;
        listaAdyacente = new ListaEnlazada[numVertices + 1];
        for (int i = 1; i <= this.numVertices; i++) {
            listaAdyacente[i] = new ListaEnlazada<>();
        }
    }

    @Override
    public Integer numAristas() {
        return numAristas;
    }

    @Override
    public Integer numVertices() {
        return numVertices;
    }

    @Override
    public Boolean existeArista(Integer o, Integer d) throws Exception {
        Boolean existe = false;
        if (o.intValue() <= numVertices && d.intValue() <= numVertices) {
            ListaEnlazada<Adyacencia> lista = listaAdyacente[o];
            for (int i = 0; i < lista.getSize(); i++) {
                Adyacencia a = lista.obtener(i);
                if (a.getDestino().intValue() == d.intValue()) {
                    existe = true;
                    break;
                }
            }
        } else {
            throw new VerticeOfSizeException();
        }
        return existe;
    }

    @Override
    public Double pesoArista(Integer o, Integer d) {
        //Nan: no es un valor numerico, Not a Number
        Double peso = Double.NaN;
        try {
            if (existeArista(o, d)) {
                ListaEnlazada<Adyacencia> adyacentes = listaAdyacente[o];
                for (int i = 0; i < adyacentes.getSize(); i++) {
                    Adyacencia a = adyacentes.obtener(i);
                    if (a.getDestino().intValue() == d.intValue()) {
                        peso = a.getPeso();
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
        return peso;
    }

    @Override
    public void insertarArista(Integer o, Integer d) throws Exception {
        insertarArista(o, d, Double.NaN);
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) throws Exception {

        if (o.intValue() <= numVertices && d.intValue() <= numVertices) {
            if (!existeArista(o, d)) {
                numAristas++;
                listaAdyacente[o].insertar(new Adyacencia(d, peso));
            }
        } else {
            throw new VerticeOfSizeException();
        }
    }

    @Override
    public ListaEnlazada<Adyacencia> adyacentes(Integer v) {

        return listaAdyacente[v];
    }

}
