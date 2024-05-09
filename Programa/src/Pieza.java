import java.util.ArrayList;
import java.util.Objects;

public abstract class Pieza implements Movimiento {
    //Coordenadas x e y
    private int x;
    private int y;
    //El color al que pertenece la pieza
    private Color color;
    //Se haran muchas instancias y se guardaran aquí para que cada objeto pueda comparses con un objeto de la misma clase
    private static ArrayList<Pieza> piezas;
    //Constructor
    public Pieza(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Se inicializa todas las pizas con sus respectivos atributos
    public static void setPiezas(){
        piezas = new ArrayList<>();
        // Peones blancos
        for (int i = 0; i < 8; i++) {
            piezas.add(new Peon(i, 1, Color.BLANCO));
        }

        // Torres blancas
        piezas.add(new Torre(0, 0, Color.BLANCO));
        piezas.add(new Torre(7, 0, Color.BLANCO));

        // Caballos blancos
        piezas.add(new Caballo(1, 0, Color.BLANCO));
        piezas.add(new Caballo(6, 0, Color.BLANCO));

        // Alfiles blancos
        piezas.add(new Alfil(2, 0, Color.BLANCO));
        piezas.add(new Alfil(5, 0, Color.BLANCO));

        // Rey y Reina blancos
        piezas.add(new Rey(4, 0, Color.BLANCO));
        piezas.add(new Reina(3, 0, Color.BLANCO));

        // Peones negros
        for (int i = 0; i < 8; i++) {
            piezas.add(new Peon(i, 6, Color.NEGRO));
        }

        // Torres negras
        piezas.add(new Torre(0, 7, Color.NEGRO));
        piezas.add(new Torre(7, 7, Color.NEGRO));

        // Caballos negros
        piezas.add(new Caballo(1, 7, Color.NEGRO));
        piezas.add(new Caballo(6, 7, Color.NEGRO));

        // Alfiles negros
        piezas.add(new Alfil(2, 7, Color.NEGRO));
        piezas.add(new Alfil(5, 7, Color.NEGRO));

        // Rey y Reina negros
        piezas.add(new Rey(4, 7, Color.NEGRO));
        piezas.add(new Reina(3, 7, Color.NEGRO));

    }
    //Comprueba si hay obstucalo comprobando teniendo en cuenta el colo
    public static boolean hayObstaculo(int x, int y , Color color) {
        for(Pieza pi : getPiezas()){
            if(pi.getX()==x && pi.getY()==y && color == pi.getColor())
                return true;
        }
        return false;
    }
    //Comomprueba si hay obstaculo sin comprobar el color (es bueno para ver si hay obstaculos en las trayectorias de algunas piezas)
    public static boolean hayObstaculo(int x, int y) {
        for(Pieza pi : getPiezas()){
            if(pi.getX()==x && pi.getY()==y)
                return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Pieza pieza = (Pieza) o;
        return x == pieza.x && y == pieza.y && color == pieza.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }

    public static ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    public static void setPiezas(ArrayList<Pieza> piezas) {
        Pieza.piezas = piezas;
    }
    public static void removePieza(Pieza pieza){
        Pieza.piezas.remove(pieza);
    }
    public static Pieza searchPieza(byte x , byte y ,Color color){
        return getPiezas().get(getPiezas().indexOf((Pieza) new PiezaSearch(x,y,color)));
    }
    public static Pieza searchAttackedPieza(byte x , byte y ,Color color){
        Color var;
        if(color == Color.BLANCO){
            var = Color.NEGRO;
        }else{
            var = Color.BLANCO;
        }
        Pieza pieza = getPiezas().get(getPiezas().indexOf((Pieza) new PiezaSearch(x,y,var)));
        if (pieza instanceof Rey) {
            if (color == Color.BLANCO)
                Juego.setGanador(Ganar.NEGRAS);
            else
                Juego.setGanador(Ganar.BLANCAS);
        }
        return pieza;
    }
}
