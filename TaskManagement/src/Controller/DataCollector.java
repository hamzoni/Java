
package Controller;

import Entities.TaskType;
import Ultility.Tool;
import java.util.Scanner;

public class DataCollector {
    private Tool tool;
    private Scanner sc;
    public DataCollector() {
        tool = new Tool();
        sc = new Scanner(System.in);
    }
    
    public int getTaskTypeID() {
        int input = tool.getInt();
        if (!(input == TaskType.CODE || input == TaskType.REVIEW || 
                input == TaskType.DESIGN || input == TaskType.TEST)) {
            System.out.println("Invalid Task Type ID. Try again: ");
            return getTaskTypeID();
        }
        return input;
    }
    
    public String getFormattedDate() {
        String date = sc.nextLine();
        if (!date.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            System.out.println("Invalid Date input, must be dd-MM-YYYY. Try again: ");
            return getFormattedDate();
        }
        return date;
    }
    
    public float getPlanTime() {
        float input = tool.getFloat();
        if (!(input >= 8 && input <= 17.5) ||
                !(input % 0.5 == 0)) {
            System.out.println("Invalid Plan time. Time must be from 8:00 to 17:30");
            System.out.print("Try again: ");
            return getPlanTime();
        }
        return input;
    }
    
}
