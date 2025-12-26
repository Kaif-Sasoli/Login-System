package loginsystem.controller;

import java.util.List;
import loginsystem.utils.AlertUtils;
import loginsystem.service.FileHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import loginsystem.model.User;
import loginsystem.model.Users;

public class LoginController {
    @FXML
    private BorderPane mainPane;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML 
    private Button loginButton;
//  @FXML
//  private Button createAccountButton;
    
    
    // ... 
    @FXML 
    private void handleLogin (ActionEvent event) throws Exception {
        
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();
 
        if(email.isEmpty() || password.isEmpty()) {
            AlertUtils.showWarning("All fields must be filled");
            return;
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            AlertUtils.showError("Invalid email format.");
            return;
        }
         if (password.length() < 6) {
            AlertUtils.showError("Password must be at least 6 characters.");
            return;
        }
          
//      Load Users
        for (User user : FileHandler.loadUsers().getUsers()) {
            
           if(email.equalsIgnoreCase(user.getEmail()) && password.equalsIgnoreCase(user.getPassword())) {
        
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/Dashboard.fxml"));
           Parent dashboardRoot = loader.load();
           Dashboard controller = loader.getController();       
           controller.setUser(user);
           
           Scene scene = ((Node) event.getSource()).getScene();
           Stage stage = (Stage) scene.getWindow();
           stage.getScene().setRoot(dashboardRoot);

           return;
           }
        }
        
         AlertUtils.showWarning("Invalid email or password");
    }
    
    @FXML 
    private void createNewAccount (ActionEvent event) throws Exception {
       
        Node createAccount = FXMLLoader.load(getClass().getResource("/resource/fxml/CreateAccount.fxml"));
        mainPane.setCenter(createAccount);
    }
    
    @FXML 
    public void initialize() {
        mainPane.getStylesheets().add(getClass().getResource("/resource/css/login.css").toExternalForm());
        
    }
    
    
}