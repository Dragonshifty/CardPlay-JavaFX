public class Score {
    private int playerScore;
    private int compyScore;

    // private static final Score score = new Score();
    // Singleton synchronized
    private static volatile Score score = null;
    private static final Object singleHolding = new Object();

    private Score(){}

    public static synchronized Score getScoreInstance(){
        if (score != null){
            return score;
        }
        synchronized (singleHolding){
            if (score == null){
                score = new Score();
            }
            return score;
        }
    }

    public void setPlayerScore(int score){
            this.playerScore += score;
    }

    public int getPlayerScore(){
        return playerScore;
    }

    public void setCompyScore(int score){
            this.compyScore += score;
    }

    public int getCompyScore(){
        return compyScore;
    }

    public void resetScores(){
        playerScore = 0;
        compyScore = 0;
    }
}