@echo off
java --module-path "lib" ^
     --add-modules javafx.controls,javafx.fxml ^
     -jar "LoginSystem.jar"
pause
