package com.project.airlinereservation;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * AirlineReservation class     Reservation Console Program
 * @author                      Teckth Symphony
 * @version 1.0
 * @version java 13.0.2
 */
public class AirlineReservation {

    private static Scanner scan = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int airlineCapacity = 3;
        String newPassenger = "";
        String heading = "";

        List<String> passengers = new LinkedList<>();

        while (true) {

            System.out.println("Remaining seat(s): " + airlineCapacity);

            char userChoice = userChoice();

            switch (userChoice) {

                case '1':

                    String traveler = getPassenger();

                    if(ifPassengerExists(passengers, traveler)) {
                        System.out.println("Passenger already exists");
                        continue;
                    }
                    
                    passengers.add(traveler);
                    System.out.println("Booking confirmed!! Your confirmation number is: " ); // FIXME: 3/19/22
                    airlineCapacity--;

                    if (airlineCapacity == 0) {
                        System.out.println("Seats are full");
                        break;
                    }
                    break;

                case '2':

                    heading = String.format("%-15S %-15S %-25S %-7S %-15S %-15S",
                            "First Name", "Last Name", "Email", "Age", "Confirmation", "Booking Date/Time");

                    System.out.println(heading);

                    for (String passenger : passengers) {
                        passenger = displayPassenger(passenger);
                        System.out.println(passenger);
                    }
                    break;

                case '3':

                    System.out.print("Enter confirmation number: ");
                    String confirmationNumber = scan.next();

                    System.out.println(heading);

                    for (int i = 0; i < passengers.size(); i++){
                        if (passengers.get(i).contains(confirmationNumber)) {
                            newPassenger = displayPassenger(passengers.get(i));
                            System.out.println(newPassenger);
                            break;
                        }
                    }
                    break;

                case '4':

                    System.out.println("Good Bye!!");
                    break;

                default:

                    System.out.println("Invalid option, please try again");
                    break;
            }

            if (userChoice == '4') {
                break;
            }
        }
    }

    public static String getPassenger(){

        String firstName = getName("Enter first name: ").toUpperCase();
        String lastName = getName("Enter last name: ").toUpperCase();
        String email = getEmail("Enter email: ").toUpperCase();
        int age = getAge("Enter age: ");

        String confirmation = generateConfirmationNumber();
        String localTimeStamp = generateZonedTimeStamp().toUpperCase();

        return firstName + "," + lastName + "," + email + "," + age + "," 
                + confirmation + "," + localTimeStamp;  
    }
    
    public static String displayPassenger(String passenger){
        String [] psg = passenger.split(",");
        passenger = String.format("%-15s %-15s %-25s %-7s %-15s %-15s",
                            psg[0], psg[1], psg[2], psg[3], psg[4], psg[5]);
        return passenger;
    }

    /**
     * @param passenger is a list of current passengers
     * @param traveler  is a string varialbe in the list
     * @return true if the passenger exists in the passenger list
     */
    public static boolean ifPassengerExists(List<String> passenger, String traveler){

        String [] psg = traveler.split(",");

        for (int i = 0; i < passenger.size(); i++){

            if (passenger.get(i).contains(psg[0]) &&
                    passenger.get(i).contains(psg[1]) &&
                    passenger.get(i).contains(psg[2]) &&
                    passenger.get(i).contains(psg[3]))
                return true;
        }
        return false;
    }

    /**
     * Utility method to display menu message
     */
    public static void menu(){
        System.out.print("Press\n1 >> Book\n2 >> Display List\n3 >> Find Passenger\n4 >> Exit\n>> ");
    }

    /**
     * @param 'no' parameter provided
     * @return user choice of char type
     */
    public static char userChoice(){

        menu();
        char userChoice = scan.next().charAt(0);

        return userChoice;

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

    /**
     *
     * @param message takes in a string argument
     * @return returns a valid email
     * @see
     * {@link#isValidEmail(String)isValidEmail}method
     * refrence:
     */
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
    public static boolean isValidAge(int age){
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
                
                System.out.print(message);
                age = scan.nextInt();
                
                if (isValidAge(age))
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

    /**
     * @param 'not' provided
     * @return alphanumeric randomized string with a length of 12
     */
    public static String generateConfirmationNumber(){

        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = lowerCase.toUpperCase();
        String numbers = "0123456789";

        String alphaNumeric = lowerCase + uppercase + numbers;
        String confirmationNumber = "";

        int confirmationStrLength = 12;

        Random ran = new Random();

        for(int i = 0; i < confirmationStrLength; i++){

            int randomNumber = ran.nextInt(alphaNumeric.length());
            char ch = alphaNumeric.charAt(randomNumber);
            confirmationNumber += ch;
        }
        return confirmationNumber;
    }

    /**
     * @param 'not' provided
     * @return string representation of date time and region
     */
    public static String generateZonedTimeStamp(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm:ss z");

        Instant now = Instant.now();
        ZonedDateTime zonedTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());

        return zonedTime.format(formatter);
    }

}
