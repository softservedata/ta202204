package com.softserve.homework01;

public class Main {
    public static void main(String[] args) {
        StringVerification service = new StringVerification();
        String s= "((Test tex))";
        System.out.println(service.verifybrackets(s));
        StringVerification numbers = new StringVerification();
        System.out.println(numbers.numberbrackets(s));
    }
}
