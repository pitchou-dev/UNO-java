
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int gameswon;
    private String name;
    private final ArrayList<Card> hand = new ArrayList<>();
    private int score;
    private final Scanner scanner = new Scanner(System.in);


    public void setName() { //set player same 
        this.name = scanner.next();
    }

    public String getName() {
        return name;
    }

    public void drawCard(Deck deck) {
        // la carte que le joueur tire est ajouté à son hand
        hand.addLast(deck.drawCard());
    }

    // give the player his card back in case he play a wrong card
    public void giveCardBack(Card card) {
        hand.addLast(card);
    }

    public int getHandSize() {
        return hand.size();
    }

    public void displayHand() { // i added this method to display the player's hand in Demo.java (old comment)
        System.out.println("Player " + name + " has the following cards in hand:");
        int i = 1;
        for (Card card : hand) {

            System.out.println(i + "." + card);
            i++;
        }
    }

    public Card playCard() {
        System.out.println("Choose your card: ");
        try {
            int num = scanner.nextInt();
            if (num <= 0 || num > hand.size()) {
                System.out.println("Invalid choice. Try again.");
                return playCard();
            }
            return hand.remove(num - 1);
        } catch (InputMismatchException e) {
            scanner.nextLine(); // clear the buffer
            System.out.println("Please enter a valid number.");
            return playCard();
        }
    }

    public boolean CanPlayerPlay(Card topCard, Color currentColor) { //checks wether to make him draw or not
        for (Card card : hand) {
            if (card.canBePlayedOn(topCard, currentColor)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void sayUno() {
        if (hand.size() == 1) {
            System.out.println(getName() + " says UNO!");
            System.out.println("Other players should be careful!!");
        }
    }

      public Color Chosencolor(Game game){

        System.out.println("Choose a color: 1:Red 2:Yellow 3:Blue 4:Green");
        int Choice = scanner.nextInt();
        Color newcolor;
        newcolor = Color.BLACK;

        switch (Choice) { //converted switch to rule switch thus why the syntax seems different
            case 1 -> newcolor = Color.RED;
            case 2 -> newcolor = Color.YELLOW;
            case 3 -> newcolor = Color.BLUE;
            case 4 -> newcolor = Color.GREEN;

            default -> {
                System.out.println("Invalid Choice, Try again.");

                return Chosencolor(game);
            }

        }
        return newcolor;
    }
    public int getgameswon(){
        return gameswon;
    }
    public void setgameswon(int gameswon){
        this.gameswon = gameswon;
    }
    public int getScore() {
        return score;
    }
    public int setScore(int score) {
        this.score = score;
        return score;
    }
}




// add say uno when 1 card left(old comment)
