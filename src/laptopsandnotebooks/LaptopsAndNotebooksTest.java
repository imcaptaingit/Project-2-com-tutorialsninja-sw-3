package laptopsandnotebooks;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = ("http://tutorialsninja.com/demo/index.php?");

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //1.2 Click on Show All Laptops & Notebooks
        // selectMenu("Show AllLaptops & Notebooks");

        //1.3 Select Sort By "Price (High > Low)"
        selectFromDropDownMenu(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 Click on show All Laptops & Notebooks
        //selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        //selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product â€œMacBook
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //2.5 Verify the text â€œMacBook
        verifyTextElement("MacBook", By.xpath("//h1[normalize-space()='MacBook']"));

        //2.6 Click on ×˜Add To Cart button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message Success: You have added MacBook to your shopping cart!
        verifyTextElement("Success: You have added MacBook to your shopping cart!\n" +
                "×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        // 2.8 Click on link shopping cart display into the success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.9 Verify the text "Shopping Cart"
        verifyTextElement("Shopping Cart  (0.00kg)", By.xpath("//h1[contains(text(),'Shopping Cart')]"));

        //2.10 Verify the Product name "MacBook"
        verifyTextElement("MacBook", By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > a:nth-child(1)"));

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");

        //2.12 Click on Update Tab
        clickOnElement(By.xpath("//button[@type='submit']"));

        //2.13 Verify the message Success: You have modified your shopping cart!
        verifyTextElement("Success: You have modified your shopping cart!\n" +
                "×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.14 Verify the Total $1,204.00
        verifyTextElement("$1,204.00", By.xpath("//tbody/tr[1]/td[6]"));


        //2.15 Click on Checkout button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.16 Verify the text Checkout
        verifyTextElement("Checkout", By.xpath("//h1[contains(text(),'Checkout')]"));

        //2.17 Verify the Text Customer
        verifyTextElement("New Customer", By.xpath("//h2[contains(text(),'New Customer')]"));

        //2.18 Click on the Guest Checkout button
        clickOnElement(By.xpath("//input[@value='guest']"));

        //2.19 Click on Continue tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Sarvat");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Shaikh");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "iambossy@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "9825868472");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "283 High Road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "E11 4HH");
        selectFromDropDownMenu(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectFromDropDownMenu(By.xpath("//select[@id='input-payment-zone']"), "Kent");

        //2.21 Click on Continue Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into the text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Thank you for the service. Please make sure it has the drivers pre-installed.");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]"));

        //2.24 Click on the Continue button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message Warning: Payment method required!
        verifyTextElement("Warning: No Payment options are available. Please contact us for assistance!", By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]"));
        Thread.sleep(3000);
    }

    public void tearDown() {
        driver.close();
    }
}