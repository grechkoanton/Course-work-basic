import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private double employeeSalary;
    private static int counter = 1;
    private int id;

    public Employee(int counter, String fullName, int department, double employeeSalary) {
        this.fullName = fullName;
        this.department = department;
        this.employeeSalary = employeeSalary;
        this.id = counter++;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public int getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }                  // не требуется

    public void setDepartment(int department) {
        if ((department < 1 || department > 6)) {
            throw new IllegalArgumentException("Такого отдела в компании не существует");
        }
        this.department = department;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public void setId(int id) {
        this.id = id;
    }                   // не требуется

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employeeSalary, employee.employeeSalary) == 0 && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, employeeSalary, id);
    }

    @Override
    public String toString() {
        return "ID: " + id + ". ФИО: " + fullName + ". Отдел: " + department + ". Зарплата: " + employeeSalary + " руб.";
    }
}
