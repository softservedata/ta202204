package com.softserve.edu.homework01;

public class BracketsAppImp implements BracketsApp{
    public boolean verifyBrackets (String text) {
       if (!this.verifyOnBrackets(text)) {
           System.out.println("Text doesn't have bracket!");
           return false;
       }
       String[] symbols = text.split("");
       return this.checkBracketsPair(symbols);
    }

    private boolean verifyOnBrackets (String text) {
        return text.matches(".*(\\(|\\)).*");
    }

    private boolean checkBracketsPair (String[] symbols) {
        int count = 0;

        for (String symbol: symbols) {
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
