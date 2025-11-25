public class Menu {
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    private int getUserChoice() {
        return scanner.nextInt();
    }
    
    
    public Menu() {
        System.out.println("1. Start Game\n" +
                   "2. Exit");
        int choice = this.getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Starting the game...");
                // hnaya tbdaw l3b
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