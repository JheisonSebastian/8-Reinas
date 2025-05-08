package vista;

public class VistaConsola {

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print((celda == 1 ? "♛" : ".") + " ");
            }
            System.out.println();
        }
        System.out.println(); // línea en blanco entre soluciones
    }
}
