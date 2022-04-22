package com.softserve.homework01;

import java.util.Stack;

public class StringVerification {
    public boolean verifyBrackets(String text) {
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) == '(') {
                stack.addElement(text.charAt(index));
            } else if ((text.charAt(index) == ')')) {
                if (stack.empty()){
                    return false;
                }

                stack.pop();
            }
        }

        return stack.empty();
    }
}

