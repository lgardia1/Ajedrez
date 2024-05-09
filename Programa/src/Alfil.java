public final class Alfil extends Pieza{
    public Alfil(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public boolean canMove(int x, int y) {
        int diffX = Math.abs(x -getX());
        int diffY = Math.abs(y -getY());
        if(!hayObstaculo(x,y,getColor()))
        if(diffY == diffX && diffX!=0){
            int deltaX = x > getX() ? 1 : -1;
            int deltaY = y > getY() ? 1 : -1;
            int checkX = deltaX + getX();
            int checkY = deltaY + getY();
            while (checkY != y && checkX != x){
                if(hayObstaculo(checkX,checkY,getColor()))
                    return false;
                checkY +=deltaY;
                checkX +=deltaX;
            }
            return true;
        }
        return false;

    }

}
