
package loginsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import loginsystem.model.User;
import loginsystem.service.FileHandler;


public class Dashboard {
    
    private User currentUser;
    @FXML
    private Label userIDLabel;
    @FXML
    private Label userFullNameLabel;
    @FXML 
    private Label userEmailLabel;
    @FXML
    private Label userGenderLabel;
    @FXML
    private Label userPasswordLabel;
    @FXML 
    private Button signOutButton;
    @FXML
    private Button deleteAccountBtn;
    
    
    @FXML
    private void signOutClicked (ActionEvent event) throws Exception {
        
        currentUser = null;
        
        Parent loginRoot = FXMLLoader.load(getClass().getResource("/resource/fxml/Login.fxml"));
        Scene scene = ((Node) event.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.getScene().setRoot(loginRoot);
        
    }
    
    @FXML
    private void deleteAccountBtnClicked(ActionEvent event) throws Exception {
        
        if (currentUser != null) {
        boolean success = FileHandler.deleteUser(currentUser);
        if (success) {
            System.out.println("Account deleted successfully!");

            // Go back to login screen
            Parent loginRoot = FXMLLoader.load(getClass().getResource("/resource/fxml/Login.fxml"));
            Scene scene = ((Node) event.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.getScene().setRoot(loginRoot);
            
        } else {
            System.out.println("Failed to delete account.");
        }
    }
    }
    
    @FXML
    public void initialize() {
       
    }
    
    public void setUser(User user) {
        this.currentUser = user;
         userIDLabel.setText("ID: " + Integer.toString(currentUser.getUserId()));
         userFullNameLabel.setText("Name: " + currentUser.getFullName());
         userEmailLabel.setText("Email: " + currentUser.getEmail());
         userGenderLabel.setText("Gender: " + currentUser.getGender());
         userPasswordLabel.setText("Password: " + currentUser.getPassword());
         
    }
    
}
