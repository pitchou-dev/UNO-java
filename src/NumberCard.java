public class NumberCard extends Card {
    private int value;

    public NumberCard(Color color, int value) {
        super(color);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "[" +"" + getColor() +", " + value +']';
}       // we override toString to display card info because it was showing the object reference by default
}