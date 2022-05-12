package com.softserve.hw1;

public class Brackets {
    public boolean verifyBrackets(String text) {
        int closed = 0;
        int opened = 0;
        String[] atext = text.split("");
        for (int i = 0; i < atext.length; i++) {
            if (atext[0].equals(")")) {
                return false;
            } else if (atext[i].equals("(")) {
                opened = opened + 1;
            } else if (atext[i].equals(")")) {
                closed = closed + 1;
            }
        }
        if (opened == closed) {
            return true;
        } else {
            return false;
        }
    }

    public int numberBrackets(String text) {
        int cnt = 0;
        boolean qtBrackets = verifyBrackets(text);
        if (!qtBrackets) {
            throw new RuntimeException("Incorrect Brackets");
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(' || text.charAt(i) == ')')
                cnt++;
        }
        return cnt;
    }
}