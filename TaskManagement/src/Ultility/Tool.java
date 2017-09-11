
package Ultility;

import java.util.Scanner;

public class Tool {
    private Scanner sc;

    public Tool() {
        sc = new Scanner(System.in);
    }
    
    public int getInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error: Input must be a number.");
            System.out.print("Try again: ");
            return getInt();
        }
    }
    
    public float getFloat() {
        try {
            return Float.parseFloat(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error: Input must be a number.");
            System.out.print("Try again: ");
            return getFloat();
        }
    }
    
}
