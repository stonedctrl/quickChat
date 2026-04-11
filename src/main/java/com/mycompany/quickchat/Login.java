/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author kamot
 */
public class Login {
    public static String username;
    public static String password;
    //check if username has correct format
    public static boolean checkUserName(String name){
        if (name.isEmpty()) {
            System.out.print("");
            return false;
        }
        else if (name.contains("_") && name.length() <= 5) {
            
            
            return true;
        } 
        else {
            System.out.println("Username is not correctly formatted; \nplease ensure that your username contains an underscore and is \nno more than five characters in length");
            return false;
        }
    }
    //check if password has correct format
    public static boolean checkPasswordComplexity(String pass) {
        
        int specialChars = 0, lowerChars = 0, upperChars=0, digitChars =0, length;
        char ch;
        length = pass.length();
        
        
            
            if (pass.isEmpty()) {
            System.out.print("");
            return false;
            }
            else if (length < 8) {
                            System.out.println("Password is not correctly formatted; \nplease ensure that your password contains at least eight characters, \na capital letter, a number and a special character.");
            return false;
            }
            else {
                for (int i =0; i < length; i++) {
                    ch= pass.charAt(i);
                    if (Character.isUpperCase(ch)) {
                        upperChars++;
                    }
                    else if (Character.isLowerCase(ch)) {
                        lowerChars++;
                    }
                    else if (Character.isDigit(ch)) {
                        digitChars++;
                    }
                    else {
                        specialChars++;
                    }
                }
            }
            if (upperChars != 0 && digitChars != 0 && specialChars != 0) {
                return true;
            }
            else {
                System.out.println("Password is not correctly formatted; \nplease ensure that the password contains at least eight characters, \na capital letter, a number, and a special character.");
                return false;
            }
            
        }
    //check if phone number has coorect format
    public static boolean checkCellPhoneNumber(String cellNumber) {
        String countryCode = "+27";
        int number;
        if (cellNumber.isEmpty()) {
            System.out.print("");
            return false;
            }
        else {
            number = cellNumber.replace(countryCode, "").length();
                if (cellNumber.contains(countryCode) && number == 9){
                    System.out.println("Cell phone number successfully added.");
                    return true;
                    } 
                else {
                    System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
                    return false;
                }       
            }
        }
        
    public static String registerUser(String name, String pass) {
        if (checkUserName(name) != true) {
            return "The username is incorrectly formatted.";
        }
        else if (checkPasswordComplexity(pass) != true) {
            return "The password does noot meet the complexity requirements.";
            
        }
        else {
            username = name;
            password = pass;
            return "The username and password meet the requirements." + name +  " is successfully registered.";
        }
    }
    public static boolean loginUser(String name, String pass) {
        if (name == null|| name.isEmpty() || pass.isEmpty()) {
            return false;
        } else {
        return name.equals(username) && pass.equals(password);
        }
    }
    public static String returnLoginStatus(String name, String pass) {
        if (loginUser(name, pass) == true) {
            return "Logged in successfully.";
        }
        else {
            return "Login failed. Try again.";
        }
    }
}
