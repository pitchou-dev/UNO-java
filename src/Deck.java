
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private List<Card> cards;

    public Deck() {
        initDeck(); // we needed to call initDeck in the constructor to initialize the deck
    }

    private void initDeck() {
        this.cards = new ArrayList<>(); //create array list of cards
        for (Color color : Color.values()) {  //loops for each color in the enum

            if (color == Color.BLACK) {  //black is special cards case
                for (int i = 0; i < 4; i++) { //makes 4 of each change color and draw four
                    Wildcard CHANGE_COLOR = new Wildcard(Wildtype.CHANGE_COLOR);
                    this.cards.addLast(CHANGE_COLOR); //each time this is seen means it adds to the deck

                    Wildcard DRAW_FOUR = new Wildcard(Wildtype.DRAW_FOUR);
                    this.cards.addLast(DRAW_FOUR);
                }
                continue; //when this ends it goes to the rest of the loop
            }

            NumberCard numberCard_0 = new NumberCard(color, 0); //creates only 1 0card for each color
            this.cards.addLast(numberCard_0); 

            for (int i = 1; i <= 9; i++) { //adds for each number 2 number cards 
                NumberCard numberCard = new NumberCard(color, i);
                this.cards.addLast(numberCard);
                NumberCard secondNumberCard = new NumberCard(color, i);
                this.cards.addLast(secondNumberCard);
            }
            for (int i = 0; i < 2; i++) { //adds for each color 2 of each action type
                Actioncard skipCard = new Actioncard(color, Actiontype.SKIP);
                this.cards.addLast(skipCard);

                Actioncard reverseCard = new Actioncard(color, Actiontype.REVERSE);
                this.cards.addLast(reverseCard);

                Actioncard drawTwoCard = new Actioncard(color, Actiontype.DRAW_TWO);
                this.cards.addLast(drawTwoCard);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards); //this randomly shuffles all the cards in a deck
    }

    ;

    public Card drawCard() {
        return this.cards.removeFirst(); 
    }

    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    public void refillDeckAndShuffle(List<Card> discardedCards) {
        this.cards.addAll(discardedCards); //refills deck with all the played previously cards
        this.shuffle(); // shuffles it again
    }
    public void reset(){  //for the game restart resets the deck fully
        cards.clear();
        initDeck();
        shuffle();
    }
}
