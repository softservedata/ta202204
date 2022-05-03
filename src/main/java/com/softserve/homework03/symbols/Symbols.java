package com.softserve.homework03.symbols;

public class Symbols implements ISymbols {
    public String seeSymbols() {
        System.out.println("Running Symbols getSymbols()");
        return "some sample text";
    }
    public String seeSymbols(String text) {
        System.out.println("Running Symbols getSymbols(String text");
        return "some sample text" + text;
    }

    public boolean verifyBrackets(String brackText) {
        char[] brackChar = brackText.toCharArray();
        char[] compareBracket = {'(', ')'};

        int firstBracket = 0;
        int lastBracket = 0;

        for (int i = 0; i < brackChar.length; i++) {
            char first_elem = brackChar[i];

            if (first_elem == compareBracket[0]) {
                firstBracket++;
            }
            if (first_elem == compareBracket[1]) {
                lastBracket++;
                if (lastBracket > firstBracket) return false;
            }
        }
        return firstBracket == lastBracket;
    }
}
