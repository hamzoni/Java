
package Entities;

import java.util.ArrayList;

public class Employee {
    public int id;
    public String name;
    public String dob;
    public ArrayList<String> skill;

    public Employee() {
        skill = new ArrayList<String>();
    }
    
}
