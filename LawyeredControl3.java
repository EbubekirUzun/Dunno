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


public class LawyeredControl3 implements Initializable {

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    private MediaView mediaView;

    @FXML
    public ProgressBar progressBar2;
    @FXML
    public Label label2;
    @FXML
    private ImageView imageView;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonRefresh;
    @FXML
    private Button buttonToMS;


    public static double life2 = LawyeredControl2.getLife();


    Image bg3 = new Image(getClass().getResourceAsStream("arkap.jpg"));

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        progressBar2.setProgress(life2);
        progressBar2.setStyle("-fx-accent: yellow");
        label2.setText((int) Math.round(life2 * 4) + " CAN");

        imageView.setImage(bg3);

        file = new File("C:\\Users\\ebube\\Desktop\\ProjeACE\\two.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

        buttonToMS.setVisible(false);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(54), event -> {

        buttonToMS.setVisible(true);

        }));
        timeline.setCycleCount(1);
        timeline.play();
    }


    public void refresher() throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        Scene scene2 = new Scene(root3);
        Stage stage1 = (Stage) label2.getScene().getWindow();
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

    public static double getLife2(){
        return life2;
    }

    public void toScene4() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        Scene scene1=new Scene(root);
        Stage stage1 =(Stage)label2.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setFullScreen(true);
        stage1.show();
        mediaPlayer.stop();
    }

}




