import java.util.*;
import java.util.stream.Collectors;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

public class PokerGame {

    public static final String PLAYER_2_WIN = "player2 win";
    public static final String PLAYER_1_WIN = "player1 win";
    public static final String TIE = "tie";
    public static final String SPECIAL_CARD_VALUE = "TJQKA";
    public static final int ORDINARY = 0;
    public static final int A_PAIR = 1;
    public static final int TWO_PAIR = 2;
    public static final int THREE_OF_A_KIND = 3;
    public static final int STRAIGHT = 4;
    public static final int FLUSH = 5;
    public static final int FULL_HOUSE = 6;
    public static final int FOUR_OF_A_KIND = 7;
    public static final int STRAIGHT_FLUSH = 8;

    public String compareCard(String card1, String card2) {
        if (getValue(card1.charAt(0)) < getValue(card2.charAt(0))) {
            return PLAYER_2_WIN;
        } else if (getValue(card1.charAt(0)) == getValue(card2.charAt(0))) {
            return TIE;
        } else {
            return PLAYER_1_WIN;
        }
    }

    public String compareDeckOFCard(String deckOFPlayer1, String deckOFPlayer2) {
        List<Card> deck1 = packagedToCard(deckOFPlayer1);
        List<Card> deck2 = packagedToCard(deckOFPlayer2);
        deck1 = deck1.stream()
                .sorted(Comparator.comparing(Card::getValue).reversed())
                .collect(Collectors.toList());
        deck2 = deck2.stream()
                .sorted(Comparator.comparing(Card::getValue).reversed())
                .collect(Collectors.toList());
        int deck1Type = getDeckType(deck1);
        int deck2Type = getDeckType(deck2);
        if (deck1Type == deck2Type) {
            return comPareValue(deck1, deck2, deck1Type);
        } else {
            return deck1Type > deck2Type ? PLAYER_1_WIN : PLAYER_2_WIN;
        }
    }

    private String comPareValue(List<Card> deck1, List<Card> deck2, int deck1Type) {
        String winer;
        int type = deck1Type;
        switch (type) {
            case 0:
                winer = compareHighCard(deck1, deck2);
                break;
            case 1:
            case 2:
                winer = comparePair(deck1, deck2);
                break;
            case 3:
                winer = compareThreeOfKind(deck1, deck2);
                break;
            case 6:
                winer = compareFullHouse(deck1, deck2);
                break;
            case 7:
                winer = compareFourOfKind(deck1, deck2);
                break;
            default:
                winer = compareHighCard(deck1, deck2);
        }
        return winer;
    }

    private String compareFullHouse(List<Card> deck1, List<Card> deck2) {
        int deck1PairValue = deck1.get(2).getValue();
        int deck2PairValue = deck2.get(2).getValue();

        return deck1PairValue > deck2PairValue ? PLAYER_1_WIN : PLAYER_2_WIN;
    }

    private String getResult(List<Card> deck1, List<Card> deck2, int deck1PairValue, int deck2PairValue) {
        if (deck1PairValue == deck2PairValue) {
            return compareHighCard(deck1, deck2);
        }
        return deck1PairValue > deck2PairValue ? PLAYER_1_WIN : PLAYER_2_WIN;
    }

    private String compareFourOfKind(List<Card> deck1, List<Card> deck2) {
        int deck1PairValue = 0;
        int deck2PairValue = 0;
        deck1PairValue = getFourOfKindValue(deck1);
        deck2PairValue = getFourOfKindValue(deck2);
        return getResult(deck1, deck2, deck1PairValue, deck2PairValue);
    }

    private int getFourOfKindValue(List<Card> deck1) {
        int deck1PairValue;
        if (deck1.get(0).getValue() == deck1.get(3).getValue()) {
            deck1PairValue = deck1.get(0).getValue();
        } else {
            deck1PairValue = deck1.get(1).getValue();
        }
        return deck1PairValue;
    }

    private String compareThreeOfKind(List<Card> deck1, List<Card> deck2) {
        int deck1PairValue = 0;
        int deck2PairValue = 0;
        deck1PairValue = getThreeOfKindValue(deck1, deck1PairValue);
        deck2PairValue = getThreeOfKindValue(deck2, deck2PairValue);
        return getResult(deck1, deck2, deck1PairValue, deck2PairValue);
    }

    private int getThreeOfKindValue(List<Card> deck1, int deck1PairValue) {
        for (int i = 0; i < deck1.size() - 2; i++) {
            if (deck1.get(i).getValue() == deck1.get(i + 1).getValue()
                    && deck1.get(i).getValue() == deck1.get(i + 2).getValue()) {
                deck1PairValue = deck1.get(i).getValue();
            }
        }
        return deck1PairValue;
    }

