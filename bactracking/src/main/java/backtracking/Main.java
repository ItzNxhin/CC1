package backtracking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del tablero (n): ");
        int n = scanner.nextInt();
        System.out.print("Ingrese la fila inicial para la reina (0 a " + (n - 1) + "): ");
        int filaInicial = scanner.nextInt();
        System.out.print("Ingrese la columna inicial para la reina (0 a " + (n - 1) + "): ");
        int columnaInicial = scanner.nextInt();
        
        Backtrack solucion = new Backtrack(n);
        solucion.resolver(filaInicial, columnaInicial);
        scanner.close();
    }
}
