import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Compy {
    private List<Card> compyHand = new ArrayList<>();
    private Card cardInPlay;

    public void sortHand(List<Card> compyHand){
        this.compyHand = compyHand;
        Collections.sort(compyHand);
    }

    public void getCardInPlay(Card cardInPlay){
        this.cardInPlay = cardInPlay;
    }

    public void showCompyHand(){
        System.out.println("Compy hand:\n");
        for (int i = 0; i < compyHand.size(); i++){
            System.out.println(compyHand.get(i));
        }
        System.out.println();
    }

    public int[] possibleScores(){
        // Return array with compy card played index and card score
        int[] returnInfo = new int[3];
        int[] scoreTemp = new int[5];
        int highLowDraw;
        int differenceScore = 0;
        boolean checkSuit = false;
        int index = 0;
        
        for (int i = 0; i < compyHand.size(); i++){
            highLowDraw = compyHand.get(i).compareTo(cardInPlay);
            switch (highLowDraw){
                case 0:
                    scoreTemp[i] = 0;
                    break;
                case 1:
                    differenceScore = Card.getDifference(compyHand.get(i), cardInPlay);
                    checkSuit = Card.checkSuitMatch(compyHand.get(i), cardInPlay);
                    if (checkSuit){
                        scoreTemp[i] = differenceScore * 2;
                    } else {
                        scoreTemp[i] = differenceScore;
                    }
                    break;
                case -1:
                    differenceScore = Card.getDifference(compyHand.get(i), cardInPlay);
                    checkSuit = Card.checkSuitMatch(compyHand.get(i), cardInPlay);
                    if (checkSuit){
                        scoreTemp[i] = 0;
                    } else {
                        scoreTemp[i] = -differenceScore;
                    }
                    break;
            }
        }
        int max = scoreTemp[0];
        for (int i = 0; i < scoreTemp.length; i++){
            if (max < scoreTemp[i]){
                max = scoreTemp[i];
                index = i;
            }
        }

        returnInfo[0] = index;
        returnInfo[1] = scoreTemp[index];
        returnInfo[2] = max;
        return returnInfo;
    }
}
