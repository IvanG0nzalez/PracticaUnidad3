/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Iván González
 */
public class Pais {
    
    private Integer id;
    private String nombre;
    private String capital;
    private Double territorio;
    private Double pib;

    public Pais() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Double getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Double territorio) {
        this.territorio = territorio;
    }

    public Double getPib() {
        return pib;
    }

    public void setPib(Double pib) {
        this.pib = pib;
    }

    @Override
    public String toString() {
        return nombre + "(" + capital + ")";
    }
    
    
    
}
