

public class Wildcard extends Card implements Actionable {

    private final Wildtype wildcard;
    public Wildcard(Wildtype wildcard) {
        super(Color.BLACK);
        this.wildcard = wildcard;

    }
  

    @Override
    public void Applyeffect(Game game) {
        game.setcurrentColor(game.getPlayer(game.getcurrentPlayerIndex()).Chosencolor(game));
        if (wildcard == Wildtype.DRAW_FOUR) {
            System.out.println("Next player draws four cards.");
            game.nextPlayer();
            for (int i = 0; i < 4; i++) {
                game.getPlayer(game.getcurrentPlayerIndex()).drawCard(game.getDeck());
            }
        }
    }

    @Override
    public boolean canBePlayedOn(Card topCard, Color currentColor) {
        return true;
    }

    @Override
    public String toString() {
        return "[" + wildcard + "]";
    }

}
