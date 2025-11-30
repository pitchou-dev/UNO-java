public class Demo {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Player player1 = new Player();
        System.out.println("Enter player name: ");
        player1.setName();
        player1.drawCard(deck);
        System.out.println(player1.getName() + " has " + player1.getHandSize() + " card(s) in hand.");
        player1.displayHand();
        player1.drawCard(deck);
        player1.drawCard(deck);
        System.out.println(player1.getName() + " has " + player1.getHandSize() + " card(s) in hand.");
        player1.displayHand();
        player1.playCard(1);
        player1.displayHand();
    }  //the demo for tp 2 
}
