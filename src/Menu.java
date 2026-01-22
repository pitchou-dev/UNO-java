
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private boolean botsChosen;


    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            scanner.next(); // discard invalid input
            System.out.println("Please enter a number.");
        }
        return scanner.nextInt();
    }


    public void start() {
        System.out.println("============== UNO GAME ==============");
        System.out.println("The rules are simple: be the first to get rid of all your cards!");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                setupGame();
                break;
            case 2:
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
                start();
        }
    }

    private void setupGame() {
        System.out.println("Do you want to play with bots?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choiceBots = getUserChoice();
        botsChosen = (choiceBots == 1);

        int players = numberOfPlayers();

        System.out.println("Starting the game...");
        Game game = new Game(players);
        game.startGame(botsChosen);
        game.play();
    }


    private int numberOfPlayers() {
        System.out.println("Enter number of players (2-4): ");
        int numPlayers = getUserChoice();

        if (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Invalid number. Try again.");
            return numberOfPlayers(); // recursion
        }

        System.out.println("You chose " + numPlayers + " players.");
        return numPlayers;
    }


    private boolean replayMenu() {
        System.out.println("Do you want to play again?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int choice = getUserChoice();
        return choice == 1;
    }


    public static void main(String[] args) {
        Menu menu = new Menu();

        do {
            menu.start();
        } while (menu.replayMenu());

        System.out.println("Exiting the game. Goodbye!");
    }
}
// fast game uno mod addition 
// uno H2O mode
