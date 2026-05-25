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
            System.out.println(Color.BROWN + "=====" + Color.RESET);
        } else {
            int maxDiametro = discos.getFirst().getDiametro();

            for (int i = discos.size() - 1; i >= 0; i--) {
                Disco disco = discos.get(i);
                int espacios = (maxDiametro - disco.getDiametro()) / 2;
                disco.dibujarDisco(espacios, maxDiametro + 2);
            }

            for (int i = 0; i < maxDiametro + 2; i++) {
                System.out.print("=");
            }
            System.out.println();
        }
    }

    public String getBaseComoTexto(int anchoTotal, int diametroMaximo) {
        int base;
        if (estaVacio()) {
            base = 5;
        } else {
            base = diametroMaximo + 2;
        }
        int espacios = (anchoTotal - base) / 2;
        return " ".repeat(espacios) + Color.BROWN + "=".repeat(base) + Color.RESET + " ".repeat(anchoTotal - espacios - base);
    }

    public String getFilaComoTexto(int fila, int anchoTotal, int numDiscos) {
        int filasVacias = numDiscos - discos.size();
        int indice = fila - filasVacias;

        StringBuilder resultado = new StringBuilder();

        if (indice < 0) {
            int espaciosAntes = anchoTotal / 2;
            int espaciosDespues = anchoTotal - espaciosAntes - 1;
            resultado.append(" ".repeat(Math.max(0, espaciosAntes)));
            resultado.append(Color.WOOD + "|" + Color.RESET);
            resultado.append(" ".repeat(Math.max(0, espaciosDespues)));
        } else {
            Disco d = discos.get(discos.size() - 1 - indice);
            int espaciosAntes = (anchoTotal - d.getDiametro()) / 2;
            int espaciosDespues = anchoTotal - espaciosAntes - d.getDiametro();
            resultado.append(" ".repeat(Math.max(0, espaciosAntes)));
            for (int i = 0; i < d.getDiametro(); i++) resultado.append(d.getSimbolo());
            resultado.append(" ".repeat(Math.max(0, espaciosDespues)));
        }

        return resultado.toString();
    }

    public int getTamanio() {
        return discos.size();
    }
}