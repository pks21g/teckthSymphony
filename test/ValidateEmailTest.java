import com.project.airlinereservation.AirlineReservation;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidateEmailTest {

    AirlineReservation airlineReservation = new AirlineReservation();

    @Test
    public void is_an_empty_email_test(){
        assertFalse("Empty email test failed",
                airlineReservation.validateEmail(""));
    }

    @Test
    public void is_a_null_email_test(){
        assertFalse("Null email test failed",
                airlineReservation.validateEmail(null));
    }

    @Test
    public void is_a_valid_email_address(){
        assertTrue("valid email test",
                airlineReservation.validateEmail("Appl12a@baNana.com"));
    }

    @Test
    public void dot_test_beg_and_end_more_than_once(){
        assertFalse("dot in the beginning and more than 1 test failed",
                airlineReservation.validateEmail(".fads@..ca.com"));
    }

    @Test
    public void at_symbol_repetition_test(){
        assertFalse("@ symbol repetition test failed",
                airlineReservation.validateEmail("airline@hongkong@hk.com"));

    }
    @Test
    public void username_upper_bound_test(){
        assertFalse("username upperbound test failed",
                airlineReservation.validateEmail("asfasfdsafdasfds@gmail.com"));
    }
    @Test
    public void user_name_lower_bound_test(){
        assertFalse("username lowerboud test failed",
                airlineReservation.validateEmail("aaaa@gmail.com"));
    }

    @Test
    public void service_provider_name_upper_bound(){
        assertFalse("service provider upper bound test failed",
                    airlineReservation.validateEmail("airline@hongkong.com"));
    }

    @Test
    public void service_provider_name_lower_bound(){
        assertFalse("service provider lower bound test failed",
                airlineReservation.validateEmail("airline@hk.com"));
    }

    @Test
    public void domain_name_test_lower_bound(){
        assertFalse("test failed: domain name is less than length",
                airlineReservation.validateEmail("airline@hongkong.c"));
    }

    @Test
    public void domain_name_test_upper_bound(){
        assertFalse("test failed, length is more than upper bound",
                airlineReservation.validateEmail("airline.hongkong.coom"));
    }

}
