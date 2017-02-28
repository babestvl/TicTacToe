import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private boolean check(Board board, int putX, int putY) {
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
        System.out.println(s);
        if(s.contains("XXXXX")||s.contains("OOOOO")){
            return true;
        }

        s = "";
        for (int i = -5; i < 5; i++) {
            if (putX - i >= 0 && putX - i < 9 && putY + i >= 0 && putY + i < 9) {
                s += board.getSquares()[putX - i][putY + i];
            }
        }
        System.out.println(s);
        if(s.contains("XXXXX")||s.contains("OOOOO")){
            return true;
        }

        return false;
    }

    public void start() {
        int row = 9;
        int column = 9;
        Board board = new Board(row,column);
        System.out.print("First player name: ");
        Player p1 = new Player(scanner.nextLine(), "X");
        System.out.print("Second player name: ");
        Player p2 = new Player(scanner.nextLine(), "O");
        Player[] p = {p1,p2};

        for (int i = 0; true; i++){
            System.out.println(p[i%2].getName()+"'s turn.");
            System.out.print("Please select row: ");
            int putX = scanner.nextInt();
            System.out.print("Please select column: ");
            int putY = scanner.nextInt();
            p[i%2].placeSymbol(board, putX, putY);
            System.out.printf("You placed %s on (%d,%d)\n",p[i%2].getSymValue(), row, column);
            board.print();
            if (check(board, putX - 1, putY - 1)) {
                System.out.printf("%s player win!\n",p[i%2].getName());
                break;
            }
        }

    }

    public static void main(String[] args) {
       Game game = new Game();
       game.start();
    }
}
