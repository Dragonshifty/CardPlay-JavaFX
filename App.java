import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.geometry.*;
import javafx.concurrent.Task;
import javafx.scene.media.AudioClip;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {

    Button compyCardOne;
    Button compyCardTwo;
    Button compyCardThree;
    Button compyCardFour;
    Button compyCardFive;

    Button packLabel;
    Button cardPileLabel;

    Button newGameButton;

    Button playerCardOne;
    Button playerCardTwo;
    Button playerCardThree;
    Button playerCardFour;
    Button playerCardFive;

    Button compyTotalPoints;
    Button playerTotalPoints;
    Button compyPointsScored;
    Button playerPointsScored;

    AudioClip shuffleSound;
    AudioClip dealSound;
    AudioClip playerCardSound;
    AudioClip compyCardSound;
    AudioClip winSound;
    AudioClip loseSound;

    Game game = new Game();

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Set up main window
        window = primaryStage;
        window.setTitle("CardPlay");

        // Set Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        GridPane gridTop = new GridPane();
        gridTop.setAlignment(Pos.CENTER);
        GridPane gridLeft = new GridPane();
        gridLeft.setAlignment(Pos.CENTER);
        GridPane gridRight = new GridPane();
        gridRight.setAlignment(Pos.CENTER);
        GridPane gridBottom = new GridPane();
        gridBottom.setAlignment(Pos.CENTER);

        VBox vBoxLeft = new VBox();
        vBoxLeft.setAlignment(Pos.CENTER);

        VBox vBoxRight = new VBox();
        vBoxRight.setAlignment(Pos.CENTER);
        
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        gridTop.setPadding(new Insets(20, 10, 10, 10));
        gridTop.setVgap(10);
        gridTop.setHgap(10);

        gridBottom.setPadding(new Insets(10, 10, 20, 10));
        gridBottom.setVgap(10);
        gridBottom.setHgap(10);

        gridLeft.setPadding(new Insets(10, 10, 10, 10));
        gridLeft.setVgap(10);
        gridLeft.setHgap(10);

        gridRight.setPadding(new Insets(10, 10, 10, 10));
        gridRight.setVgap(10);
        gridRight.setHgap(10);

        
        // Set Buttons and Labels
        compyCardOne = new Button("Card\nOne");
        compyCardOne.setId("card");
        compyCardOne.setMinWidth(104);
        compyCardOne.setMinHeight(150);
        compyCardOne.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardOne, 0, 0);

        compyCardTwo = new Button("Card\nTwo");
        compyCardTwo.setId("card");
        compyCardTwo.setMinWidth(104);
        compyCardTwo.setMinHeight(150);
        compyCardTwo.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardTwo, 1, 0);

        compyCardThree = new Button("Card\nThree");
        compyCardThree.setId("card");
        compyCardThree.setMinWidth(104);
        compyCardThree.setMinHeight(150);
        compyCardThree.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardThree, 2, 0);

        compyCardFour = new Button("Card\nFour");
        compyCardFour.setId("card");
        compyCardFour.setMinWidth(104);
        compyCardFour.setMinHeight(150);
        compyCardFour.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardFour, 3, 0);

        compyCardFive = new Button("Card\nFive");
        compyCardFive.setId("card");
        compyCardFive.setMinWidth(104);
        compyCardFive.setMinHeight(150);
        compyCardFive.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardFive, 4, 0);

        packLabel = new Button("Cards:\n40");
        packLabel.setId("card");
        packLabel.setMinWidth(104);
        packLabel.setMinHeight(150);
        packLabel.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(packLabel, 0, 1);

        cardPileLabel = new Button("Ace\nSpades");
        cardPileLabel.setId("card");
        cardPileLabel.setMinWidth(104);
        cardPileLabel.setMinHeight(150);
        cardPileLabel.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(cardPileLabel, 1, 1);

        playerCardOne = new Button("Card\nOne");
        playerCardOne.setId("card");
        playerCardOne.setMinWidth(104);
        playerCardOne.setMinHeight(150);
        playerCardOne.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardOne, 0, 2);

        playerCardTwo = new Button("Card\nTwo");
        playerCardTwo.setId("card");
        playerCardTwo.setMinWidth(104);
        playerCardTwo.setMinHeight(150);
        playerCardTwo.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardTwo, 1, 2);

        playerCardThree = new Button("Card\nThree");
        playerCardThree.setId("card");
        playerCardThree.setMinWidth(104);
        playerCardThree.setMinHeight(150);
        playerCardThree.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardThree, 2, 2);
        GridPane.setHalignment(playerCardThree, HPos.CENTER);
        
        playerCardFour = new Button("Card\nFour");
        playerCardFour.setId("card");
        playerCardFour.setMinWidth(104);
        playerCardFour.setMinHeight(150);
        playerCardFour.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardFour, 3, 2);
        
        playerCardFive = new Button("Card\nFive");
        playerCardFive.setId("card");
        playerCardFive.setMinWidth(104);
        playerCardFive.setMinHeight(150);
        playerCardFive.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardFive, 4, 2);

        newGameButton = new Button("New Game");
        newGameButton.setId("newgame");
        newGameButton.setMinWidth(100);
        newGameButton.setTextAlignment(TextAlignment.CENTER);
        newGameButton.setId("scorelabel");
        GridPane.setConstraints(newGameButton, 0, 0);

        playerTotalPoints = new Button("0");
        playerTotalPoints.setId("scorelabel");
        playerTotalPoints.setMinWidth(100);
        playerTotalPoints.setTextAlignment(TextAlignment.CENTER);
        playerTotalPoints.setAlignment(Pos.BASELINE_CENTER);
        GridPane.setConstraints(playerTotalPoints, 0, 1);

        Label playerTotalLabel = new Label("Player Total");
        playerTotalLabel.setMinWidth(100);
        playerTotalLabel.setTextAlignment(TextAlignment.LEFT);
        GridPane.setConstraints(playerTotalLabel, 1, 1);

        playerPointsScored = new Button("0");
        playerPointsScored.setId("scorelabel");
        playerPointsScored.setMinWidth(100);
        playerPointsScored.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerPointsScored, 0, 2);

        Label playerLastPointsLabel = new Label("Last Points Scored");
        playerLastPointsLabel.setMinWidth(100);
        playerLastPointsLabel.setTextAlignment(TextAlignment.LEFT);
        GridPane.setConstraints(playerLastPointsLabel, 1, 2);

        Label compyTotalLabel = new Label("Computer Total");
        compyTotalLabel.setMinWidth(100);
        compyTotalLabel.setTextAlignment(TextAlignment.RIGHT);
        GridPane.setHalignment(compyTotalLabel, HPos.RIGHT);
        GridPane.setValignment(compyTotalLabel, VPos.CENTER);
        GridPane.setConstraints(compyTotalLabel, 0, 0);

        compyTotalPoints = new Button("0");
        compyTotalPoints.setId("scorelabel");
        compyTotalPoints.setMinWidth(100);
        compyTotalPoints.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyTotalPoints, 1, 0);

        Label compyLastPointsLabel = new Label("Last Points Scored");
        compyLastPointsLabel.setMinWidth(100);
        compyLastPointsLabel.setTextAlignment(TextAlignment.RIGHT);
        GridPane.setConstraints(compyLastPointsLabel, 0, 1);

        compyPointsScored = new Button("0");
        compyPointsScored.setId("scorelabel");
        compyPointsScored.setMinWidth(100);
        compyPointsScored.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyPointsScored, 1, 1);

        gridTop.getChildren().addAll(compyCardOne, compyCardTwo, compyCardThree, compyCardFour,
        compyCardFive);

        grid.getChildren().addAll(packLabel, cardPileLabel);

        gridBottom.getChildren().addAll(playerCardOne, playerCardTwo, playerCardThree,
        playerCardFour, playerCardFive);

        gridLeft.getChildren().addAll(newGameButton, playerTotalPoints, playerPointsScored, playerTotalLabel, playerLastPointsLabel);

        gridRight.getChildren().addAll(compyTotalPoints, compyPointsScored, compyTotalLabel, compyLastPointsLabel);
        
        // Load sounds
        try {
            dealSound = new AudioClip(getClass().getResource("/Resources/Audio/deal.mp3").toExternalForm());
            shuffleSound = new AudioClip(getClass().getResource("/Resources/Audio/shuffle.mp3").toExternalForm());
            playerCardSound = new AudioClip(getClass().getResource("/Resources/Audio/single.mp3").toExternalForm());
            compyCardSound = new AudioClip(getClass().getResource("/Resources/Audio/single2.mp3").toExternalForm());
            winSound = new AudioClip(getClass().getResource("/Resources/Audio/win.wav").toExternalForm());
            loseSound = new AudioClip(getClass().getResource("/Resources/Audio/lose.mp3").toExternalForm());
            } catch (Exception ex){
                ex.printStackTrace();
            }
        
        // Player action card lambdas
        playerCardOne.setOnAction(e -> {
            int cardScore = game.playPlayerCard(0);
            setCardInPlay();
            setPlayerHand();          
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
            
        });

        playerCardTwo.setOnAction(e -> {
            int cardScore = game.playPlayerCard(1);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        playerCardThree.setOnAction(e -> {
            int cardScore = game.playPlayerCard(2);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        playerCardFour.setOnAction(e -> {
            int cardScore = game.playPlayerCard(3);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        playerCardFive.setOnAction(e -> {
            int cardScore = game.playPlayerCard(4);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        newGameButton.setOnAction(e -> {
            startNewGame();
        });

        // Finalise GUI
        BorderPane pane = new BorderPane();
        pane.setTop(gridTop);
        pane.setCenter(grid);
        pane.setLeft(gridLeft);
        pane.setRight(gridRight);
        pane.setBottom(gridBottom);
        
        Scene scene = new Scene(pane, 1100, 650);
        scene.getStylesheets().add("/Resources/Style/Style.css"); 
        window.setScene(scene);
        window.show();

        // Start Initial Game
        startNewGame();
    }

    public void startNewGame(){
        disableCards(false);
        resetScores();
        game.initialiseGame();
        setCardInPlay();
        setPlayerHand();
        colourCompyCard();
        setRemainingCards();
        playShuffleSound();
        delay(1000, () -> playDealSound());        
    }

    public void showTotalPoints(){
        playerTotalPoints.setText("" + game.getPlayerTotal());
        compyTotalPoints.setText("" + game.getCompyTotal());
    }

    public void setCardInPlay(){
        cardPileLabel.setText("" + game.getCardInPlay());
    }

    public void setRemainingCards(){
        int packLeft = game.getDeckSize() -1;
        packLabel.setText("" + packLeft + "\nRemaining");
        if (packLeft == 0){
            gameOver();
        }
    }

    public void setPlayerHand(){
        List<Card> hand = new ArrayList<>();
        hand = game.getCurrentPlayerHand();
        playerCardOne.setText("" + hand.get(0));
        playerCardTwo.setText("" + hand.get(1));
        playerCardThree.setText("" + hand.get(2));
        playerCardFour.setText("" + hand.get(3));
        playerCardFive.setText("" + hand.get(4));
        colourCard();
    }

    public void playCompyCard(){
        int cardScore = game.playCompyCard();
        showTotalPoints();
        compyPointsScored.setText("" + cardScore);
        setCardInPlay();
        setRemainingCards();
        colourCard();
        playCompyCardSound();
        colourCompyCard();
    }

    public void disableCards(boolean toggle){
        playerCardOne.setDisable(toggle);
        playerCardTwo.setDisable(toggle);
        playerCardThree.setDisable(toggle);
        playerCardFour.setDisable(toggle);
        playerCardFive.setDisable(toggle);
    }

    public void gameOver(){
    disableCards(true);
    String message;
    if (game.getPlayerTotal() == game.getCompyTotal()){
        message = "Draw";
        playWinSound();
    } else if (game.getPlayerTotal() > game.getCompyTotal()){
        message = "You Win!";
        playWinSound();
    } else {
        message = "You Lose!";
        playLoseSound();
    }
    packLabel.setText("Game Over\n" + message);
    }

    public void resetScores(){
    compyPointsScored.setText("0");
    compyTotalPoints.setText("0");
    playerPointsScored.setText("0");
    playerTotalPoints.setText("0");
    }

    public void colourCard(){
        List<Card> hand = game.getCurrentPlayerHand();
        if (hand.get(0).getCardType() == Card.CardType.HEARTS | hand.get(0).getCardType() == Card.CardType.DIAMONDS){
                playerCardOne.setStyle("-fx-text-fill: red");
            } else {
                playerCardOne.setStyle("-fx-text-fill: black");
            }

        if (hand.get(1).getCardType() == Card.CardType.HEARTS | hand.get(1).getCardType() == Card.CardType.DIAMONDS){
                playerCardTwo.setStyle("-fx-text-fill: red");
            } else {
                playerCardTwo.setStyle("-fx-text-fill: black");
            }

        if (hand.get(2).getCardType() == Card.CardType.HEARTS | hand.get(2).getCardType() == Card.CardType.DIAMONDS){
                playerCardThree.setStyle("-fx-text-fill: red");
            } else {
                playerCardThree.setStyle("-fx-text-fill: black");
            }

        if (hand.get(3).getCardType() == Card.CardType.HEARTS | hand.get(3).getCardType() == Card.CardType.DIAMONDS){
                playerCardFour.setStyle("-fx-text-fill: red");
            } else {
                playerCardFour.setStyle("-fx-text-fill: black");
            }

        if (hand.get(4).getCardType() == Card.CardType.HEARTS | hand.get(4).getCardType() == Card.CardType.DIAMONDS){
                playerCardFive.setStyle("-fx-text-fill: red");
            } else {
                playerCardFive.setStyle("-fx-text-fill: black");
            }

        if (game.getCardInPlay().getCardType() == Card.CardType.HEARTS | game.getCardInPlay().getCardType() == Card.CardType.DIAMONDS){
                cardPileLabel.setStyle("-fx-text-fill: red");
            } else {
                cardPileLabel.setStyle("-fx-text-fill: black");
            }
    }

    public void colourCompyCard(){
        List<Card> hand = game.getCurrentCompyHand();
        if (hand.get(0).getCardType() == Card.CardType.HEARTS | hand.get(0).getCardType() == Card.CardType.DIAMONDS){
                compyCardOne.setStyle("-fx-text-fill: red");
            } else {
                compyCardOne.setStyle("-fx-text-fill: black");
            }

        if (hand.get(1).getCardType() == Card.CardType.HEARTS | hand.get(1).getCardType() == Card.CardType.DIAMONDS){
                compyCardTwo.setStyle("-fx-text-fill: red");
            } else {
                compyCardTwo.setStyle("-fx-text-fill: black");
            }

        if (hand.get(2).getCardType() == Card.CardType.HEARTS | hand.get(2).getCardType() == Card.CardType.DIAMONDS){
                compyCardThree.setStyle("-fx-text-fill: red");
            } else {
                compyCardThree.setStyle("-fx-text-fill: black");
            }

        if (hand.get(3).getCardType() == Card.CardType.HEARTS | hand.get(3).getCardType() == Card.CardType.DIAMONDS){
                compyCardFour.setStyle("-fx-text-fill: red");
            } else {
                compyCardFour.setStyle("-fx-text-fill: black");
            }

        if (hand.get(4).getCardType() == Card.CardType.HEARTS | hand.get(4).getCardType() == Card.CardType.DIAMONDS){
                compyCardFive.setStyle("-fx-text-fill: red");
            } else {
                compyCardFive.setStyle("-fx-text-fill: black");
            }
    }

    // Delay Method
    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    // Sound Methods
    void playShuffleSound(){
        try {
            shuffleSound.play();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

    void playDealSound(){
        try {
            dealSound.play();
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

    void playPlayerCardSound(){
        try {
            playerCardSound.play();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void playCompyCardSound(){
        try {
            compyCardSound.play();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void playWinSound(){
        try {
            winSound.play();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    void playLoseSound(){
        try {
            loseSound.play();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}


