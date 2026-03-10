package com.quintas.carmen.login_register.model;

import java.util.regex.Pattern;

/**
 *
 * @author carme
 */
public class UserDataValidations {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * Checks if any of the given fields are empty or null.
     *
     * @param fields one or more strings to validate
     * @return true if any field is null or empty (after trim), false otherwise
     */
    public static boolean hasEmptyFields(String... fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates that the email has a correct format.
     *
     * @param email the email string to validate
     * @return true if the format is valid, false otherwise
     */
    public static boolean checkEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    /**
     * Validates that both passwords match and meet the minimum length requirement.
     *
     * @param password the password
     * @param confirmPassword the password confirmation
     * @return true if both are valid and equal, false otherwise
     */
    public static boolean checkConfirmPassword(String password, String confirmPassword) {
        return isPasswordSecure(password) && password.equals(confirmPassword);
    }

    /**
     * Checks if the password meets the minimum length requirement (8 characters).
     *
     * @param password the password to validate
     * @return true if length is 8 or more, false otherwise
     */
    public static boolean isPasswordSecure(String password) {
        return password != null && password.length() >= 8;
    }

    /**
     * Simulates credentials verification against a database.
     *
     * @param usuario the username
     * @param password the password
     * @return true if credentials match, false otherwise
     */
    public static boolean areCredentialsCorrect(String usuario, String password) {
        // Fallback: admin / 12345678
        if (usuario != null && usuario.equals("admin") && password != null && password.equals("12345678")) {
            return true;
        }
        // Check registered users (usuario is treated as email)
        return RegisteredUsers.isRegistered(usuario, password);
    }
}
