package com.teckthsymphony.airlinereservationfile;

import java.io.*;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AirlineReservationFIle {

    public static void main(String[] args) throws IOException {

        String newPassenger = "";
        final int CAPACITY = 3;
        int size = 0;

        String outputFile = createFileIfDontExist();

        Scanner scan = new Scanner(System.in);

        while(true) {

            System.out.println("\u001B[31mRemaining seats: " + (CAPACITY - size) +"\u001B[0m");

            switch (menu(scan)) {

                case 'a':
                case 'A':

                    if (size == CAPACITY) {
                        System.out.println("\u001B[31mSeats are full\u001B[0m");
                        break;
                    }
                    String firstName = getName("First Name: ", scan);
                    String lastName = getName("Last Name: ", scan);
                    String email = getEmail("Email: ", scan);
                    int age = getAge("Age: ", scan);
                    String conformation = generateRandomNumber();
                    String bookedTime = getBookedTime();

                    newPassenger = String.format("%-15s %-15s %-25s %-7s %-15s %-15s", firstName, lastName, email, age, conformation, bookedTime);

                    if (!ifExistsInFile(outputFile, firstName, lastName, email, age )){
                        writePassengerToFile(outputFile, newPassenger);
                        System.out.println("Passenger added successfully");
                    }
                    else{
                        System.out.println("\u001B[31mPassenger already booked\u001B[0m");
                        continue;
                    }

                    size++;
                    break;

                case 'b':
                case 'B':
                    System.out.printf("\u001B[33m%-15S %-15S %-25S %-7S %-15S %-15S\n",
                            "First Name", "Last Name", "Email", "Age", "Confirmation", "Booked Date/Time");

                    printToConsole();
                    break;

                case 'c':
                case 'C':
                    System.out.print("Enter the confirmation number: ");
                    String userConfirmation = scan.next();
                    userConfirmation = isConfirmed(userConfirmation);
                    System.out.println(userConfirmation);
                    break;
                case 'q':
                case 'Q':
                    System.out.println("Thanks for booking with us!");
                    break;

                default:
                    System.out.println("\u001B[31mInvalid choice\u001B[0m");

            }
// FIXME: 3/22/22  loop not ending           if (menu(scan) == 'q' || menu(scan) == 'Q')
//                break;

        }

    }

    private static char menu(Scanner scan){

        char userChoice = '\0';

        System.out.println("\u001B[31mEnter\n(A)\u001B[0m to add passenger to a file" +
                "\n\u001B[31m(B)\u001B[0m to see the list on console" +
                "\n\u001B[31m(C)\u001B[0m to see your booking on console" +
                "\n\u001B[31m(Q)\u001B[0m to quit ");

        userChoice = scan.next().charAt(0);
        return userChoice;
    }
    private static String getName(String message, Scanner reader){

        String name = "";

        while(true){

            System.out.print("\u001B[33m" + message + "\u001B[0m");
            name = reader.next();

            if (name.matches("^[a-zA-Z]{2,15}")) {
                name = name.toUpperCase();
                break;
            }

            System.out.println("\u001B[31mInvalid " + message.toLowerCase().replace(":", ",") + "Please try again\u001B[0m");
        }
        return name;
    }

    private static String getEmail(String message, Scanner reader){

        String email = "";

        while (true) {

            System.out.print("\u001B[33m" + message + "\u001B[0m");
            email = reader.next();

            if (email.matches("^[^@\\s]+@[^@\\s\\.]+\\.[^@\\.\\s]+$")) {
                email = email.toUpperCase();
                break;
            }

            System.out.println("\u001B[31mInvalid " + message.toLowerCase().replace(":", ",") + "Please try again\u001B[0m");
        }
        return email;
    }

    private static int getAge(String message, Scanner reader){

        int age = 0;

        while (true){

            try {
                System.out.print("\u001B[33m" + message + "\u001B[0m");
                age = reader.nextInt();

                if (age >= 5)
                    break;
            }
            catch (InputMismatchException ex){
                System.out.println("\u001B[31mInvalid " + message.toLowerCase().replace(":", ",") +
                        "Please try again\u001B[0m");
            }
            reader.next();
        }
        return age;
    }

    private static String generateRandomNumber(){

        Random ran = new Random();
        int randomNumber = ran.nextInt(Integer.MAX_VALUE) + Short.MAX_VALUE;

        return String.valueOf(randomNumber);
    }

    private static String isConfirmed(String confirmationNumber){

        String file = createFileIfDontExist();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine() ) != null) {
                if(line.contains(confirmationNumber))
                    return String.format("\u001B[33m%-15S %-15S %-25S %-7S %-15S %-15S\u001B[33m%n",
                            "First Name", "Last Name", "Email", "Age", "Confirmation", "Booked Date/Time")
                            + "\u001B[34m" + line + "\u001B[0m";
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return "\u001B[31mConfirmation not found\u001B[0m";
    }

    private static String getBookedTime(){

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy z hh:mm a");
        Instant now = Instant.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());

        return zonedDateTime.format(timeFormatter);
    }

    public static boolean ifExistsInFile(String file, String firstName,
                                         String lastName, String email, int age){

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine() ) != null) {
                if (line.contains(firstName) && line.contains(lastName)
                        && line.contains(email) && line.contains(String.valueOf(age)))
                    return true;
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
    }

    private static void writePassengerToFile(String file, String passenger) {

        String heading = String.format("%-15S %-15S %-25S %-7S %-15S %-15S",
                "First Name", "Last Name", "Email", "Age", "Confirmation", "Booked Date/Time");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){

            PrintWriter writer = new PrintWriter(bw);
            File newFile = new File(file);

            if (newFile.length() == 0) {
                writer.println(heading);
            }

            writer.println(passenger);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }


    }
    private static String createFileIfDontExist(){

        File checkFile = null;
        try {
            checkFile = new File("src/com/teckthsymphony/airlinereservationfile/passengers.txt");
            if (!checkFile.exists()) {
                checkFile.createNewFile();
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return checkFile.toString();
    }

    public static void printToConsole(){

        String file = createFileIfDontExist();

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = "";
            while ((line = reader.readLine() ) != null) {
                System.out.println("\u001B[34m" + line + "\u001B[0m");
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
