/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskpart2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        // Password complexity rules
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecialChar;
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is incorrectly formatted.";
        } else if (!checkPasswordComplexity()) {
            return "Password does not meet the complexity requirements.";
        } else {
            return "User has been registered successfully.";
        }
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public String returnLoginStatus(boolean isAuthenticated) {
        if (isAuthenticated) {
            return "Successful login.";
        } else {
            return "Failed login.";
        }
    }
}
