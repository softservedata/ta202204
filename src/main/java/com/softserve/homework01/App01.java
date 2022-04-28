package com.softserve.homework01;

public class App01 {
    public static void main(String[] args) {
        Brackets text = new Brackets();

        String s1 = "test(test)";   //true
        String s2 = "!hhj(test456(test123_+)fhfh)fhf(sjs)"; //true
        String s3 = "fjf*(jd)(jdncj)dnj"; //true
        String s4 = "sjfh)(jnsj";   //false
        String s5 = "fhf(jhdjd)7373)";  //false
        String s6 = "jaj(728(dgd**)";   //false
        String s7 = "dsjhgfj)sksk(dj);";    //false

        System.out.println(text.verifyBrackets(s1));
        System.out.println(text.verifyBrackets(s2));
        System.out.println(text.verifyBrackets(s3));
        System.out.println(text.verifyBrackets(s4));
        System.out.println(text.verifyBrackets(s5));
        System.out.println(text.verifyBrackets(s6));
        System.out.println(text.verifyBrackets(s7));
    }
}
