package desktops;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class DesktopTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        WebElement sortByElement = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortByElement);
        select.selectByVisibleText("Name (Z - A)");
        mouseHoverAndClickOnElement(By.xpath("//select[@id='input-sort']"));

        //selectByVisibleTextFromDropDown(By.linkText("Name (Z - A)"));
        selectFromDropDownMenu(By.xpath("//option[contains(text(),'Name (Z - A)')]"), "Name (Z - A");
        //1.4 Verify the Product will arrange in Descending order
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on the Desktop Tab. and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        mouseHoverAndClickOnElement(By.xpath("//select[@id='input-sort']"));
        //2.3 Select Sort By position "Name: A to Z
        Thread.sleep(3000);
        //2.3 Select Sort By position "Name: A to Z"
        WebElement sortByElement = driver.findElement(By.xpath("//select[@id='input-sort']"));
        Select select = new Select(sortByElement);
        select.selectByVisibleText("Name (A - Z)");
        //selectByVisibleTextFromDropDown(By.xpath("//option[contains(text(),'Name (A - Z)')]"),"Name (A - Z)");

        //2.4 Select product “HP LP3065”
        driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).click();
        //2.5 Verify the Text "HP LP3065"
        verifyTextElement("HP LP3065", By.xpath("//h1[contains(text(),'HP LP3065')]"));
        //2.6 Select Delivery Date "2022-11-30"
        Thread.sleep(5000);

        String month = "November";
        String year = "2022";
        String date = "30";


        driver.findElement(By.xpath("//i[@class='fa fa-calendar']")).click();
        Thread.sleep(3000);
        while (true) {
            String monthYear = driver.findElement(By.xpath("//th[normalize-space()='April 2011']")).getText();
            // System.out.println(monthYear);
            //break;

            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equals(year)) {
                break;

            } else {
                driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]")).click();
            }
        }

            driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
            // 2.7.Enter Qty '1' using Select class
            sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

            //2.8 Click on “Add to Cart” button
            clickOnElement(By.xpath("//button[@id='button-cart']"));

            // 2.9 Verify the Message “Success:
            verifyTextElement("Success: You have added HP LP3065 to your shopping cart!\n" +
                    "×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

            //You have added HP LP3065 to your shopping cart !”
            //2.10 Click on link “shopping cart” display into the success message
            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
//2.11 Verify the text "Shopping Cart"
            verifyTextElement("Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"));

            // 2.12 Verify the Product name "HP LP3065"
            verifyTextElement("HP LP3065", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

            // 2.13 Verify the Delivery Date "2022-11-30"
            verifyTextElement("Delivery Date:2022-11-30", By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));

            // 2.14 Verify the Model "Product21"
            verifyTextElement("Product 21", By.xpath("//td[contains(text(),'Product 21')]"));

            //2.15 Verify the Todat "£74.73"
            verifyTextElement("$122.00", By.xpath("//tbody/tr[1]/td[6]"));

        }
    }





