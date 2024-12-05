package day01;

import org.junit.jupiter.api.*;

public class P02_testNotation {

    @BeforeAll
    public static void setUp(){
        System.out.println("Test Süreci Başlatılıyor");
    }


    @AfterAll
    public static void tearDown(){
        System.out.println("Test Süreci Tamamlandı...");

    }

    @BeforeEach
    public void beforeTest(){
        System.out.println("Sıradaki Test Çalıştırılıyor\n");
    }
    @AfterEach
    public void afterTest(){
        System.out.println("\nBir Test scope'u tamamlandı. Varsa diğer scope çalışacak");
    }



    @Test
    public void asuman(){
        System.out.println("Asuman Çoban\nQA Engineer\n\n");
    }

    @Test
    public void oguzhan(){
        System.out.println("O.Melih Güçlü\nQA Engineer\n\n");
    }

    @Test
    public void hamza(){
        System.out.println("Hamza KAVAS\nQA Engineer\n\n");
    }
}
