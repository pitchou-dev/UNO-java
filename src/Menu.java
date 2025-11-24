public class Menu {
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    public int getUserChoice() {
        return scanner.nextInt();
    }
    
    
    public Menu() {
        System.out.println("1. Start Game\n" +
                   "2. Exit");
        int choice = this.getUserChoice();
        if (choice == 1) {
            System.out.println("Starting the game...");
            // hnaya tbdaw l3b
        } else if (choice == 2) {
            System.out.println("Exiting the game. Goodbye!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice. Please try again.");
            this.getUserChoice();
        }
    }
    
    
    public static void main(String[] args) {
        new Menu();
    }
}