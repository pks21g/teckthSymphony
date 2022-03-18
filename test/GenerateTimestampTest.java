import com.project.airlinereservation.AirlineReservation;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertTrue;

public class GenerateTimestampTest {

    AirlineReservation airlineReservation = new AirlineReservation();

    @Test
    public void test_local_time(){

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss");

        assertTrue("Time and date test failed",
                airlineReservation.generateZonedTimeStamp().contains(localDateTime.format(formatter)));

    }

    @Test
    public void test_timezone_id(){
        assertTrue("Test failed for test zone id",
                airlineReservation.generateZonedTimeStamp().endsWith("CDT"));
    }
}
