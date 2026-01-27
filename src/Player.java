
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int gameswon;
    private String name;
    private final ArrayList<Card> hand = new ArrayList<>();


    public void setName() { //set player same 
        Scanner scan = new Scanner(System.in);
        this.name = scan.next();
    }

    public String getName() {
        return name;
    }

    public void drawCard(Deck deck) {
        // la carte que le joueur tire est ajouté à son hand
        hand.addLast(deck.drawCard());
    }

    // give the player his card back in case he play a wrong card
    public void giveCardBack(Card card) {
        hand.addLast(card);
    }

    public int getHandSize() {
        return hand.size();
    }

    public void displayHand() { // i added this method to display the player's hand in Demo.java (old comment)
        System.out.println("Player " + name + " has the following cards in hand:");
        int i = 1;
        for (Card card : hand) {

            System.out.println(i + "." + card);
            i++;
        }
    }

    public Card playCard() {
        int num;
        do {
            System.out.println("Choose your card: ");
            Scanner scan = new Scanner(System.in);
            num = scan.nextInt();
        } while (num <= 0 || num > hand.size());


        return hand.remove(num - 1);
    }

    public boolean CanPlayerPlay(Card topCard, Color currentColor) { //checks wether to make him draw or not
        for (Card card : hand) {
            if (card.canBePlayedOn(topCard, currentColor)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void sayUno() {
        if (hand.size() == 1) {
            System.out.println(name + " says UNO!");
            System.out.println("Other players should be careful!!");
        }
    }

      public Color Chosencolor(Game game){
        if( game.getcurrentColor()!=Color.BLACK){
            return game.getcurrentColor();
        }
        System.out.println("Choose a color: 1:Red 2:Yellow 3:Blue 4:Green");
        Scanner scan = new Scanner(System.in);
        int Choice = scan.nextInt();
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
                System.out.println("Invalid Choice, Try again.");

                Chosencolor(game);
                break;

        }
        return newcolor;
    }
    public int getgameswon(){
        return gameswon;
    }
    public void setgameswon(int gameswon){
        this.gameswon = gameswon;
    }
}




// add say uno when 1 card left(old comment)
