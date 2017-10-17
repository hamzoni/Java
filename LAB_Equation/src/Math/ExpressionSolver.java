
package Math;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionSolver {
    public static double calc(String s, double v) {
        try {
            String eqst = "";
            ArrayList<String> eps = parseExpression(s, v);
            for (String ep : eps) eqst += ep;
            return parseBracket(eqst);
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
        return - 1;
    }
    
    private static double parseBracket(String s) {
        String regexp = "(\\([^)(]+\\))";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String root = matcher.group();
            String root2 = root;
            // remove bracket
            root = root.replaceAll("\\(|\\)", "");
            double rs = calcExp(parseExpression(root, 0));
            s = s.replace(root2, rs + "");
        }
        
        if (s.contains(")") || s.contains(")")) {
            return parseBracket(s);
        }
        return calcExp(parseExpression(s, 0));
    }
    
    private static void print(ArrayList<String> lists) {
        for (String list : lists) System.out.print(list + " ");
        System.out.println("");
    }
    
    private static double calcExp(ArrayList<String> eqs) {
        //Ex: "2.02 * 1.0 ^ 2 * 2 + 4 * 1.0 - 1 / 2" 
        ArrayList<String> eqs0 = new ArrayList<String>();
        eqs = filterNeg(eqs);
        // calculate: "^" operators
        for (int i = 0; i < eqs.size(); i++) {
            String t = eqs.get(i);
            if (t.matches("\\^") && (i - 1 >= 0 && i + 1 < eqs.size())) {
                double r = -1;
                double a = Double.parseDouble(eqs.get(i - 1));
                double b = Double.parseDouble(eqs.get(i + 1));
                r = Math.pow(a, b);
                eqs0.remove(eqs0.size() - 1);
                eqs.set(i + 1, r + "");
                eqs0.add(r + "");
                i++;
            } else {
                eqs0.add(t);
            }
        }
        eqs = eqs0;
        // From: "2.02 * 1.0 ^ 2 * 2 + 4 * 1.0 - 1 / 2"
        // To: "2.02 * 1.0 * 2 + 4 * 1.0 - 1 / 2"
        ArrayList<String> eqs1 = new ArrayList<String>();
        // calculate: "*", "/" operators
        for (int i = 0; i < eqs.size(); i++) {
            String t = eqs.get(i);
            if (t.matches("\\*|\\/") && (i - 1 >= 0 && i + 1 < eqs.size())) {
                double r = -1;
                double a = Double.parseDouble(eqs.get(i - 1));
                double b = Double.parseDouble(eqs.get(i + 1));
                if (t.matches("\\*")) r = a * b;
                if (t.matches("\\/")) r = a / b;
                eqs1.remove(eqs1.size() - 1);
                eqs.set(i + 1, r + "");
                eqs1.add(r + "");
                i++;
            } else {
                eqs1.add(t);
            }
        }
        eqs = eqs1;
        // From: "2.02 * 1.0 * 2 + 4 * 1.0 - 1 / 2"
        // To: "4.04 + 4 - 0.5"
        // calculate: "*", "/" operators
        double result = 0;
        for (int i = 0; i < eqs.size(); i++) {
            String t = eqs.get(i);
            if (t.matches("\\+|\\-") && (i - 1 >= 0 && i + 1 < eqs.size())) {
                result = 0;
                double r = 0;
                double a = Double.parseDouble(eqs.get(i - 1));
                double b = Double.parseDouble(eqs.get(i + 1));
                if (t.matches("\\+")) r = a + b;
                if (t.matches("\\-")) r = a - b;
                result += r;
                eqs.set(i + 1, r + "");
                i++;
            } else {
                try {
                    result += Double.parseDouble(t);
                } catch (Exception e) {}
            }
        }
        // From: "4.04 + 4 - 0.5"
        // To: 7.54
        return result;
    }
    
    private static ArrayList<String> parseExpression(String s, double v) {
        // "7*1+2+1/4^3^2+x*x*x+x^2/2-1*3x/4x"
        ArrayList<String> eqs = new ArrayList<String>();
        String[] ss = (s + " ").split("");
        String num = "";
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].matches("\\d|\\.")) {
                num += ss[i];
            } else {
                // Add * around x if it's surrounded by number or other x's
                if (ss[i].matches("x")) {
                    if (i - 1 >= 0) {
                        if (ss[i - 1].matches("\\d")) {
                            eqs.add(num);
                            eqs.add("*");
                        }
                    }
                    
                    eqs.add(v + "");
                    
                    if (i + 1 < ss.length) {
                        if (ss[i + 1].matches("\\d|x|\\(")) eqs.add("*");
                    }
                    // Add number before operators,
                } else if (ss[i].matches("[\\+\\-\\*\\/\\^]")) {
                    if (i - 1 >= 0) {
                        if (ss[i - 1].matches("\\d")) eqs.add(num);
                    }
                    eqs.add(ss[i]);
                } else if (ss[i].matches("\\)|\\(")) {
                    if (ss[i].matches("\\(")) {
                        if (i - 1 >= 0) {
                           if (ss[i - 1].matches("\\d")) {
                               eqs.add(num);
                               eqs.add("*");
                           }
                        }
                       eqs.add(ss[i]);
                    }
                    if (ss[i].matches("\\)")) {
                        if (i - 1 >= 0) {
                           if (ss[i - 1].matches("\\d")) {
                               eqs.add(num);
                           }
                        }
                       eqs.add(ss[i]);
                       if (i + 1 < ss.length) {
                           if (ss[i + 1].matches("\\d|x|\\(")) {
                               eqs.add("*");
                           }
                        }
                    }
                } else {
                    eqs.add(num);
                }
                num = "";
            }
        }
        for (int i = 0; i < eqs.size(); i++) {
            eqs.set(i, eqs.get(i).trim());
            if (eqs.get(i).equals("")) eqs.remove(i);
        }
        return eqs;
    }

    private static ArrayList<String> filterNeg(ArrayList<String> eqs) {
        String s, ns;
        for (int i = 0; i < eqs.size(); i++) {
            s = eqs.get(i);
            if (s.matches("\\-")) {
                
                if (i + 1 < eqs.size()) {
                    ns = eqs.get(i + 1);
                    // Remove minus if there are a couple of them stay nextby each other
                    if (ns.matches("\\-")) {
                        eqs.remove(i + 1);
                        eqs.remove(i);
                        i--;
                    } else {
                        
                        if (ns.matches("x|\\d|(\\d\\.?)+")) {
                            eqs.set(i + 1, "-" + ns);
                            eqs.remove(i); 
                            i--;
                        }
                        
                    }
                }
            }
        }
        return eqs;
    }
    
}
