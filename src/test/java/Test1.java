import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test1 {

    public static WebDriver driver;
    public static Search search;
    public static WebDriverWait wait;

    @Before
    public void Begin() {
        System.setProperty("webdriver.chrome.driver", "/Users/juli/Desktop/chromedriver");
        driver = new ChromeDriver();

        search = new Search(driver);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");
    }


    @Test
    public void Test1() throws InterruptedException {
        driver.findElement(By.cssSelector("[data-id='market']")).click();
        for (String nextPage : driver.getWindowHandles()) {
            driver.switchTo().window((nextPage));
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Компьютеры"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ноутбуки"))).click();

        driver.findElement(By.id("glpricefrom")).sendKeys("10000");
        driver.findElement(By.id("glpriceto")).sendKeys("30000");

        search.choose();
        search.choose1();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ie) {

        }
        WebElement button = driver.findElement(By.xpath("//button[@class='vLDMfabyVq']"));
        try {
            button.click();
        }
        catch (Exception e) {
            System.out.println("Element not clicked");
        }

        driver.findElement(By.xpath("//button[@class='_1YeOF5Jcfi _35PaznpQ-g']")).click();

        String namePc = search.name();
        driver.findElement(By.id("header-search")).sendKeys(namePc);
        driver.findElement(By.xpath("//button[@class='_1XiEJDPVpk']")).click();

        String newNamePc = search.name();
        if (namePc != newNamePc) {
            System.out.println("Wrong name or value");
        }
    }
}

