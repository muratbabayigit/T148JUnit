package day01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class P01_TestNotation {

    @Test
    public void testC() {
        System.out.println("Test C Çalıştı");
    }

    @Test
    public void testA(){
        System.out.println("Test A Çalıştı");
    }

    @Test @Disabled
    public void testB(){
        System.out.println("Test B Çalıştı");
    }
}
