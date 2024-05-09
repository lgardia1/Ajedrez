public final class Reina extends Pieza{
    public Reina(int x, int y, Color color) {
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
                if(hayObstaculo(checkX,checkY))
                    return false;
                checkY +=deltaY;
                checkX +=deltaX;
            }
            return true;
        }else if((diffX == 0 && diffY>0) || (diffX>0 && diffY == 0)) if (diffX == 0) {
            int deltaY = y > getY() ? 1 : -1;
            int checkY = deltaY + getY();
            while (checkY != x) {
                if (hayObstaculo(getX(), checkY,getColor()))
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
