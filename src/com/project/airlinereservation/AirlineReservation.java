package com.project.airlinereservation;

/**
 * AirlineReservation class     Reservation Console Program
 * @author                      Teckth Symphony
 */
public class AirlineReservation {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        // variables declarations with initial values
        String firstName = "";          // stores firstName
        String lastName = "";           // stores lastName
        String email = "";              // stores email address
        String confirmation = "";       // stores confirmation number
        String localTimeStamp = "";     // stores system-based time date and zone
        int age = 0;                    // stores age

    }

    /**
     *
     * @param name is a type string
     *
     * @return true only if name contains letters containing a-z or A-Z and
     * the inclusive length of 2-15
     */
    private static boolean validateName(String name){
        return name.matches("^[a-zA-Z]{2,15}");
    }

}
