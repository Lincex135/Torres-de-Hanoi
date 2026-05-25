import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("***********************");
        System.out.println("* LAS TORRES DE HANOI *");
        System.out.println("* Autora: Ximena López *");
        System.out.println("***********************");
        System.out.println();

        int menuPrincipal;
        do {
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1 - Nueva partida");
            System.out.println("2 - Salir");

            // EXCEPCIÓN 1: Menú principal
            try {
                menuPrincipal = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("¡Cuidado! Debes introducir un número.");
                menuPrincipal = -1;
            }

            switch (menuPrincipal) {
                case 1:
                    System.out.println("¿Con cuántos discos deseas jugar?");

                    // EXCEPCIÓN 2: Número de discos
                    int numDiscos;
                    try {
                        numDiscos = Integer.parseInt(teclado.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("¡Cuidado! Debes introducir un número.");
                        break;
                    }
                    Partida partida = new Partida(numDiscos);

                    int menuPartida;
                    do {
                        partida.dibujarPartida();
                        System.out.println("1- Realizar un movimiento");
                        System.out.println("2- Abandonar la partida");

                        // EXCEPCIÓN 3: Menú de partida
                        try {
                            menuPartida = Integer.parseInt(teclado.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("¡Cuidado! Debes introducir un número.");
                            menuPartida = -1;
                        }

                        switch (menuPartida) {
                            case 1:
                                System.out.println("¿Cuál es el poste de origen? (1-3):");

                                // EXCEPCIÓN 4: Poste de origen
                                int posteOrigen;
                                try {
                                    posteOrigen = Integer.parseInt(teclado.nextLine()) - 1;
                                } catch (NumberFormatException e) {
                                    System.out.println("¡Cuidado! Debes introducir un número.");
                                    break;
                                }

                                System.out.println("¿Cuál es el poste de destino?");

                                // EXCEPCIÓN 5: Poste de destino
                                int posteDestino;
                                try {
                                    posteDestino = Integer.parseInt(teclado.nextLine()) - 1;
                                } catch (NumberFormatException e) {
                                    System.out.println("¡Cuidado! Debes introducir un número.");
                                    break;
                                }

                                switch (partida.moverDisco(posteOrigen, posteDestino)) {
                                    case 0:
                                        System.out.println("Disco movido con éxito");
                                        break;
                                    case 1:
                                        System.out.println("ERROR: Número de poste no válido");
                                        break;
                                    case 2:
                                        System.out.println("ERROR. Poste de origen vacío");
                                        break;
                                    case 3:
                                        System.out.println("ERROR. Tamaño del disco en la cima del poste origen mayor que tamaño del disco en la cima del poste destino.");
                                        break;
                                }
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("ERROR. Introduce una opción válida (1 o 2)");
                        }
                    } while (menuPartida != 2 && !partida.haTerminado());
                    if (partida.haTerminado()) {
                        partida.dibujarPartida();
                        System.out.println("Partida acabada");
                    } else {
                        System.out.println("Abandonando la partida...");
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("ERROR. Debes introducir una opción válida (1 o 2)");
                    break;
            }
        } while (menuPrincipal != 2);
        System.out.println("Saliendo del programa. Muchas gracias por jugar.");
    }
}
