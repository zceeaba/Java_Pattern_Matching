package javaclasses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LevenshteinDistanceTest {
    private String stringa;
    private String stringb;
    private int expectedresult;
    private LevenshteinDistance tester;

    public LevenshteinDistanceTest(String a, String b, int expected) {
        this.stringa = a;
        this.stringb = b;
        this.expectedresult = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"Damsel", "Hamlet", 3},
                {"dog", "cat", 3},
                {"Abhishekh", "Absheikh", 3},
                {"Griffin", "GrifFin", 0},
                {"O'Brien", "OBrien", 1},
                {"O'Brien", "Brien", 2},
                {"University of Birmingham", "Birmingham University", 14}
        });
    }

    @Before
    public void setUp() throws Exception {
        tester = new LevenshteinDistance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void computeLevenshtein() throws Exception {
        assertEquals("output should be ", expectedresult, tester.computeLevenshtein(stringa, stringb));
        Assert.assertTrue(true);
    }

    @Test
    public void getminimum() throws Exception {
        assertEquals("output should be 3", 3, tester.getminimum(2, 4, 1, 3));
    }

    @Test
    public void mapiterate() throws Exception {
    }

}