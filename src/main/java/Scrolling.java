import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.List;

public class Scrolling {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the WebDriver object for the Edge browser
        WebDriver driver = new EdgeDriver();
        // Navigate to the given URL using the WebDriver object
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Initialize the JavascriptExecutor object and cast it to the WebDriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll the window to the specified location using the JavascriptExecutor object
        js.executeScript("window.scroll(0,500)");
        // Pause the execution of the script for 3 seconds
        Thread.sleep(3000);
        // Scroll the table to the specified location using the JavascriptExecutor object
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        // Find all the elements with the given CSS selector and store them in a List
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        // Initialize the sum variable
        int sum = 0;
        // Loop through the List of elements and sum up their integer values
        for (int i = 0; i < values.size(); i++) {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }
        // Extract the total amount from the specified element using the given CSS selector and convert it to an integer
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        // Check if the sum of the values is equal to the total amount
        Assert.assertEquals(sum, total);

    }
}
