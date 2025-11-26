import java.util.LinkedList;
public class Player{

    private String name;
    private LinkedList<Card> hand = new LinkedList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void drawCard(Deck deck){
        //la carte que le joueur tire est ajouté à son hand
        hand.addLast(deck.drawCard());
    }
    
    public int getHandSize() {
        return hand.size();
    }

    public void displayHand() {   //i added this method to display the player's hand in Demo.java
        System.out.println("Player " + name + " has the following cards in hand:");
        for (Card card : hand) {
            System.out.println(card);
}
    }
}
                    //getter pour la main du joueur
                    //add say uno when 1 card left
                    //play card method


