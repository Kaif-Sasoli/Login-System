package loginsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import loginsystem.utils.AlertUtils;

public class LoginSystem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resource/fxml/Login.fxml"));
            Scene scene = new Scene(root);
            Image icon = new Image(getClass().getResourceAsStream("/resource/images/loginSystem-removebg-preview.png"));
            stage.getIcons().add(icon);
            stage.setTitle("Login System");
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.show();
        } catch (Exception e) {
            AlertUtils.showError("An unexpected Occured!");
        }

    }
}
