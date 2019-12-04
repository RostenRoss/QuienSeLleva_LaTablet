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
//// Nodo para TAD Cola para Recorrido en Anchura de Árbol Binario.
public class NodoColaRecorridoAnchura {

    //// define un atributo para apuntar recursivamente a otro nodo de la cola.
    public NodoColaRecorridoAnchura siguiente;

    //// define un atributo para almacenar un valor del tipo Nodo Arbol Binario.
    public NodoABinario valor;

    public NodoColaRecorridoAnchura(NodoABinario valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}