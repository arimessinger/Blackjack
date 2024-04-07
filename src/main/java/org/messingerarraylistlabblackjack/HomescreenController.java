package org.messingerarraylistlabblackjack; //package

//imports necessary classes
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//HomescreenController class that implements Initializable
public class HomescreenController implements Initializable {
    @FXML
    private Slider playerAmountSlider; //declares new Slider - scenebuilder takes care of the rest

    private byte playerAmount = 1;

    //switches between gamemodes - only one player works
    public void switchScenes(ActionEvent buttonPress) throws IOException {
        switch (playerAmount) {
            case 1:
                onePlayer(buttonPress);
                break;
            case 2:
                twoPlayers(buttonPress);
                break;
            case 3:
                threePlayers(buttonPress);
                break;
        }
    }

    private Stage stage; //declares stage
    private Scene scene; //declares scene

    //outcome of onePlayer being selected
    private void onePlayer(ActionEvent buttonPress) throws IOException {
        FXMLLoader onePlayer = new FXMLLoader(Main.class.getResource("onePlayer.fxml")); //creates new FXMLLoader and loads the one player fxml
        stage = (Stage) ((Node) buttonPress.getSource()).getScene().getWindow(); //sets stage = the stage of where the button was pressed
        scene = new Scene(onePlayer.load(), 600, 400); //loads the scene in
        stage.setScene(scene); //sets the scene to be shown
        stage.show(); //displays the scene
    }

    //don't mind all this (twoPlayers() & threePlayers()) - can't remove because will break other code - code is trivial though
    private void twoPlayers(ActionEvent buttonPress) throws IOException {
        FXMLLoader twoPlayers = new FXMLLoader(Main.class.getResource("twoPlayers.fxml"));
        stage = (Stage) ((Node) buttonPress.getSource()).getScene().getWindow();
        scene = new Scene(twoPlayers.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void threePlayers(ActionEvent buttonPress) throws IOException {
        FXMLLoader threePlayers = new FXMLLoader(Main.class.getResource("threePlayers.fxml"));
        stage = (Stage) ((Node) buttonPress.getSource()).getScene().getWindow();
        scene = new Scene(threePlayers.load(), 600, 400);
        stage.setScene(scene);
        stage.show();
    }


    @Override //code to happen when the homescreen is loaded in
    public void initialize(URL arg0, ResourceBundle arg1) {
        //gets the value of the slider
        playerAmountSlider.valueProperty().addListener((observableValue, number, t1) -> {
            playerAmount = (byte) playerAmountSlider.getValue();});
    }
}