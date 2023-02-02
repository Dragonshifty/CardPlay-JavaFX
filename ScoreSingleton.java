public enum ScoreSingleton {
    INSTANCE;

    int compyScore;
    int playerScore;

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