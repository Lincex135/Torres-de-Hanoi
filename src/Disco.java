import java.util.Scanner;

public class Disco {

    protected int diametro;

    public Disco(int diametro) {
        if (diametro < 3) {
            this.diametro = 3;
            System.out.println("ADVERTENCIA: diámetro demasiado pequeño, se le asigna tamaño 3.");
        }
        else if (diametro % 2 == 0) {
            this.diametro = diametro + 1;
            System.out.println("ADVERTENCIA: diámetro del disco inválido, se le asigna tamaño " + this.diametro);
        }
        else {
            this.diametro = diametro;
        }
    }

    public int pedirDiametro(Scanner teclado) {
        System.out.println("Introduce el diametro del disco: ");
        return Integer.parseInt(teclado.nextLine());
    }

    public void dibujarDisco(){
        for (int i = 1; i <= diametro; i++) {
            System.out.print("o");
        }
        System.out.println();
    }

    public void dibujarDisco(int espacios, int anchoTotal) {
        for (int i = 0; i < espacios; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= diametro; i++) {
            System.out.print("o");
        }
        int espaciosDespues = anchoTotal - espacios - diametro;
        for (int i = 0; i < espaciosDespues; i++) {
            System.out.print(" ");
        }
    }

    public int getDiametro() {
        return diametro;
    }

    public String getSimbolo() {
        return "o";
    }
}
