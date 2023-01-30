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

    List<Button> compyButtons = new ArrayList<>();

    Button packLabel;
    Button cardPileLabel;
    Button newGameButton;

    Button playerCardOne;
    Button playerCardTwo;
    Button playerCardThree;
    Button playerCardFour;
    Button playerCardFive;

    List<Button> playerButtons = new ArrayList<>();

    Button compyTotalPoints;
    Button playerTotalPoints;
    Button compyPointsScored;
    Button playerPointsScored;

    List<Button> scoreButtons = new ArrayList<>();

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
        // Initialise computer buttons
        compyCardOne = new Button("Card\nOne");
        GridPane.setConstraints(compyCardOne, 0, 0);

        compyCardTwo = new Button("Card\nTwo");
        GridPane.setConstraints(compyCardTwo, 1, 0);

        compyCardThree = new Button("Card\nThree");
        GridPane.setConstraints(compyCardThree, 2, 0);

        compyCardFour = new Button("Card\nFour");
        GridPane.setConstraints(compyCardFour, 3, 0);

        compyCardFive = new Button("Card\nFive");
        GridPane.setConstraints(compyCardFive, 4, 0);

        // Add compyButtons to List and set shared attributes
        compyButtons.add(compyCardOne);
        compyButtons.add(compyCardTwo);
        compyButtons.add(compyCardThree);
        compyButtons.add(compyCardFour);
        compyButtons.add(compyCardFive);

        for (Button button : compyButtons){
            button.setId("card");
            button.setMinWidth(104);
            button.setMinHeight(150);
            button.setTextAlignment(TextAlignment.CENTER);
        }

        // Initialise pack buttons
        packLabel = new Button("Cards:\n40");
        GridPane.setConstraints(packLabel, 0, 1);

        cardPileLabel = new Button("Ace\nSpades");
        GridPane.setConstraints(cardPileLabel, 1, 1);

        // Add packButtons to List and set shared attributes
        List<Button> packButtons = new ArrayList<>();
        packButtons.add(packLabel);
        packButtons.add(cardPileLabel);

        for (Button button : packButtons){
            button.setId("card");
            button.setMinWidth(104);
            button.setMinHeight(150);
            button.setTextAlignment(TextAlignment.CENTER);
        }

        // Initialise player buttons
        playerCardOne = new Button("Card\nOne");
        GridPane.setConstraints(playerCardOne, 0, 2);

        playerCardTwo = new Button("Card\nTwo");
        GridPane.setConstraints(playerCardTwo, 1, 2);

        playerCardThree = new Button("Card\nThree");
        GridPane.setConstraints(playerCardThree, 2, 2);
        
        playerCardFour = new Button("Card\nFour");
        GridPane.setConstraints(playerCardFour, 3, 2);
        
        playerCardFive = new Button("Card\nFive");
        GridPane.setConstraints(playerCardFive, 4, 2);

        // Add playerButtons to List and set shared attributes
        playerButtons.add(playerCardOne);
        playerButtons.add(playerCardTwo);
        playerButtons.add(playerCardThree);
        playerButtons.add(playerCardFour);
        playerButtons.add(playerCardFive);

        for (Button button : playerButtons){
            button.setId("card");
            button.setMinWidth(104);
            button.setMinHeight(150);
            button.setTextAlignment(TextAlignment.CENTER);
        }

        // Initialise new game and score buttons, and labels
        newGameButton = new Button("New Game");
        GridPane.setConstraints(newGameButton, 0, 0);

        playerTotalPoints = new Button("0");
        GridPane.setConstraints(playerTotalPoints, 0, 1);

        Label playerTotalLabel = new Label("Player Total");
        playerTotalLabel.setMinWidth(100);
        playerTotalLabel.setTextAlignment(TextAlignment.LEFT);
        GridPane.setConstraints(playerTotalLabel, 1, 1);

        playerPointsScored = new Button("0");
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
        GridPane.setConstraints(compyTotalPoints, 1, 0);

        Label compyLastPointsLabel = new Label("Last Points Scored");
        compyLastPointsLabel.setMinWidth(100);
        compyLastPointsLabel.setTextAlignment(TextAlignment.RIGHT);
        GridPane.setConstraints(compyLastPointsLabel, 0, 1);

        compyPointsScored = new Button("0");
        GridPane.setConstraints(compyPointsScored, 1, 1);

        // Add scoreButtons to List and set shared attributes
        scoreButtons.add(newGameButton);
        scoreButtons.add(playerTotalPoints);
        scoreButtons.add(playerPointsScored);
        scoreButtons.add(compyTotalPoints);
        scoreButtons.add(compyPointsScored);

        for (Button button : scoreButtons){
            button.setId("scorelabel");
            button.setMinWidth(100);
            button.setTextAlignment(TextAlignment.CENTER);
        }

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
            disableCards(true);
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        playerCardTwo.setOnAction(e -> {
            int cardScore = game.playPlayerCard(1);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            disableCards(true);
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        playerCardThree.setOnAction(e -> {
            int cardScore = game.playPlayerCard(2);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            disableCards(true);
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        playerCardFour.setOnAction(e -> {
            int cardScore = game.playPlayerCard(3);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            disableCards(true);
            playerPointsScored.setText("" + cardScore);
            playPlayerCardSound();
            delay(1500, () -> playCompyCard());
        });

        playerCardFive.setOnAction(e -> {
            int cardScore = game.playPlayerCard(4);
            setCardInPlay();
            setPlayerHand();
            showTotalPoints();
            disableCards(true);
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
        
        int index = 0;
        for (Button button : playerButtons){
            button.setText("" + hand.get(index));
            index++;
        }
        colourCard();
    }

    public void playCompyCard(){
        int cardScore = game.playCompyCard();
        showTotalPoints();
        compyPointsScored.setText("" + cardScore);
        setCardInPlay();
        disableCards(false);
        setRemainingCards();
        colourCard();
        playCompyCardSound();
        colourCompyCard();
    }

    public void disableCards(boolean toggle){
        for (Button button : playerButtons){
            button.setDisable(toggle);
        }
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
        for (Button button : scoreButtons){
            if (button != newGameButton){
                button.setText("0");
            }
        }
    }

    public void colourCard(){
        List<Card> hand = game.getCurrentPlayerHand();
        int index = 0;

        for (Button button : playerButtons){
            if (hand.get(index).getCardType() == Card.CardType.HEARTS | hand.get(index).getCardType() == Card.CardType.DIAMONDS){
                button.setStyle("-fx-text-fill: red");
            } else {
                button.setStyle("-fx-text-fill: black");
            }
            index++;
        }

        if (game.getCardInPlay().getCardType() == Card.CardType.HEARTS | game.getCardInPlay().getCardType() == Card.CardType.DIAMONDS){
                cardPileLabel.setStyle("-fx-text-fill: red");
            } else {
                cardPileLabel.setStyle("-fx-text-fill: black");
            }
    }

    public void colourCompyCard(){
        List<Card> hand = game.getCurrentCompyHand();
        int index = 0;

        for (Button button : compyButtons){
            if (hand.get(index).getCardType() == Card.CardType.HEARTS | hand.get(index).getCardType() == Card.CardType.DIAMONDS){
                button.setStyle("-fx-text-fill: red");
            } else {
                button.setStyle("-fx-text-fill: black");
            }
            index++;
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


