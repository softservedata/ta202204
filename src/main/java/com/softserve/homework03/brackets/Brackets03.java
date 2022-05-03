package com.softserve.homework03.brackets;

import com.softserve.homework01.Brackets;
import com.softserve.homework03.symbols.ISymbols;
import com.softserve.homework03.symbols.Symbols;

public class Brackets03 {
    //public Brackets03 text;
    private ISymbols symbols;

    public Brackets03 (ISymbols symbols) {
        this.symbols=symbols;
    }

    public ISymbols getSymbols() {return symbols;}
    //
    public boolean verifyBrackets (String text) {
        ISymbols line = new Symbols();
        if (line.verifyBrackets(text) == true) {
            return true;
        } else { return false;}
    }
    public int numberBrackets(String brText) {
        ISymbols checkBrackets = getSymbols();
        int numberOfBrackets = 0;
        char[] brChar = brText.toCharArray();
        char [] compareBracket = {'(' , ')'};
        if (checkBrackets.verifyBrackets(brText) == false) {
            throw new RuntimeException("Invalid Brackets");
        } else {
            for (int i: brChar) {
                //if (i != compareBracket[0] || i != compareBracket[1]) {
                //}
                if (i == compareBracket[0] || i== compareBracket[1]) {
                    numberOfBrackets++;
                }
            } return numberOfBrackets;
        }

    }
}
