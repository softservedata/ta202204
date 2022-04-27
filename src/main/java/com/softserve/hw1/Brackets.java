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
}