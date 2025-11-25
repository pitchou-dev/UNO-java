import java.util.LinkedList;
public class Player{

private String name;
LinkedList<Card> hand = new LinkedList<Card>();

public void setName(String name) {
    this.name = name;
}

public String getName() {
    return name;
}

public void drawCard(deck Deck){
    Card card = Deck.draw();
}
 
  public int getHand() {
    return handsize.size();
}


}




