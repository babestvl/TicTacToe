import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First player name: ");
        String name1 = scanner.nextLine();
        System.out.print("Second player name: ");
        String name2 = scanner.nextLine();
        Game g = new Game(9, 9, name1, name2);
        for (int i = 0; true; i++) {
            System.out.println(g.getP()[i%2].getName() + "'s turn.");
            System.out.print("Please select row: ");
            int putX = scanner.nextInt();
            System.out.print("Please select column: ");
            int putY = scanner.nextInt();
            System.out.printf("You placed %s on (%d,%d)\n", g.getP()[i%2].getSymValue(), putX, putY);
            g.getP()[i%2].placeSymbol(g.getBoard(), putX, putY);
            if (g.check(putX - 1, putY - 1)) {
                System.out.printf("%s player win!\n", g.getP()[i%2].getName());
                break;
            }
        }
    }
}
