package com.howtojava;

import java.util.Scanner;

public class LargestString {

    public static void main(String[] args) {

        String userInput = "";
        String longest = "";
        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.println("Enter a sentence and I will give you the longest word: ");
            userInput = scan.nextLine();
            if (userInput != null && !userInput.isBlank())
                break;
            System.out.println("Input file cannot be empty");
        }

        longest = getUserInput(userInput);
        System.out.println(getUserInput(longest));
    }


    public static String getUserInput(String userInput){

            String [] words = userInput.split(" ");

            String largest = words[0];

            for (int i = 1; i < words.length; i++){

                if (largest.length() < words[i].length())
                    largest = words[i];
            }
            return largest;
        }

}
