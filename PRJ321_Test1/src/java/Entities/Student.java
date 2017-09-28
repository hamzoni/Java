
package Entities;

public class Student {
    private int id;
    private String name;
    private int gender;
    private int department_id;
    private String department_name;
    private String dob;

    public Student(int id, String name, int gender, int department_id, String department_name, String dob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department_id = department_id;
        this.department_name= department_name;
        this.dob = dob;
    }

    public Student() {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

}
