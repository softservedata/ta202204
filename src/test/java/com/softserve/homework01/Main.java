package com.softserve.homework01;

public class Main {
    public static void main(String[] args) {
        StringVerification service = new StringVerification();
        String s= "((Test))";
        System.out.println(service.verifyBrackets(s));
    }
}
