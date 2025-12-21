
public class Actioncard extends Card implements Actionable {

    private Actiontype action;

    public Actioncard(Color color, Actiontype action) {
        super(color);
        this.action = action;

    }

    public void ApplyEffect(Game game) {
        switch (action) {
            case SKIP:
                System.out.println("Next player's turn is skipped");
                game.nextPlayer();
                //On modifie l'index du prochain joueur en skippant un joueur

                break;
            case REVERSE:
                System.out.println("Play direction is reversed");
                int newDirection = game.getdirection() * -1;
                game.setdirection(newDirection); //On modifie la direction du jeu
                ;

                break;
            case DRAW_TWO:
                System.out.println("Next player draws two cards");
                game.nextPlayer();
                game.getPlayer(game.getcurrentPlayerIndex()).drawCard(game.getDeck());
                game.getPlayer(game.getcurrentPlayerIndex()).drawCard(game.getDeck());

                break;
            default:

        }
    }

    @Override
    public void Applyeffect(Game game) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public boolean canBePlayedOn( Card topCard , Color currentColor) {
        // t9der tl3b ida nafs color
        if (this.getColor() == currentColor) {
            return true;
        } 
        if (topCard instanceof Actioncard topActionCard) {
            return this.action == topActionCard.action;   
        }
        return false;

    }

}
