/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

import controlador.lista.ListaEnlazada;

/**
 *
 * @author Usuario iTC
 */
public abstract class Grafo {

    //V ---> A
    //N1 --- N2
    /**
     * Es el numero de vertices del grafo
     *
     * @return
     */
    public abstract Integer numVertices();

    public abstract Integer numAristas();

    public abstract Boolean existeArista(Integer o, Integer d) throws Exception;

    public abstract Double pesoArista(Integer o, Integer d);

    public abstract void insertarArista(Integer o, Integer d) throws Exception;

    public abstract void insertarArista(Integer o, Integer d, Double peso) throws Exception;

    public abstract ListaEnlazada<Adyacencia> adyacentes(Integer v);

    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");
        try {
            for (int i = 1; i <= numVertices(); i++) {
                grafo.append("Vertice: " + String.valueOf(i));
                ListaEnlazada<Adyacencia> lista = adyacentes(i);
                for (int j = 0; j < lista.getSize(); j++) {
                    Adyacencia a = lista.obtener(j);
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- Vertice destino: " + a.getDestino() + " -- SP");
                    } else {
                        grafo.append("-- Vertice destino: " + a.getDestino() + " -- Peso" + a.getPeso());
                    }
                }
                grafo.append("\n");
            }
        } catch (Exception e) {
            grafo.append(e.getMessage());
        }
        return grafo.toString();
    }

    public ListaEnlazada caminoMinimo(Integer origen, Integer destino) throws Exception {
        ListaEnlazada camino = new ListaEnlazada();
        if (estaConectado()) {
            ListaEnlazada pesos = new ListaEnlazada();
            Boolean finalizar = false;
            Integer inicial = origen;
            camino.insertar(inicial);
            while (!finalizar) {
                ListaEnlazada<Adyacencia> adyacencias = adyacentes(inicial);
                Double peso = 10000000.0;
                int T = -1;
                for (int i = 0; i < adyacencias.getSize(); i++) {
                    Adyacencia ad = adyacencias.obtener(i);
                    if (!estaEnCamino(camino, destino)) {
                        Double pesoArista = ad.getPeso();
                        if (destino.intValue() == ad.getDestino().intValue()) {
                            T = ad.getDestino();
                            peso = pesoArista;
                            break;
                        } else if (pesoArista < peso) {
                            T = ad.getDestino();
                            peso = pesoArista;
                        }
                    }
                }
                pesos.insertar(peso);
                camino.insertar(T);
                inicial = T;
                if (destino.intValue() == inicial.intValue()) {
                    finalizar = true;
                }
            }
        } else {
            throw new Exception("Grafo no conectado");
        }
        return camino;
    }

    public Boolean estaEnCamino(ListaEnlazada<Integer> lista, Integer vertice) throws Exception {
        Boolean band = false;
        for (int i = 0; i < lista.getSize(); i++) {
            if (lista.obtener(i).intValue() == vertice.intValue()) {
                band = true;
                break;
            }
        }
        return band;
    }

    public Boolean estaConectado() {
        Boolean band = true;
        for (int i = 1; i <= numVertices(); i++) {
            ListaEnlazada<Adyacencia> lista = adyacentes(i);
            if (lista.estaVacia() || lista.getSize() == 0) {
                band = false;
                break;
            }
        }
        return band;
    }

    public ListaEnlazada caminoMinimoDijkstra(Integer origen) {
        ListaEnlazada caminoDijkstra = new ListaEnlazada<>();
        Double[][] Pesos = pesos();
        Integer s = origen - 1;
        Integer n = this.numVertices();
        Integer[] ultimo = new Integer[n];
        Double[] D = new Double[n];
        Boolean[] F = new Boolean[n]; //true si ya fue recorrido el nodo 

        for (int i = 0; i < n; i++) {
            F[i] = false;
            D[i] = Pesos[s][i];
            ultimo[i] = s;
//            System.out.println("D: " + D[i]);
//            System.out.println("F: " + F[i]);
//            System.out.println("ultimo: " + ultimo[i]);
        }
        F[s] = true;
        D[s] = 0.0;

        for (int j = 1; j < n; j++) {
            Integer v = minimoDijkstra(n, F, D);
//            System.out.println("v: " + v);
            F[v] = true;
            for (int w = 1; w < n; w++) {
                if (!F[w]) {
                    if ((D[v] + Pesos[v][w]) < D[w]) {
                        D[w] = D[v] + Pesos[v][w];
                        ultimo[w] = v;
//                        caminoDijkstra.insertar(D[j-1]);
                    }
//                    caminoDijkstra.insertar(D[j-1]);
                }
            }
        }

        System.out.println("--------------------------------------");
        System.out.println("Desde el nodo " + origen);
        System.out.println("======================================");
        for (int i = 0; i < n; i++) {
            System.out.println("Hacia el nodo " + (i + 1) + " -> Peso minimo: " /**
                     * + F[i] + " - "*
                     */
                    + D[i] + " - " + ultimo[i]/**
             * + " - " + ultimo[i] *
             */
            );
        }
        System.out.println("--------------------------------------");
        return caminoDijkstra;
    }

    private Integer minimoDijkstra(Integer n, Boolean[] F, Double[] D) {
        Double mx = Double.POSITIVE_INFINITY;
        Integer v = 1;
//        System.out.println("n " + n);
//        System.out.println("F " + F);
//        System.out.println("D " + D);
        for (int i = 1; i < n; i++) {
//            System.out.println(!F[i] + " - " + D[i]+ "<="+ mx);
            if (!F[i] && (D[i] <= mx)) {
                mx = D[i];
                v = i;
//                System.out.println("mx: " + mx);
//                System.out.println("v: " + v);
            }
        }
        return v;
    }

    private Double[][] pesos() {
        Integer vertices = this.numVertices();
        Double[][] matriz = new Double[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                Double peso = this.pesoArista(i + 1, j + 1);
                if (peso != 0) {
                    matriz[i][j] = peso;
                } else {
                    matriz[i][j] = Double.POSITIVE_INFINITY;
                }
//                System.out.println("matriz: " + matriz[i][j]);
            }
//            System.out.println("-----");
        }
        return matriz;
    }

    public void caminoMinimoFloyd() {
        Integer n = this.numVertices();
        Double[][] pesos = this.pesos();
        Double[][] d = new Double[n][n];
        Integer[][] traza = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = pesos[i][j];
                traza[i][j] = -1;
//                System.out.println("d: " + d[i][j]);
            }
//            System.out.println("--------");
        }

        for (int i = 0; i < n; i++) {
            d[i][i] = 0.0; //minimo hacia si mismo: 0
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
//                    System.out.println(d[i][k]+ "+"+ d[k][j] +"<"+ d[i][j]);
                    if ((d[i][k] + d[k][j]) < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        traza[i][j] = k;
//                        System.out.println("d: " + d[i][j]);
//                        System.out.println(traza[i][j]);
                    }
                }
            }
        }

        System.out.println("\tV1\tV2\tV3\tV4\tV5\tV6\tV7");
        System.out.println("   ---------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.print("V" + (i + 1) + "|" + "\t");
            for (int j = 0; j < n; j++) {
                System.out.print(d[i][j] + "\t");
            }
            System.out.println("\n");
        }

    }
}
