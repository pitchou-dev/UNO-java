
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private ArrayList<Card> hand = new ArrayList<>();

    public void setName() {
        Scanner scan = new Scanner(System.in);
        this.name = scan.next();
    }

    public String getName() {
        return name;
    }

    public void drawCard(Deck deck) {
        //la carte que le joueur tire est ajouté à son hand
        hand.addLast(deck.drawCard());
    }

    public int getHandSize() {
        return hand.size();
    }

    public void displayHand() {   //i added this method to display the player's hand in Demo.java
        System.out.println("Player " + name + " has the following cards in hand:");
        int i = 1;
        for (Card card : hand) {

            System.out.println(i + "." + card);
            i++;
        }
    }

    public Card playCard(int i) {
        System.out.println(name + " played: " + hand.get(i - 1));

        return hand.remove(i - 1);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void sayUno() {
        if (hand.size() == 1) {
            System.out.println(name + " says UNO!");
        }
    }
     /*  public boolean canPlayCard(Card topCard, Card cardToPlay) {
     return cardToPlay.getColor() == topCard.getColor() || cardToPlay.getValue() == topCard.getValue();
    }*/ 

}
//getter pour la main du joueur
//add say uno when 1 card left
//play card method and remove from hand
//compare card with top card method

