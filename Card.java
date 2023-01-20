import java.util.LinkedList;
import java.util.Collections;

public class Card implements Comparable<Card> {
    private Card() {};

    public enum CardNumber {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), 
		EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);

        private int ord;
        private CardNumber(int i){
            this.ord= i;
        }

        public int GetOrd(){
            return ord;
        }
    }

    public enum CardType{
        DIAMONDS, HEARTS, CLUBS, SPADES;
    }

    private CardNumber cardNumber;
    private CardType cardType;

    public CardNumber getCardNumber(){
        return cardNumber;
    }

    public CardType getCardType(){
        return cardType;
    }

    public static LinkedList<Card> getPack(){
        LinkedList<Card> cardList = new LinkedList<>();

        for (CardType type : CardType.values()){
            for (CardNumber num : CardNumber.values()){
                Card card = new Card();
                card.cardNumber = num;
                card.cardType = type;
                cardList.add(card);
            }
        }
        return cardList;
    }

    public static void Shuffler(LinkedList<Card> cards){
        Collections.shuffle(cards);
    }

    @Override 
    public String toString() {
        return cardNumber + "\nof\n" + cardType;
    }

    @Override
    public int compareTo(Card select){
        if (this.getCardNumber() == select.getCardNumber()){
            return 0;
        } else if (this.getCardNumber().GetOrd() > select.getCardNumber().GetOrd()){
            return 1;
        } else {
            return -1;
        }
    }

    public static int getDifference(Card played, Card cardInPlay){
        int playedCard = played.getCardNumber().GetOrd();
        int deckCard = cardInPlay.getCardNumber().GetOrd();

        if (playedCard == deckCard) {
            return 0;
        } else if (playedCard > deckCard){
            return playedCard - deckCard;
        } else {
            return deckCard - playedCard;
        }
    }

    public static boolean checkSuitMatch(Card played, Card cardInPlay){
        boolean isAMatch = false;
        if (played.getCardType() == cardInPlay.getCardType()){
            isAMatch = true;
        }
        return isAMatch;
    }
}

