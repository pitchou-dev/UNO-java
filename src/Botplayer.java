import java.util.Random;

public class Botplayer extends Player {

    private static int numberOfBots = 0;
    private String botName;
    private int i = random(0, super.getHandSize() - 1);

    public int random(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    @Override
    public void setName() {
        numberOfBots++;
        botName = "BotPlayer" + numberOfBots;
    }

    @Override
    public String getName() {
        return botName;
    }

    @Override
    public Card playCard() {
        System.out.println(getName() + " played: " + getHand().get(i));
        return getHand().remove(i);
    }

    @Override
    public void sayUno() {
        super.sayUno();
    }

}
