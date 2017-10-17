
package Ultility;

import java.util.Scanner;

public class Tool {
    private Scanner sc = new Scanner(System.in);
    
    public Double getDoubleCond(double min, double max) {
        double n = getDouble();
        if (n < min || n > max) {
            System.out.println("Number must be >= " + min + " and <= " + max);
            return getDoubleCond(min, max);
        }
        return n;
    }
    
    public int getIntCond(int min, int max) {
        int n = getInt();
        if (n < min || n > max) {
            System.out.println("Number must be >= " + min + " and <= " + max);
            return getIntCond(min, max);
        }
        return n;
    }
    
    public int getInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input: Must be number");
            return getInt();
        }
    }
    
    public double getDouble() {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input: Must be number");
            return getDouble();
        }
    }
    
}
