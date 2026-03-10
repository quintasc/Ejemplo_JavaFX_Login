package com.quintas.carmen.login_register.model;

/**
 * Stores registered users' emails and passwords in parallel arrays.
 * Shared between Login and Register controllers.
 */
public class RegisteredUsers {

    public static final int MAX_USERS = 10;

    /** Emails of registered users (parallel to passwords). */
    public static String[] emails = new String[MAX_USERS];

    /** Passwords of registered users (parallel to emails). */
    public static String[] passwords = new String[MAX_USERS];

    private static int count = 0;

    /**
     * Adds a new user when registration is successful.
     *
     * @param email the user's email
     * @param password the user's password
     * @return true if added successfully, false if array is full
     */
    public static boolean addUser(String email, String password) {
        if (count >= MAX_USERS) {
            return false;
        }
        emails[count] = email;
        passwords[count] = password;
        count++;
        return true;
    }

    /**
     * Checks if the given email and password match a registered user.
     *
     * @param email the email to check
     * @param password the password to check
     * @return true if credentials match a registered user, false otherwise
     */
    public static boolean isRegistered(String email, String password) {
        for (int i = 0; i < count; i++) {
            if (emails[i] != null && emails[i].equals(email) && passwords[i] != null && passwords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }

    /** Returns the current number of registered users. */
    public static int getCount() {
        return count;
    }
}
