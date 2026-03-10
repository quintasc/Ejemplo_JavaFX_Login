/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.quintas.carmen.login_register.controller;

import com.quintas.carmen.login_register.App;
import com.quintas.carmen.login_register.model.RegisteredUsers;
import com.quintas.carmen.login_register.model.RegistroCsvManager;
import com.quintas.carmen.login_register.model.UserDataValidations;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author carme
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPassword;
    @FXML
    private Label lblInfo;
    @FXML
    private Button btnRegister;
    @FXML
    private Button btnLimpiar;
    @FXML
    private Hyperlink loginHLink;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onRegisterClick(ActionEvent event) {
        String user = txtUser.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        if (UserDataValidations.hasEmptyFields(user, email, password, confirmPassword)) {
            lblInfo.setText("Error: You must fill in all fields.");
            lblInfo.setStyle("-fx-text-fill: orange;");
        } else if (!UserDataValidations.checkEmail(email)) {
            lblInfo.setText("Error: Invalid email format.");
            lblInfo.setStyle("-fx-text-fill: red;");
        } else if (!UserDataValidations.isPasswordSecure(password)) {
            lblInfo.setText("Error: Password must be at least 8 characters.");
            lblInfo.setStyle("-fx-text-fill: red;");
        } else if (!UserDataValidations.checkConfirmPassword(password, confirmPassword)) {
            lblInfo.setText("Error: Passwords do not match.");
            lblInfo.setStyle("-fx-text-fill: red;");
        } else if (!RegisteredUsers.addUser(email.trim(), password)) {
            lblInfo.setText("Error: Maximum users reached.");
            lblInfo.setStyle("-fx-text-fill: red;");
        } else {
            saveToCsv(user.trim(), email.trim(), password);
            lblInfo.setText("Account created successfully!");
            lblInfo.setStyle("-fx-text-fill: green;");
            btnRegister.setDisable(true);
            btnLimpiar.setManaged(true);
            btnLimpiar.setVisible(true);
        }
    }

    @FXML
    private void onLimpiarClick(ActionEvent event) {
        txtUser.clear();
        txtEmail.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
        lblInfo.setText("");
        btnLimpiar.setManaged(false);
        btnLimpiar.setVisible(false);
        btnRegister.setDisable(false);
    }

    @FXML
    private void switchLogin(ActionEvent event) throws IOException {
        App.setRoot("/com/quintas/carmen/login_register/fxml/Login");
    }

    /** Appends the registered user to the CSV file (file is managed by RegistroCsvManager). */
    private void saveToCsv(String user, String email, String password) {
        try {
            RegistroCsvManager.appendRegistro(user, email, password);
        } catch (Exception ex) {
            lblInfo.setText("Account created, but error saving to file: " + ex.getMessage());
            lblInfo.setStyle("-fx-text-fill: orange;");
        }
    }

}
