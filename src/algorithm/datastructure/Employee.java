package algorithm.datastructure;

public class Employee {

    private String name;

    public Employee() {
        this.name = "";
    }

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, String anotherName) {
        this.name = name + " " + anotherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
