package com.softserve.edu.homework01;

public class BracketsAppImp implements BracketsApp {
    public boolean verifyBrackets(String text) {
        if (!this.verifyOnBrackets(text)) {
            return false;
        }
        String[] symbols = text.split("");
        return this.checkBracketsPair(symbols);
    }

    private boolean verifyOnBrackets(String text) {
        return text.matches(".*([()]).*");
    }

    public int numberBrackets(String text) {
        int bracketsCount = 0;

        if (!verifyBrackets(text)) {
            throw new RuntimeException("Incorrect string of brackets");
        }

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (currentSymbol == '(' || currentSymbol == ')') {
                bracketsCount++;
            }
        }

        return bracketsCount;
    }

    private boolean checkBracketsPair(String[] symbols) {
        int count = 0;

        for (String symbol : symbols) {
            if (symbol.equals("(")) {
                count = count + 1;
            }
            if (symbol.equals(")")) {
                count = count - 1;
            }
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }
}
