public class Demo {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Player player1 = new Player();
        player1.setName("Ahmed");
        player1.drawCard(deck);
        System.out.println(player1.getName() + " has " + player1.getHandSize() + " card(s) in hand.");
        player1.displayHand();
        player1.drawCard(deck);
        player1.drawCard(deck);
        System.out.println(player1.getName() + " has " + player1.getHandSize() + " card(s) in hand.");
        player1.displayHand();
    }  //the demo for tp 2 
}
