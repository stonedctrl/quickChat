/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.quickchat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;



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
        int numMessage ;
        String msgStr;
        ArrayList<String>  msg= new ArrayList<>();
        ArrayList<Long> msgId = new ArrayList<>();
        ArrayList<String> msgHash = new ArrayList<>();
        ArrayList<String> recipients = new ArrayList<>();
        
        int option;
        int numMessagesSent=0;
        
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
        option = Integer.parseInt(scn.nextLine());
           
        
            if (option == 1){
                System.out.println("Enter recipient phone number");
                String recipientNumber = scn.nextLine();
                while(!Login.checkCellPhoneNumber(recipientNumber)){
                Message.checkRecipientCell(recipientNumber);
                recipientNumber = scn.nextLine();
    }
              
                    
                   
                
              System.out.print("How many message do you wish to send: ");
              numMessage = Integer.parseInt(scn.nextLine());
              
               
              for (int i =0; i<numMessage; i++){
                  System.out.println("Enter message: ");
                  msgStr = scn.nextLine();
                  if (msgStr.length()<250){
                    
                    long min = 1_000_000_000L;
                    long max = 10_000_000_000L;
                    long randomNum = ThreadLocalRandom.current().nextLong(min, max);
                    


                    while(msgId.contains(randomNum)){
                        randomNum = ThreadLocalRandom.current().nextLong(min, max);
                        

                    }
                    String rand = String.valueOf(randomNum);
                    String hash= Message.createMessageHash(rand, numMessagesSent, msgStr);

                    if(Message.checkMessageId(rand)){
                        msgId.add(randomNum);
                        msg.add(msgStr);
                        recipients.add(recipientNumber);
                        msgHash.add(hash);
                        numMessagesSent++;
                    }
                        
                        int sendOption = 0;
                        while(sendOption < 1 || sendOption > 3){
                            System.out.println("Option 1) Send Message \nOption 2) Disregard Message \nOption 3) Store Message to send later");
                            sendOption = Integer.parseInt(scn.nextLine());
                }       
                            System.out.println(Message.sentMessage(sendOption, msg, msgId, msgHash));
                           
                        if (sendOption == 1){
                            
                            
                            System.out.println(Message.printMessage(rand, hash, recipientNumber, msgStr));
                            
                        }
                        else if(sendOption==2){
                            String confirm = scn.nextLine();
                            if(confirm.equals("0")){
                                System.out.println("Message deleted.");
                                if (numMessagesSent>0){
                                numMessagesSent--;}
                            }
                            }
                        else if(sendOption == 3){
                            Message.storeMessage(rand, hash, recipientNumber, msgStr);
}
                           

                        
                  } 
                  else {
                    System.out.println("Please enter a message of less than 250 characters.");
                    i--;

                  }
                  
              }
              System.out.println("Total messages sent: " + Message.returnTotalMessages(numMessagesSent));
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
