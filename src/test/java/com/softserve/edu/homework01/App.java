package com.softserve.edu.homework01;

import java.util.Scanner;

public class App {

    public static void main (String[] args){

        String text = getString();
        VerifyBrackets result = new VerifyBrackets();

        if (result.isCorrectBrackets(text)){
            System.out.println("You have a correct brackets format!");
            System.out.println("Number of brackets: " + result.countBrackets(text));
        } else System.out.println("Recheck brackets in text!");

    }

    public static String getString (){
        Scanner scanner  = new Scanner(System.in);
        String text;
        System.out.println("Enter your string: ");
        return text = scanner.nextLine();
    }
}
