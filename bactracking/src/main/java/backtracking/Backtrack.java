package backtracking;
import java.util.Arrays;

public class Backtrack {
    private int n;
    private int[] tablero;

    public Backtrack(int n) {
        this.n = n;
        this.tablero = new int[n];
        Arrays.fill(tablero, -1);
    }

    public void resolver(int filaInicial, int columnaInicial) {
        tablero[filaInicial] = columnaInicial;
        if (colocarReina(0)) {
            imprimirSolucion();
        } else {
            System.out.println("No hay solución para " + n + " reinas con esta configuración inicial.");
        }
    }

    private boolean colocarReina(int fila) {
        if (fila == n) {
            return true;
        }
        
        if (tablero[fila] != -1) { // Si ya hay una reina en esta fila, continuar con la siguiente
            return colocarReina(fila + 1);
        }
        
        for (int columna = 0; columna < n; columna++) {
            if (esSeguro(fila, columna)) {
                tablero[fila] = columna;
                if (colocarReina(fila + 1)) {
                    return true;
                }
                tablero[fila] = -1; // Backtrack
            }
        }
        return false;
    }

    private boolean esSeguro(int fila, int columna) {
        for (int i = 0; i < n; i++) {
            if (tablero[i] != -1) {
                if (tablero[i] == columna || Math.abs(tablero[i] - columna) == Math.abs(i - fila)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void imprimirSolucion() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((tablero[i] == j) ? "Q " : "• ");
            }
            System.out.println();
        }
    }
}