    private String comparePair(List<Card> deck1, List<Card> deck2) {
        int deck1PairValue = 0;
        int deck2PairValue = 0;
        deck1PairValue = getPairValue(deck1, deck1PairValue);
        deck2PairValue = getPairValue(deck2, deck2PairValue);
        return getResult(deck1, deck2, deck1PairValue, deck2PairValue);
    }

    private int getPairValue(List<Card> deck1, int deck1PairValue) {
        int tmp;
        for (int i = 0; i < deck1.size() - 1; i++) {
            if (deck1.get(i).getValue() == deck1.get(i + 1).getValue()) {
                tmp = deck1.get(i).getValue();
                if (tmp > deck1PairValue) {
                    deck1PairValue = tmp;
                }
            }
        }
        return deck1PairValue;
    }

    private String compareHighCard(List<Card> deck1, List<Card> deck2) {
        for (int i = 0; i < deck1.size(); i++) {
            if (deck1.get(i).getValue() > deck2.get(i).getValue()) {
                return PLAYER_1_WIN;
            } else if (deck1.get(i).getValue() < deck2.get(i).getValue()) {
                return PLAYER_2_WIN;
            }
        }
        return TIE;
    }

    private int getDeckType(List<Card> deck) {
        if (isFlush(deck)) {
            if (isStraight(deck)) {
                return STRAIGHT_FLUSH;
            }
            return FLUSH;
        }
        if (isStraight(deck)) {
            return STRAIGHT;
        }
        if (isThreeOfKind(deck)) {
            if (isFourOfKind(deck)) {
                return FOUR_OF_A_KIND;
            }
            if (isFullHouse(deck)) {
                return FULL_HOUSE;
            }
            return THREE_OF_A_KIND;
        }
        int pairCount = getPairCount(deck);
        if (pairCount == 3) {
            return TWO_PAIR;
        } else if (pairCount == 4) {
            return A_PAIR;
        } else {
            return ORDINARY;
        }
    }

    private int getPairCount(List<Card> deck) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < deck.size(); i++) {
            hashSet.add(deck.get(i).getValue());
        }
        return hashSet.size();
    }

    private boolean isFourOfKind(List<Card> deck) {
        if (deck.get(0).getValue() == deck.get(3).getValue() ||
                deck.get(1).getValue() == deck.get(4).getValue()) {
            return true;
        }
        return false;
    }

    private boolean isThreeOfKind(List<Card> deck) {
        for (int i = 0; i < deck.size() - 2; i++) {
            if (deck.get(i).getValue() == deck.get(i + 1).getValue()
                    && deck.get(i).getValue() == deck.get(i + 2).getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean isFullHouse(List<Card> deck) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < deck.size(); i++) {
            hashSet.add(deck.get(i).getValue());
        }
        return hashSet.size() == 2;
    }

    private boolean isFlush(List<Card> deck) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < deck.size(); i++) {
            hashSet.add(deck.get(i).getColor());
        }
        return hashSet.size() == 1;
    }

    private boolean isStraight(List<Card> deck) {
        if (deck.get(0).getValue() + deck.get(4).getValue() ==
                deck.get(1).getValue() + deck.get(3).getValue() &&
                deck.get(2).getValue() * 2 ==
                        deck.get(1).getValue() + deck.get(3).getValue() &&
                deck.get(2).getValue() == deck.get(0).getValue() - 2 &&
                deck.get(2).getValue() == deck.get(4).getValue() + 2
        ) {
            return true;
        }
        return false;
    }

    private List<Card> packagedToCard(String deckOfCard) {
        List<Card> deck = Arrays.asList(
                new Card(getValue(deckOfCard.charAt(0)), deckOfCard.substring(1, 2)),
                new Card(getValue(deckOfCard.charAt(3)), deckOfCard.substring(4, 5)),
                new Card(getValue(deckOfCard.charAt(6)), deckOfCard.substring(7, 8)),
                new Card(getValue(deckOfCard.charAt(9)), deckOfCard.substring(10, 11)),
                new Card(getValue(deckOfCard.charAt(12)), deckOfCard.substring(13, 14))
        );
        return deck;
    }

    private int getValue(char value) {
        for (int i = 1; i < SPECIAL_CARD_VALUE.length() + 1; i++) {
            if (value == SPECIAL_CARD_VALUE.charAt(i - 1)) {
                return 9 + i;
            }
        }
        return value - '0';
    }
}