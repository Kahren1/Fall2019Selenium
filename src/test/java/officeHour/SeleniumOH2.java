package officeHour;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {
    public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://automationpractice.com");
    WebElement search_box= driver.findElement(By.id("search_query_top"));
    //WebElement = interface in Selenium/Java and it has many useful methods
        //.sendkeys - WebElement method
        search_box.sendKeys("T-shirt" + Keys.ENTER);
Thread.sleep(3000);
search_box.clear();
        //WebElement error = driver.findElement(By.xpath("//p[@class ='alert alert-warning'));
        //String errorText = error.getText();
        //System.out.println(errorText);
        Thread.sleep(2000);
        WebElement count = driver.findElement(By.className("product-count"));
        System.out.println(count.getText());
        driver.quit();



    }
}
