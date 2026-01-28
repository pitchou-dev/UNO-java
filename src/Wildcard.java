

public class Wildcard extends Card implements Actionable {

    private final Wildtype wildcard;
    public Wildcard(Wildtype wildcard) {
        super(Color.BLACK);
        this.wildcard = wildcard;

    }
  

    @Override
    public void Applyeffect(Game game) { //wild cards effects
       //for change color it is handled in the game class when played
        if (wildcard == Wildtype.DRAW_FOUR) { // 4 cards draw
            System.out.println("Next player draws four cards.");
            game.nextPlayer();
            for (int i = 0; i < 4; i++) {
                game.getPlayer(game.getcurrentPlayerIndex()).drawCard(game.getDeck());
            }
        }
    }

    @Override
    public boolean canBePlayedOn(Card topCard, Color currentColor) {
        return true; // always playable
    }

    @Override
    public String toString() {
        return "[" + wildcard + "]"; //again tostring redefinition for output purposes
    }

}
