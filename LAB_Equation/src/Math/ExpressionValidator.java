
package Math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {
    public static boolean isValid(String expression) {
        String[] rules = {
            "[^\\.\\+\\-\\*\\dx\\^\\s]+", // No characters other than valid characters: + - * / ^ x . spaces and digits
            "[*/+\\^]{2,}", // No more two operations stay next to each other
            "^([+*\\^/]+)|[+*\\^/]+$", // No standalone operations
            "\\/0", // No divide to zero,
            "([^\\d]+\\.)|(\\.[^\\d]+)|^\\.|\\.$", // Decimal point must be between 2 digits or standalone
            "\\([^x\\d]*\\)", // No empty brackets
            "\\/x", // No divide to x (so to prevent divide by zero)
        };

        for (int i = 0; i < rules.length; i++) {
            Pattern p = Pattern.compile(rules[i]);
            Matcher m = p.matcher(expression);
            if (m.find()) {
                System.out.println(i);
                return false;
            }
        }

        if (!isValidBrackets(expression)) {
            return false;
        }

        return true;
    }

    private static boolean isValidBrackets(String s) {
        String[] chars = s.split("");

        int bl, br;
        bl = br = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i].equals("(")) {
                bl++;
            }
            if (chars[i].equals(")")) {
                br++;
            }
        }
        return bl == br;
    }
}
