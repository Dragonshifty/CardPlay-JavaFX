import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Game {

    private LinkedList<Card> deck = new LinkedList<>();
    private List<Card> playerHand = new ArrayList<>();
    private List<Card> compyHand = new ArrayList<>();
    private LinkedList<Card> cardPile = new LinkedList<>();
    private Card cardPlayed;
    private Card cardInPlay;
    private int lastPlayerScore;
    private int lastCompyScore;

    Score score = Score.getScoreInstance();

    public void getNewDeck(){
        deck = Card.getPack();
    }

    public void getPlayerHand(){
        for (int i = 0; i < 5; i++){
            playerHand.add(deck.removeLast());
        }
        Collections.sort(playerHand);
    }

    public List<Card> getCurrentPlayerHand(){
        return playerHand;
    }

    public void getCompyHand(){
        for (int i = 0; i < 5; i++){
            compyHand.add(deck.removeLast());
        }
    }

    public List<Card> getCurrentCompyHand(){
        return compyHand;
    }

    public void getNewCard(String whoIsPlaying){
        if (whoIsPlaying == "Player" && deck.size() > 0){
            playerHand.add(deck.removeLast());
        } else if (whoIsPlaying == "Compy" && deck.size() > 0){
            compyHand.add(deck.removeLast());
        }
    }

    public int getPlayerTotal(){
        return score.getPlayerScore();
    }

    public int getCompyTotal(){
        return score.getCompyScore();
    }

    public int getDeckSize(){
        return deck.size();
    }

    public int playPlayerCard(int index){
        cardInPlay = cardPile.getFirst();
        cardPlayed = playerHand.get(index);
        cardPile.addFirst(playerHand.remove(index));
        getNewCard("Player");
        Collections.sort(playerHand);

        int HighLowDraw = cardPlayed.compareTo(cardInPlay);
        int difference = Card.getDifference(cardPlayed, cardInPlay);
        boolean isAMatch = Card.checkSuitMatch(cardPlayed, cardInPlay);

        // Score player
        switch(HighLowDraw){
            case 0:
                lastPlayerScore = 0;
                break;
            case 1:
                if (isAMatch){
                    difference *= 2;
                    lastPlayerScore = difference;
                    score.setPlayerScore(difference);
                } else {
                    lastPlayerScore = difference;
                    score.setPlayerScore(difference);
                }
                break;
            case -1:
                if (isAMatch){
                    lastPlayerScore = 0;
                } else {
                    score.setPlayerScore(-difference);
                    lastPlayerScore = -difference;
                }
                break;
        }
        cardInPlay = cardPile.getFirst();
        return lastPlayerScore;
    }

    public int playCompyCard(){
        //Get card in play from top of the card pile
        cardInPlay = cardPile.getFirst();

        // Compy turn
        Compy compy  = new Compy();
        compy.sortHand(compyHand);
        compy.getCardInPlay(cardInPlay);

        // Receive card played index and score
        int[] compyCardPlayed = compy.possibleScores();

        // Remove card played and add to top of card pile
        cardPile.addFirst(compyHand.remove(compyCardPlayed[0]));

        // Get new card from deck
        getNewCard("Compy");

        // Score compy
        score.setCompyScore(compyCardPlayed[1]);
        lastCompyScore = compyCardPlayed[2];
        cardInPlay = cardPile.getFirst();
        return lastCompyScore;
    }

    public void initialiseGame(){
        deck.clear();
        cardPile.clear();
        playerHand.clear();
        compyHand.clear();
        score.resetScores();
        
        getNewDeck();
        Card.Shuffler(deck);

        getPlayerHand();
        getCompyHand();
        cardPile.add(deck.removeLast());
        cardInPlay = cardPile.getFirst();
    }

    public Card getCardInPlay(){
        return cardInPlay;
    }


}
