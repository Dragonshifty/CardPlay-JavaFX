import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.geometry.*;
import javafx.concurrent.Task;


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
        // vBoxLeft.setPadding(new Insets(10, 10, 10, 10));
        // vBoxLeft.setAlignment(Pos.CENTER);
        // vBoxLeft.setVgap(10);
        // vBoxLeft.setHgap(10);

        // vBoxRight.setPadding(new Insets(10, 10, 10, 10));
        // gridRight.setVgap(10);
        // gridRight.setHgap(10);
        
        compyCardOne = new Button("Card\nOne");
        compyCardOne.setId("card");
        compyCardOne.setMinWidth(100);
        compyCardOne.setMinHeight(150);
        compyCardOne.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardOne, 0, 0);
        GridPane.setHalignment(compyCardOne, HPos.CENTER);

        compyCardTwo = new Button("Card\nTwo");
        compyCardTwo.setId("card");
        compyCardTwo.setMinWidth(100);
        compyCardTwo.setMinHeight(150);
        compyCardTwo.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardTwo, 1, 0);
        GridPane.setHalignment(compyCardTwo, HPos.CENTER);

        compyCardThree = new Button("Card\nThree");
        compyCardThree.setId("card");
        compyCardThree.setMinWidth(100);
        compyCardThree.setMinHeight(150);
        compyCardThree.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardThree, 2, 0);
        GridPane.setHalignment(compyCardThree, HPos.CENTER);

        compyCardFour = new Button("Card\nFour");
        compyCardFour.setId("card");
        compyCardFour.setMinWidth(100);
        compyCardFour.setMinHeight(150);
        compyCardFour.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardFour, 3, 0);
        GridPane.setHalignment(compyCardFour, HPos.CENTER);

        compyCardFive = new Button("Card\nFive");
        compyCardFive.setId("card");
        compyCardFive.setMinWidth(100);
        compyCardFive.setMinHeight(150);
        compyCardFive.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyCardFive, 4, 0);
        GridPane.setHalignment(compyCardFive, HPos.CENTER);

        packLabel = new Button("Cards:\n47");
        packLabel.setId("card");
        packLabel.setMinWidth(100);
        packLabel.setMinHeight(150);
        packLabel.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(packLabel, 0, 1);
        GridPane.setHalignment(packLabel, HPos.CENTER);

        cardPileLabel = new Button("Ace\nSpades");
        cardPileLabel.setId("card");
        cardPileLabel.setMinWidth(100);
        cardPileLabel.setMinHeight(150);
        cardPileLabel.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(cardPileLabel, 1, 1);
        GridPane.setHalignment(cardPileLabel, HPos.CENTER);

        playerCardOne = new Button("Card\nOne");
        playerCardOne.setId("card");
        playerCardOne.setMinWidth(100);
        playerCardOne.setMinHeight(150);
        playerCardOne.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardOne, 0, 2);
        GridPane.setHalignment(playerCardOne, HPos.CENTER);

        playerCardTwo = new Button("Card\nTwo");
        playerCardTwo.setId("card");
        playerCardTwo.setMinWidth(100);
        playerCardTwo.setMinHeight(150);
        playerCardTwo.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardTwo, 1, 2);
        GridPane.setHalignment(playerCardTwo, HPos.CENTER);

        playerCardThree = new Button("Card\nThree");
        playerCardThree.setId("card");
        playerCardThree.setMinWidth(100);
        playerCardThree.setMinHeight(150);
        playerCardThree.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardThree, 2, 2);
        GridPane.setHalignment(playerCardThree, HPos.CENTER);
        
        playerCardFour = new Button("Card\nFour");
        playerCardFour.setId("card");
        playerCardFour.setMinWidth(100);
        playerCardFour.setMinHeight(150);
        playerCardFour.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardFour, 3, 2);
        GridPane.setHalignment(playerCardFour, HPos.CENTER);
        
        playerCardFive = new Button("Card\nFive");
        playerCardFive.setId("card");
        playerCardFive.setMinWidth(100);
        playerCardFive.setMinHeight(150);
        playerCardFive.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerCardFive, 4, 2);
        GridPane.setHalignment(playerCardFive, HPos.CENTER);

        newGameButton = new Button("New Game");
        newGameButton.setId("newgame");
        newGameButton.setMinWidth(100);
        newGameButton.setTextAlignment(TextAlignment.CENTER);
        newGameButton.setAlignment(Pos.BASELINE_CENTER);
        GridPane.setConstraints(newGameButton, 0, 0);
        GridPane.setHalignment(newGameButton, HPos.CENTER);

        playerTotalPoints = new Button("Player Total:\n0");
        playerTotalPoints.setId("scorelabel");
        playerTotalPoints.setMinWidth(100);
        playerTotalPoints.setTextAlignment(TextAlignment.CENTER);
        playerTotalPoints.setAlignment(Pos.BASELINE_CENTER);
        GridPane.setConstraints(playerTotalPoints, 0, 1);
        GridPane.setHalignment(playerTotalPoints, HPos.CENTER);

        playerPointsScored = new Button("Last Points:\n0");
        playerPointsScored.setId("scorelabel");
        playerPointsScored.setMinWidth(100);
        playerPointsScored.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(playerPointsScored, 0, 2);
        GridPane.setHalignment(playerPointsScored, HPos.CENTER);

        compyTotalPoints = new Button("Compy Total:\n0");
        compyTotalPoints.setId("scorelabel");
        compyTotalPoints.setMinWidth(100);
        compyTotalPoints.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyTotalPoints, 0, 0);
        GridPane.setHalignment(compyTotalPoints, HPos.CENTER);

        compyPointsScored = new Button("Last Points:\n0");
        compyPointsScored.setId("scorelabel");
        compyPointsScored.setMinWidth(100);
        compyPointsScored.setTextAlignment(TextAlignment.CENTER);
        GridPane.setConstraints(compyPointsScored, 0, 1);
        GridPane.setHalignment(compyPointsScored, HPos.CENTER);

        // grid.getChildren().addAll(compyCardOne, compyCardTwo, compyCardThree, compyCardFour,
        // compyCardFive, packLabel, cardPileLabel, playerCardOne, playerCardTwo, playerCardThree,
        // playerCardFour, playerCardFive);

        gridTop.getChildren().addAll(compyCardOne, compyCardTwo, compyCardThree, compyCardFour,
        compyCardFive);

        grid.getChildren().addAll(packLabel, cardPileLabel);

        gridBottom.getChildren().addAll(playerCardOne, playerCardTwo, playerCardThree,
        playerCardFour, playerCardFive);

        gridLeft.getChildren().addAll(newGameButton, playerTotalPoints, playerPointsScored);

        gridRight.getChildren().addAll(compyTotalPoints, compyPointsScored);
        
        
        playerCardOne.setOnAction(e -> {
            int cardScore = game.playPlayerCard(0);
            setCardInPlay();
            setPlayerHand();
            
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            delay(1500, () -> playCompyCard());
            
        });

        playerCardTwo.setOnAction(e -> {
            int cardScore = game.playPlayerCard(1);
            setCardInPlay();
            setPlayerHand();
            // setRemainingCards();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            delay(1500, () -> playCompyCard());
        });

        playerCardThree.setOnAction(e -> {
            int cardScore = game.playPlayerCard(2);
            setCardInPlay();
            setPlayerHand();
            // setRemainingCards();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            delay(1500, () -> playCompyCard());
        });

        playerCardFour.setOnAction(e -> {
            int cardScore = game.playPlayerCard(3);
            setCardInPlay();
            setPlayerHand();
            // setRemainingCards();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            delay(1500, () -> playCompyCard());
        });

        playerCardFive.setOnAction(e -> {
            int cardScore = game.playPlayerCard(4);
            setCardInPlay();
            setPlayerHand();
            // setRemainingCards();
            showTotalPoints();
            playerPointsScored.setText("" + cardScore);
            delay(1500, () -> playCompyCard());
        });

        newGameButton.setOnAction(e -> {
            StartNewGame();
        });

        StartNewGame();
        
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
    }

    public void StartNewGame(){
        game.initialiseGame();
        setCardInPlay();
        setPlayerHand();
        setRemainingCards();
    }

    public void showTotalPoints(){
        playerTotalPoints.setText("" + game.getPlayerTotal());
        compyTotalPoints.setText("" + game.getCompyTotal());
    }

    public void setCardInPlay(){
        cardPileLabel.setText("" + game.getCardInPlay());
    }

    public void setRemainingCards(){
        packLabel.setText("" + game.getDeckSize() + "\nRemaining");
    }

    public void setPlayerHand(){
        List<Card> hand = new ArrayList<>();
        hand = game.getCurrentPlayerHand();
        playerCardOne.setText("" + hand.get(0));
        playerCardTwo.setText("" + hand.get(1));
        playerCardThree.setText("" + hand.get(2));
        playerCardFour.setText("" + hand.get(3));
        playerCardFive.setText("" + hand.get(4));
    }

    public void playCompyCard(){
        int cardScore = game.playCompyCard();
        showTotalPoints();
        compyPointsScored.setText("" + cardScore);
        setCardInPlay();
        setRemainingCards();
    }

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

}


