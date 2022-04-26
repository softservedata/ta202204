package com.softserve.homework1;

public class BracketsChecker {
    public boolean checkBrackets(String txt) {
        if (txt.isEmpty()) return false;
        char[] chars = parseStringToArray(txt);
        int bracketsCounter = 0;

        if (chars[0] != '(' || chars.length % 2 == 1) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                bracketsCounter+=1;
            } else {
                bracketsCounter-=1;
            }

            if (checkCounter(bracketsCounter, false)) return false;
        }
        return checkCounter(bracketsCounter, true);
    }

    private char[] parseStringToArray(String str) {
        char[] result = str.toCharArray();
        if (!isBracketValid(result)) {
            result = new char[1];
        }
        return result;
    }

    private boolean isBracketValid(char[] symbols) {
        for (int i = 0; i < symbols.length; i++) {
            if(symbols[i] != '(' && symbols[i] != ')') return false;
        }
        return true;
    }
    private boolean checkCounter(int counter, boolean finalCheck) {
        if (finalCheck) {
            return counter == 0;
        }
            return counter < 0;
    }
}
