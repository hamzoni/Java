package LinkList;

public class Person {
    String name;
    int age;
    public Person(String xName, int xAge) {
        this.name = xName;
        this.age = xAge;
    }
    public String toString() {
        String s = "(" + name + "," + age + ")";
        return s;
    }
}
