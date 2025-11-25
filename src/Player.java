import java.util.LinkedList;
public class Player{

    private String name;
    LinkedList<Card> hand = new LinkedList<>();

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
    
    public int getHand() {
        return hand.size();
    }

}




