package com.project.airlinereservation;

import java.util.InputMismatchException;
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
        lastName = getName("Enter last name: ");
        email = getEmail("Enter email: ");
        age = getAge("Enter age: ");

        System.out.println("First name: " + firstName + "\nLast Name: " + lastName +
                            "\nEmail: " + email + "\nAge: " + age);
    }

    /**
     * @param name is a type string
     * @return true only if name contains letters containing a-z or A-Z and
     * the inclusive length of 2-15
     */
    public static boolean isValidName(String name){

        if (name == null) return false;
        return name.matches("^[a-zA-Z]{2,15}");
    }

    /**
     * @param email is a type string for email
     * @return true if the provided email address contains all the properties of
     * an email ie: username containing only alphanumeric characters in the range
     * of 5-15, @ symbol after username, followed by provider name containing
     * 3-6 alphabetic characters, followed by . character, followed by domain name
     * containing exactly 2 or 3 alphabetic characters
     */
    public static boolean isValidEmail(String email){

        if (email == null) return false;
        return email.matches("^[a-zA-Z0-9]{5,15}" +
                                    "[@]{1}" + "[a-zA-Z]{3,6}" +
                                    "[.]{1}" + "[a-zA-Z]{2,3}$");
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

            if(isValidName(name))
                break;

            System.out.println("Invalid " + message.substring(message.indexOf(" ") + 1) + "please try again");
        }
        return name;
    }

    public static String getEmail(String message){

        String email = "";

        while(true){

            System.out.print(message);
            email = scan.next();

            if (isValidEmail(email))
                break;

            System.out.println("Invalid " + message.substring(message.indexOf(" ") + 1) + "please try again");
        }
        return email;
    }

    /**
     * @param age takes in an int value 
     * @return returns true only if the age is greater than 5 and smaller than 120
     */
    public static boolean validateAge(int age){
        return (age > 5 && age < 120);
    }

    /**
     * @param message takes in a message to display for age prompt
     * @return returns a valid age which is of type int and greater than 5
     * @exception InputMismatchException is caught when a non-int value is encountered
     */
    public static int getAge(String message){

        int age = 0;
        
        while(true) {

            try {
                
                System.out.println(message);
                age = scan.nextInt();
                
                if (validateAge(age))
                    break;
                System.out.println("Invalid " + message.substring(message.indexOf(" ") + 1) + "please try again");
            }
            catch (InputMismatchException ex) {
                System.out.println("Invalid data type: please try again");
            }
            scan.next();
        }
        return age;
    }

}
