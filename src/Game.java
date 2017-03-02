public class Game {
    public boolean check(Board board, int putX, int putY) {
        String s = "";
        for (int i = -5; i < 5; i++) {
            if (putY + i >= 0 && putY + i < 9) {
                s += board.getSquares()[putX][putY + i];
            }
        }
        if(s.contains("XXXXX")||s.contains("OOOOO")){
            return true;
        }

        s = "";
        for (int i = -5; i < 5; i++) {
            if (putX + i >= 0 && putX + i < 9) {
                s += board.getSquares()[putX + i][putY];
            }
        }
        if(s.contains("XXXXX")||s.contains("OOOOO")){
            return true;
        }

        s = "";
        for (int i = -5; i < 5; i++) {
            if (putX + i >= 0 && putX + i < 9 && putY + i >= 0 && putY + i < 9) {
                s += board.getSquares()[putX + i][putY + i];
            }
        }
        if(s.contains("XXXXX")||s.contains("OOOOO")){
            return true;
        }

        s = "";
        for (int i = -5; i < 5; i++) {
            if (putX - i >= 0 && putX - i < 9 && putY + i >= 0 && putY + i < 9) {
                s += board.getSquares()[putX - i][putY + i];
            }
        }
        if(s.contains("XXXXX")||s.contains("OOOOO")){
            return true;
        }

        return false;
    }


}
