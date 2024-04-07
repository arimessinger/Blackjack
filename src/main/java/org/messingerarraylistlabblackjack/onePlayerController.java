package org.messingerarraylistlabblackjack; //package

//imports necessary classes
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

//controls the main game with one player; implements Initializable
public class onePlayerController implements Initializable {
    //creates many ImageViews - think box for images to be displayed in
    @FXML
    ImageView playerCard1View, playerCard2View, playerCard3View, playerCard4View, playerCard5View, dealerCard1View, dealerCard2View, dealerCard3View, dealerCard4View, dealerCard5View;

    //creates 3 buttons
    @FXML
    Button dealButton, hitButton, stayButton;

    //creates a bunch of text displays
    @FXML
    Label playerLabel, dealerLabel, playerBustLabel, playerBlackjackLabel, winner;

    //creates many Image objects
    @FXML
    Image playerCard1Image, playerCard2Image, playerCard3Image, playerCard4Image, playerCard5Image, dealerCard1Image, dealerCard2Image, dealerCard3Image, dealerCard4Image, dealerCard5Image, unknownDealerCard2Image;

    //declares many Card objects
    private Card playerCard1, playerCard2, playerCard3, playerCard4, playerCard5, dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5;

    //method to set up player's hand
    private void initializePlayerHand() {

        try {
            //sets first two player Cards equal to the next Card
            playerCard1 = Main.deck.nextCard();
            playerCard2 = Main.deck.nextCard();

            //adds Cards to ArrayList
            playerHand.add(playerCard1);
            playerHand.add(playerCard2);

            //sets Images equal to the corresponding image file based on the filename of the card
            playerCard1Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + playerCard1.getCardFileName()));
            playerCard2Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + playerCard2.getCardFileName()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //method to set up dealer's hand
    public void initializeDealerHand() {
        //sets first two player Cards equal to the next Card
        dealerCard1 = Main.deck.nextCard();
        dealerCard2 = Main.deck.nextCard();

        //adds Cards to ArrayList
        dealerHand.add(dealerCard1);
        dealerHand.add(dealerCard2);

        //sets Images equal to the corresponding image file based on the filename of the card + an extra for the hidden card for later
        try {
            dealerCard1Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + dealerCard1.getCardFileName()));
            dealerCard2Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/Back2.png"));
            unknownDealerCard2Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + dealerCard2.getCardFileName()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //sets an ImageView visible and sets it to an image
    public void displayImage(ImageView imageView, Image image) {
        imageView.setVisible(true);
        imageView.setImage(image);
    }

    //method for the dealing of Cards
    public void initialDeal() throws InterruptedException {
        //creates hands for both the dealer and the player
        initializePlayerHand();
        initializeDealerHand();

        //shows the four cards dealt at the beginning of the game
        displayImage(playerCard1View, playerCard1Image);
        displayImage(playerCard2View, playerCard2Image);
        displayImage(dealerCard1View, dealerCard1Image);
        displayImage(dealerCard2View, dealerCard2Image);

        //makes the deal button invisible
        dealButton.setDisable(true);
        dealButton.setVisible(false);

        //makes labels visible
        dealerLabel.setVisible(true);
        playerLabel.setVisible(true);

        //makes hit & stay buttons visible
        hitButton.setVisible(true);
        stayButton.setVisible(true);

        //sets the amount of Cards in each hand to 2
        cardsInPlayerHand = 2;
        cardsInDealerHand = 2;

        //changes text display
        playerLabel.setText("Player: " + getPlayerTotalValue());

        //checks to see if player has bj off the bat
        playerBlackjack();

    }

    //gets called at the start of the scene
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //sets all card views to invisible
        playerCard1View.setVisible(false);
        playerCard2View.setVisible(false);
        playerCard3View.setVisible(false);
        playerCard4View.setVisible(false);
        playerCard5View.setVisible(false);

