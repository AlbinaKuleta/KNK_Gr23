package com.example.knk2023;

import com.example.knk2023.sample.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) {

        if(!usernameTextField.getText().isBlank() && !passwordPasswordField.getText().isBlank()) {
          //  loginMessageLabel.setText("You try to login!");
            validateLogin();
        } else{
            loginMessageLabel.setText("Please enter username and password!");

        }
    }
    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB  = connectNow.getConnection();
        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordPasswordField.getText() + "'";
   try{

     Statement statement = connectDB.createStatement();
       ResultSet queryResult = statement.executeQuery(verifyLogin);
       while(queryResult.next()){
           if(queryResult.getInt(1) ==1){
              loginMessageLabel.setText("Welcome!");

           } else{
               loginMessageLabel.setText("Invalid login...Please try again!");

           }
       }

   } catch(Exception e){

e.printStackTrace();

   }


    }

}
