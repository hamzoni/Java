
package Model;

import Entities.Task;
import Entities.TaskType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Model implements Serializable {
    private HashMap<Integer, Task> tasks;
    private ArrayList<TaskType> taskTypes;
    private int nextID;

    public Model() {
        tasks = new HashMap<Integer, Task>();
        nextID = 1;
        taskTypes = new ArrayList<TaskType>();
        taskTypes.add(new TaskType(TaskType.CODE, "Code"));
        taskTypes.add(new TaskType(TaskType.DESIGN, "Design"));
        taskTypes.add(new TaskType(TaskType.REVIEW, "Review"));
        taskTypes.add(new TaskType(TaskType.TEST, "Test"));
    }

    public int getNextID() {
        return nextID;
    }

    public void setNextID(int nextID) {
        this.nextID = nextID;
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }
    
    public Task getTask(int taskID) {
        return tasks.get(taskID);
    }
    
    public void addTask(Task task) {
        this.tasks.put(task.getId(), task);
    }
    
    public void deleteTask(int taskID) {
        tasks.remove(taskID);
    }
    
    public boolean checkTaskExists(int taskID) {
        return tasks.containsKey(taskID);
    }
    
    public ArrayList<TaskType> getTaskTypes() {
        return taskTypes;
    }

}
