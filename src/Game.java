
import java.util.List;

public class Game {

    private Deck deck;
    private List<Player> players;
    private List<Card> discardPile;
    private int currentPlayerIndex;
    private int direction = 1;//La direction initiale est de 1
    private Card topCard;
    private Color currentColor;
    private int numPlayers;

    public void Game(int numPlayers) {
        this.numPlayers = numPlayers;
        this.deck = new Deck();
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + direction + numPlayers) % numPlayers;

    }

    public int getcurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Player getPlayer(int currentPlayerIndex) {
        return players.get(currentPlayerIndex);
    }

    public int getdirection() {
        return direction;
    }

    public void setdirection(int direction) {
        this.direction = direction;
    }

    public int getnumPlayers() {
        return numPlayers;
    }

    public Color getcurrentColor() {
        return currentColor;
    }

    public void discardtodraw(Deck deck) {
        topCard = discardPile.remove(discardPile.size() - 1);
        deck.refillDeckAndShuffle(discardPile);
        discardPile.clear();
        discardPile.add(topCard);
    }

    public void distributeCards() {
        for (Player player : players) {
            for (int i = 0; i < 7; i++) {
                player.drawCard(deck);
            }
        }
    }

    public void setcurrentColor(Color color) {
        this.currentColor = color;
    }

    public Deck getDeck() {
        return deck;
    }

    public void startGame() {
        distributeCards();
        topCard = deck.drawCard();
        discardPile.add(topCard);
        currentColor = topCard.getColor();
    }

}
//is playable interface 
//fix deck to add other cards

