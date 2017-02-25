import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private boolean check(Board board, int row, int column) {
        //column check
        for (int i = 0; i < row; i++) {
            String s = "";
            for (int j = 0; j < column; j++) {
                s+=board.getSquares()[i][j];
            }
            if (s.contains("XXXXX")||s.contains("OOOOO")) {
                return true;
            }
        }
        //row check
        for (int i = 0; i < column; i++) {
            String s = "";
            for (int j = 0; j < row; j++) {
                s += board.getSquares()[j][i];
            }
            if (s.contains("XXXXX")||s.contains("OOOOO")) {
                return true;
            }
        }
        //cross check
        for (int i = 0; i < row; i++) {
            String s = "";
            for (int j = 0; j < row; i++) {
                for (int k = 0; k < column; k++) {

                }
            }
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
            row = scanner.nextInt();
            System.out.print("Please select column: ");
            column = scanner.nextInt();
            p[i%2].placeSymbol(board, row, column);
            System.out.printf("You placed %s on (%d,%d)\n",p[i%2].getSymValue(), row, column);
            board.print();
            if (check(board, row, column)) {
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
