public final class Caballo extends Pieza{
    public Caballo(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public boolean canMove(int x, int y) {
        int diffX = Math.abs(x -getX());
        int diffY = Math.abs(y -getY());
        if((diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2) && !hayObstaculo(x,y,getColor())){
            return true;
        }
        return false;
    }

}
