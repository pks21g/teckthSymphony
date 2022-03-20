import com.howtojava.ReverseString;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseStringTest {

    ReverseString rs = new ReverseString();

    @Test
    public void test_for_loop_method(){
        assertEquals("for loop method test failed",
                "avaJ si sihT", rs.forLoop("This is Java"));
    }

    @Test
    public void test_char_array_method(){
        assertEquals("char array method test failed",
                "avaJ si sihT", rs.charArray("This is Java"));
    }

    @Test
    public void test_string_builder_method(){
        assertEquals("string builder method test failed",
                "avaJ si sihT", rs.stringBuilder("This is Java"));
    }

    @Test
    public void test_string_builderII_method(){
        assertEquals("string builder method test failed",
                "avaJ si sihT", rs.stringBuilderII("This is Java"));
    }


}
