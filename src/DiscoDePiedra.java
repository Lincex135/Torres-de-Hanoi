public class DiscoDePiedra extends Disco{

    public DiscoDePiedra(int diametro) {
        super(diametro);
    }

    public void dibujarDisco(){
        for (int i = 1; i <= diametro; i++) {
            System.out.print("@");
        }
        System.out.println();
    }
}