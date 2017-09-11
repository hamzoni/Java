
package Controller;

import Entities.Task;
import Entities.TaskType;
import FileIO.FileController;
import Model.Model;
import Ultility.Tool;
import View.View;
import java.util.Scanner;

public class Controller {
    private boolean running;
    private View view;
    private Model model;
    private Tool tool;
    private Scanner sc;
    private DataCollector collector;
    private FileController fc;
    
    public Controller() {
        running = true;
        view = new View();
        tool = new Tool();
        sc = new Scanner(System.in);
        collector = new DataCollector();
        fc = new FileController();
    }
    
    public void run() {
        // before running the main screen, load and validate data from file
        load();
        while (running) {
            view.showMenu();
            int option = tool.getInt();
            switch (option) {
                case 1: // ADD TASK
                    showAddTask();
                    break;
                case 2: // DELETE TASK
                    showDeleteTask();
                    break;
                case 3: // SHOW ALL TASK
                    showAllTask();
                    break;
                case 4: // SHOW TASK
                    showTask();
                    break;
                default: // EXIT
                    view.end();
                    running = false;
                    break;
            }
            if (option >= 1 && option <= 3) {
                view.cont();
                sc.nextLine();
            }
        }
    }
    
    private void load() {
        model = (Model) fc.read();
        if (model == null) model = new Model();
        model.setNextID(model.getNextID() + 1);
    }
    
    private boolean save() {
        return fc.write(model);
    }
    
    private void showDeleteTask() {
        showAllTask();
        
        int taskID = -1;
        // Ask user for task ID to be deleted
        view.askTaskID();
        taskID = tool.getInt();
        
        // Check if the record according to the ID is existed, then delete if the prior action return true
        if (model.checkTaskExists(taskID)) {
            model.deleteTask(taskID);
            if (save()) {
                System.out.println("Unable to save file. Action to be reverted");
                load();
                return;
            }
            System.out.println("Remove task #" + taskID + " done.");
            return;
        }
        
        // Announce if the task does not exists
        System.out.println("Task #" + taskID + " does not exist. Unable to remove.");
    }
    
    private void showAllTask() {
        view.showAllTask(model.getTasks(), model.getTaskTypes());
    }
    
    private void showTask() {
        int taskID = -1;
        view.askTaskID();
        taskID = tool.getInt();
        if (model.checkTaskExists(taskID)) {
            view.showTask(model.getTask(taskID), model.getTaskTypes());
            return;
        }
        System.out.println("Task #" + taskID + " does not exist. Unable to show.");
    }
    
    private void showAddTask() {
        Task task = new Task();
        // the default ID is the next ID defined in model
        task.setId(model.getNextID());
        
        // Show title
        view.addTask(0);
        
        // List all task type name
        view.listTaskTypes();
        // Ask task type
        view.addTask(1);
        task.setTaskTypeId(collector.getTaskTypeID());
        
        // Ask requirement name
        view.addTask(2);
        task.setRequirementName(sc.nextLine());
        
        // Ask date
        view.addTask(3);
        task.setDate(collector.getFormattedDate());
        
        // Ask plan from
        view.addTask(4);
        task.setPlanFrom(collector.getPlanTime());
        
        // Ask plant to
        view.addTask(5);
        task.setPlanTo(collector.getPlanTime());
        // time plan to must not be smaller than time plan from
        while (task.getPlanTo() <= task.getPlanFrom()) {
            System.out.println("Time plan from must larger than time plan to.");
            if (!askTryAgain()) {
                System.out.println("Cancle adding task.");
                return;
            }
            // Ask again since the user wanted to try again
            view.addTask(5);
            task.setPlanTo(collector.getPlanTime());
        }
        
        // Ask Assignee
        view.addTask(6);
        task.setAssignee(sc.nextLine());
        
        // Ask Reiviewer
        view.addTask(7);
        task.setReviewer(sc.nextLine());
        
        // Add task to Buffer
        model.addTask(task);
        // Store all task to file 
        if (save()) {
            // Announce to user that task has been added
            System.out.println("Task #" + task.getId() + " added.");
            // new ID is set right after add done
            model.setNextID(model.getNextID() + 1);
        } else {
            // if unable to write file (as an error occur) then revert action of storing data in buffer
            model.deleteTask(task.getId());
        }
        
        if (askCont()) showAddTask();
    }
    
    private boolean askTryAgain() {
        // if user want to try again, then this function return TRUE
        // if user said 'n', then return FALSE
        // if user put in invalid data, then ask again
        System.out.print("Do you want to try again? (Y/N): ");
        String opt = sc.nextLine();
        opt = opt.toLowerCase();
        if (opt.equals("y")) {
            return true;
        } else if (opt.equals("n")) {
            return false;
        } else {
            return askCont();
        }
    }
    
    private boolean askCont() {
        // if user want to continue, then this function return TRUE
        // if user said 'n', then return FALSE
        // if user put in invalid data, then ask again
        System.out.print("Do you want to continue? (Y/N): ");
        String opt = sc.nextLine();
        opt = opt.toLowerCase();
        if (opt.equals("y")) {
            return true;
        } else if (opt.equals("n")) {
            return false;
        } else {
            return askCont();
        }
    }
}
