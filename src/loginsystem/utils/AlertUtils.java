
package loginsystem.utils;

import javafx.scene.control.Alert;

public class AlertUtils {
    
    public static void showInfo(String message) {
        showAlert(Alert.AlertType.INFORMATION, "Info", message);
    }

    public static void showError(String message) {
        showAlert(Alert.AlertType.ERROR, "Error", message);
    }

    public static void showWarning(String message) {
        showAlert(Alert.AlertType.WARNING, "Warning", message);
    }
            
    private static void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
