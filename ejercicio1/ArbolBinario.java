/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolespractica.ejercicio1;

 public class ArbolBinario {

    private NodoABinario raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public boolean vacio() {
        return this.raiz == null;
    }

    public void construir(NodoABinario raiz) {
        this.raiz = raiz;
    }

    public void agregar(String valor) {
        this.raiz = agregarRecursivo(this.raiz, valor);
    }

    public void eliminar(String valor) {
        this.raiz = eliminarRecursivo(this.raiz, valor);
    }

    public void imprimirPreOrder() {
        preOrder(this.raiz);
    }

    public void imprimirInOrder() {
        inOrder(this.raiz);
    }

    public void imprimirPostOrder() {
        posOrder(this.raiz);
    }

    public void imprimirEnAnchura() {
        anchura(this.raiz);
    }

    //// Método interno para realizar recorrido preOrden recursivo
    private void preOrder(NodoABinario nodo) {

        if (nodo == null)
            return;

        System.out.println(nodo.valor);

        preOrder(nodo.izq);
        preOrder(nodo.der);
    }

    //// Método interno para realizar recorrido inOrden recursivo
    private void inOrder(NodoABinario nodo) {

        if (nodo == null)
            return;

        inOrder(nodo.izq);
        System.out.println(nodo.valor);
        inOrder(nodo.der);
    }

    //// Método interno para realizar recorrido posOrden recuersivo
    private void posOrder(NodoABinario nodo) {

        if (nodo == null)
            return;

        posOrder(nodo.izq);
        posOrder(nodo.der);
        System.out.println(nodo.valor);
    }

    //// Método interno para realizar recorrido en anchura
    private void anchura(NodoABinario nodo) {

        ColaBusquedaAnchura cola = new ColaBusquedaAnchura();
        cola.encolar(nodo);

        while (!cola.vacia())
        {
            NodoABinario aux = cola.desencolar();
            System.out.print(aux.valor + " ");

            /*Enqueue left child */
            if (aux.izq != null) {
                cola.encolar(aux.izq);
            }

            /*Enqueue right child */
            if (aux.der != null) {
                cola.encolar(aux.der);
            }
        }
    }

    //// Método interno para agregar valores de forma recursiva
    private NodoABinario agregarRecursivo(NodoABinario nodo, String valor) {

        // Si el nodo es una hoja, entonces lo crear y retorna
        if (nodo == null) {
            nodo = new NodoABinario(valor);
            return nodo;
        }

        // En caso contrario, recorrer el arbol de forma recursiva
        if (valor.compareTo(nodo.valor) <= 0) {
            nodo.izq = agregarRecursivo(nodo.izq, valor);
        }
        else if (valor.compareTo(nodo.valor) > 0) {
            nodo.der = agregarRecursivo(nodo.der, valor);
        }

        // Retorna el nuevo nodo del arbol para ser unido a la raiz
        return nodo;
    }

    //// Método interno para eliminar nodos tomando los 3 casos teóricos.
    private NodoABinario eliminarRecursivo(NodoABinario nodo, String valor){
        NodoABinario aux = nodo;

        if (aux == null) {
            return aux;
        }

        if(valor.compareTo(aux.valor) < 0) {
            aux.izq = eliminarRecursivo(aux.izq, valor);
        }
        else if(valor.compareTo(aux.valor) > 0){
            aux.der = eliminarRecursivo(aux.der, valor);
        }
        else {
            if(aux.izq == null && aux.der == null){
                aux = null;
            }
            else if(aux.der == null){
                aux = aux.izq;
            }
            else if(aux.izq == null){
                aux = aux.der;
            }
            else {
                NodoABinario auxNodoHojaIzq  = encontrarNodoMasIzquierda(aux.der);
                aux.valor = auxNodoHojaIzq.valor;
                aux.der = eliminarRecursivo(aux.der, auxNodoHojaIzq.valor);
            }
        }

        return aux;
    }

    //// Método auxiliar para el proceso de eliminacion de nodos con sub-arboles a la izquierda y derecha.
    private NodoABinario encontrarNodoMasIzquierda(NodoABinario nodo) {
        NodoABinario aux = nodo;

        while(aux.izq != null){
            aux = aux.izq;
        }

        return aux;
    }

    //// Opcional, método para inserción sin usar recursividad
    private void agregarIterativo(String valor){
        NodoABinario nuevo = new NodoABinario(valor);

        if (vacio()) {
            this.raiz = nuevo;
        }
        else {
            NodoABinario auxAnterior = null;
            NodoABinario auxActual = this.raiz;

            while (auxActual != null) {

                auxAnterior = auxActual;

                if (valor.compareTo(auxActual.valor) <= 0) {
                    auxActual = auxAnterior.izq;
                }
                else if (valor.compareTo(auxActual.valor) > 0) {
                    auxActual = auxActual.der;
                }
            }

            if (valor.compareTo(auxAnterior.valor) <= 0) {
                auxAnterior.izq = nuevo;
            }

            else if (valor.compareTo(auxAnterior.valor) > 0) {
                auxAnterior.der = nuevo;
            }
        }
        
        
    }
    public int getNumElementos(NodoABinario nodo){
            int contador = 1;
            
            if (nodo.izq != null) {
                contador +=getNumElementos(nodo.izq);
            }
            if (nodo.der !=null) {
                contador +=getNumElementos(nodo.der);
            }
            return contador;
    }
    
    public int altura (NodoABinario nodo){
        int altura=0;
        
        if (esInterno(nodo)) {
            if (nodo.izq != null) {
                //Math.max devuelve el mas alto de ambos
                altura += Math.max(altura, altura(nodo.izq));
            }
            
            if (nodo.der != null){
                altura += Math.max(altura, altura(nodo.der));
            }
            altura++;
        }
        return altura;
    }
    
    /*public int profundidad (NodoABinario nodo){
        int prof=0;
        
        if (nodo != getRaiz() ) {
            prof =1 + profundidad(nodo.getPadre());
        }
        return prof;
    }*/
    
  
    
    private boolean esHoja (NodoABinario nodo){
        return nodo.izq == null && nodo.der ==null;
    }
    

     public int getProfundidad(NodoABinario root) { 
         if(root!=null) return 1+ Math.max(getProfundidad(root.izq),getProfundidad(root.der)); 
         else return 0; } // an empty tree has height −1 } else { // compute the depth of each subtree int leftDepth = maxDepth(node.left); int rightDepth = maxDepth(node.right); // use the larger one if (leftDepth > rightDepth ) return (leftDepth + 1); else return (rightDepth + 1); } } 


    //si tiene hijos
    private boolean esInterno(NodoABinario nodo){
        return !esHoja(nodo);
    }
    
    public NodoABinario getRaiz(){
        return this.raiz;
    }
    
    public ArbolBinario copia (){
        ArbolBinario arbol = new ArbolBinario();
        arbol.construir(raiz);
        return arbol;
    }
    
    public boolean sonIguales(ArbolBinario s){
        return this.raiz.equals(s.getRaiz()); //retorna verdadero si este arbol es igual al del parametro
                                               // eso lo hace comparando la raiz de ambos arboles.
    }
    
    
  
    //Funcion Maximo
    public String maxNodo(NodoABinario nodo) {
        String max = nodo.valor;
        ColaBusquedaAnchura cola = new ColaBusquedaAnchura();
        cola.encolar(nodo);

        while (!cola.vacia())
        {
            NodoABinario aux = cola.desencolar();

            /*Enqueue left child */
            if (aux.izq != null) {
                cola.encolar(aux.izq);
                if (max.compareToIgnoreCase(aux.izq.valor)<0) {
                    max=aux.izq.valor;
                }
            }

            /*Enqueue right child */
            if (aux.der != null) {
                cola.encolar(aux.der);
                if (max.compareToIgnoreCase(aux.der.valor)<0) {
                    max=aux.der.valor;
                }
            }
        }
        return max;
    }
    
    public String minNodo(NodoABinario nodo) {
        String max = nodo.valor;
        ColaBusquedaAnchura cola = new ColaBusquedaAnchura();
        cola.encolar(nodo);

        while (!cola.vacia())
        {
            NodoABinario aux = cola.desencolar();

            /*Enqueue left child */
            if (aux.izq != null) {
                cola.encolar(aux.izq);
                if (max.compareToIgnoreCase(aux.izq.valor)>0) {
                    max=aux.izq.valor;
                }
            }

            /*Enqueue right child */
            if (aux.der != null) {
                cola.encolar(aux.der);
                if (max.compareToIgnoreCase(aux.der.valor)>0) {
                    max=aux.der.valor;
                }
            }
        }
        return max;
    }
}