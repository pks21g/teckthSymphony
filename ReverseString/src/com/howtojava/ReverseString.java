package com.howtojava;

public class ReverseString {

    public static void main(String[] args) {

        String format = "%-30s %-25s%n";

        System.out.printf(format, "Test forLoop method: ",
                forLoop("This is Java"));

        System.out.printf(format, "Test charArray method: ",
                charArray("This is Java"));

        System.out.printf(format, "Test stringBuilder method: ",
                stringBuilder("This is Java"));

        System.out.printf(format, "Test stringBuilderII method: ",
                stringBuilderII("This is Java"));

    }

    public static String forLoop(String userVal){

        String reverse = "";
        for (int i = 0; i < userVal.length(); i++){
            char ch = userVal.charAt(userVal.length() - i - 1);
            reverse += ch;
        }

        // alternate approach

//         for (int i = userVal.length() -1; i >= 0; i--){
//             char ch = userVal.charAt(i);
//             reverse += ch;
//         }

        return reverse;
    }

    public static String charArray(String userVal){

        char [] ch = new char[userVal.length()];

        for (int i = 0; i < userVal.length(); i++){
            ch[userVal.length() - i - 1 ] = userVal.charAt(i);
        }
        return new String(ch);
    }

    public static String stringBuilder(String userVal){

        StringBuilder sb = new StringBuilder(userVal.length());

        for (int i = userVal.length() - 1; i >= 0; i--){
            sb.append(userVal.charAt(i));
        }
        return String.valueOf(sb);
    }

    public static String stringBuilderII(String userVal){

        StringBuilder sb = new StringBuilder(userVal);
        sb.reverse();

        return String.valueOf(sb);
    }
}
