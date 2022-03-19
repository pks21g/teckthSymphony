import com.howtojava.LargestString;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class LargestStringTest {

    private LargestString ls = new LargestString();

    @Test
    public void largest_string_test(){

        String name = "All is good in America!!";
        assertTrue("Test method failed", ls.getUserInput(name).equals("America!!"));

    }

    @Test
    public void largest_string_test_II(){

        String name = "All is good in              America!!";
        assertTrue("Test method II failed", ls.getUserInput(name).equals("America!!"));
    }

    @Test
    public void largest_string_test_III(){

        String name = "All is good in              US";
        assertTrue("Test method III failed", ls.getUserInput(name).equals("good"));
    }

    @Test
    public void largest_string_test_IV(){

        String name = "                  ";
        Assert.assertThrows("Expected to throw ArrayIndexOutOfBoundsException",
                            ArrayIndexOutOfBoundsException.class,
                            () -> ls.getUserInput(name).equals("     "));
    }
    @Test
    public void largest_string_test_V(){
        String name = null;
        Assert.assertThrows("Expected to throw NullPointerException",
                NullPointerException.class, () -> ls.getUserInput(name).equals(null));
    }
}
