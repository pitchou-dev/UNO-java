
public class Menu {

    java.util.Scanner scanner = new java.util.Scanner(System.in);
    private int getreplayChoice() {
        return scanner.nextInt();
    }
    private boolean botschosen;
    private int getUserChoice() {
        return scanner.nextInt();
    }
    

    public int NumberofPlayers() {
        System.out.println("Enter number of players (2-4): ");
        int numPlayers = this.getUserChoice();
        if (numPlayers < 2|| numPlayers > 4) {
            System.out.println("Invalid number of players. Please enter a number between 2 and 4.");
            this.NumberofPlayers();
        } else {
            System.out.println("You chose to play with " + numPlayers + " players.");
        }
        return numPlayers;
    }
    public void replayMenu() {
        System.out.println("do you want to play again?\n"
                + "1. Yes\n"
                + "2. No");
        int rpchoice = this.getreplayChoice();
        switch (rpchoice) {
            case 1:
                Menu menu = new Menu();
                menu.getUserChoice();
                break;
            case 2:
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                this.replayMenu();
                break;
        }
    }   
    public Menu() {
        System.out.println("============== UNO GAME ==============");
        System.out.println("The rules are simple: be the first to get rid of all your cards!");
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
                        this.botschosen = true;
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
                game.startGame(this.botschosen);
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
        while (true) {
            menu.replayMenu();
        }
    }
}
