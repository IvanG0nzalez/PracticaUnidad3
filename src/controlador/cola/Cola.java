/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.cola;

import controlador.cola.excepciones.CimaExcepcion;
import controlador.cola.excepciones.ColaVaciaExcepcion;
import controlador.lista.ListaEnlazada;
import controlador.lista.excepciones.ListaNullException;
import controlador.lista.excepciones.PosicionNoEncontradaExcepcion;

/**
 *
 * @author ivangonzalez
 */
public class Cola<E> extends ListaEnlazada<E>{
    private Integer cima;

    public Cola(Integer cima) {
        this.cima = cima;
    }
    
    public Boolean estaLleno(){
        return cima == getSize();
    }
    
    public void queue(E dato) throws PosicionNoEncontradaExcepcion, CimaExcepcion{
        if(!estaLleno()){
           insertar(dato);           
            
        } else throw new CimaExcepcion();
        
    }
    
    public E dequeue() throws ColaVaciaExcepcion, PosicionNoEncontradaExcepcion, ListaNullException{
        if(!estaVacia()){
            E dato = eliminar(0);
            return dato;
        } else throw new ColaVaciaExcepcion();
    }
}
