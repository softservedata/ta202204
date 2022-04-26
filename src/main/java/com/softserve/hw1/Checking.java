package com.softserve.hw1;

public class Checking {
    public static void main(String[] args) {
        Brackets text = new Brackets();
        System.out.println("check () - result: " + text.verifyBrackets("()"));
        System.out.println("check (()) - result: " + text.verifyBrackets("(())"));
        System.out.println("check (())() - result: " + text.verifyBrackets("(())()"));
        System.out.println("check )( - result: " + text.verifyBrackets(")("));
        System.out.println("check (() - result: " + text.verifyBrackets("(()"));
        System.out.println("check ()) - result: " + text.verifyBrackets("())"));
    }
}
