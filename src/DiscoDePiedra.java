public class DiscoDePiedra extends Disco{

    public DiscoDePiedra(int diametro) {
        super(diametro);
    }

    public void dibujarDisco(int espacios, int anchoTotal) {
        for (int i = 0; i < espacios; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= diametro; i++) {
            System.out.print("@");
        }
        int espaciosDespues = anchoTotal - espacios - diametro;
        for (int i = 0; i < espaciosDespues; i++) {
            System.out.print(" ");
        }
    }

    @Override
    public String getSimbolo() {
        return Color.GRAY + "@" + Color.RESET;
    }
}