
package View;

import Entities.Task;
import Entities.TaskType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class View {
    
    public void showMenu() {
        System.out.println("TASK MANAGEMENT");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Show All Tasks");
        System.out.println("4. Show Task");
        System.out.println("#. Exit");
        System.out.print("Your option: ");
    }
    
    public void askTaskID() {
        System.out.println("Enter Task ID: ");
    }
    private void printTitle(String title, String decoration, int length) {
        for (int i = 0; i < length; i++) System.out.print(decoration);
        System.out.print(" " + title + " ");
        for (int i = 0; i < length; i++) System.out.print(decoration);
        System.out.println();
    }
    public void addTask(int type) {
        if (type == 0) {
            printTitle("ADD TASK", "-", 10);
            return;
        }
        System.out.print("Enter ");
        switch (type) {
            case 1:
                System.out.print("Task Type ID (1-4)");
                break;
            case 2:
                System.out.print("Requirement Name");
                break;
            case 3:
                System.out.print("Date (dd-MM-yyyy)");
                break;
            case 4:
                System.out.print("Plan From");
                break;
            case 5:
                System.out.print("Plan To");
                break;
            case 6:
                System.out.print("Assignee");
                break;
            case 7:
                System.out.print("Expert");
                break;
        }
        System.out.print(": ");
    }
    
    public void end() {
        System.out.println("Program Ended");
    }
    
    public void cont() {
        System.out.println("Press [Enter] to continue ...");
    }

    private void printBorder(int[] style) {
        System.out.print("+");
        for (int i = 0; i < style.length; i++) {
            for (int j = 0; j < style[i]; j++) {
                System.out.print("-");
            }
            System.out.print("+");
        }
        System.out.println("");
    }
    
    public void listTaskTypes() {
        System.out.println("LIST TASK TYPES");
        for (int i = 0; i < TaskType.taskNames.length; i++) {
            System.out.println((i + 1) + ". " + TaskType.taskNames[i]);
        }
    }
    
    private void printRows(String[] rows, int[] style) {
        System.out.print("|");
        for (int i = 0; i < rows.length; i++) {
            String row = formatString(style[i], rows[i]) + "|";
            System.out.print(row);
        }
        System.out.println("");
    }
    
    private String formatString(int space_n, String text) {
        int offset_n = space_n - text.length();
        if (offset_n < 0) offset_n = 0;
        for (int i = 0; i < offset_n; i++) {
            text += " ";
        }
        return text;
    }
    
    public void showAllTask(HashMap<Integer, Task> tasks, ArrayList<TaskType> taskTypes) {
        printTitle("SHOW ALL TASKS", "-", 10);
        String[] headers = {"ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer"};
        int[] style = {8, 15, 10, 15, 8, 15, 15};
        printBorder(style);
        printRows(headers, style);
        
        Iterator it = tasks.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Task task = (Task) pair.getValue();
            String c1 = task.getId() + "";
            String c2 = task.getRequirementName();
            String c3 = taskTypes.get(task.getTaskTypeId() - 1).getName();
            String c4 = task.getDate();
            String c5 = (task.getPlanTo() - task.getPlanFrom()) + "";
            String c6 = task.getAssignee();
            String c7 = task.getReviewer();
            String[] tuple = {c1, c2, c3, c4, c5, c6, c7};
            printBorder(style);
            printRows(tuple, style);
        }
        if (tasks.size() == 0) {
            printBorder(style);
            String noRecords = formatString(getSumInt(style), "NO RECORD FOUND.");
            System.out.print("|" + noRecords + "|");
            System.out.println("");
            printBorder(new int[] {getSumInt(style)});
        } else {
            printBorder(style);
        }
    }
    
    public int getSumInt(int[] arr) {
        int sum = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    public void showTask(Task task, ArrayList<TaskType> taskTypes) {
        printTitle("SHOW TASK #" + task.getId(), "-", 10);
        String[] headers = {"ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer"};
        int[] style = {8, 15, 10, 15, 8, 15, 15};
        printBorder(style);
        printRows(headers, style);
        
        String c1 = task.getId() + "";
        String c2 = task.getRequirementName();
        String c3 = taskTypes.get(task.getTaskTypeId() - 1).getName();
        String c4 = task.getDate();
        String c5 = (task.getPlanTo() - task.getPlanFrom()) + "";
        String c6 = task.getAssignee();
        String c7 = task.getReviewer();
        String[] tuple = {c1, c2, c3, c4, c5, c6, c7};
        printBorder(style);
        printRows(tuple, style);
        printBorder(style);
    }

}
