package chess;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        while (true) {
            String command = sc.nextLine();
            if (command.equals("start")) {
                board.initialize();
                board.print();
            }
            if (command.equals("end")) {
                break;
            }
        }
    }
}
