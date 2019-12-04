/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolespractica.ejercicio1;

/**
 *
 * @author nesto
 */
public class Main {
    
    
    public static void main(String[] args) {

        NodoABinario nodo50 = new NodoABinario("50");
        NodoABinario nodo30 = new NodoABinario("30");
        NodoABinario nodo70 = new NodoABinario("70");
        NodoABinario nodo20 = new NodoABinario("20");
        NodoABinario nodo40 = new NodoABinario("40");
        NodoABinario nodo60 = new NodoABinario("60");
        NodoABinario nodo80 = new NodoABinario("80");
        NodoABinario nodo90 = new NodoABinario("90");
        NodoABinario nodo10 = new NodoABinario("10");
        NodoABinario nodo15 = new NodoABinario("15");
        NodoABinario nodo75 = new NodoABinario("75");
        NodoABinario nodo94 = new NodoABinario("92");

        nodo50.izq = nodo30;
        nodo50.der = nodo70;

        nodo30.izq = nodo20;
        nodo30.der = nodo40;

        nodo70.izq = nodo60;
        nodo70.der = nodo80;
        
        nodo80.izq = nodo75;
        nodo80.der = nodo94;
        
        nodo20.izq = nodo15;

        ArbolBinario ab = new ArbolBinario();
        ab.construir(nodo50);

        System.out.println("///a");

        System.out.println("Cantidad de elementos: "+ab.getNumElementos(nodo50));
        
        System.out.println("///b");

        
        System.out.println("La profundidad del arbol es: "+ab.getProfundidad(ab.getRaiz()));
        
        System.out.println("///c");
        
        System.out.println("El elemento de valor maximo es: "+ab.maxNodo(ab.getRaiz()));
        
        System.out.println("///d");
        
        System.out.println("El elemento de valor minimo es: "+ab.minNodo(ab.getRaiz()));
        
    }
    
}
