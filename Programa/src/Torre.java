public final class Torre extends Pieza{

    public Torre(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public boolean canMove(int x, int y) {
        int diffX = Math.abs(x -getX());
        int diffY = Math.abs(y -getY());
        if(!hayObstaculo(x,y,getColor()))
        if((diffX == 0 && diffY>0) || (diffX>0 && diffY == 0)) if (diffX == 0) {
            int deltaY = y > getY() ? 1 : -1;
            int checkY = deltaY + getY();
            while (checkY != y) {
                if (hayObstaculo(getX(), checkY))
                    return false;
                checkY += deltaY;
            }
            return true;
        } else {
            int deltaX = x > getX() ? 1 : -1;
            int checkX = deltaX + getX();
            while (checkX != x) {
                if (hayObstaculo(checkX, y,getColor()))
                    return false;
                checkX += deltaX;
            }
            return true;
        }
        return false;
    }
}
