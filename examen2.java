package org.yourcompany.yourproject;
import java.util.Scanner;
public class TresEnRaya1 {
    public static void main(String[] args) {
        System.out.println("Bueno pesaus este el juego del tres en Raya");
        System.out.println("o como en ingles se dice tic tac toe");
        System.out.println("Comnezemos chios let´s goo");
        Scanner scanner = new Scanner(System.in);
        char[][] tablero = new char[3][3];
        inicializarTablero(tablero);
        boolean juegoTerminado = false;
        char jugadorActual = 'X';
        while (!juegoTerminado) {
            imprimirTablero(tablero);
            realizarMovimiento(tablero, jugadorActual, scanner);
            juegoTerminado = comprobarEstadoJuego(tablero, jugadorActual);
            jugadorActual = cambiarJugador(jugadorActual);
        }
    }
    // Inicializa el tablero con espacios vacíos
    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }
    // Imprime el tablero actual
    public static void imprimirTablero(char[][] tablero) {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---|---|---");
        }
    }
    // Realiza un movimiento el jugador hace una jugada
    public static void realizarMovimiento(char[][] tablero, char jugador, Scanner scanner) {
        int fila, columna;
        boolean movimientoValido = false;

        while (!movimientoValido) {
            System.out.println("Jugador " + jugador + ", ingresa tu movimiento (fila y columna): ");
            System.out.print("Columna: ");
            fila = scanner.nextInt();
            System.out.print("Fila: ");
            columna = scanner.nextInt();
            
            if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                tablero[fila][columna] = jugador;
                movimientoValido = true;
            } else {
                System.out.println("Movimiento inválido. Intenta nuevamente.");
            }
        }
    }
    
    // Esta parte cambia de turno del jugador uno al otro jugador
    public static char cambiarJugador(char jugadorActual) {
        return (jugadorActual == 'X') ? 'O' : 'X';
    }
    
    // Vemos aqui si hay empate o si hay un ganador
    public static boolean comprobarEstadoJuego(char[][] tablero, char jugadorActual) {
        if (hayGanador(tablero, jugadorActual)) {
            imprimirTablero(tablero);
            System.out.println("¡Jugador " + jugadorActual + " ha ganado!");
            return true;
        }
        
        if (esEmpate(tablero)) {
            imprimirTablero(tablero);
            System.out.println("¡Es un empate!");
            return true;
        }
        
        return false;
    }
    
    // Comprueba si hay un ganador en el tablero
    public static boolean hayGanador(char[][] tablero, char jugador) {
        // filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true;
            }
        }
        
        // Clumnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == jugador && tablero[1][j] == jugador && tablero[2][j] == jugador) {
                return true;
            }
        }
        
        // Cprobar diagonales
        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true;
        }
        
        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true;
        }
        
        return false;
    }
    
    // Compruebar el llenado de la tabla 
    public static boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void mostrarTableroInicial() {
        char[][] tablero = new char[3][3];
        inicializarTablero(tablero);
        imprimirTablero(tablero);
    }
}

