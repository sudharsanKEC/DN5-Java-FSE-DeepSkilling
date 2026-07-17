public class Employee {
    private int empId;
    private String name;
    private String position;
    private double salary;

    Employee(int empId, String name, String position, double salary){
        this.empId = empId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public static Employee createEmployee(int empId, String name, String position, double salary){
        return new Employee(empId, name, position, salary);
    }

    // Getters and Setters

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
