/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TestClasses;

import com.mycompany.quickchat.Login;
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
     
       boolean expected= Login.checkUserName("ka_mo");
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
   @Test
   public void TestIncorrectPassword() {
       boolean expected= Login.checkPasswordComplexity("U$3rN@m3");
       boolean actual= Login.checkPasswordComplexity("password");
       assertEquals(expected, actual);
   }
   @Test
   public void TestCorrectCellphone() {
       boolean expected= Login.checkCellPhoneNumber("+27123456789");
       boolean actual= Login.checkCellPhoneNumber("+27838968976");
       assertEquals(expected, actual);
   }
    @Test
       public void TestIncorrectCellphone() {
       boolean expected= Login.checkCellPhoneNumber("+27123456789");
       boolean actual= Login.checkCellPhoneNumber("08966553");
       assertEquals(expected, actual);
   }
    @Test
       public void TestLoginPass() {
       boolean expected= Login.loginUser(Login.username = "ka_mo", Login.password="U$3rN@m3");
       assertTrue(expected);
   }
    @Test
       public void TestUSERNAME() {
       boolean expected= Login.checkUserName("ka_mo");
       assertTrue(expected);
   }
       public void TestUSERNAMEInc() {
       boolean expected= Login.checkUserName("kyle!!!!");
       assertFalse(expected);
       }
       @Test
       public void TestPassCompl() {
       boolean expected= Login.checkPasswordComplexity("U$3rN@m3");
       assertTrue(expected);
       }
       @Test
       public void TestIncPassCompl() {
       boolean expected= Login.checkPasswordComplexity("password");
       assertFalse(expected);
       }
       @Test
       public void TestPhoneNum() {
       boolean expected= Login.checkPasswordComplexity("+27123456789");
       assertFalse(expected);
       }
       @Test
       public void TestIncPhoneNum() {
       boolean expected= Login.checkCellPhoneNumber("08966553");
       assertFalse(expected);
       }
       
}