import org.junit.Assert;
import org.junit.Test;

public class PokerGameTests {
    @Test
    public void testHighCard_givenTowCards_thenReturnPlayer2Win(){
        //given
        String card1 = "2C";
        String card2 = "3S";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareCard(card1,card2);
        //then
        Assert.assertEquals("player2 win",result);
    }
    @Test
    public void testHighCardWithKAndJ_givenTowCards_thenReturnPlayer2Win(){
        //given
        String card1 = "TC";
        String card2 = "JS";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareCard(card1,card2);
        //then
        Assert.assertEquals("player2 win",result);
    }
    @Test
    public void testHighCard_givenTowCards_thenReturnTie(){
        //given
        String card1 = "2C";
        String card2 = "2S";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareCard(card1,card2);
        //then
        Assert.assertEquals("tie",result);
    }
    @Test
    public void testHighCard_givenTowCards_thenReturnPlayer1Win(){
        //given
        String card1 = "3C";
        String card2 = "2S";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareCard(card1,card2);
        //then
        Assert.assertEquals("player1 win",result);
    }
    @Test
    public void  testHighCard_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "2H 3C 8H 7S 9C";
        String deckOFPlayer2 = "5C 8H 2S 3D 4H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);
    }
    @Test
    public void  testHighCardWithKAndA_givenTwoDeckOfCards_thenReturnPlayer2Win(){
        //given
        String deckOFPlayer1 = "2H 3C KH 7S 9C";
        String deckOFPlayer2 = "5C AH 2S 3D 4H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player2 win",result);
    }
    @Test
    public void testOneHavePair_givenTwoDeckOfCards_thenReturnPlayer2Win(){
        //given
        String deckOFPlayer1 = "2H 3C 8H 7S 9C";
        String deckOFPlayer2 = "2C 8H 2S 3D 4H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player2 win",result);

    }
    @Test
    public void testBothHavePair_givenTwoDeckOfCards_thenReturnPlayer2Win(){
        //given
        String deckOFPlayer1 = "4H 3C 4H 7S 9C";
        String deckOFPlayer2 = "6C 8H 6S 3D 4H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player2 win",result);

    }
    @Test
    public void testOneHaveTwoPair_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "2H 2C 4H 4S 9C";
        String deckOFPlayer2 = "5C 8H 5S 3D 4C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testBothHaveTwoPair_givenTwoDeckOfCards_thenReturnPlayer2Win(){
        //given
        String deckOFPlayer1 = "2H 2C 4H 4S 9C";
        String deckOFPlayer2 = "5C 3H 5S 3D 4C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player2 win",result);

    }
    @Test
    public void testOneHaveThreeOFAKind_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "5C 5H 5S 3D 4C";
        String deckOFPlayer2 = "2H 2C 4H 4S 9C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testBothHaveThreeOFAKind_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "5C 5H 5S 3D 4C";
        String deckOFPlayer2 = "2H 2C 2H 4S 9C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testOneHaveStraight_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "2C 3H 4S 5D 6C";
        String deckOFPlayer2 = "7C 7H 7S 3D 4C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testBothHaveStraight_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "3C 4H 5S 6D 7C";
        String deckOFPlayer2 = "2C 3H 4S 5D 6C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testOneHaveFlush_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "4C 3C 2C 5C 7C";
        String deckOFPlayer2 = "5H 6H 7S 8D 9C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testBothHaveFlush_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "4C 3C 2C 5C 7C";
        String deckOFPlayer2 = "4S 3S 2S 5S 7S";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("tie",result);

    }
    @Test
    public void testOneHaveFullHouse_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "2H 2D 2S 3C 3H";
        String deckOFPlayer2 = "4C 3C 2C 5C 7C";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testBothHaveFullHouse_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "4H 4D 4S 3C 3H";
        String deckOFPlayer2 = "2H 2D 2S 5C 5H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);

    }
    @Test
    public void testOneHaveFourOFAKind_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "2H 2D 2S 2C 3H";
        String deckOFPlayer2 = "4H 4D 5S 4C 5H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);
    }
    @Test
    public void testBothHaveFourOFAKind_givenTwoDeckOfCards_thenReturnPlayer2Win(){
        //given
        String deckOFPlayer1 = "2H 2D 2S 2C 5H";
        String deckOFPlayer2 = "4H 4D 4S 4C 3H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player2 win",result);
    }
    @Test
    public void testOneHaveStraightFlush_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "3H 4H 5H 6H 7H";
        String deckOFPlayer2 = "9H 9D 9S 9C 3H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player1 win",result);
    }
    @Test
    public void testBothHaveStraightFlush_givenTwoDeckOfCards_thenReturnPlayer1Win(){
        //given
        String deckOFPlayer1 = "3H 4H 5H 6H 7H";
        String deckOFPlayer2 = "8H 4H 5H 6H 7H";
        //when
        PokerGame pokerGame = new PokerGame();
        String result= pokerGame.compareDeckOFCard(deckOFPlayer1,deckOFPlayer2);
        //then
        Assert.assertEquals("player2 win",result);
    }
    }
