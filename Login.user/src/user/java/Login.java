package user.java;

import javax.swing.*;

//login class

public class Login {

//Declarations for Methods used for registration

    static String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String allDigits = "0123456789";
    static String setUsername;
    static String setPassword;
    static String setNumber;

    // Method check Username(To check if username has an underscore and is no more than five characters )

    static boolean checkUsername(String user) {

        if ((user.contains("_")) && (user.length() <= 5)) {
            JOptionPane.showMessageDialog(null, "Welcome " + user + " its great to see you.");
            return true;

        }
        JOptionPane.showMessageDialog(null, "Username is not correctly formatted please ensure that your usernmae contains an underscore and is no more than five characters in length.");
        return false;

    }

    // Method Check Password Complexity ( To check if password has more than 8 characters, has an uppercase and has a special character  )

    static boolean checkPasswordComplexity(String Pass) {

        if (Pass.length() > 8 && isUpperCase(Pass) && isDigit(Pass) && isSymbol(Pass)) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }
        return false;


    }

    // Method (To check if at least one uppercase character exists in the password )

    static Boolean isUpperCase(String pass) {

        char letterInABC;

        for (int i = 0; i < allLetters.length(); i = i + 1) {
            letterInABC = allLetters.charAt(i);

            String convertedLetter = Character.toString(letterInABC);
            if (pass.contains(convertedLetter)) {

                return true;
            }


        }

        return false;
    }

    // Method Symbol (This method works by running through all the numbers and letters of the alphabet and returns false which returns a special character  )

    static Boolean isSymbol(String pass) {

        char letterInABC;

        for (int i = 0; i < pass.length(); i = i + 1) {
            letterInABC = pass.charAt(i);

            if (!Character.isLetterOrDigit(letterInABC)) {

                return true;
            }
        }

        return false;
    }

    // Method Check CellPhoneNumber (To check if the cellphone number has the international code and is 10 characters long)

    static boolean checkCellphoneNumber(String cellnumber) {


        if (cellnumber.contains("+27") && (cellnumber.length() == 12)) {
            JOptionPane.showMessageDialog(null, "Cellphone number successfully captured.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Cellphone number incorrectly formated or does not contain international code, please correct the number and try again.");
            return false;
        }


    }

    //method register Username (To prompt user to enter username, password and number for registration )

    static void registerUser() {

        setUsername = JOptionPane.showInputDialog("Enter Username:");

        boolean user = checkUsername(setUsername);


        setPassword = JOptionPane.showInputDialog("Enter Password");


        boolean pass = checkPasswordComplexity(setPassword);

        setNumber = JOptionPane.showInputDialog("Enter Number");

        boolean cellnumber = checkCellphoneNumber(setNumber);


    }


    //Method Digit (looping through all the digits )

    static boolean isDigit(String character) {


        char DigitIn012;


        for (int i = 0; i < allDigits.length(); i = i + 1) {
            DigitIn012 = allDigits.charAt(i);

            String convertedDigit = Character.toString(DigitIn012);
            if (character.contains(convertedDigit)) {


                return true;
            }

        }

        return false;

    }

    //Method loginUser (Prompts for user to enter username and password )

    static boolean loginUser() {
        String username = JOptionPane.showInputDialog(null, "Enter Username:");

        String Password = JOptionPane.showInputDialog(null, "Enter Password");


        if (username.equals(setUsername)
                &&
                Password.equals(setPassword)
        ) return true;

        else return false;

    }

    //Method returnLoginStatus (This is a method to prompt user if log in was successful or not)

    static String returnLoginStatus(boolean isLogin) {

        if (isLogin) {
            return "A successful login";
        }
        return "A failed login";

    }
// Main Program

    public static void main(String[] args) {


        registerUser();

// if statement to check if the login requirements have been met, shows a prompt message

        if (loginUser()) {
            JOptionPane.showMessageDialog(null, returnLoginStatus(true));

            JOptionPane.showMessageDialog(null, "Welcome " + setUsername + " its great to see you again.");
        } else {
            JOptionPane.showMessageDialog(null, returnLoginStatus(false));
            JOptionPane.showMessageDialog(null, "Username or password incorrect,please try again.");

        }
    }

    String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

