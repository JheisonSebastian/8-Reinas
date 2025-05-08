package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private int[][] tablero;
    private List<int[][]> soluciones;

    public Tablero() {
        tablero = new int[8][8];
        soluciones = new ArrayList<>();
    }

    public boolean esValido(int fila, int col) {
        // Verifica si hay una reina en la misma columna o diagonales
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 1) return false; // misma columna
            if (col - (fila - i) >= 0 && tablero[i][col - (fila - i)] == 1) return false; // diagonal izquierda
            if (col + (fila - i) < 8 && tablero[i][col + (fila - i)] == 1) return false; // diagonal derecha
        }
        return true;
    }

    public void resolver(int fila) {
        if (fila == 8) {
            soluciones.add(getCopiaTablero());
            return;
        }

        for (int col = 0; col < 8; col++) {
            if (esValido(fila, col)) {
                tablero[fila][col] = 1;
                resolver(fila + 1);
                tablero[fila][col] = 0; // backtrack
            }
        }
    }

    public void colocarPrimeraReina(int fila, int col) {
        tablero[fila][col] = 1;
        resolver(1); // comienza desde la fila 1, ya que la 0 tiene la reina inicial
        tablero[fila][col] = 0; // limpiar después de resolver
    }

    public List<int[][]> getSoluciones() {
        return soluciones;
    }

    public int[][] getCopiaTablero() {
        int[][] copia = new int[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(tablero[i], 0, copia[i], 0, 8);
        }
        return copia;
    }
}
