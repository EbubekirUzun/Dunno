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

public class LawyeredControl5 implements Initializable {

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;
    @FXML
    private ImageView imageView1;
    @FXML
    private ImageView imageView2;
    @FXML
    public Label label4;
    @FXML
    public ProgressBar progressBar4;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonRefresh;

    @FXML
    private Button buttonLab;
    @FXML
    private Button button302;
    @FXML
    private Button button303;

    public static double life4 = LawyeredControl4.getLife3();


    Image bg5 = new Image(getClass().getResourceAsStream("ace.jpg"));
    Image secenekc = new Image(getClass().getResourceAsStream("secenekler.png"));

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("C:\\Users\\ebube\\Desktop\\ProjeACE\\three.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

        label4.setText((int)Math.round(life4 * 4) +" CAN");
        progressBar4.setProgress(life4);
        progressBar4.setStyle("-fx-accent: red");

        imageView1.setImage(bg5);
        imageView2.setImage(secenekc);

        button302.setVisible(false);
        button303.setVisible(false);
        buttonLab.setVisible(false);
        imageView2.setVisible(false);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(68), event -> {

            button302.setVisible(true);
            button303.setVisible(true);
            buttonLab.setVisible(true);
            imageView2.setVisible(true);


        }));
        timeline.setCycleCount(1);
        timeline.play();

    }


    public void refresher() throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("scene5.fxml"));
        Scene scene2 = new Scene(root3);
        Stage stage1 = (Stage) label4.getScene().getWindow();
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

    public void basLab() throws IOException {
        buttonLab.setVisible(false);
        if (life4 > 0) {
            life4 -= 0.25;
            life4 = Math.max(0, life4);
            progressBar4.setProgress(life4);
            label4.setText((int)Math.round(life4 * 4)+" CAN");
        }
        if (life4 < 0.25) {
            Parent root = FXMLLoader.load(getClass().getResource("sceneover.fxml"));
            Scene scene1=new Scene(root);
            Stage stage1 =(Stage)label4.getScene().getWindow();
            stage1.setScene(scene1);
            stage1.setFullScreen(true);
            stage1.show();
            mediaPlayer.stop();

        }

    }

    public void bas302() throws IOException{

        Parent root4 = FXMLLoader.load(getClass().getResource("scene6.fxml"));
        Scene scene4 = new Scene(root4);
        Stage stage4 = (Stage) label4.getScene().getWindow();
        stage4.setScene(scene4);
        stage4.setFullScreen(true);
        stage4.show();
        mediaPlayer.stop();
    }

    public void bas303() throws IOException {
        button303.setVisible(false);
        if (life4 > 0) {
            life4 -= 0.25;
            life4 = Math.max(0, life4);
            progressBar4.setProgress(life4);
            label4.setText((int)Math.round(life4 * 4)+" CAN");
        }
        if (life4 < 0.25) {
            Parent root = FXMLLoader.load(getClass().getResource("sceneover.fxml"));
            Scene scene1=new Scene(root);
            Stage stage1 =(Stage)label4.getScene().getWindow();
            stage1.setScene(scene1);
            stage1.setFullScreen(true);
            stage1.show();
            mediaPlayer.stop();

        }
        }

    public static double getLife4(){
        return life4;
    }
    }


