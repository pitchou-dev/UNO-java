
public class NumberCard extends Card {

    private final int value;

    public NumberCard(Color color, int value) {
        super(color);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "[" + "" + getColor() + ", " + value + ']';
    }
    // we override toString to display card info because it was showing the object
    // reference by default

    @Override
    public boolean canBePlayedOn(Card topCard, Color currentColor) {
        // t9der tl3b ida nafs color
        if (this.getColor() == currentColor) {
            return true;
        }
        if (topCard instanceof NumberCard topNumberCard) {
            return this.value == topNumberCard.getValue();
        }
        return false;

    }
}
