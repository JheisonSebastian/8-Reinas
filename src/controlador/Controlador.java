package controlador;

import modelo.Tablero;
import vista.VistaConsola;

import java.util.Scanner;

public class Controlador {
    private Tablero tablero;
    private VistaConsola vista;

    public Controlador() {
        tablero = new Tablero();
        vista = new VistaConsola();
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        
        vista.mostrarMensaje("Ingrese la fila (0-7) para la primera reina:");
        int fila = leerEntrada(sc, 0, 7);

        vista.mostrarMensaje("Ingrese la columna (0-7) para la primera reina:");
        int col = leerEntrada(sc, 0, 7);

        tablero.colocarPrimeraReina(fila, col);

        vista.mostrarMensaje("\nSoluciones encontradas: " + tablero.getSoluciones().size() + "\n");

        for (int[][] solucion : tablero.getSoluciones()) {
            vista.mostrarTablero(solucion);
        }
    }

    private int leerEntrada(Scanner sc, int min, int max) {
        int valor;
        while (true) {
            try {
                valor = Integer.parseInt(sc.nextLine());
                if (valor >= min && valor <= max) {
                    return valor;
                }
                vista.mostrarMensaje("Por favor, ingrese un número entre " + min + " y " + max + ":");
            } catch (NumberFormatException e) {
                vista.mostrarMensaje("Entrada inválida. Intente de nuevo:");
            }
        }
    }
}
