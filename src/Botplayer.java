import java.util.Random;
import java.util.ArrayList;

public class Botplayer extends Player {
    private int i=random(0,7);
    public int random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
    @Override
    public void setName() {
        int y = 0;
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
    
    
}
