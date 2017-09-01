package javaclasses.JUnittester;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MyTests {
    @Test

    public void testJunit(){
        String str="Junit is working fine";
        assertEquals("Junit is working fine",str);
    }
}
