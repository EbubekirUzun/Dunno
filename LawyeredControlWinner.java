package com.example.JusticeForJoseph;

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
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LawyeredControlWinner implements Initializable {

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @FXML
    private ImageView imageView1;
    @FXML
    private Button buttonExit;
    @FXML
    private Button buttonRefresh;
    @FXML
    private Label labelEnd;
    @FXML
    private MediaView mediaView;

    String musicFile = "src/main/resources/letmepainttheview.mp3";
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayerMusic = new MediaPlayer(sound);

    Image bgend = new Image(getClass().getResourceAsStream("goodbye.jpg"));

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        file = new File("C:\\Users\\ebube\\Desktop\\ProjeACE\\final.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();

        imageView1.setImage(bgend);

        buttonExit.setVisible(false);
        labelEnd.setVisible(false);

        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayerMusic.play();
            buttonExit.setVisible(true);
            labelEnd.setVisible(true);
        });
    }

    public void refresher() throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("sceneWinner.fxml"));
        Scene scene2 = new Scene(root3);
        Stage stage1 = (Stage) labelEnd.getScene().getWindow();
        stage1.setScene(scene2);
        stage1.setFullScreen(true);
        mediaPlayer.stop();
        mediaPlayerMusic.stop();
    }

    public void exit() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Çıkış");
        alert.setHeaderText("Çıkmak İstediğinize Emin Misiniz?");
        alert.setContentText("Yusuf'un katilini bulduğunuz için TEŞEKKÜRLER!");
        Optional<ButtonType> uyar = alert.showAndWait();
        if (uyar.isPresent() && uyar.get() == ButtonType.OK) {
            System.exit(0);
        }
    }


}
