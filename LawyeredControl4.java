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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LawyeredControl4 implements Initializable{

    @FXML
    public ImageView imageView;
    @FXML
    private ImageView imageView2;
    @FXML
    public Label label3;
    @FXML
    private Label labelCount;
    @FXML
    private Label labelKrok;
    @FXML
    public ProgressBar progressBar3;
    @FXML
    private Button buttonExit;


    private int countSec = 90;


    Image murderScene = new Image(getClass().getResourceAsStream("cinayetmahal.jpg"));
    Image bg3 = new Image(getClass().getResourceAsStream("arkap.jpg"));


    String musicFile = "src/main/resources/climax.mp3";
    Media sound = new Media(new File(musicFile).toURI().toString());
    MediaPlayer mediaPlayer = new MediaPlayer(sound);

    public static double life3 = LawyeredControl3.getLife2();
    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        label3.setText((int)Math.round(life3 * 4) +" CAN");
        progressBar3.setProgress(life3);
        progressBar3.setStyle("-fx-accent: yellow");


        imageView.setImage(murderScene);
        imageView2.setImage(bg3);
        mediaPlayer.play();

        labelKrok.setVisible(true);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            countSec--;
            if (countSec > 0) {
                int countMin = countSec / 60;
                int countSecR = countSec % 60;
                labelCount.setText(( countMin + ":" + countSecR));
            } else if (countSec < 1){
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("scene5.fxml"));
                    Scene scene1 = new Scene(root);
                    Stage stage1 = (Stage)label3.getScene().getWindow();
                    stage1.setScene(scene1);
                    stage1.setFullScreen(true);
                    stage1.show();
                    mediaPlayer.stop();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }));
        timeline.setCycleCount(90);
        timeline.play();
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

    public static double getLife3(){
        return life3;
    }


}
