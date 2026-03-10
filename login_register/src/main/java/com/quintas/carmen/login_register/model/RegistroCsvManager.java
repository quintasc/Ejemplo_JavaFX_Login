package com.quintas.carmen.login_register.model;

import ficheros.ClassFichero;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Manages the CSV file for registered users. File is created once at app start
 * and closed when the app exits. Headers are written once.
 */
public class RegistroCsvManager {

    private static boolean initialized = false;

    /**
     * Creates the CSV file and writes the header. Call once at application startup.
     */
    public static void init() {
        if (initialized) {
            return;
        }
        try {
            String dateStr = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
            String fileName = "usuarios_registrado_" + dateStr + ".csv";
            String filePath = Paths.get(System.getProperty("user.dir"), fileName).toString();

            ClassFichero.createFile(filePath);
            ClassFichero.writeFile("Usuario;Email;Password\n");
            initialized = true;
        } catch (FileNotFoundException ex) {
            System.err.println("Error creating CSV file: " + ex.getMessage());
        }
    }

    /**
     * Appends a registration line to the CSV file.
     *
     * @param user username
     * @param email email
     * @param password password
     */
    public static void appendRegistro(String user, String email, String password) {
        if (!initialized) {
            return;
        }
        ClassFichero.writeFile(user + ";" + email + ";" + password + "\n");
    }

    /**
     * Closes the CSV file. Call when the application exits.
     */
    public static void close() {
        if (initialized) {
            ClassFichero.closeFile();
            initialized = false;
        }
    }
}
