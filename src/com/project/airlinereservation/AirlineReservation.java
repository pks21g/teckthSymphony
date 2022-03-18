package com.project.airlinereservation;

import java.util.Scanner;

/**
 * AirlineReservation class     Reservation Console Program
 * @author                      Teckth Symphony
 */
public class AirlineReservation {

    private static Scanner scan = new Scanner(System.in);

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

        firstName = getName("Enter first name: ");
        System.out.println(firstName);

        lastName = getName(lastName);
        System.out.println(lastName);
    }

    /**
     * @param name is a type string
     * @return true only if name contains letters containing a-z or A-Z and
     * the inclusive length of 2-15
     */
    public static boolean validateName(String name){
        if (name == null) return false;
        return name.matches("^[a-zA-Z]{2,15}");
    }

    /**
     * @param message is a type string, and it is used to hold a prompt message
     * @return valid alpha string: first name or last name depending on the usage
     */
    public static String getName(String message){

        String name = "";
        while(true) {

            System.out.print(message);
            name = scan.next();

            if(validateName(name))
                break;
            System.out.println("Invalid " + message.substring(message.indexOf(" ") + 1) + "please try again");
        }
        return name;
    }

}
