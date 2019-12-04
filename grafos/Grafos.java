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
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] vertices = { "A", "B", "C", "D", "E", "F" };
        String[][] aristas ={{"E", "A"},{"E", "A"},{"E", "B"},{"E", "C"},{"E", "D"},{"E", "F"},{"A", "B"},{"A", "F"},{"F", "D"},{"F", "D"},{"D", "C"},{"C", "B"},{"C", "B"},};
        String vertice = null;
        String vertice1 = "A";
        String vertice2 = "B";
        String vertice3 = "C";
        String vertice4 = "D";
        String vertice5 = "E";
        String vertice6 = "F";
        
        int ponderacion = 0;

        // Inicializarlo
        Grafo g = new Grafo(vertices, aristas);
        
        // Nuevas conexiones
        
           
        // Nuevas conexiones con Ponderacion

        // Recorrerlo
        g.imprimir();
        System.out.println("");
        g.imprimirConexiones();
        
        System.out.println("Adyacentes de C: "+g.obtenerAdyacentes("C"));

    }
    
}
