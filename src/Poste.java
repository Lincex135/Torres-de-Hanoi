import java.util.ArrayList;

public class Poste {

    private ArrayList<Disco> discos;

    public Poste() {
        discos = new ArrayList<>();
    }

    public boolean estaVacio() {
        return discos.isEmpty();
    }

    public int obtenerUltDiam() {
        if (estaVacio()) {
            return 0;
        } else {
            return discos.getLast().getDiametro();
        }
    }

    public void insertarDisco(Disco d) {
        discos.add(d);
    }

    public Disco extraerDisco() {
        if (estaVacio()) {
            return null;
        } else {
            return discos.removeLast();
        }
    }

    public void dibujarPoste() {
        if (estaVacio()) {
            System.out.println("=====");
        } else {
            int maxDiametro = 0;
            for (int i = discos.size() - 1; i >= 0; i--) {
                Disco d = discos.get(i);
                d.dibujarDisco();
                if (d.getDiametro() > maxDiametro) {
                    maxDiametro = d.getDiametro();
                }
            }

            for (int i = 0; i < maxDiametro + 2; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public int getTamanio() {
        return discos.size();
    }
}