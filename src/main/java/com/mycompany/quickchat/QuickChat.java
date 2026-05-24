/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.Scanner;

/**
 *
 * @author kamot
 */

class message{
    
}
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
        int numMessage =0;
        int option;
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
        //login
        while(Login.loginUser(loginName, loginPass) == false) {
            
            System.out.println("Please enter login details \nEnter username: ");
            loginName = scn.nextLine();
            System.out.println("Enter password: ");
            loginPass= scn.nextLine();
            System.out.println(Login.returnLoginStatus(loginName,loginPass));
        }
        
        while(Login.loginUser(loginName, loginPass)){
        System.out.println("Welcome to QuickChat \nOption 1) Send Messages \nOption 2) Show recently sent messages - This feature is is still under development. \nOption 3) Quit \n");
        option = scn.nextInt();
           
        
            if (option == 1){
              System.out.print("How many message do you wish to send: ");
              numMessage = Integer.parseInt(scn.nextLine());
              
            }
            else if (option == 2){
                System.out.println("COMING SOON! \n");
            }
           
            else if ( option == 3){
                System.out.println("Bye!");
                loginName= "";
                loginPass="";
            }
    
            else {
                int i = 0;
                while(i<option) {
                   i++;
                System.out.println("why");
            }
                
            }
            
        }
       
        
        
    }
    
}
