
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private final ArrayList<Card> hand = new ArrayList<>();

    public void setName() {
        Scanner scan = new Scanner(System.in);
        this.name = scan.next();
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

    public void displayHand() { // i added this method to display the player's hand in Demo.java
        System.out.println("Player " + name + " has the following cards in hand:");
        int i = 1;
        for (Card card : hand) {

            System.out.println(i + "." + card);
            i++;
        }
    }

    public Card playCard() {
        int num;
        do {
            System.out.println("Choose your card: ");
            Scanner scan = new Scanner(System.in);
            num = scan.nextInt();
        } while (num <= 0 || num > hand.size());


        return hand.remove(num - 1);
    }

    public boolean CanPlayerPlay(Card topCard, Color currentColor) {
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
            System.out.println(name + " says UNO!");
        }
    }

}

// add say uno when 1 card left
