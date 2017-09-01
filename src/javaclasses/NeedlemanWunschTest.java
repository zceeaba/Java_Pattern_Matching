package javaclasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NeedlemanWunschTest {
    public NeedlemanWunsch needlemanWunsch=new NeedlemanWunsch();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void computeNeedle() throws Exception {
    }

    @Test
    public void preprocessmatrix() throws Exception {
    }

    @Test
    public void scoringscheme() throws Exception {
    }

    @Test
    public void choosebest() throws Exception {
    }

    @Test
    public void storescoredirection() throws Exception {
        assertEquals("output should be",2,needlemanWunsch.computeNeedle("Tom Griffin","Tom Greffen"));
    }

}