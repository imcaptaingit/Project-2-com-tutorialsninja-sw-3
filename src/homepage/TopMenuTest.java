package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);//navigating to the webpage
    }

    public void selectMenu(String menu) {
        //This method should click on the menu
        List<WebElement> elements = driver.findElements(By.xpath("//nav[@id='menu']"));
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //mouse hover on Desktops and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Desktops']"));

        //call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show All Desktops");
        verifyElements("Desktops", By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"), "correct text");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNoteBooksPageSuccessfully() {
        //Mouse hover on “Laptop & Notebooks” Tab and click
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyElements("Laptops & Notebooks", By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Laptops & Notebooks']"), "correct text");
    }

    @Test
    public void verifyUserShouldNavigateToComponentPageSuccessfully() {

        //3.1 Mouse hover on “Components” Tab and click
        clickOnElement(By.xpath("//a[normalize-space()='Components']"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");

        //3.3 Verify the text ‘Components’
        verifyElements("Components", By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Components']"), "correct text");
    }

    @After
    public void testDown() {
        closeBrowser();
    }

}
