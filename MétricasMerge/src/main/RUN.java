/*
 * 		Camilo Andres Martinez Duarte 20231020019
 * 		Sergio Alejandro Sanchez Cardenas 20231020031
 * 		Nahin Jose Peñaranda Mejia 20231020032
 */
package main;

import java.util.ArrayList;
import java.util.Random;
import mergeSort.*;
import javax.swing.JOptionPane;

public class RUN {
	public static void main(String[] args) {
		int contador=0;
		MergeSort mergeSort = new MergeSort(contador);
		ArrayList<Integer> lista = new ArrayList<Integer>();
        Random x = new Random();
        
    //Definimos el tamaño de la lista 
        int TAM;
        TAM=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño de la lista a ordenar:"));
        
    //repartimos números aleatorios por la lista
        asignarAleatorios(lista, x, TAM);
        System.out.println("Lista original: " + lista);
        
     // Opciones para mostrar al usuario
        String[] opciones = {"Merge Sort", "Bubble Sort"};
        
        // Mostrar cuadro de diálogo con opciones
        int seleccion = JOptionPane.showOptionDialog(
            null,"Elige un algoritmo", "Selecciona un algoritmo", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,                        
            opciones,                     
            opciones[0]                   
        );

        // Verificar qué opción fue seleccionada
        if (seleccion == 0) {
        	// CASO MERGE SORT
            System.out.println("\nSe ha seleccionado Merge Sort.");
            mergeSort.mergeSort(lista, 0, lista.size() - 1); 
            System.out.println("lista ordenada: " + lista);  
            System.out.println("Numero de procesos: "+mergeSort.getContador());
        } else if (seleccion == 1) {
        	//CASO BURBUJA
            System.out.println("Se ha seleccionado Burbuja.");
            // burbuja();  
        } else {
            // En caso de que el usuario cierre la ventana o no elija nada
            System.out.println("No se seleccionó ninguna opción.");
            System.exit(0);
        }
    
        
        

	}
	// MÉTODOS
    public static void asignarAleatorios(ArrayList<Integer> lista, Random x, int TAM) {
        for (int i = 0; i < TAM; i++) {
            lista.add(x.nextInt(TAM));
        }
    }
}
