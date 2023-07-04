package myaccounts;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;


public class MyAccountTest extends Utility {

        String baseUrl = "http://tutorialsninja.com/demo/index.php?";

        @Before
        public void setUp() {
            openBrowser(baseUrl);
        }

        @Test
        public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
            //1.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
            //“Register”

            //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
            //selectMyAccountOptions("Register");
            Thread.sleep(3000);
            mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Register']"));

            //1.3 Verify the text “Register Account”
            verifyTextElement("Register Account",By.xpath("//h1[contains(text(),'Register Account')]"));

        }
        @Test
        public void verifyUserShouldNavigateToLoginPageSuccessfully()
        {
            //2.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
            mouseHoverAndClickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
            //   2.3 Verify the text “Returning Customer”.

            verifyTextElement("Returning Customer",By.xpath("//h2[normalize-space()='Returning Customer']"));

        }

        @Test
        public void verifyThatUserRegisterAccountSuccessfully()
        {
            //3.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            //Call the method “selectMyAccountOptions” method and pass the parameter
            //“Register
            mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Register']"));
            //Enter First Name
            driver.findElement(By.id("input-firstname")).sendKeys("Sarvat");
            //3.4 Enter Last Name
            driver.findElement(By.id("input-lastname")).sendKeys("Shaikh");
            //3.5 Enter Email
            driver.findElement(By.id("input-email")).sendKeys("iambossy@gmaill.com");
            //3.6. Enter Telephone
            driver.findElement(By.id("input-telephone")).sendKeys("9825868472");
            //3.7 Enter Password
            driver.findElement(By.id("input-password")).sendKeys("iamboss111");
            //3.8. Enter Password Confirm
            driver.findElement(By.id("input-confirm")).sendKeys("iamboss111");
            //3.9. Select Subscribe Yes radio button
            driver.findElement(By.name("newsletter")).click();
            //3.10 Click on Privacy Policy check box
            driver.findElement(By.name("agree")).click();
            //3.11 Click on Continue button
            driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
            //3.12 Verify the message “Your Account Has Been Created!”
            //verifyTextElement("Your Account Has Been Created!",By.xpath("h1[text()='Your Account Has Been Created!']"));

            //3.13 Click on Continue button
            driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
            //3.14 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
            //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
            mouseHoverAndClickOnElement(By.xpath("//a[text()='Logout']"));
            //3.16 Verify the text “Account Logout”
            verifyTextElement("Logout",By.xpath(""));
            //3.17 Click on Continue button
            mouseHoverAndClickOnElement(By.xpath("Logout"));

            verifyTextElement("Account Logout",By.xpath("//h1[text()='Account Logout']"));


        }

        @Test
        public void verifyThatUserShouldLoginAndLogoutSuccessfully()
        {
            //4.1 Click on My Account Link.
            clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

            // 4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
            mouseHoverAndClickOnElement(By.xpath("//a[text()='Login']"));
            //  4.3. Enter Email address
            driver.findElement(By.id("input-email")).sendKeys("iambossy@gmaill.com");
            //
            //4.5 Enter Password
            driver.findElement(By.id("input-password")).sendKeys("iamboss111");
            //4.6 Click on Login button
            clickOnElement(By.xpath("//input[@value='Login']"));
            //4.7. Verify text “My Account”
            verifyTextElement("My Account",By.xpath("//h2[contains(text(),'My Account')]"));
            //4.8 Click on My Account Link.
            clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='My Account']"));

            //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
            clickOnElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
            //   4.10 Verify the text “Account Logout”
            verifyTextElement("Account Logout",By.xpath("//h1[contains(text(),'Account Logout')]"));
            // 4.11 Click on Continue button
            clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        }
    }
