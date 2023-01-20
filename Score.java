public class Score {
    private int playerScore;
    private int compyScore;

    private Score(){}

    private static final Score score = new Score();

    public static Score getScoreInstance(){
        return score;
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