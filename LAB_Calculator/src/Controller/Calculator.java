package Controller;

public class Calculator {

    public static double currentValue;
    public static String currentDigit;
    public static String prevOpt;
    public static String prevDigit;
    
    private Controller c;
    
    public Calculator(String opt, Controller c) {
        this.c = c;
        exp(opt);
    }

    // Memory clear
    public static void MC() {
        currentValue = 0;
        currentDigit = "";
        prevDigit = null;
        prevOpt = null;
    }
  
    public void exp(String opt) {
        if (opt.matches("\\d|\\.")) {
            if (currentDigit.matches(".*\\..*") && opt.matches(".*\\..*")) return;
            if (currentDigit.length() == 0 && opt.matches(".*\\..*")) return;
            currentDigit += opt;
        } else { // No preceeding operations
            Double d = Double.parseDouble(currentDigit);
            switch (opt) {
                case "MC":
                    MC();
                    break;
                case "MR":
                    break;
                case "M+":
                    break;
                case "M-":
                    break;
                case "√": break;
                case "/": 
                case "x":
                case "-":
                case "+":
                    if (prevOpt == null) {
                        prevDigit = currentDigit;
                        currentDigit = "";
                        prevOpt = opt;
                    } else {
                        if (prevDigit != null) {
                            basicSolver();
                        }
                        
                    }
                    break;
                case "%": break;
                case "1/x": break;
                case "=": break;
                case "+/-": break;
            }
        }
        print();
    }
    
    private void basicSolver() {
        double a =  Double.parseDouble(prevDigit);
        double b =  Double.parseDouble(currentDigit);
        switch (prevOpt) {
            case "/":
                currentValue = a / b;
                break;
            case "x":
                currentValue = a * b;
                break;
            case "-":
                currentValue = a - b;
                break;
            case "+":
                currentValue = a + b;
                break;
        }
        currentDigit = "";
        prevOpt = prevDigit = null;
    }
    
    public void print() {
        System.out.println("currentDigit: " + currentDigit);
        System.out.println("prevOpt: " + prevOpt);
        System.out.println("prevDigit: " + prevDigit);
        System.out.println("currentValue: " + currentValue);
        System.out.println("------------");
    }
}
