
abstract public class Card {

    private Color color;

    public Card(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
    
    public abstract boolean canBePlayedOn(Card topCard);
}
