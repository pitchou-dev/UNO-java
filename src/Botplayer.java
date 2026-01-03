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
        if (size <= 0) {
            throw new IllegalStateException("Bot has no cards to play");
        }
        return RAND.nextInt(size);
    }

    @Override
    public String getName() {
        return botName;
    }

    @Override
    public Card playCard() {
        int index = randomIndex(getHandSize());
        Card card = getHand().get(index);
        return getHand().remove(index);
    }

    @Override
    public void sayUno() {
        super.sayUno();
    }
    @Override
    public void displayHand() {
        // Bots do not display their hand
    }
    public static final Random RANDCOLOR = new Random();
    @Override
    public Color Chosencolor() {
        Color CurrentColor = Color.BLACK;
        while (Color.BLACK == CurrentColor) {
            int pick = RANDCOLOR.nextInt(Color.values().length);
            CurrentColor = Color.values()[pick];
        }
        return CurrentColor;
    }
}