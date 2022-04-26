package com.softserve.homework1;

public class App 
{
    public static void main( String[] args )
    {
        BracketsChecker checker = new BracketsChecker();
        String str1 = "";
        String str2 = "((()))";
        String str3 = "()()()";
        String str4 = "()(())()";
        String str5 = "()()((())())";
        System.out.println(checker.checkBrackets(str1));
//        System.out.println(checker.checkBrackets(str2));
//        System.out.println(checker.checkBrackets(str3));
//        System.out.println(checker.checkBrackets(str4));
//        System.out.println(checker.checkBrackets(str5));
    }
}
