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
            menuPrincipal = Integer.parseInt(teclado.nextLine());
            switch (menuPrincipal) {
                case 1:
                    System.out.println("¿Con cuántos discos deseas jugar?");
                    Partida partida = new Partida(Integer.parseInt(teclado.nextLine()));

                    int menuPartida;
                    do {
                        partida.dibujarPartida();
                        System.out.println("1- Realizar un movimiento");
                        System.out.println("2- Abandonar la partida");
                        menuPartida = Integer.parseInt(teclado.nextLine());

                        switch (menuPartida) {
                            case 1:
                                System.out.println("¿Cuál es el poste de origen? (1-3):");
                                int posteOrigen = Integer.parseInt(teclado.nextLine()) - 1;
                                System.out.println("¿Cuál es el poste de destino?");
                                int posteDestino = Integer.parseInt(teclado.nextLine()) - 1;
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