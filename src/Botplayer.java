import java.util.ArrayList;
import java.util.Random;

public class Botplayer extends Player {
    private int i=random(0, super.getHandSize()-1);
    public int random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    @Override
    public void setName() {
        int y = 0;
        y++;
        String botName = "BotPlayer" + y; 
    }
    public void drawCard(Deck deck) {
        super.drawCard(deck);
    }
    public Card playCard() {
        System.out.println(getName() + " played: " + getHand().get(i));
        return getHand().remove(i);
    }
    public void sayUno() {
        super.sayUno();
    }
    public int getHandSize() {
        return super.getHandSize();
    }
    public void displayHand() {
        super.displayHand();
    }
    public ArrayList<Card> getHand() {
        return super.getHand();
    }
    public boolean CanPlayerPlay(Card topCard, Color currentColor) {
        return super.CanPlayerPlay(topCard, currentColor);
    }
    

    
    
    
}
