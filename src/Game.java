
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

    public void resetGame() {
            
        discardPile.clear();

        for (Player p : players) {
            p.getHand().clear();   // vider les mains
        }

        currentPlayerIndex = 0;
        direction = 1;

        Deck newDeck = new Deck();
        newDeck.shuffle();

        this.deck.refillDeckAndShuffle(discardPile);
        
        distributeCards();

        do {
            topCard = deck.drawCard();
            discardPile.add(topCard);
        } while (topCard instanceof Wildcard);

        currentColor = topCard.getColor();
    }


    public void winresults(){// celui ci affiche les victoires uniquement pour les humains
        for (Player p : players){
    
            System.out.println("player "+p.getName()+"'s stats are:");
            System.out.println("Wins: "+p.getgameswon());
        }
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + direction + numPlayers) % numPlayers;
    }

    public int getcurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public Player getPlayer(int currentPlayerIndex1) {
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

    private void discardtodraw(Deck deck) {
        discardPile.removeLast(); // remove the top card from the discard pile
        deck.refillDeckAndShuffle(discardPile);
        discardPile.clear();
        discardPile.add(topCard); // add the top card to the discard pile again
    }

    private void distributeCards() {
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
   
    public void startGame(boolean botsChosen) {

        players.clear();

        if (botsChosen) {
            System.out.println("Setting up bot players...");

            // numPlayers - 1 bots
            for (int i = 0; i < numPlayers - 1; i++) {
                players.add(new Botplayer());
            }

            // 1 human player
            System.out.println("Setting up the human player.");
            System.out.print("Choose player name: ");
            Player humanPlayer = new Player();
            humanPlayer.setName();
            players.add(humanPlayer);

        } else {
            // all human players
            for (int i = 0; i < numPlayers; i++) {
                System.out.println("Setting up Player " + (i + 1)+ "...");
                System.out.print("Choose player name: ");
                Player player = new Player();
                player.setName();
                players.add(player);
            }
        }

        distributeCards();

        do {
            topCard = deck.drawCard();
            discardPile.add(topCard);
        } while (topCard instanceof Wildcard);

        if (topCard instanceof Wildcard) {
            currentColor = players.get(currentPlayerIndex).Chosencolor(this);
        } else {
            currentColor = topCard.getColor();
        }
    }

    private Card playerChoose(Player currentPlayer, Card topcard, Color currentColor) {
        Card playedCard = currentPlayer.playCard();
        if (!playedCard.canBePlayedOn(topcard, currentColor)) {
            if (!(currentPlayer instanceof Botplayer)) {
                System.out.println("You can't play with that card.");
            }
            // give his card back:
            currentPlayer.giveCardBack(playedCard);
            currentPlayer.displayHand();
            return playerChoose(currentPlayer, topcard, currentColor);
        } else {
            System.out.print(currentPlayer.getName() + " has " + currentPlayer.getHandSize() + " cards left. " + "\n");
            return playedCard;
        }
    }

    public void play() {
        boolean gameOver = false;

        while (!gameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n============ Turn of " + currentPlayer.getName() + " ============");
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
                System.out.println(currentPlayer.getName() + " played: " + playedCard);
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
                    System.out.println(currentPlayer.getName() + " played: " + playedCard);
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
            
                
                // si il reste une seule carte seulement afficher "say uno!"
                currentPlayer.sayUno();

                if (currentPlayer.getHand().isEmpty()) {
                    System.out.println("Congratulation! " + currentPlayer.getName() + ", won !");
                    currentPlayer.setgameswon(currentPlayer.getgameswon()+1);
                    winresults();
                    System.out.println("Game Over!.");

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
