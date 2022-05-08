package com.softserve.edu.homework01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyBrackets implements IVerifyBrackets {

    public VerifyBrackets(){}

    public boolean isCorrectBrackets(String text) {
        int openBrackets = 0;
        int closeBrackets = 0;
        char[] textInChars = text.toCharArray();

        if (text.length() == 0){
            throw new RuntimeException("The string is empty!");
        }

        for (char textInChar : textInChars) {
            if (textInChar == '(') {
                openBrackets++;
            }
            if (textInChar == ')') {
                closeBrackets++;
                if (closeBrackets > openBrackets) {
                    return false;
                }
            }
        }

        if (closeBrackets == 0 && openBrackets == 0){
            System.out.println("You don`t have brackets in text");
            return false;
        }
        return (closeBrackets == openBrackets);
    }

    public int countBrackets(String text) {
        boolean bracketsFormat = isCorrectBrackets(text);

        char[] textInChars = text.toCharArray();
        int numberOfBrackets = 0;

        if (!bracketsFormat){
            throw new RuntimeException("Incorrect brackets format!");
        }

        for (char textInChar : textInChars) {
            if (textInChar == '(' || textInChar == ')'){
                numberOfBrackets++;
            }
        }
        return numberOfBrackets;
    }

    public String getString() {
        Scanner scanner  = new Scanner(System.in);
        String text;
        System.out.println("Enter your string: ");
        return text = scanner.nextLine();
    }


}
