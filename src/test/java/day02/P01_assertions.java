package day02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class P01_assertions {
    static WebDriver driver;
    //https://www.bestbuy.com/ Adresine gidin
        //  farkli test method'lari olusturarak asagidaki testleri yapin
        //  ○ Sayfa URL'inin https://www.bestbuy.com/ 'a esit oldugunu test edin
        //  ○ titleTest => Sayfa başlığının "Rest" içermediğini(contains) test edin
        //  ○ logoTest => BestBuy logosunun görüntülendigini test edin
        //  ○ BestBuyOutletLİnkTest => BestBuy Outlet Linkinin aktif olduğunu test edin

    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com");
    }


    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3500);
        driver.quit();
    }

    @Test
    public void test01(){
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.bestbuy.com/";

       assertEquals(expectedUrl,actualUrl);
    }



    @Test
    public void test02(){
        String actualTitle=driver.getTitle();
        String word="Rest";

        assertFalse(actualTitle.contains(word));
    }


    @Test
    public void test03(){
        WebElement logo= driver.findElement(By.xpath("//*[@class='logo']"));
        assertTrue(logo.isDisplayed());

    }

    @Test
    public void test04(){
        driver.findElement(By.xpath("(//img[@alt='United States'])[1]")).click();
        WebElement outletLink=driver.findElement(By.xpath("(//a[@class='universal-nav-link'])[2]"));
        assertTrue(outletLink.isEnabled());
    }

}
