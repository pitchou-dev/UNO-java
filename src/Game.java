
import java.util.List;

public class Game {

    private Deck deck;
    private List<Player> players;
    private List<Card> discardPile;
    private int currentPlayerIndex = 0;
    private int direction = 1;//La direction initiale est de 1
    private Card topCard;
    private Color currentColor;
    private int numPlayers;

    public Game(int numPlayers) {
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
        for (int i = 0; i < numPlayers; i++) {
            players.set(i, new Player());
            players.get(i).setName();
        }
        distributeCards();
        topCard = deck.drawCard();
        discardPile.add(topCard);
        currentColor = topCard.getColor();
    }
    
    public void play() {
        boolean gameOver = false;

        while(!gameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n--- Turn of " + currentPlayer.getName() + " ---");
            System.out.println("Top card is : " + topCard);
            
            //si le joueur est humain les cartes s'afficheront sinon non (polymorphisme)
            currentPlayer.displayHand();

            Card playedCard = null;
            if (currentPlayer.CanPlayerPlay(topCard, currentColor)) {
                //si le joueur a une carte jouable alors il doit choisir une des cartes jouables:
                do {   
                    playedCard = currentPlayer.playCard();
                } while (!playedCard.canBePlayedOn(topCard, currentColor));
            } else {
                //sinon il pioche une carte et si il peut jouer avec cette carte joue:
                System.out.println("You dont have any playable card, drawing one..."); 
                currentPlayer.drawCard(deck);
                currentPlayer.displayHand();
                
                if(currentPlayer.CanPlayerPlay(topCard, currentColor)) {
                    do {   
                        playedCard = currentPlayer.playCard();
                    } while (!playedCard.canBePlayedOn(topCard, currentColor));
                }
            }

            if (playedCard != null) {
                topCard = playedCard;
                discardPile.add(topCard);
                currentColor = topCard.getColor(); //important pour les wildcard

                //si la carte doit affecter le jeu on applique son effet:
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


