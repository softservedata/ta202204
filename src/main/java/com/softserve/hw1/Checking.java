package com.softserve.hw1;

public class Checking {
    public static void main(String[] args) {
        Brackets text=new Brackets();
        text.verifyBrackets("()");
        text.verifyBrackets("(())");
        text.verifyBrackets("(())()");
        text.verifyBrackets(")(");
        text.verifyBrackets("(()");
        text.verifyBrackets("())");
        System.out.println("result: (())()" + text.verifyBrackets("(())()"));
    }
}
