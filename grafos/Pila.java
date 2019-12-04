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
public class Pila {

    private Nodo ultimo;
    private int tamaño;

    public Pila() {
        this.tamaño = 0;
        this.ultimo = null;
    }

    public boolean vacia() {
        return this.ultimo == null;
    }

    // push
    public void apilar(int valor) {

        Nodo nuevo = new Nodo(valor);

        if (vacia()) {

            this.ultimo = nuevo;

        } else {

            nuevo.siguiente = this.ultimo;
            this.ultimo = nuevo;
        }

        this.tamaño++;
    }

    // pop
    public int desapilar() {
        if (vacia()) {
            return -1;

        } else {

            //String aux = this.ultimo.valor;
            Nodo aux = new Nodo(this.ultimo.valor);

            this.ultimo = this.ultimo.siguiente;
            this.tamaño--;

            return aux.valor;
        }
    }

    public void imprimir() {
        if (vacia()) {
            System.out.println("Pila vacia");
        } else {
            Nodo aux = this.ultimo;
            for(int i = 0; i<this.tamaño; i++) {
                System.out.println(aux.valor);
                aux = aux.siguiente;
            }
        }
    }
}
