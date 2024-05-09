public class Juego {
    private static Tablero tablero;
    //El turno si es true, nos permite mover las blancas y si es false nos permite mover las negras
    private static boolean  turno ;
    //El ganador se setea si falta algunos de los 2 rey
    private static Ganar ganador;
    public Juego(Tablero tablero) {
        //Se obtiene el tablero donde se incializa el tablero y las piezas
        this.tablero = tablero;
        //Empiezan las blancas
        turno = true;
        //La partida ha empezado y se disputara el ganador se deja sin aclarar el ganador
        ganador = Ganar.NADIE;

    }
    //Nos permite mover las piezas , atacar , cambiar de turno.
    public final void move(String posInicial , String posFinal) throws NullPointerException , ArrayIndexOutOfBoundsException{
    char[] charInicial = posInicial.toCharArray();
    char[] charFinal = posFinal.toCharArray();
         byte[] cartInicial = parseCartesiano(charInicial[0],charInicial[1]);
         byte[] cartFinal = parseCartesiano(charFinal[0], charFinal[1]);
         if(checkPos(cartInicial) && checkPos(cartFinal)) {
                 Color color;
                    if(turno){
                        color = Color.BLANCO;
                    }else{
                        color = Color.NEGRO;
                    }
                    if(Pieza.getPiezas().contains(new PiezaSearch(cartInicial[0],cartInicial[1],color))){
                        Pieza piezaEncontrada = Pieza.searchPieza(cartInicial[0],cartInicial[1],color);
                        Movimiento mov = (Movimiento) piezaEncontrada;
                        if(mov.canMove(cartFinal[0],cartFinal[1])) {
                            if(color == Color.NEGRO) {
                                if (Pieza.getPiezas().contains(new PiezaSearch(cartFinal[0], cartFinal[1], Color.BLANCO)))
                                    Pieza.removePieza(Pieza.searchAttackedPieza(cartFinal[0], cartFinal[1], color));
                            }
                            else {
                                if (Pieza.getPiezas().contains(new PiezaSearch(cartFinal[0], cartFinal[1], Color.NEGRO)))
                                    Pieza.removePieza(Pieza.searchAttackedPieza(cartFinal[0], cartFinal[1], color));
                            }
                            piezaEncontrada.setX(cartFinal[0]);
                            piezaEncontrada.setY(cartFinal[1]);
                            byte[] tableInicial = parseArray(cartInicial[0], cartInicial[1]);
                            byte[] tableFinal = parseArray(cartFinal[0], cartFinal[1]);
                            tablero.setTablero(tableInicial[0],tableInicial[1],'-');
                            tablero.setTablero(tableFinal[0],tableFinal[1],charByInsatceOf(piezaEncontrada));
                            if (turno){
                                setTurno(false);
                            }else{
                                setTurno(true);
                            }
                        }else{
                            System.out.println("No se pude mover la pieza");
                        }
                    }else{
                        System.out.println("Pieza no encontrada");
                    }
         }else{
             System.out.println("Escriba bien las posiciones");
         }
    }
    //Pasa a unas coordenadas clasica de 2 dimensiones al estilo coordenada cartesiano clásico, asi es como estan distribuidas el ArrayList de piezas
    private static byte[] parseCartesiano(char x , char y){
        byte[] i = new byte[2];
        switch (Character.toUpperCase(x)){
            case 'A':
                i[1]=0;
                break;
            case 'B':
                i[1]=1;
                break;
            case 'C':
                i[1]=2;
                break;
            case 'D':
                i[1]=3;
                break;
            case 'E':
                i[1]=4;
                break;
            case 'F':
                i[1]=5;
                break;
            case 'G':
                i[1]=6;
                break;
            case 'H':
                i[1]=7;
                break;
            default:
                i[1]=-1;
                break;
        }
        switch (Character.toUpperCase(y)){
            case '1':
                i[0]=0;
                break;
            case '2':
                i[0]=1;
                break;
            case '3':
                i[0]=2;
                break;
            case '4':
                i[0]=3;
                break;
            case '5':
                i[0]=4;
                break;
            case '6':
                i[0]=5;
                break;
            case '7':
                i[0]=6;
                break;
            case '8':
                i[0]=7;
                break;
            default:
                i[0]=-1;
                break;
        }
        return i;
    }
    //Esto traduce las coordenadas cartesianas a unas coordenadas ajustada a los arrays bidimensional donde se modificará la tabla
    private static byte[] parseArray(byte x , byte y){
        byte[] i = new byte[2];
        i[0] = (byte) (x+1);
        i[1] = (byte) Math.abs(((int) (y))-7);
        return i;
    }
    private static boolean checkPos(byte[] pos){
        return pos[0] != -1 && pos[1] != -1;
    }
    private static char charByInsatceOf(Pieza  pieza){
        char c;
        if(pieza instanceof Peon){
            c = 'p';
        } else if (pieza instanceof Caballo) {
            c = 'c';
        } else if (pieza instanceof Alfil) {
            c = 'a';
        } else if (pieza instanceof Torre) {
            c = 't';
        } else if (pieza instanceof  Reina) {
            c = 'q';
        } else{
            c = 'k';
        }
        if(pieza.getColor() == Color.BLANCO)
            c = Character.toUpperCase(c);
        return c;
    }

    public static void setTurno(boolean turno) {
        Juego.turno= turno;
    }

    public static void setGanador(Ganar ganador){
        Juego.ganador = ganador;
    }
    public static Ganar getGanador() {
        return ganador;
    }

    public static Tablero getTablero() {
        return tablero;
    }
}
