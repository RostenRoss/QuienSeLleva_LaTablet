/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author nesto
 */
public class Nodo {

    public int valor;
    public Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    // toString() retorna el valor del nodo.
    @Override
    public String toString() {
        return ""+this.valor;
    }
}