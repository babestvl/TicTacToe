public class Board {
    private int row;
    private int column;
    private Square[][] squares;

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        squares = new Square[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                squares[i][j] = new Square();
            }
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Boolean placeSymbol(Symbol symbol, int row, int column) {
        return squares[row][column].setSymbol(symbol);
    }

    public void print() {
        int num = 1;
        for (int i = 0; i <= row; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (Square[] s1 : squares) {
            System.out.print(num++ + " ");
            for (Square s2 : s1) {
                System.out.print(s2.toString() + " ");
            }
            System.out.println();
        }

    }

    public Square[][] getSquares() {
        return squares;
    }
}
