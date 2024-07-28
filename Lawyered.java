package com.example.JusticeForJoseph;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class Lawyered extends Application implements Initializable {

    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    private Label label;
    @FXML
    private Button butonExitMenu;

    String musicFile = "src/main/resources/pursuit.mp3";
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);


    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setResizable(true);

        stage.setTitle("Uzman Avukat: Yusuf İçin Adalet!");


        Image icon = new Image(getClass().getResourceAsStream("phoenix.png"));
        stage.getIcons().add(icon);


        stage.show();
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mediaPlayer.play();

    }

    public static void main(String[] args) {
        launch();
    }

    public void switchToScene2() throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene scene2 = new Scene(root3);
        Stage stage1 = (Stage) label.getScene().getWindow();
        stage1.setScene(scene2);
        stage1.setFullScreen(true);
        stage1.setResizable(false);
        mediaPlayer.stop();
    }

    public void exitMenu(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Çıkış");
        alert.setHeaderText("Çıkmak İstediğinize Emin Misiniz?");
        alert.setContentText("Yusuf'un katilini bulmalısınız!");
        Optional<ButtonType> uyar = alert.showAndWait();
        if (uyar.isPresent() && uyar.get() == ButtonType.OK) {
            System.exit(0);
        }

    }

    @Override
    public void stop() {
        System.exit(0);
    }



}
