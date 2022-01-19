package lecture7;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {
    /** Tests the Sort.sort method. */
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        //for (int i = 0; i < input.length; i += 1) {
        //    if (!input[i].equals(expected[i])) {
        //        System.out.println("Mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i] + ".");
        //        break;
        //    }
        //}
        assertArrayEquals(expected, input);
    }

    /** Test the Sort.findSmallest method. */
    @Test
    public void testFindSmallest(){
        String[] input = {"there", "are", "many", "pigs"};
        int expected1 = 1;
        int actual = Sort.findSmallest(input,0);
        org.junit.Assert.assertEquals(expected1, actual);

        int expected2 = 1;
        int actual2 = Sort.findSmallest(input,1);
        org.junit.Assert.assertEquals(expected2, actual2);

        int expected3 = 2;
        int actual3 = Sort.findSmallest(input,2);
        org.junit.Assert.assertEquals(expected3, actual3);

        int expected4 = 3;
        int actual4 = Sort.findSmallest(input,3);
        assertEquals(expected4, actual4);


    }

    /** Test the Sort.swap method. */
    @Test
    public void testSwap(){
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        assertArrayEquals(expected, input);
    }
}
