
public class Actioncard extends Card implements Actionable {

    private final Actiontype action; 
    


    public Actioncard(Color color, Actiontype action) {
        super(color);
        this.action = action;

    }

    public Actiontype getaction() {
        return this.action;
    }

    @Override
    public void Applyeffect(Game game) { //for each action type its corresponding effect
        switch (action) {
            case SKIP -> {
                System.out.println("Next player's turn is skipped");
                game.nextPlayer();
                // On modifie l'index du prochain joueur en skippant un joueur
            }
            case REVERSE -> {
                System.out.println("Play direction is reversed");
                int newDirection = game.getdirection() * -1;
                game.setdirection(newDirection); // On modifie la direction du jeu
                
            }
            case DRAW_TWO -> {
                System.out.println("Next player draws two cards");
                game.nextPlayer();
                game.getPlayer(game.getcurrentPlayerIndex()).drawCard(game.getDeck());
                game.getPlayer(game.getcurrentPlayerIndex()).drawCard(game.getDeck());
                // On passe au prochain joueur et force deux fois la pioche
            }
            default -> {
            }
        }
    }

    @Override
    public boolean canBePlayedOn(Card topCard, Color currentColor) {
        // we check if it is the same color to allow the card to be played
        if (this.getColor() == currentColor) {
            return true; //same color as the current game color
        }
        if (topCard instanceof Actioncard topActionCard) {
            return this.action == topActionCard.action; //not same color but same action as topcard
        }
        return false; //none of the above so not playable on topcard
    }

    @Override
    public String toString() { //to string redefinition for input purposes
        return "[" + getaction() + "," + getColor() + "]";
    }
}
