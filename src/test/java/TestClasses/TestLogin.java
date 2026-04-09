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
    
   @Test
   public void TestCorrectUserName() {
     
       boolean expected= Login.checkUserName("ka_mo");
       boolean actual = Login.checkUserName("kyl_1");
       assertEquals(expected, actual);
   }
    
   @Test
   public void TestIncorrectUserName() {
     
       boolean expected= Login.checkUserName("ka_mo");
       boolean actual = Login.checkUserName("kyle!!!!!!!!");
       assertEquals(expected, actual);
   }
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
       public void TestLoginIncName() {
       boolean expected= Login.loginUser("kyle!!!!!!!", Login.password="U$3rN@m3");
       assertFalse(expected);
   }
       public void TestLoginIncPass() {
       boolean expected= Login.loginUser(Login.username="ka_mo", "password");
       assertFalse(expected);
       }
       @Test
       public void TestLoginEmpty() {
       boolean expected= Login.loginUser("","");
       assertFalse(expected);
       }
       @Test
       public void TestLoginNull() {
       boolean expected= Login.loginUser(null,null);
       assertFalse(expected);
       }
       @Test
       
}