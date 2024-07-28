package com.example.JusticeForJoseph;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class LawyeredControlOver implements Initializable {

    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private Button returnMenu;
    @FXML
    private Label label;


    Image image = new Image(getClass().getResourceAsStream("dark.jpg"));
    Image image1 = new Image(getClass().getResourceAsStream("fail.png"));
    Image image2 = new Image(getClass().getResourceAsStream("muratorm.png"));
    /**
     * @param url
     * @param resourceBundle
     */
    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        imageView5.setImage(image);
        imageView6.setImage(image1);
        imageView7.setImage(image2);
    }

    public void toExit() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Çıkış");
        alert.setHeaderText("Çıkmak İstediğinize Emin Misiniz?");
        alert.setContentText("Yusuf'un katili bulunamadı!");
        Optional<ButtonType> uyar = alert.showAndWait();
        if (uyar.isPresent() && uyar.get() == ButtonType.OK) {
            System.exit(0);
        }
    }
}
