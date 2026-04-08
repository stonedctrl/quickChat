/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.Scanner;
import com.mycompany.quickchat.Login;

/**
 *
 * @author kamot
 */
public class QuickChat {

    /**
     * @param args the command line arguments 
     */
    
        
        
        
    
    public static void main(String[] args) {
        // TODO code application logic here'
        //scanner
        Scanner scn = new Scanner(System.in);
       
        
        //varables
        String name = "";
        String password = "";
        String cellNumber = "";
        String loginName = "";
        String loginPass = "";
        //username input
        while(Login.checkUserName(name) == false) {
            System.out.println("Enter a username: ");
            name = scn.nextLine();  
        }
        System.out.println("Username successfully captured.");
        //password input
        while(Login.checkPasswordComplexity(password) == false) {
            System.out.println("Enter a password: ");
            password = scn.nextLine();
        }
        System.out.println("Password successfully captured");
        //cellphone number input
        while(Login.checkCellPhoneNumber(cellNumber) == false) {
            System.out.println("Enter a cell phone number: ");
            cellNumber = scn.nextLine();
        }
        System.out.println(Login.registerUser(name, password));
        
        while(Login.loginUser(loginName, loginPass) == false) {
            
            System.out.println("Please enter login details \nEnter username: ");
            loginName = scn.nextLine();
            System.out.println("Enter password: ");
            loginPass= scn.nextLine();
            System.out.println(Login.returnLoginStatus(loginName,loginPass));
        }
        
    }
    
}
