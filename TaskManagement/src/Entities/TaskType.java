
package Entities;

import java.io.Serializable;

public class TaskType implements Serializable {
    public static final int CODE = 1;
    public static final int TEST = 2;
    public static final int DESIGN = 3;
    public static final int REVIEW = 4;
    public static final String[] taskNames = {"Code", "Test", "Design", "Review"};
    
    private int id;
    private String name;

    public TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
