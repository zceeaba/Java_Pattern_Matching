package javaclasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class hashingTest {
    public hashing hash=new hashing();;
    private String txt="GEEKS FOR GEEKS";
    private String pat="GEEK";
    private int q=101;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void computehashing() throws Exception {
        assertEquals("output should be",10,hash.computehashing("BRIAN","O'BRIEN",101));
    }

}