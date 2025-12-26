package loginsystem.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import loginsystem.model.User;
import loginsystem.model.Users;
import loginsystem.service.FileHandler;
import loginsystem.utils.AlertUtils;
import loginsystem.service.FileHandler;
import loginsystem.controller.Dashboard;

public class CreateAccount {
    
    @FXML
    private TextField fullNameField;
    @FXML 
    private TextField emailField;
    @FXML 
    private RadioButton maleRadio;
    @FXML
    private RadioButton femaleRadio;
    @FXML 
    private PasswordField passwordField;
    @FXML 
    private TextField ageField;
    @FXML 
    private Button createAccountButton;
    @FXML
    private Button loginPageButton;
    
    //..
    @FXML
    public void initialize() {
        
       // Group Radio Buttons
       ToggleGroup genderGroup = new ToggleGroup();
       maleRadio.setToggleGroup(genderGroup);
       femaleRadio.setToggleGroup(genderGroup);
       

       
    }
    
    @FXML
    private void loginPageButton (ActionEvent event) throws Exception  {
        
           Parent loginRoot = FXMLLoader.load(getClass().getResource("/resource/fxml/Login.fxml"));
           Scene scene = ((Node) event.getSource()).getScene();
           Stage stage = (Stage) scene.getWindow();
           stage.getScene().setRoot(loginRoot);
           
    }
    
    @FXML
    private void createAccountButton (ActionEvent event) {
    try {
        // Get values
        String fullName = fullNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();
        String ageText = ageField.getText().trim();
        String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : null;

        // Validate inputs
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty() || ageText.isEmpty() || gender == null) {
            AlertUtils.showWarning("All fields must be filled.");
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

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0) {
                AlertUtils.showError("Age must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            AlertUtils.showError("Age must be a valid number.");
            return;
        }

        try {
            User user = new User(fullName, email, gender, password, age);
            boolean success = FileHandler.saveUser(user);
             
            if(success) {
            //   Load dasboard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resource/fxml/Dashboard.fxml"));
            Parent dashboardRoot = loader.load();
            Dashboard controller = loader.getController();
            controller.setUser(user);
         
         
            Scene scene = ((Node) event.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();
            stage.getScene().setRoot(dashboardRoot);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            AlertUtils.showError("An unexpected occurred");
        } 

     } catch (Exception e) {
         e.printStackTrace();
        AlertUtils.showError("An unexpected error occurred.");
    }
        
    }

    
}
