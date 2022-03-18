import com.project.airlinereservation.AirlineReservation;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateNameTest {

    AirlineReservation airlineReservation = new AirlineReservation();

    @Test
    public void name_is_less_than_lower_bound(){
        assertFalse("\u001B[31mEXPECTED: LENGTH LESS < 2", airlineReservation.isValidName("A"));
    }

    @Test
    public void name_equals_lower_bound(){
        String name = "ab";
        assertTrue("\u001B[31mTEST FAILED FOR LENGTH LESS THAN LOWER BOUND", airlineReservation.isValidName(name));
    }

    @Test
    public void name_is_more_than_upper_bound(){
        String name = "AmericanDreamComesTrue";
        assertFalse("\u001B[31mTEST FALIED FOR LENGTH MORE THAN UPPERBOUND", airlineReservation.isValidName(name));
    }

    @Test
    public void name_is_a_null_String(){
        String name = null;
        assertFalse("\u001B[31mTEST FAILED FOR NOT NULL", airlineReservation.isValidName(name));
    }
    @Test
    public void name_is_an_empty_String(){
        assertFalse("\u001B[31mEmpty String not expected".toUpperCase(), airlineReservation.isValidName(""));
    }

    @Test
    public void name_contains_numbers_and_special_characters(){
        assertFalse("name cannot contain numbers or special characters".toUpperCase(),
                airlineReservation.isValidName("20afsd&^%"));
    }
}
