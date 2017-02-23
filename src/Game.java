import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);

    private boolean check(Board board, int row, int column) {
        int count = 0;
        Square[][] s = board.getSquares();
        for (int i = 0; i < row; i++) {
            rowCheck(s[i]);
        }
        for (int i = 0; i < row; i++) {
            Square[] sq = new Square[column];
            for (int j = 0; j < column; j++) {
                sq[j] = s[i][j];
            }
            columnCheck(sq);
        }
        return false;
    }
    private boolean rowCheck(Square[] row) {
        
    }
    private boolean columnCheck(Square[] col) {

    }

    public void start() {
        int row = 9;
        int column = 9;
        Board board = new Board(row,column);
        System.out.print("First player name: ");
        Player p1 = new Player(scanner.nextLine(), "X");
        System.out.print("Second player name: ");
        Player p2 = new Player(scanner.nextLine(), "O");
        while(true) {
            System.out.println("P1's turn.");
            System.out.print("Please select row: ");
            row = scanner.nextInt();
            System.out.print("Please select column: ");
            column = scanner.nextInt();

            p1.placeSymbol(board, row, column);

            System.out.printf("You placed %s on (%d,%d)\n","X",row,column);
            board.print();
            if (check(board, row, column)) {
                System.out.printf("%s player win!\n",p1.getName());
                break;
            }

            System.out.println("P2's turn.");
            System.out.print("Please select row: ");
            row = scanner.nextInt();
            System.out.print("Please select column: ");
            column = scanner.nextInt();

            p2.placeSymbol(board, row, column);

            System.out.printf("You placed %s on (%d,%d)\n","O",row,column);
            board.print();
            if (check(board, row, column)) {
                System.out.printf("%s player win!\n",p2.getName());
                break;
            }

        }

    }

    public static void main(String[] args) {
       Game game = new Game();
       game.start();
    }
}
