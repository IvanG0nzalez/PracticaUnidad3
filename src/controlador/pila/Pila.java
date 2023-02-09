/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.pila;

import controlador.lista.ListaEnlazada;
import controlador.lista.excepciones.*;
import controlador.pila.excepciones.*;

/**
 *
 * @author ivangonzalez
 */
public class Pila<E> extends ListaEnlazada<E>{
    
    private Integer tope;

    public Pila() {
    }
    
    public Pila(Integer tope) {
        this.tope = tope;
    }

    public Boolean estaLleno(){
        return tope == getSize();
    }
    
    public void push(E dato) throws TopeException{
        if(!estaLleno()){
            insertarCabecera(dato);
        } else throw new TopeException();
    }
    
    public E pop() throws PilaVaciaExcepcion, ListaNullException, PosicionNoEncontradaExcepcion{
        if(!estaVacia()){
            E  dato = eliminar(0);
            
            return dato;
        } else throw new PilaVaciaExcepcion();
    }
    
    public Integer getTope() {
        return tope;
    }

    public void setTope(Integer tope) {
        this.tope = tope;
    }
    
}
