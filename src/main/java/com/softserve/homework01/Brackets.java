package com.softserve.homework01;

public class Brackets {
    public boolean verifyBrackets(String brackText) {
        char [] brackChar = brackText.toCharArray();
        char [] compareBracket = {'(' , ')'};

        int firstBracket = 0;
        int lastBracket = 0;

        for (int i=0; i<brackChar.length; i++) {
            char first_elem = brackChar[i];

            if (first_elem == compareBracket[0]) {
                firstBracket++;
            }
            if (first_elem == compareBracket[1]) {
                lastBracket++;
                if (lastBracket>firstBracket) return false;
            }
        }
        return firstBracket==lastBracket;
    }
}
