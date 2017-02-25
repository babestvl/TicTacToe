public class Player {
    private String name;
    private String symValue;
    public Player(String name, String symValue) {
        this.name = name;
        this.symValue = symValue;
    }

    public Boolean placeSymbol(Board board, int row, int column) {
        return board.placeSymbol(new Symbol(symValue), row-1, column-1);
    }

    public String getName() {
        return name;
    }

    public String getSymValue() {
        return symValue;
    }
}
