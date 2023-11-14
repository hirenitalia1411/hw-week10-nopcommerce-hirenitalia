package nopcommerce;
/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url. “https://demo.nopcommerce.com/login?returnUrl=%2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NopCommerce {

    static String baseUrl = "https://demo.nopcommerce.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {

        // Step 1: Setup browser
        if (browser.trim().equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }

        // Step 2: Open URL
        driver.get(baseUrl); // open the URL in the browser
        driver.manage().window().maximize(); // maximize the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000)); // wait for 5 seconds to load the page

        // Step 3: Print title of the page
        String titleOfPage = driver.getTitle();
        System.out.println("Title of the page: " + titleOfPage);

        // Step 4: Print the current URL
        String currentPageUrl = driver.getCurrentUrl();
        System.out.println("The Current Page URL: " + currentPageUrl);

        // Step 5: Print the page resource
        System.out.println(driver.getPageSource());

        // Step 6: Navigate to Login URL
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);

        // Step 7: Print the current URL
        System.out.println("The Current Page URL: " + driver.getCurrentUrl());

        // Step 8: Navigate back to the home page (using back button on the browser)
        driver.navigate().back();

        // Step 9: Navigate to the login page (using forward button on the browser)
        driver.navigate().forward();

        // Step 10: Print the current URL
        System.out.println("The Current Page URL: " + driver.getCurrentUrl());

        // Step 11: Refresh the page (using refresh button on the browser)
        driver.navigate().refresh();

        // Step 12: Enter email to the email field
        driver.findElement(By.id("Email")).sendKeys("hiren.italia@gmail.com");

        // Step 13: Enter password to the password field
        driver.findElement(By.id("Password")).sendKeys("Hiren123");

        // Step 14: Click on login button
        driver.findElement(By.cssSelector(".login-button")).click();

        // Step 15: Close the browser
        driver.quit();

    }
}