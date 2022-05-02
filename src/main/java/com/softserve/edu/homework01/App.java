package com.softserve.edu.homework01;

/*
    1.1) Дано стрічку, яка може містити круглі дужки '(' та ')'.
    Напишіть метод public boolean verifyBrackets(String text) { ... }
    для перевірки коректного розміщення дужок у стрічці.
    Наприклад, для випадків "()", "(())", "(())()" ми повинні отримати true,
    а для "(()", ")(" та  "()) " - false.
    Для коду використати пакет com.softserve.homework01
*/

/*
    3.1) Додати до класу попереднього завдання метод обчислення кількості дужок
    public int numberBrackets()
    На початку методу викликати verifyBrackets() і у випадку false викидати RuntimeException.
*/

public class App {
    public static void main(String[] args) {
        BracketsApp bracketsApp = new BracketsAppImp();
        System.out.println(bracketsApp.numberBrackets("(O.T.) (did ((hw3)) <3)"));
    }
}
