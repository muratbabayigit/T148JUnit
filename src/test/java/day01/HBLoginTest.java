package day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;

import java.time.Duration;


public class HBLoginTest {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void tearDown() {
       // driver.quit();
    }

    @BeforeEach
    public void LoginTesti() {
        driver.get("https://www.hepsiburada.com");
        driver.findElement(By.xpath("//*[@data-test-id='account']")).click();
        driver.findElement(By.xpath("//a[@id='login']")).click();
    }

    @AfterEach
    public void afterTest() {
        driver.findElement(By.id("myAccount")).click();
        driver.findElement(By.xpath("(//*[@rel='nofollow'])[17]")).click();
    }

    @Test
    public void girisTesti() {
        driver.findElement(By.id("txtUserName")).sendKeys("uyelik@babayigit.net");
        driver.findElement(By.id("txtPassword")).sendKeys("Ps7hDbPv");
        driver.findElement(By.id("btnLogin")).click();

    }
}