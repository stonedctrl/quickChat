/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kamot
 */
public class Message{
     static String checkRecipientCell(String cellNumber) {
        String countryCode = "+27";
        int number;
        if (cellNumber.isEmpty()) {
            
            return "";
            }
        else {
            number = cellNumber.replace(countryCode, "").length();
                if (cellNumber.contains(countryCode) && number == 9){
                    System.out.println("Cell phone number successfully added.");
                    return "Cell phone number successfully added.";
                    } 
                else {
                    System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
                    return "Cell phone number incorrectly formatted or does not contain international code.";
                }       
            }
        }
     public static boolean checkMessageId(String msgId){
         
             return msgId.length()==10;
     }
     public static String createMessageHash(String msgId, int numMsgSent, String msg){
         String firstTwo =msgId.substring(0, 2);
         String words[]=msg.trim().split(" ");
         String firstWord= words[0];
         String lastWord=words[words.length - 1];
         
         
         String messageHash = (firstTwo + ":" + numMsgSent +":" + firstWord +lastWord).toUpperCase();
         return messageHash;
     }
     public static String sentMessage(int option, ArrayList<String> msg,ArrayList<Long> msgId,ArrayList<String> msgHash){
         
        if(option == 1) return "Message successfully sent.";
        else if(option == 2) {
            
            msg.remove(msg.size()-1);
            msgId.remove(msgId.size()-1);
            msgHash.remove(msgHash.size()-1);
            
    
            return "Press 0 to delete the message.";
        }
        else if(option == 3) return "Message successfully stored.";
        else return "Invalid option.";
}
     public static String printMessage(String rand, String hash, String recipientNumber, String msgStr){
          return "ID: " + rand + "\nHash: " + hash + "\nRecipient: " + recipientNumber + "\nMessage: " + msgStr;
}
     public static int returnTotalMessages(int numMessagesSent){
         return numMessagesSent;
     }

     public static void storeMessage(String rand, String hash, String recipient, String msgStr) {
        Gson gson = new Gson();
    String[] messageData = {rand, hash, recipient, msgStr};
    String json = gson.toJson(messageData);
    
    try(FileWriter writer = new FileWriter("storedMessages.json", true)){
        writer.write(json + "\n");
    } catch(IOException e){
        System.out.println("Error storing message.");
    }
     }
}

































































































