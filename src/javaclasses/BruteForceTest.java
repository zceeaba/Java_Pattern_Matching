package javaclasses;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class BruteForceTest {
    public BruteForce bf=new BruteForce();;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void computeBruteForce() throws Exception {
        ArrayList<Integer> set=new ArrayList<Integer>();
        set.add(0);
        ArrayList<Integer> cherset=new ArrayList<Integer>(Arrays.asList(2,3,1,0));
        Set<ArrayList<Integer>> mainset=new HashSet<ArrayList<Integer>>(Arrays.asList(set,cherset));
        //Using an assertEquals statement to compare the return valuew of the function with a set
        assertEquals("output should be",mainset,bf.computeBruteForce("University of Birmingham","Birmingham University"));
        //assertEquals("output should be",mainset,bf.computeBruteForce("Tom Griffin","Tom Ggriffin"));
        //assertEquals("output should be",mainset,bf.computeBruteForce("William David","David William"));

        //Can also compare using an assertTrue statement to check that the two sets are equal
    }

}
