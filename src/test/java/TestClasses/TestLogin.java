/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;
import java.util.ArrayList;
import com.mycompany.quickchat.Login;
import com.mycompany.quickchat.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kamot
 */
public class TestLogin {
    //tests if the user name is formatted correctly= true
   @Test
   public void TestCorrectUserName() {
     
       boolean expected= Login.checkUserName("ka_mo");
       boolean actual = Login.checkUserName("kyl_1");
       assertEquals(expected, actual);
   }
    //tests if the user name is formatted correctly = false
   @Test
   public void TestIncorrectUserName() {
     
       boolean expected= Login.checkUserName("ka_mo0");
       boolean actual = Login.checkUserName("kyle!!!!!!!!");
       assertEquals(expected, actual);
   }
   //tests if password is formatted correctly = true
   @Test
   public void TestCorrectPassword() {
       boolean expected= Login.checkPasswordComplexity("U$3rN@m3");
       boolean actual= Login.checkPasswordComplexity("Ch&&sec@ke99!");
       assertEquals(expected, actual);
   }
   //tests if password is formatted correctly = false
   @Test
   public void TestIncorrectPassword() {
       boolean expected= Login.checkPasswordComplexity("Username");
       boolean actual= Login.checkPasswordComplexity("password");
       assertEquals(expected, actual);
   }
   //tests if phone number is formatted correctly = true
   @Test
   public void TestCorrectCellphone() {
       boolean expected= Login.checkCellPhoneNumber("+27123456789");
       boolean actual= Login.checkCellPhoneNumber("+27838968976");
       assertEquals(expected, actual);
   }
   //tests if phone number is formatted correctly = false
    @Test
       public void TestIncorrectCellphone() {
       boolean expected= Login.checkCellPhoneNumber("+2712345678");
       boolean actual= Login.checkCellPhoneNumber("08966553");
       assertEquals(expected, actual);
   }
    //tests if user exists = true
    @Test
       public void TestLoginPass() {
       boolean expected= Login.loginUser(Login.username = "ka_mo", Login.password="U$3rN@m3");
       assertTrue(expected);
   }
    @Test
       public void TestLoginFail() {
       boolean expected= Login.loginUser(Login.username = "kamo", Login.password="U$3rN@m3");
       assertFalse(expected);
   }
       //tests if username format is correct = true
    @Test
       public void TestUSERNAME() {
       boolean expected= Login.checkUserName("ka_mo");
       assertTrue(expected);
   }
       //tests if username format is correct = false
       @Test
       public void TestUSERNAMEInc() {
       boolean expected= Login.checkUserName("kyle!!!!");
       assertFalse(expected);
       }
       //tests if password format is correct = true
       @Test
       public void TestPassCompl() {
       boolean expected= Login.checkPasswordComplexity("U$3rN@m3");
       assertTrue(expected);
       }
        //tests if password format is correct = false
       @Test
       public void TestIncPassCompl() {
       boolean expected= Login.checkPasswordComplexity("password");
       assertFalse(expected);
       }
        //tests if phone number format is correct = true
       @Test
       public void TestPhoneNum() {
       boolean expected= Login.checkCellPhoneNumber("+27123456789");
       assertTrue(expected);
       }
       //tests if phone number format is correct = false
       @Test
       public void TestIncPhoneNum() {
       boolean expected= Login.checkCellPhoneNumber("08966553");
       assertFalse(expected);
       }
       
       @Test
       public void TestAmountChar() {
           String expected = "A short message";
           String actual="Hi Mike, can you join us for dinner tonight?";
           assertEquals(expected.length()<250, actual.length()<250);
       }
       
       @Test
       public void TestIncAmountChar() {
           String expected ="A looooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooong message"
;
           String actual="Hi Mike, can yooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooou join us for dinner tonight?";
           assertEquals(expected.length()>250, actual.length()>250);
       }
       
       @Test
       public void TestRecipientCell() {
       boolean expected= Login.checkCellPhoneNumber("+27123456789");
       boolean actual= Login.checkCellPhoneNumber("+27838968976");
       assertEquals(expected, actual);
   }
   //tests if phone number is formatted correctly = false
       @Test
       public void TestIncorrectRecipientCell() {
       boolean expected= Login.checkCellPhoneNumber("12345678");
       boolean actual= Login.checkCellPhoneNumber("08966553");
       assertEquals(expected, actual);
       }
       
