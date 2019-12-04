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
public class Grafo {
    private String [] vertices;
    private String [][]aristas;
    private int[][] matriz;
    private int[][] matrizPeso;
      
    public Grafo(String [] vertices, String [][] aristas){
        this.vertices=vertices;
        this.aristas=aristas;
        matriz=new int[vertices.length][vertices.length];
        matrizPeso=new int[vertices.length][vertices.length];;

        //Inicializamos el grafo
        for (int i = 0; i < vertices.length; i++) {
            //columnas
            for (int j = 0; j < vertices.length; j++) {
                matriz[i][j]=0;
                matrizPeso[i][j]=0;
               
            }
        }
        
        //cargar grafo
        for (int i = 0; i < aristas.length; i++) {
            String Vertice1=aristas[i][0];
            String Vertice2=aristas[i][1];
            
            int iVertice1= buscarVertice(Vertice1);
            int iVertice2= buscarVertice(Vertice2);
            
             boolean control=maximoConexiones(iVertice1, iVertice2);
            if (control) {
                
                matrizPeso[iVertice2][iVertice1]=1;
                matrizPeso[iVertice1][iVertice2]=1;

                matriz[iVertice1][iVertice2]++;
                matriz[iVertice2][iVertice1]++;
            }else{
                System.out.println("Numeros maximo de enlaces alcanzado!!");
            }
            
            
        }
    }
    //nueva Conexion con ponderacion
    public void conectar (String vertice1, String vertice2, int ponderacion){
        int iVertice1= buscarVertice(vertice1);
        int iVertice2= buscarVertice(vertice2);
        if (iVertice1 !=-1 && iVertice2 != -1) {
            boolean control=maximoConexiones(iVertice1, iVertice2);
            if (control) {
                matrizPeso[iVertice1][iVertice2]=ponderacion;
                matrizPeso[iVertice2][iVertice1]=ponderacion;

                matriz[iVertice1][iVertice2]++;
                matriz[iVertice2][iVertice1]++;
                System.out.println("Conexion establecida con exito!!");
            }else{
                System.out.println("Numeros maximo de conexiones alcanzado!!");
            }
        }
        
    }
    //CONECTAR 
     //nueva Conexion con ponderacion
    public void conectar (String vertice1, String vertice2){
        int iVertice1= buscarVertice(vertice1);
        int iVertice2= buscarVertice(vertice2);
        if (iVertice1 !=-1 && iVertice2 != -1) {
               matriz[iVertice1][iVertice2]++;
               matriz[iVertice2][iVertice1]++; 
       }
        
    }
    private int buscarVertice(String vertice) {
        for (int i = 0; i < this.vertices.length; i++) {
            if (this.vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }
     public void imprimir() {

        for (int i = 0; i < vertices.length; i++) {
            // columnas
            for (int j = 0; j < vertices.length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
     
     public void imprimirConexiones() {

        for (int i = 0; i < matrizPeso.length; i++) {
            // columnas
            for (int j = 0; j < matrizPeso.length; j++) {
                System.out.print(matrizPeso[i][j] + " ");
            }
            System.out.println();
        }
    }
    private boolean maximoConexiones(int x, int y){
        if (matriz[y][x]<2) {
            return true;
        }else{
            return false;
    
        }
    }
    //eliminar
    public void eliminarConexion (String valor1, String valor2){
        int index1=buscarVertice(valor1);
        int index2=buscarVertice(valor2);
         if (index1 !=-1 && index2 != -1) {
             if (matriz[index1][index2]>0) {
                matriz[index1][index2]--;
                matriz[index2][index1]--;
                 System.out.println("Conexion eliminada!!");
            }else {
                 System.out.println("No existen conexiones que eliminar!!!");
             }
        }
        
    }
    
    public  String obtenerAdyacentes(String valor){
        String retorno="";
        int index = buscarVertice(valor);
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[index][i]>0) {
                retorno+=vertices[i]+", ";
            }
        }
        return retorno;
    }
     ///despues
    public void recorrer(String vertice1, String vertice2){
        int index1=buscarVertice(vertice1);
        int index2=buscarVertice(vertice2);
        Pila pila =new Pila();
        
        for (int i = index1; i < matriz.length; i++) {
                for (int j = 0; j < 10; j++) {
                
                    if (matriz[i][j] != 0) {
                        pila.apilar(j);
                    }
                }
               while(!pila.vacia()){
                   int indexAd=pila.desapilar();
                   
                   if (indexAd !=-1) {
                       for (int j = 0; j < matriz.length;j++) {
                           if (matriz[indexAd][j] != 0) {
                               pila.apilar(j);
                           }
                       }
                   }
               }
            
        }
        
    }
}
