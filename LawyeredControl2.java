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

public class LawyeredControl2  implements Initializable {

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;


    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView3;
    @FXML
    private MediaView mediaView;

    @FXML
    private ProgressBar progressBar1;

    @FXML
    private Button butonMurat;
    @FXML
    private Button butonFizik;
    @FXML
    private Button butonDabbe;



    @FXML
    private Button butonRefresher;
    @FXML
    private Button butonExit;


    public static double life = 1.0 ;
    public Label label;

    Image bg2 = new Image(getClass().getResourceAsStream("bg22.jpg"));
    Image secenekc = new Image(getClass().getResourceAsStream("secenekler.png"));



    public void bg2() {
        imageView3.setImage(bg2);
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("C:\\Users\\ebube\\Desktop\\ProjeACE\\one.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();


        progressBar1.setStyle("-fx-accent: yellow");
        imageView4.setImage(secenekc);


        butonMurat.setVisible(false);
        butonFizik.setVisible(false);
        butonDabbe.setVisible(false);

        imageView4.setVisible(false);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(122), event -> {

            butonMurat.setVisible(true);
            butonFizik.setVisible(true);
            butonDabbe.setVisible(true);

            imageView4.setVisible(true);
        }));
        timeline.setCycleCount(1);
        timeline.play();

    }

    public void basMurat() throws IOException {
        butonMurat.setVisible(false);
        if (life > 0) {
            life -= 0.25;
            life = Math.max(0, life);
            progressBar1.setProgress(life);
            label.setText((int)Math.round(life * 4)+" CAN");
        }
        if (life < 0.25) {
            Parent root = FXMLLoader.load(getClass().getResource("sceneover.fxml"));
            Scene scene1 = new Scene(root);
            Stage stage1 =(Stage)label.getScene().getWindow();
            stage1.setScene(scene1);
            stage1.setFullScreen(true);
            stage1.show();
            mediaPlayer.stop();

        }

    }

    public void basFizik() throws IOException{

        Parent root4 = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        Scene scene4 = new Scene(root4);
        Stage stage4 = (Stage) label.getScene().getWindow();
        stage4.setScene(scene4);
        stage4.setFullScreen(true);
        stage4.show();
        mediaPlayer.stop();
    }

    public void basDabbe() throws IOException {

        butonDabbe.setVisible(false);
        if (life > 0) {
            life -= 0.25;
            life = Math.max(0, life);
            progressBar1.setProgress(life);
            label.setText((int)Math.round(life * 4)+" CAN");
        }
        if (life < 0.25) {
            Parent root = FXMLLoader.load(getClass().getResource("sceneover.fxml"));
            Scene scene1=new Scene(root);
            Stage stage1 =(Stage)label.getScene().getWindow();
            stage1.setScene(scene1);
            stage1.setFullScreen(true);
            stage1.show();
            mediaPlayer.stop();
        }
    }
    public static double getLife(){
        return life;
}

    public void refresher() throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene scene2 = new Scene(root3);
        Stage stage1 = (Stage) label.getScene().getWindow();
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

