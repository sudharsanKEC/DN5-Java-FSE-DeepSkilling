import java.util.*;
public class Main {

    public static void addEmployee(Employee[] employee){
        Scanner sc = new Scanner(System.in);

        int lastEmp = 0;
        for(int i = 0; i < 50; i++){
            if(employee[i]==null){ 
                lastEmp = i;
                break;
            };
        }
        if(lastEmp == 50){
            System.out.println("Maximum employees reached.");
            return;
        }

        System.out.print("Enter the employee id: ");
        int empId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name of the employee: ");
        String empName = sc.nextLine();
        System.out.print("Enter position of the employee: ");
        String empPosition = sc.nextLine();
        System.out.print("Enter salary of the employee: ");
        double empSalary = sc.nextDouble();

        Employee newEmployee = Employee.createEmployee(empId, empName, empPosition, empSalary);
        employee[lastEmp] = newEmployee;
        System.out.println("Employee added successfully");
        return;
    }

    public static void searchEmployee(Employee[] employee){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the employee Id: ");
        int empId = sc.nextInt();
        for(int i = 0; i < employee.length; i++){
            if(employee[i]!=null && employee[i].getEmpId() == empId){
                System.out.println("Employee found: "+employee[i].toString());
                return;
            }
        }
        System.out.println("Employee doesn't found.");
    }

    public static void deleteEmployee(Employee[] employees){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee id to delete: ");
        int empId = sc.nextInt();
        for(int i = 0; i < employees.length; i++){
            if(employees[i]!=null && employees[i].getEmpId() == empId){
                employees[i] = null;
                shiftEmployees(i, employees);
                System.out.println("Employee deleted successfully.");
            }
        }
        System.out.println("Employee with the given ID doesn't found.");
        return;
    }

    public static void shiftEmployees(int i, Employee[] employees){
        for(int j = i; j < 49; j++){
            employees[j] = employees[j+1];
        }
    }

    public static void displayEmployees(Employee[] employee){
        System.out.println("Employees: ");
        for(int i = 0; i < 50; i++){
            if(employee[i]!=null){
                System.out.println(employee[i].toString());
            }
        }
    }

    public static void main(String[] args) {
        
        Employee[] employees = new Employee[50]; // initial length is assigned to 50
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Enter 1 to add employees.");
            System.out.println("Enter 2 to search employees.");
            System.out.println("Enter 3 to display all employees.");
            System.out.println("Enter 4 to delete an employee.");
            System.out.println("Enter 5 to end operations.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:{
                    addEmployee(employees);
                    break;
                }
                case 2:{
                    searchEmployee(employees);
                    break;
                }
                case 3:{
                    displayEmployees(employees);
                    break;
                }
                case 4:{
                    deleteEmployee(employees);
                    break;
                }
                case 5:{
                    break;
                }
                default:{
                    System.out.println("Enter a valid number");
                    break;
                }
            }

        }while(choice!=5);

    }
}
