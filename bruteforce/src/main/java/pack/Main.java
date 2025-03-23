/*
* @autores
* 			- Camilo Andres Martinez Duarte 20231020019
* 			- Sergio Alejandro Sanchez Cardenas 20231020031
* 			- Nahin Jose Peñaranda Mejia 20231020032
* 	
* Solucionador sudoku 4x4 por fuerza bruta.
* 
*/

package pack;

import java.util.HashSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random x = new Random(); // Generador de números aleatorios
        int[][] matrix = new int[4][4]; // Matriz 4x4 para almacenar los números
        boolean condition = false; // Bandera para verificar si la matriz cumple con la condición
        long startTime = System.currentTimeMillis(); // Tiempo de inicio para medir ejecución

        // Se repite hasta encontrar una matriz válida
        while (!condition) {
            // Reiniciar la matriz
            matrix = new int[4][4];

            matrix[0][1] = 3;
            matrix[0][2] = 4;
            matrix[1][0] = 4;
            matrix[1][3] = 2;
            matrix[2][0] = 1;
            matrix[2][3] = 3;
            matrix[3][1] = 3;
            matrix[3][2] = 4;

            // Llenar la matriz con números aleatorios del 1 al 4
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if(matrix[i][j] == 0 )matrix[i][j] = x.nextInt(matrix.length) + 1; // Números entre 1 y 4
                }
            }

            //System.out.println(" ");
            //for (int i = 0; i < 4; i++) {
              //  for (int j = 0; j < 4; j++) {
                //    System.out.print(" " + matrix[i][j]);
                //}
                //System.out.println("");
            //}
            //System.out.println(" ");

            // Verificar si la matriz es la de la condición
            condition = verificador(matrix);
            System.out.println(condition);
        }

        // Calcular y mostrar el tiempo de ejecución
        System.out.println("Tiempo de ejecución: " + (System.currentTimeMillis() - startTime) / 1000.0 + " segundos");

        // Imprimir la matriz generada
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }
    }

    /**
     * Verifica si la matriz cumple con las reglas del mini Sudoku 4x4:
    * - No debe haber números repetidos en filas
    * - No debe haber números repetidos en columnas
    * - No debe haber números repetidos en subcuadrículas de 2x2
    */
    public static boolean verificador(int[][] x) {
        // Verificar filas y columnas
        for (int i = 0; i < 4; i++) {
            HashSet<Integer> rowSet = new HashSet<>(); // Conjunto para verificar duplicados en filas
            HashSet<Integer> colSet = new HashSet<>(); // Conjunto para verificar duplicados en columnas
            for (int j = 0; j < 4; j++) {
                // Si ya existía el número en la fila o en la columna, la matriz no es válida
                if (!rowSet.add(x[i][j]) || !colSet.add(x[j][i])) {
                    return false; // Número repetido en fila o columna
                }
            }
        }

        // Verificar subcuadrículas 2x2
        for (int row = 0; row < 4; row += 2) {
            for (int col = 0; col < 4; col += 2) {
                if (!isValidSubgrid(x, row, col)) {
                    return false; // Número repetido en una subcuadrícula
                }
            }
        }

        return true; // La matriz es válida si no se encontraron repeticiones
    }

    /**
     * Verifica si una subcuadrícula 2x2 no tiene números repetidos.
    */
    private static boolean isValidSubgrid(int[][] matrix, int startRow, int startCol) {
        HashSet<Integer> subgridSet = new HashSet<>(); // Conjunto para verificar duplicados
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                // Si ya existía el número en la subcuadrícula, la matriz no es válida
                if (!subgridSet.add(matrix[startRow + i][startCol + j])) {
                    return false; // Número repetido en la subcuadrícula
                }
            }
        }
        return true; // No hay repeticiones en la subcuadrícula
    }
}