package com.softserve.edu;

import java.util.Scanner;

public class Appl {

    // Testability? Spaghetti code
    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("a = ");
        a = sc.nextDouble();
        System.out.print("b = ");
        b = sc.nextDouble();
        System.out.print("a + b = " + (a + b));
        sc.close();
    }

}
