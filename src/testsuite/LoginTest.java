package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    //Declaring BaseURL
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        // Verify the text “Secure Area”
        String expected = "Secure Area";
        String actual = driver.findElement(By.xpath("//div[@class = 'example']//h2[text() = ' Secure Area']")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        // Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        //Verify the error message “Your username is invalid!”
        String expected = "Your username is invalid!\n" + "×";
        String actual = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText();
        Assert.assertEquals(expected,actual);


    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        // Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
        // Verify the error message “Your password is invalid!”
        String expected = "Your password is invalid!\n" + "×";
        String actual = driver.findElement(By.xpath("//div[@class = 'flash error']")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
