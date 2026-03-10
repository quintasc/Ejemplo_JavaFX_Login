/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.quintas.carmen.login_register.controller;

import com.quintas.carmen.login_register.App;
import com.quintas.carmen.login_register.model.UserDataValidations;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {

    // --- Cajas de texto y etiquetas de nuestra pantalla (Vista) ---
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Label lblInfo;
    @FXML
    private ImageView imgAvatar;

    /**
     * Este método está conectado al botón "Entrar" en el archivo FXML. Solo se
     * ejecuta cuando el usuario hace clic. No recibe parámetros raros.
     */
    @FXML
    public void onLoginClick() {

        // 1. Recogemos lo que el usuario ha escrito en la pantalla
        String usuarioEscrito = txtUser.getText();
        String passwordEscrita = txtPass.getText();

        // 2. Empezamos las comprobaciones pidiendo ayuda a nuestra clase experta (El Modelo)
        // Comprobación A: ¿Se ha olvidado de rellenar algo?
        if (UserDataValidations.hasEmptyFields(usuarioEscrito, passwordEscrita)) {

            lblInfo.setText("Error: Debes rellenar todos los campos.");
            lblInfo.setStyle("-fx-text-fill: orange;");

            // Comprobación B: ¿La contraseña es muy corta?
        } else if (!UserDataValidations.isPasswordSecure(passwordEscrita)) {

            lblInfo.setText("Error: La contraseña debe tener 8 caracteres o más.");
            lblInfo.setStyle("-fx-text-fill: red;");

            // Comprobación C: ¿El usuario y la contraseña son los correctos?
        } else if (UserDataValidations.areCredentialsCorrect(usuarioEscrito, passwordEscrita)) {
            try {
                App.setRoot("/com/quintas/carmen/login_register/fxml/Game");
            } catch (IOException ex) {
                lblInfo.setText("Error al cargar el juego.");
                lblInfo.setStyle("-fx-text-fill: red;");
            }
            // Si ha rellenado todo, la clave es larga, pero NO coinciden con los de la base de datos...
        } else {

            lblInfo.setText("Usuario o contraseña incorrectos.");
            lblInfo.setStyle("-fx-text-fill: red;");

        }
    }

    @FXML
    private void switchRegister(ActionEvent event) throws IOException {
//        App.setRoot("Register");
        App.setRoot("/com/quintas/carmen/login_register/fxml/Register");
    }
}
