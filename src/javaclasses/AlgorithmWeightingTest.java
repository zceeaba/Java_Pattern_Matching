package javaclasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class AlgorithmWeightingTest {
    public AlgorithmWeighting aw=new AlgorithmWeighting("University of Birmingham","Birmingham University");

    @Before
    public void setUp() throws Exception {
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getscore() throws Exception {
        ArrayList<Integer> mainlist = new ArrayList<Integer>(Arrays.asList(2, 3, 1, 0));
        assertEquals("output should be", 5, aw.getscore());
    }
}