import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    public void start(Game game) {
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
            if (game.check(board, putX - 1, putY - 1)) {
                System.out.printf("%s player win!\n",p[i%2].getName());
                break;
            }
        }

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.start(new Game());
    }
}
