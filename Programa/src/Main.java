import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Juego partida = new Juego(new Tablero());
        String posInicial , posFinal;
        while(Juego.getGanador() == Ganar.NADIE){
            try{
                System.out.println(partida.getTablero());
                System.out.println("Escriba la posiciona incial");
                posInicial = input.next();
                System.out.println("Escriba la posicion final");
                posFinal = input.next();
                System.out.println();
                partida.move(posInicial,posFinal);
            }catch (InputMismatchException | ArrayIndexOutOfBoundsException ex){
                System.out.println("Caracteres no validos");
            }catch (NullPointerException ex){
                System.out.println("Posicones vacias");
            }
        }
        if(partida.getGanador() == Ganar.BLANCAS)
            System.out.println("Ha ganado las piezas blancas");
        else
            System.out.println("Ha ganado las piezas negras");
    }
}