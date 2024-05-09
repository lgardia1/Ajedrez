public interface Movimiento {
    //Define el movimiento de cada pieza permite restringir el movimiento para decir si lo puede hacer cuando se le pida
    public boolean canMove(int x , int y);
}
