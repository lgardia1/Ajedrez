import java.util.ArrayList;

public class Tablero{
    private final byte dimension = 9;
    private char[][] tablero;

    public Tablero() {
        tablero = new char[dimension][dimension];
        setTablero();
        Pieza.setPiezas();
    }
    private final void setTablero() {
        // Rellenar guías para las coordenadas de la columna (1,2,3,4,5,6,7,8)
        for (int col = 0; col < 8; col++) {
            tablero[col+1][8] = (char) ('1' + col);
        }

        // Rellenar guías para las coordenadas de la fila (A,B,C,D,E,F,G,H)
        for (int row = 0; row < 8; row++) {
            tablero[0][row] = (char) ('H' - row);
        }

        // Rellenar el resto del tablero con espacios en blanco
        for (int col = 1; col < 9; col++) {
            for (int row = 2; row < 7; row++) {
                tablero[col][row] = '-';
            }
        }

        // Peones blancos
        for (int col = 1; col <= 8; col++) {
            tablero[col][1] = 'p';
        }

        // Peones negros
        for (int col = 1; col <= 8; col++) {
            tablero[col][6] = 'P';
        }

        // Torres blancas
        tablero[1][0] = 't';
        tablero[8][0] = 't';

        // Torres negras
        tablero[1][7] = 'T';
        tablero[8][7] = 'T';

        // Caballos blancos
        tablero[2][0] = 'c';
        tablero[7][0] = 'c';

        // Caballos negros
        tablero[2][7] = 'C';
        tablero[7][7] = 'C';

        // Alfiles blancos
        tablero[3][0] = 'a';
        tablero[6][0] = 'a';

        // Alfiles negros
        tablero[3][7] = 'A';
        tablero[6][7] = 'A';

        // Reinas
        tablero[4][0] = 'q';
        tablero[4][7] = 'Q';

        // Reyes
        tablero[5][0] = 'k';
        tablero[5][7] = 'K';

        tablero[0][8]= '-';
    }


     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                sb.append(tablero[col][row]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(byte x , byte y , char c) {
        this.tablero[x][y] = c;
    }
}
