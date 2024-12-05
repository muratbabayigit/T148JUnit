package day01;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03_signInTesti {
    static WebDriver driver;
/*
        1-https://babayigit.net/test/ adresine gidin
        2-Login butonuna tıklayın
        3-Username kısmına “babayigit” yazdırın
        4-Password kısmına baba123 yazdırın
        5-Login butonuna tıklayın
        6-Başarılı giriş yapılamadığını doğrulayın
        7-Login Sayfasında kullanıcı adına "babayigit" Pasword kısmına “Mb3471&” yazdırın.
        8-Login butonuna tıklayın
        9-Başarılı giriş yapıldığını doğrulayın
        10-Sayfayı kapatın
*/

    @BeforeAll
    public static void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    @BeforeEach
    public void girisEkrani(){
        driver.get("https://www.babayigit.net/test");
        driver.findElement(By.xpath("//img[@src='img/login.png']")).click();
    }

    @AfterEach
    public void testBitir(){
        System.out.println("\nTest Tamamlandı\n");
    }

    @Test
    public void negativeLogin(){
        driver.findElement(By.id("username")).sendKeys("babayigit");
        driver.findElement(By.id("password")).sendKeys("baba123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String expectedMessage="The username or password is incorrect.";
        String actualMessage=driver.findElement(By.id("result")).getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println("Giriş Yapılamadı. Bilgi Hatası Var.\nThe username or password is incorrect.");
        }

    }

    @Test
    public void PositiveLogin(){
        driver.findElement(By.id("username")).sendKeys("babayigit");
        driver.findElement(By.id("password")).sendKeys("Mb3471&");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String expectedMessage="Successful entry!";
        String actualMessage=driver.findElement(By.id("result")).getText();

        if (actualMessage.equals(expectedMessage)){
            System.out.println("Giriş Yapıldı.\nSuccessful entry!");
        }

    }



}
