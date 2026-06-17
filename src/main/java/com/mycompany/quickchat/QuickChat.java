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
        ArrayList<String> disregardedMsg = new ArrayList<>();
        
        
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
        
                
        ArrayList<String> storedMsg = Message.readStoredMessages();

        while(Login.loginUser(loginName, loginPass)){
        System.out.println("Welcome to QuickChat \nOption 1) Send Messages \nOption 2) Show recently sent messages. \nOption 3) Quit \nOption 4) Stored Messages \n");
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
                                disregardedMsg.add(msgStr);
                                if (numMessagesSent>0){
                                numMessagesSent--;}
                            }
                            }
                        else if(sendOption == 3){
                            storedMsg.add(msgStr); 
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
            
            else if(option == 4){
                System.out.println("a) Show all recipients\nb) Longest message\nc) Search by ID\nd) Search by recipient\ne) Delete by hash\nf) Report");
                String subOption = scn.nextLine();
    
                if(subOption.equals("a")){
                    for(int i=0; i<msg.size(); i++){
                        System.out.println("Recipient: " + recipients.get(i) + " Message: " + msg.get(i));
                    }
                }
                else if(subOption.equals("b")){
                    String longest = "";
                    for(String m : msg){
                        if(m.length() > longest.length()) longest = m;
                    }
                    System.out.println("Longest message: " + longest);
                }
                else if(subOption.equals("c")){
                    System.out.println("Enter message ID: ");
                    String searchId = scn.nextLine();
                    for(int i=0; i<msgId.size(); i++){
                        if(String.valueOf(msgId.get(i)).equals(searchId)){
                            System.out.println(recipients.get(i) + ": " + msg.get(i));
                        }
                    }
                }
                else if(subOption.equals("d")){
                    System.out.println("Enter recipient number: ");
                    String searchRec = scn.nextLine();
                    for(int i=0; i<recipients.size(); i++){
                        if(recipients.get(i).equals(searchRec)){
                            System.out.println(msg.get(i));
                        }
                    }
                }
                else if(subOption.equals("e")){
                    System.out.println("Enter message hash: ");
                    String searchHash = scn.nextLine();
                    for(int i=0; i<msgHash.size(); i++){
                        if(msgHash.get(i).equals(searchHash)){
                            System.out.println("Message: \"" + msg.get(i) + "\" successfully deleted.");
                            msg.remove(i);
                            msgId.remove(i);
                            msgHash.remove(i);
                            recipients.remove(i);
                            break;
                        }
                    }
                }
                else if(subOption.equals("f")){
                    for(int i=0; i<msg.size(); i++){
                        System.out.println(Message.printMessage(String.valueOf(msgId.get(i)), msgHash.get(i), recipients.get(i), msg.get(i)));
                    }
                }
            }
           
            }
            
        }
       
        
        
    }
    



