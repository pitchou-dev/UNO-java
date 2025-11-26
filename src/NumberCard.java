public class NumberCard extends Card {
    private int value;

    public NumberCard(Color color, int value) {
        super(color);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}