package pack;

import java.util.Scanner;
import static java.lang.Math.max;

class Main {

    static int M, N = 0;
    static Scanner in;
    public static void main(String[] args) {
        in = new Scanner(System.in);
        
        System.out.println("Ingrese el tamaño M: ");
        M = in.nextInt();
        System.out.println("Ingrese el tamaño N: ");
        N = in.nextInt();

        int[][] matri = new int[M][N + 2];
        llenado(matri);

        for (int i = 0; i < M; i++) {
            for (int j = 2; j < (N + 2); j++) {
                matri[i][j] = max(matri[i][j - 1], matri[i][j] + matri[i][j - 2]);
            }
        }

        int[] sol = new int[M + 2];
        for (int i = 0; i < M; i++) {
            sol[i + 2] = matri[i][N + 1];
        }

        for (int i = 2; i < (M + 2); i++) {
            sol[i] = max(sol[i - 1], sol[i] + sol[i - 2]);
        }

        System.out.println(sol[M + 1]);
        
    }

    public static void llenado(int[][] D){
        System.out.println("Llena la matriz");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                D[i][j + 2] = in.nextInt();
            }
        }
    }
}
