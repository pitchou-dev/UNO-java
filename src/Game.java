
import java.util.List;

public class Game {
    private Deck deck;
    private List<Player> players;
    private List<Card> discardPile;
    private int currentPlayerIndex;
    private int direction;
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
}