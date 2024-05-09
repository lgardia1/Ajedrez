public final class Rey extends Pieza{

    public Rey(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public boolean canMove(int x, int y) {
        int diffX = Math.abs(x -getX());
        int diffY = Math.abs(y -getY());
        if(diffX != 0 || diffY != 0){
            if(diffX<=1 && diffY<=1 && !hayObstaculo(x,y,getColor()))
                return true;
        }
        return false;
    }
}
