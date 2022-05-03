package com.softserve.homework03;

import com.softserve.homework03.brackets.Brackets03;
import com.softserve.homework03.symbols.ISymbols;
import com.softserve.homework03.symbols.Symbols;

public class App03 {
    public static void main(String[] args) {
        //
        String s1 = "testtest";   //true
        String s2 = "!hhj(test456(test123_+)fhfh)fhf(sjs)"; //true
        String s3 = "fjf*(jd)(jdncj)dnj"; //true
        String s4 = "sjfh)(jnsj";   //false
        String s5 = "fhf(jhdjd)7373)";  //false
        String s6 = "jaj(728(dgd**)";   //false
        String s7 = "dsjhgfj)sksk(dj);";    //false
        //
        Brackets03 text = new Brackets03(new Symbols());
        //
        System.out.println(text.verifyBrackets(s1));
        //
        System.out.println(text.numberBrackets(s2));
        System.out.println(text.numberBrackets(s7));
        System.out.println(text.numberBrackets(s1));
    }
}
