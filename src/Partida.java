import java.util.ArrayList;

public class Partida {
    private ArrayList<Poste> postes;
    private int numDiscos;

    //Constructor de la clase Partida
    public Partida(int numDiscos) {
        if (numDiscos < 1) {
            System.out.println("ERROR: La partida debe tener al menos un disco");
            this.numDiscos = 1;
        } else {
            this.numDiscos = numDiscos;
        }

        postes = new ArrayList<>();
        Poste p1 = new Poste();
        Poste p2 = new Poste();
        Poste p3 = new Poste();

        for (int i = this.numDiscos; i >= 1; i--) {
            int diametro = i * 2 + 1;
            if (i % 2 == 1) {
                p1.insertarDisco(new Disco(diametro));
            } else {
                p1.insertarDisco(new DiscoDePiedra(diametro));
            }
        }

        postes.add(p1);
        postes.add(p2);
        postes.add(p3);
    }

    public boolean haTerminado(){
        return (postes.get(0).estaVacio() && postes.get(1).estaVacio()) || postes.get(2).getTamanio() == numDiscos;
    }

    public int moverDisco(int numPosteOrigen, int numPosteDestino) { // Se hace la conversion a -1 antes de iniciar el metodo
        if (numPosteOrigen < 0 || numPosteOrigen > 2 || numPosteDestino < 0 || numPosteDestino > 2) {
            return 1;

        } else if (postes.get(numPosteOrigen).estaVacio()) {
            return 2;

        } else if (postes.get(numPosteOrigen).obtenerUltDiam() > postes.get(numPosteDestino).obtenerUltDiam() && !postes.get(numPosteDestino).estaVacio()) {
            return 3;

        } else {
            Disco extraido = postes.get(numPosteOrigen).extraerDisco();
            postes.get(numPosteDestino).insertarDisco(extraido);
            return 0;
        }
    }

    public void dibujarPartida() {
        System.out.println("Situación actual de la partida:");
        System.out.println();
        for (int i = 0; i < postes.size(); i++) {
            System.out.println("Poste " + (i+1) + ":");
            postes.get(i).dibujarPoste();
            System.out.println();
        }
    }
}