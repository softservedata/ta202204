package com.softserve.edu.homework01;

/*
    1) Дано стрічку, яка може містити круглі дужки '(' та ')'.
    Напишіть метод public boolean verifyBrackets(String text) { ... }
    для перевірки коректного розміщення дужок у стрічці.
    Наприклад, для випадків "()", "(())", "(())()" ми повинні отримати true,
    а для "(()", ")(" та  "()) " - false.
    Для коду використати пакет com.softserve.homework01
*/

public class App {
    public static void main(String[] args) {
        BracketsApp bracketsApp = new BracketsAppImp();
        App.verifyCorrectString(bracketsApp);
        App.verifyIncorrectString(bracketsApp);
    }

    private static void verifyCorrectString (BracketsApp bracketsApp) {
        System.out.println("Should be true:");
        System.out.println(bracketsApp.verifyBrackets("()"));
        System.out.println(bracketsApp.verifyBrackets("(())"));
        System.out.println(bracketsApp.verifyBrackets("(())()"));
        System.out.println(bracketsApp.verifyBrackets("aa()"));
        System.out.println(bracketsApp.verifyBrackets("aa(__)dsadasdas(dsadas())"));
    }

    private static void verifyIncorrectString (BracketsApp bracketsApp) {
        System.out.println("Should be false:");
        System.out.println(bracketsApp.verifyBrackets("(()"));
        System.out.println(bracketsApp.verifyBrackets(")("));
        System.out.println(bracketsApp.verifyBrackets("())"));
        System.out.println(bracketsApp.verifyBrackets("aa"));
        System.out.println(bracketsApp.verifyBrackets(""));
    }
}
