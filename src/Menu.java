
public class Menu {

    java.util.Scanner scanner = new java.util.Scanner(System.in);

    private int getUserChoice() {
        return scanner.nextInt();
    }

    public int NumberofPlayers() {
        System.out.println("Enter number of players (2-4): ");
        int numPlayers = this.getUserChoice();
        if (numPlayers < 2 || numPlayers > 4) {
            System.out.println("Invalid number of players. Please enter a number between 2 and 4.");
            this.NumberofPlayers();
        } else {
            System.out.println("You chose to play with " + numPlayers + " players.");
        }
        return numPlayers;
    }

    public Menu() {
        System.out.println("1. Start Game\n"
                + "2. Exit");
        int choice = this.getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Do you want to play with bots?\n"
                        + "1. Yes\n"
                        + "2. No");
                int choiceBotsorNot = this.getUserChoice();
                switch (choiceBotsorNot) {
                    case 1:
                        System.out.println("You chose to play with bots.");
                        int x = this.NumberofPlayers();
                        Game gameWithBots = new Game(x);
                        gameWithBots.startGame();
                        gameWithBots.play();
                        break;
                    case 2:
                        System.out.println("You chose to play without bots.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        this.getUserChoice();
                        break;
                }
                System.out.println("Starting the game...");
                int x = this.NumberofPlayers();
                Game game = new Game(x);
                game.startGame();
                game.play();
                break;
            case 2:
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                this.getUserChoice();
                break;
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.getUserChoice();

    }
}
