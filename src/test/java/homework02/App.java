package homework02;

public class App {

    public static void main (String[] args){
        String text = "Homework (() sdkjlskdjsk )";
        VerifyBrackets result = new VerifyBrackets();
        if (result.isCorrectBrackets(text)){
            System.out.println("You have a correct brackets format!");
        } else System.out.println("Recheck brackets in text!");
    }

}