        dealerCard1View.setVisible(false);
        dealerCard2View.setVisible(false);
        dealerCard3View.setVisible(false);
        dealerCard4View.setVisible(false);
        dealerCard5View.setVisible(false);

        //sets labels invisible
        dealerLabel.setVisible(false);
        playerLabel.setVisible(false);

        //sets button
        hitButton.setVisible(false);
        stayButton.setVisible(false);

        //sets labels invisible
        playerBlackjackLabel.setVisible(false);
        playerBustLabel.setVisible(false);
        winner.setVisible(false);
    }

    private int cardsInPlayerHand; //creates new int holding how many cards the player has
    private int cardsInDealerHand; //creates new int holding how many cards the dealer has


    //hit method for when the hit button is clicked
    public void hit() throws FileNotFoundException, InterruptedException {
        cardsInPlayerHand++; //increment number of cards in player hand
        //each time hit is called the next case happens
        switch (cardsInPlayerHand){
            case 3:
                playerCard3 = Main.deck.nextCard(); //sets the player's third card = the next card in the deck
                playerCard3Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + playerCard3.getCardFileName())); //sets the imageview equal to card #3
                displayImage(playerCard3View, playerCard3Image); //displays the image in the imageview
                playerHand.add(playerCard3); //adds card to the players hand
                break; //break switch
            case 4:
                playerCard4 = Main.deck.nextCard(); //sets the player's fourth card = the next card in the deck
                playerCard4Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + playerCard4.getCardFileName())); //sets the imageview equal to card #4
                displayImage(playerCard4View, playerCard4Image); //displays the image in the imageview
                playerHand.add(playerCard4); //adds card to the players hand
                break; //break switch
            case 5:
                playerCard5 = Main.deck.nextCard(); //sets the player's fifth card = the next card in the deck
                playerCard5Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + playerCard5.getCardFileName())); //sets the imageview equal to card #5
                displayImage(playerCard5View, playerCard5Image); //displays the image in the imageview
                playerHand.add(playerCard5); //adds card to the players hand
                break; //break switch
        }
        //calls bustSequence() if playerBust() is true
        if(playerBust()) {
            bustSequence();
        }
        //changes display of text
        playerLabel.setText("Player: " + getPlayerTotalValue());

        //checks to see if player has bj
        playerBlackjack();
    }

    private int dealerHandValue; //value of the dealers hand

    //stay method
    public void stay() throws FileNotFoundException {
        displayImage(dealerCard2View, unknownDealerCard2Image); //reveal other card

        getDealerValue(); //gets dealers hand total value

        //if dealer has auto bj the dealer wins
        if(dealerHandValue == 21) {
            dealerWins();
        }

        //while dealer's hand is lower than 16 the following code will run
        while(dealerHandValue <= 16) {
            cardsInDealerHand++; //increment number of cards in player hand
            //each time hit is called the next case happens
            switch (cardsInDealerHand){
                case 3:
                    dealerCard3 = Main.deck.nextCard(); //sets the dealer's third card = the next card in the deck
                    dealerCard3Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + dealerCard3.getCardFileName())); //sets the imageview equal to card #3
                    displayImage(dealerCard3View, dealerCard3Image); //displays the image in the imageview
                    dealerHand.add(dealerCard3);
                    break; //break switch
                case 4:
                    dealerCard4 = Main.deck.nextCard(); //sets the dealer's fourth card = the next card in the deck
                    dealerCard4Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + dealerCard4.getCardFileName())); //sets the imageview equal to card #4
                    displayImage(dealerCard4View, dealerCard4Image); //displays the image in the imageview
                    dealerHand.add(dealerCard4);
                    break; //break switch
                case 5:
                    dealerCard5 = Main.deck.nextCard(); //sets the dealer's fifth card = the next card in the deck
                    dealerCard5Image = new Image(new FileInputStream("src/main/resources/org/messingerarraylistlabblackjack/textures/Cards/" + dealerCard5.getCardFileName())); //sets the imageview equal to card #5
                    displayImage(dealerCard5View, dealerCard5Image); //displays the image in the imageview
                    dealerHand.add(dealerCard5);
                    break; //break switch
            }
            getDealerValue();

            if(dealerHandValue > 21) {
                for(Card card : dealerHand) {
                    if(card.getRank().equals("Ace")) {
                        card.setValue(card.getSecondValue());
                    }
                    getDealerValue();
                    if(dealerHandValue <= 21) {
                        break;
                    }
                }
            }
            dealerLabel.setText("Dealer: " + dealerHandValue);
        }

        if(dealerHandValue > 21 && getPlayerTotalValue() < 21) {playerWins();} //player wins if dealer busts

        else if(dealerHandValue == getPlayerTotalValue() && dealerHandValue < 21) {tie();} //tie - added the dealer hand < 21 to make sure it wasn't a bust tie which is covered below

        else if(dealerHandValue > 21 && getPlayerTotalValue() > 21) {bothBust();} //both have busts

        else if(dealerHandValue > getPlayerTotalValue() && dealerHandValue < 21) {dealerWins();}  //if dealer > player, dealer wins


        else if (getPlayerTotalValue() > dealerHandValue) {playerWins();} //if player > dealer, player wins

        else {dealerWins();}

        //makes both buttons invisible
        stayButton.setVisible(false);
        hitButton.setVisible(false);
    }

    //returns the total value of the dealer's hand
    private void getDealerValue() {
        dealerHandValue = 0;
        for(Card card : dealerHand) {
            dealerHandValue += card.getValue();
        }
    }

    //happens when player busts
    private void bustSequence() throws InterruptedException {
        dealerCard2View.setImage(unknownDealerCard2Image); //reveal dealer card #2
        playerBustLabel.setVisible(true); //shows bust

        //makes both buttons invisible
        hitButton.setVisible(false);
        stayButton.setVisible(false);

        dealerWins(); //shows dealer winning
    }

    //ArrayLists of hands
    private final ArrayList<Card> playerHand = new ArrayList<>();
    private final ArrayList<Card> dealerHand = new ArrayList<>();

    //value of the players hand
    private int playerTotalValue = 0;

    //returns the total value of the player
    private int getPlayerTotalValue() {
        playerTotalValue = 0;
        for(Card card : playerHand) {
            playerTotalValue += card.getValue();
        }
        return playerTotalValue;
    }

    //is bust method that filters through the hand, if the total val is over 21 and (there's no aces or the aces are all low), returns true, otherwise returns false
    //if there's aces it will set the value of the ace equal to the second value
    private boolean playerBust() {
        if(getPlayerTotalValue() > 21) {
            for(Card card : playerHand) {
                if(card.getRank().equals("Ace")) {
                    card.setValue(card.getSecondValue());
                }
                if(getPlayerTotalValue() <= 21) {
                    break;
                }
            }
            return getPlayerTotalValue() > 21;
        }
        return false;
    }

    //checks if the player has bj
    private void playerBlackjack() throws InterruptedException {
        if (getPlayerTotalValue() == 21) {
            dealerCard2View.setImage(unknownDealerCard2Image); //reveal dealer card #2
            playerBlackjackLabel.setVisible(true); //shows blackjack

            //sets the buttons invisible
            hitButton.setVisible(false);
            stayButton.setVisible(false);

            playerWins(); //displays player winning
        }
    }

    //pauses thread execution
    private void sleep(long time) throws InterruptedException {
        Thread.sleep(time);
    }

    //called when the dealer wins
    private void dealerWins() {
        winner.setVisible(true);
        winner.setText("DEALER WINS!");
    }

    //called when the player wins
    private void playerWins() {
        winner.setVisible(true);
        winner.setText("PLAYER WINS!");
    }

    //called when both the dealer and the player bust
    private void bothBust() {
        winner.setVisible(true);
        winner.setText("BOTH BUSTED!");
    }

    //called when both hand values are the same
    private void tie() {
        winner.setVisible(true);
        winner.setText("TIE!");
    }
}
