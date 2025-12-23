
import java.util.List;

public class Game {

    private final Deck deck;
    private final List<Player> players;
    private final List<Card> discardPile;
    private int currentPlayerIndex = 0;
    private int direction = 1;// La direction initiale est de 1
    private Card topCard;
    private Color currentColor;
    private final int numPlayers;

    public Game(int numPlayers) {
        this.players = new java.util.ArrayList<>(numPlayers);
        for (int i = 0; i < numPlayers; i++) {
            players.add(null); // Initialiser avec des valeurs nulles
        }
        this.numPlayers = numPlayers;
        this.discardPile = new java.util.ArrayList<>();
        this.deck = new Deck();
        this.deck.shuffle();
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
        discardPile.removeLast(); // remove the top card from the discard pile
        deck.refillDeckAndShuffle(discardPile);
        discardPile.clear();
        discardPile.add(topCard); // add the top card to the discard pile again
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
        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Setting up Player " + (i + 1));
            System.out.print("choose player name: ");
            players.set(i, new Player());
            players.get(i).setName();
        }
        distributeCards();
        do { 
            //dans le cas rare (0,07% de chances) où la première carte est une carte wild, on en prend une autre du deck
            topCard = deck.drawCard();
            discardPile.add(topCard);
        } while (topCard instanceof Wildcard);
        currentColor = topCard.getColor();
    }

    private Card playerChoose(Player currentPlayer, Card topcard, Color currentColor) {
        Card playedCard = currentPlayer.playCard();
        if (!playedCard.canBePlayedOn(topcard, currentColor)) {
            System.out.println("You can't play with that card.");
            // give his card back:
            currentPlayer.giveCardBack(playedCard);
            currentPlayer.displayHand();
            return playerChoose(currentPlayer, topcard, currentColor);
        } else {
            return playedCard;
        }
    }

    public void play() {
        boolean gameOver = false;

        while (!gameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n--- Turn of " + currentPlayer.getName() + " ---");
            if (topCard instanceof Wildcard) {
                System.out.println("Current color is : " + currentColor);
            }
            System.out.println("Top card is : " + topCard);

            // si le joueur est humain les cartes s'afficheront sinon non (polymorphisme)
            currentPlayer.displayHand();

            Card playedCard = null;
            if (currentPlayer.CanPlayerPlay(topCard, currentColor)) {
                // si le joueur a une carte jouable alors il doit choisir une des cartes
                // jouables:
                playedCard = playerChoose(currentPlayer, topCard, currentColor);
            } else {
                // sinon il pioche une carte et si il peut jouer avec cette carte joue:
                System.out.println("You dont have any playable card, drawing one...");
                currentPlayer.drawCard(deck);
                if (deck.isEmpty()) {
                    discardtodraw(deck);
                }
                currentPlayer.displayHand();

                if (currentPlayer.CanPlayerPlay(topCard, currentColor)) {
                    playedCard = playerChoose(currentPlayer, topCard, currentColor);
                }
            }

            if (playedCard != null) {
                topCard = playedCard;
                discardPile.add(topCard);
                currentColor = topCard.getColor(); // important pour les wildcard

                // si la carte doit affecter le jeu on applique son effet:
                if (playedCard instanceof Actionable actionable) {
                    actionable.Applyeffect(this);
                }

                if (currentPlayer.getHand().isEmpty()) {
                    System.out.println("Congratulation! " + currentPlayer.getName() + ", won !");
                    gameOver = true;
                }

            } else {
                System.out.println(currentPlayer.getName() + " drawed a card.");
            }

            if (!gameOver) {
                nextPlayer();
            }
        }
    }

}
// say uno