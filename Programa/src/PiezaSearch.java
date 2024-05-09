public class PiezaSearch extends Pieza{

    public PiezaSearch(int x, int y, Color color) {
        super(x, y, color);
    }

    @Override
    public boolean canMove(int x, int y) {
        return false;
    }
}
