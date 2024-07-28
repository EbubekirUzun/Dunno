package com.example.JusticeForJoseph;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LawyeredControl6 implements Initializable {

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    private TextField textField;
    @FXML
    private MediaView mediaView;
    @FXML
    private ImageView imageView1;
    @FXML
    public Label label5;
    @FXML
    private Label labelOfTheEnd;
    @FXML
    public ProgressBar progressBar5;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonRefresh;

    public static double life5 = LawyeredControl5.getLife4();
    Image bg6 = new Image(getClass().getResourceAsStream("c.jpg"));

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("C:\\Users\\ebube\\Desktop\\ProjeACE\\fournew.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

        label5.setText((int)Math.round(life5* 4) +" CAN");
        progressBar5.setProgress(life5);
        progressBar5.setStyle("-fx-accent: red");

        imageView1.setImage(bg6);

        labelOfTheEnd.setVisible(false);
        textField.setVisible(false);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(105), event -> {

        labelOfTheEnd.setVisible(true);
        textField.setVisible(true);

        }));
        timeline.setCycleCount(1);
        timeline.play();

    }

    public void textFielder() throws IOException{
        String text = textField.getText().toLowerCase();
        if (text.equals("hamza")) {
            Parent root = FXMLLoader.load(getClass().getResource("sceneWinner.fxml"));
            Scene scene1 = new Scene(root);
            Stage stage1 = (Stage) label5.getScene().getWindow();
            stage1.setScene(scene1);
            stage1.setFullScreen(true);
            stage1.show();
            mediaPlayer.stop();
        }else {
            if (life5 > 0) {
                life5 -= 0.25;
                life5 = Math.max(0, life5);
                progressBar5.setProgress(life5);
                label5.setText((int) Math.round(life5 * 4) + " CAN");
            }
            if (life5 < 0.25) {
                Parent root = FXMLLoader.load(getClass().getResource("sceneover.fxml"));
                Scene scene1 = new Scene(root);
                Stage stage1 = (Stage) label5.getScene().getWindow();
                stage1.setScene(scene1);
                stage1.setFullScreen(true);
                stage1.show();
                mediaPlayer.stop();
            }
        }
    }
    public void refresher() throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("scene6.fxml"));
        Scene scene2 = new Scene(root3);
        Stage stage1 = (Stage) label5.getScene().getWindow();
        stage1.setScene(scene2);
        stage1.setFullScreen(true);
        mediaPlayer.stop();
    }

    public void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Çıkış");
        alert.setHeaderText("Çıkmak İstediğinize Emin Misiniz?");
        alert.setContentText("Yusuf'un katilini bulmalısınız!");
        Optional<ButtonType> uyar = alert.showAndWait();
        if (uyar.isPresent() && uyar.get() == ButtonType.OK) {
            System.exit(0);
        }
    }

}
