/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quintas.carmen.login_register.model;

/**
 *
 * @author carme
 */
public class UserDataValidations {

    // Método 1: Comprueba si algún texto está vacío
    public static boolean hayCamposVacios(String usuario, String password) {
        if (usuario.isEmpty() || password.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // Método 2: Comprueba si la contraseña es segura (mínimo 8 caracteres)
    public static boolean esPasswordSegura(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    // Método 3: Simula la comprobación en una base de datos
    public static boolean sonCredencialesCorrectas(String usuario, String password) {
        // En un futuro, esto mirará en una base de datos real.
        // Por ahora, solo dejamos entrar a "admin" con clave "12345678"
        if (usuario.equals("admin") && password.equals("12345678")) {
            return true;
        } else {
            return false;
        }
    }
}
