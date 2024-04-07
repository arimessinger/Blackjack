package org.messingerarraylistlabblackjack;
//package

//imports necessary classes
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

//Main class inherits from Application
public class Main extends Application{
    @Override //start method
    public void start(Stage stage) throws IOException {
        FXMLLoader homescreen = new FXMLLoader(Main.class.getResource("homescreen.fxml")); //creates new FXMLLoader and loads the homescreen fxml
        Scene scene = new Scene(homescreen.load(), 600, 400); //creates scene and sets to 600px by 400px
        stage.setTitle("messingerArrayListLab-Blackjack"); //sets stage title
        stage.setScene(scene); //sets scene
        stage.setResizable(false); //makes window not resizeable
        stage.show(); //shows the stage

        deck = new Deck(); //initializes the Deck
        deck.shuffleDeck(); //shuffles the Deck

    }
    public static Deck deck; //declares new Deck

    //main method - calls method to launch application
    public static void main(String[] args) {
        launch();
    }

}