       @Test
       public void TestMessageHash(){
           String expected = Message.createMessageHash("6266735257",00,"Hi Mike, can you join us for dinner tonight?");
           String actual = Message.createMessageHash("6266735257",00,"Hi Mike, can you join us for dinner tonight?");
           assertEquals(expected,actual);
       }
       @Test
       public void TestIncHash(){
           String expected = Message.createMessageHash("66735257",00,"Hi Mike, can you join us for dinner tonight?");
           String actual = Message.createMessageHash("6266735",1,"Hi Mike, dinner tonight?");
           assertNotEquals(expected,actual);
       }
       
       @Test
       public void TestMessageID(){
           String rand = "7086382488";
           String actual = "Message ID generated: 7086382488";
           String expected= Message.generateMessageIDMessage(rand);
           assertEquals(expected, actual);
           
       }
       
       @Test
       public void TestSendMessage1(){
            ArrayList<String> msg = new ArrayList<>();
            ArrayList<Long> msgId = new ArrayList<>();
            ArrayList<String> msgHash = new ArrayList<>();
            msg.add("Hi Mike, can you join us for dinner tonight?");
            msgId.add(7086382488L);
            msgHash.add("70:0:HITONIGHT");
            String expected = "Message successfully sent.";
            String actual = Message.sentMessage(1, msg, msgId, msgHash);
            assertEquals(expected, actual);
}       
       @Test
       public void TestSendMessage2(){
            ArrayList<String> msg = new ArrayList<>();
            ArrayList<Long> msgId = new ArrayList<>();
            ArrayList<String> msgHash = new ArrayList<>();
            msg.add("Hi Mike, can you join us for dinner tonight?");
            msgId.add(7086382488L);
            msgHash.add("70:0:HITONIGHT");
            String expected = "Press 0 to delete the message.";
            String actual = Message.sentMessage(2, msg, msgId, msgHash);
            assertEquals(expected, actual);}
        @Test
        public void TestSendMessage3(){
            ArrayList<String> msg = new ArrayList<>();
            ArrayList<Long> msgId = new ArrayList<>();
            ArrayList<String> msgHash = new ArrayList<>();
            msg.add("Hi Mike, can you join us for dinner tonight?");
            msgId.add(7086382488L);
            msgHash.add("70:0:HITONIGHT");
            String expected = "Message successfully stored.";
            String actual = Message.sentMessage(3, msg, msgId, msgHash);
            assertEquals(expected, actual);
}
        @Test
        public void TestSentArray(){
            ArrayList<String> sentMessages = new ArrayList<>();
            sentMessages.add("Did you get the cake?");
            sentMessages.add("It is dinner time!");
            assertEquals("Did you get the cake?", sentMessages.get(0));
            assertEquals("It is dinner time!", sentMessages.get(1));
        }

        @Test
        public void TestLongestMessage(){
            ArrayList<String> messages = new ArrayList<>();
            messages.add("Did you get the cake?");
            messages.add("Where are you? You are late! I have asked you to be on time.");
            messages.add("Yohoooo, I am at your gate.");
            messages.add("It is dinner time!");
            String longest = "";
            for(String m : messages){
                if(m.length() > longest.length()) longest = m;
            }
            assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
        }

        @Test
        public void TestSearchRecipient(){
            ArrayList<String> messages = new ArrayList<>();
            ArrayList<String> recipients = new ArrayList<>();
            messages.add("Where are you? You are late! I have asked you to be on time.");
            messages.add("Ok, I am leaving without you.");
            recipients.add("+27838884567");
            recipients.add("+27838884567");
            ArrayList<String> results = new ArrayList<>();
            for(int i=0; i<recipients.size(); i++){
                if(recipients.get(i).equals("+27838884567")) results.add(messages.get(i));
            }
            assertEquals(2, results.size());
        }

        @Test
        public void TestDeleteByHash(){
            ArrayList<String> messages = new ArrayList<>();
            ArrayList<String> hashes = new ArrayList<>();
            messages.add("Where are you? You are late! I have asked you to be on time.");
            hashes.add("62:1:WHERETIME");
            int indexToDelete = hashes.indexOf("62:1:WHERETIME");
            String deleted = messages.get(indexToDelete);
            messages.remove(indexToDelete);
            hashes.remove(indexToDelete);
            assertEquals("Where are you? You are late! I have asked you to be on time.", deleted);
            assertEquals(0, messages.size());
        }
}
