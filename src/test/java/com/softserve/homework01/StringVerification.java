package com.softserve.homework01;

import java.util.Stack;

public class StringVerification {
    public boolean verifybrackets(String text) {
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) == '(') {
                stack.addElement(text.charAt(index));
            } else if ((text.charAt(index) == ')')) {
                if (stack.empty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.empty();
    }

    public int numberbrackets(String text) {
        if (!verifybrackets(text)) {
            throw new RuntimeException("Brackets undefined");
        }

        int generalCount = 0;

        for (int count = 0; count < text.length(); count++) {

            if (text.charAt(count) == '(' || text.charAt(count) == ')') {
                generalCount = generalCount + 1;
            }
        }

        return generalCount;
    }
}

