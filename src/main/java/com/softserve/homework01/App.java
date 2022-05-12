package com.softserve.homework01;

/*Homework 1 (from 20.04.2022)
        1) Дано стрічку, яка може містити круглі дужки '(' та ')'.
        Напишіть метод
public boolean verifyBrackets(String text) { ... }
        для перевірки коректного розміщення дужок у стрічці.
        Наприклад, для випадків "()", "(())", "(())()" ми повинні отримати true,
        а для "(()", ")(" та  "()) " - false.
        Для коду використати пакет com.softserve.homework01*/

public class App {
    public boolean verifyBrackets(String text) {
        String[] chars = text.split("");
        int count = 0;
        for (String c : chars) {
            if (count < 0) return false;
            if (c.equals("(")) {
                count++;
            } else if (c.equals(")")) {
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        App main = new App();
        System.out.println(main.verifyBrackets("()"));
        System.out.println(main.verifyBrackets("(())"));
        System.out.println(main.verifyBrackets("(())()"));
        System.out.println(main.verifyBrackets("(()"));
        System.out.println(main.verifyBrackets(")("));
        System.out.println(main.verifyBrackets("()) "));

    }
}