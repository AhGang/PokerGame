public class Card {
    private String color;
    private int value;

    public Card(int value, String color) {
        this.color = color;
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public int compare(Card card) {
        if (this.value > card.value) {
            return 1;
        } else if (this.value < card.value) {
            return -1;
        } else {
            return 0;
        }
    }
}
