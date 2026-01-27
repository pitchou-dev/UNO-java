import java.util.Random;

public class Botplayer extends Player {

    private static int numberOfBots = 0;
    private final String botName;
    private static final Random RAND = new Random();

    public Botplayer() {
        numberOfBots++;
        this.botName = "BotPlayer" + numberOfBots;
    }

    private int randomIndex(int size) {

        return RAND.nextInt(size); //initiating the random index choice in the hand of the bot
    }

    @Override
    public String getName() {
        return botName;
    }

    @Override
    public Card playCard() {
        int index = randomIndex(getHandSize()); //chooses a random index between 0 and handsize
        return getHand().remove(index); //card to be played and removed
    }

    @Override
    public void sayUno() {
         if (getHandSize() == 1) {
            System.out.println(botName + " says UNO!");
        }
    }
    @Override
    public void displayHand() {
        // Bots do not display their hand
    }
    public static final Random RANDCOLOR = new Random();
    @Override
    public Color Chosencolor(Game game) {
        Color CurrentColor = Color.BLACK;
        while (Color.BLACK == CurrentColor) {
            int pick = RANDCOLOR.nextInt(Color.values().length);
            CurrentColor = Color.values()[pick];
        }
        return CurrentColor;
    }
}
/* 
 Example of using a timer to simulate thinking time
    Timer chrono = new Timer();
    chrono.schedule(new TimerTask() {
        @Override
        public void run() {
            System.out.println("The bot is thinking...");
            return
            ;
        }
    }, 1000);
    */ 
   // timer prototype li 3ambalo kifech ydirha ya3lemna