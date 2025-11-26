import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Deck {

    private List<Card> cards;
    
    public Deck() {
        initDeck();    //we needed to call initDeck in the constructor to initialize the deck
    }


    public void initDeck() {
        this.cards = new ArrayList<>();        //we still need to add special cards in tp 3
        for (Color color : Color.values()) {
            
            if(color == Color.BLACK) {
                continue;
            }

            NumberCard numberCard_0 = new NumberCard(color, 0);
            this.cards.addLast(numberCard_0);
            
            for (int i = 1; i <= 9; i++) {
                NumberCard numberCard = new NumberCard(color, i);
                this.cards.addLast(numberCard);
                NumberCard secondNumberCard = new NumberCard(color, i);
                this.cards.addLast(secondNumberCard);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    };

    public Card drawCard() {
        return this.cards.removeFirst();
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public void refillDeckAndShuffle(List<Card> discardedCards) {
        this.cards.addAll(discardedCards);
        this.shuffle();
    }
        
}
