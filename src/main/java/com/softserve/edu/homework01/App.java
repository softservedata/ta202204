package com.softserve.edu.homework01;

import java.util.Scanner;

public class App {

    public static void main (String[] args) {

        IVerifyBrackets result = new VerifyBrackets();
        String text = result.getString();

        if (result.isCorrectBrackets(text)){
            System.out.println("You have a correct brackets format!");
            System.out.println("Number of brackets: " + result.countBrackets(text));
        } else System.out.println("Recheck brackets in text!");

    }
}
