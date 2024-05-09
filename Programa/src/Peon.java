public final class Peon extends Pieza{
    private boolean firstMove = false;
    public Peon(int x, int y, Color color) {
        super(x, y, color);
    }
    @Override
    public boolean canMove(int x, int y) {
        int diffX = Math.abs(x -getX());
        int diffY = Math.abs(y -getY());
            if(!firstMove && diffX == 0 && diffY == 2 && !hayObstaculo(x,y)){
                firstMove = true;
                return true;
            }else if(diffX == 0 && diffY == 1 && !hayObstaculo(x,y)){
                return true;
            }else if(diffX == 1 && diffY == 1 && !hayObstaculo(x,y,getColor()) && esComer(x,y,getColor())){
                return true;
            }
        return false;
    }
    public static boolean esComer(int x , int y , Color color){
        for(Pieza pi : Pieza.getPiezas()){
            if(pi.getX()==x && pi.getY()==y && color != pi.getColor()){
                return true;
            }
        }
        return false;
    }
}
