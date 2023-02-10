/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utilidades;

import com.google.gson.Gson;
import controlador.PaisController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import javax.swing.JComboBox;

/**
 *
 * @author ivangonzalez
 */
public class Utilidades {

    public static  String DISCARPDATA = "data";
    public static Gson gson = new Gson();
    
    public static JComboBox cargarComboPais(JComboBox cbx, PaisController pc) throws Exception{
        cbx.removeAllItems();
        for (int i = 0; i < pc.getPaises().getSize(); i++) {
            cbx.addItem(pc.getPaises().obtener(i));
        }
        
        return cbx;
    }
    
    public static Field obtenerAtributo(Class clase, String nombre) {
        Field atributo = null;
        for (Field aux : clase.getDeclaredFields()) {
            if (nombre.equalsIgnoreCase(aux.getName())) {
                atributo = aux;
                break;
            }
        }

        return atributo;
    }

    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }

    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }

    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }

    public static Boolean IsPrimitive(Class clase) {
        return clase.isPrimitive();
    }

    public static Boolean isObject(Class clase) {
        return (!IsPrimitive(clase) && !isBoolean(clase) && !isCharacter(clase) && !isNumber(clase) && !isString(clase));
    }

    public static Double calcularDistancia(Double y, Double y1, Double x, Double x1) {
        Double yy = y - y1;
        Double xx = x - x1;
        return redondear(Math.sqrt((yy * yy) + (xx * xx)));
    }

    public static Double redondear(Double dato) {
        return Math.round(dato * 100.0) / 100.0;
    }
    
    public static boolean guardarJson(PaisController paisController) {
        String json = gson.toJson(paisController);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DISCARPDATA + File.separatorChar + "pais.json"))){
            bw.write(json);
            System.out.println("Pais Guardado");
            return true;
        } catch (Exception e) {
            System.out.println("Erro al guardar pais: " + e);
            return false;
        }
    }
    
    public static PaisController cargarJson(){
        String fichero = "";
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(DISCARPDATA + File.separatorChar + "pais.json"));
            String linea = "";
            while((linea = br.readLine()) != null){
                fichero = fichero + linea;
            }
            br.close();
            
        } catch (FileNotFoundException e){
            System.out.println("Error: " + e);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        PaisController paises = gson.fromJson(fichero, PaisController.class);
        return paises;
    }

}
