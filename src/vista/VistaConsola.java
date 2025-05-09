package vista;

public class VistaConsola {
    public void mostrarTablero(int[][] tablero) {
        for (int[] fila : tablero) {
            for (int celda : fila) {
                System.out.print((celda == 1 ? "R" : ".") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);