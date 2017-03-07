public class Game {
    private Player[] p;
    private Board board;
    private int round;
    public Game(int row, int column, String name1, String name2) {
        board = new Board(row, column);
        round = 0;
        p = new Player[2];
        p[0] = new Player(name1, "X");
        p[1] = new Player(name2, "O");
    }

    public boolean check(int putX, int putY) {
        String s = "";
        for (int i = -5; i < 5; i++) {
            if (putY + i >= 0 && putY + i < 9) {
                s += board.getSquares()[putX][putY + i];
            }
        }
        if (s.contains("XXXXX") || s.contains("OOOOO")) {
            return true;
        }

        s = "";
        for (int i = -5; i < 5; i++) {
            if (putX + i >= 0 && putX + i < 9) {
                s += board.getSquares()[putX + i][putY];
            }
        }
        if (s.contains("XXXXX") || s.contains("OOOOO")) {
            return true;
        }

        s = "";
        for (int i = -5; i < 5; i++) {
            if (putX + i >= 0 && putX + i < 9 && putY + i >= 0 && putY + i < 9) {
                s += board.getSquares()[putX + i][putY + i];
            }
            if (s.contains("XXXXX") || s.contains("OOOOO")) {
                return true;
            }
        }
        s = "";
        for (int i = -5; i < 5; i++) {
            if (putX - i >= 0 && putX - i < 9 && putY + i >= 0 && putY + i < 9) {
                s += board.getSquares()[putX - i][putY + i];
            }
        }
        if (s.contains("XXXXX") || s.contains("OOOOO")) {
            return true;
        }

        return false;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayer() {
        return p[round++ % 2];
    }
}

