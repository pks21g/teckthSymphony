import com.project.airlinereservation.AirlineReservation;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * @version jUnit 4.13.1
 */
public class GenerateConfirmationNumberTest {

    AirlineReservation airlineReservation = new AirlineReservation();

    @Test
    public void confirmation_number_length_check(){

        int length = 12;
        String confirmation = airlineReservation.generateConfirmationNumber();

        assertTrue("length test failed", confirmation.length() == length );
    }
}
