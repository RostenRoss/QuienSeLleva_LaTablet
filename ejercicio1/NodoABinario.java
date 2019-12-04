/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolespractica.ejercicio1;

/**
 *
 /**
 * Nodo Arbol Binario
 */
public class NodoABinario {

    public String valor;

    public NodoABinario izq;
    public NodoABinario der;

    public NodoABinario(String valor) {
        this.valor = valor;
        this.izq = null;
        this.der = null;
    }

    @Override
    public String toString() {
        return this.valor;
    }
}