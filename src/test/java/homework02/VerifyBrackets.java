package homework02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyBrackets {

    public VerifyBrackets() {
    }

    public boolean isCorrectBrackets(String text) {
        int openBrackets = 0;
        int closeBrackets = 0;
        char[] textInChars = text.toCharArray();

        for (char textInChar : textInChars) {
            if (textInChar == '(') {
                openBrackets++;
            }
            if (textInChar == ')') {
                closeBrackets++;
                if (closeBrackets > openBrackets) {
                    return false;
                }
            }
        }
        return (closeBrackets == openBrackets);
    }
}
