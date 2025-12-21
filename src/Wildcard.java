
import java.util.Scanner;

public class Wildcard extends Card implements Actionable {

    private Wildtype wildcard;

    public Wildcard(Wildtype wildcard) {
        super(Color.BLACK);
        this.wildcard = wildcard;

    }
    public Wildtype  getWildcard(){
        return this.wildcard;
    }
    public Color Chosencolor() {
        System.out.println("Choose a color:1-Red,2-Yellow,3-Blue,4-Green");
        Scanner scan = new Scanner(System.in);
        int Choice = scan.nextInt();
        scan.close();
        Color newcolor;
        newcolor = Color.BLACK;

        switch (Choice) {
            case 1:
                newcolor = Color.RED;

                break;
            case 2:
                newcolor = Color.YELLOW;
                break;
            case 3:
                newcolor = Color.BLUE;
                break;
            case 4:
                newcolor = Color.GREEN;
                break;

            default:
                System.out.println("Invalid Choice, Try again");

                Chosencolor();
                break;

        }
        return newcolor;
    }

    @Override

    public void Applyeffect(Game game) {
        game.setcurrentColor(Chosencolor());
        if (wildcard == Wildtype.DRAW_FOUR) {
            System.out.println("Next player draws four cards");
            game.nextPlayer();
            for (int i = 0; i < 4; i++) {
                game.getPlayer(game.getcurrentPlayerIndex()).drawCard(game.getDeck());
            }
        }
    }
    @Override
    public boolean canBePlayedOn( Card topCard , Color currentColor) {
        return true;    
    }
     @Override
    public String toString() {
        return "[" +  getWildcard() + "]";
    } 

}
