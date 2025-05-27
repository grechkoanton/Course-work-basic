import java.util.Arrays;

public class Main {
    private static final Employee[] employeeRecordsStorage = new Employee[10];

    public static void main(String[] args) {
        employeeRecordsStorage[0] = new Employee(1, "Иванов Иван Иванович", 1, 53_000);
        employeeRecordsStorage[1] = new Employee(2, "Федоров Федор Федорович", 2, 125_000);
        employeeRecordsStorage[2] = new Employee(3, "Алексеев Алексей Алексеевич", 3, 91_000);
        employeeRecordsStorage[3] = new Employee(4, "Николаев Николай Николаевич", 4, 55_000);
        employeeRecordsStorage[4] = new Employee(5, "Андреев Андрей Андреевич", 5, 250_000);
        employeeRecordsStorage[5] = new Employee(6, "Антонов Антон Антонович", 1, 72_000);
        employeeRecordsStorage[6] = new Employee(7, "Кириллов Кирилл Кириллович", 2, 27_000);
        employeeRecordsStorage[7] = new Employee(8, "Артемов Артем Артемович", 3, 63_000);
        employeeRecordsStorage[8] = new Employee(9, "Романов Роман Романович", 4, 88_000);
        employeeRecordsStorage[9] = new Employee(10, "Александров Александр Александрович", 5, 110_000);
        printAllEmployeesWithAllData();
        calculateTheAmountOfSalaryCosts();
        findEmployeeMinSalary();
        findEmployeeMaxSalary();
        calculateTheAverageValueOfSalaries();
        printTheFullNamesOfAllEmployees();
    }

    public static void printAllEmployeesWithAllData() {
        System.out.println("Данные сотрудников: ");
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null) {
            }
            System.out.println(employeeRecordsStorage[i]);
        }
    }

    public static double calculateTheAmountOfSalaryCosts() {
        double sum = 0;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null) {
            }
            sum += employeeRecordsStorage[i].getEmployeeSalary();
        }
        System.out.printf("Сумма затрат на ЗП в месяц: %.2f руб.%n", sum);
        return sum;
    }

    public static double findEmployeeMinSalary() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i].getEmployeeSalary() != 0 && employeeRecordsStorage[i].getEmployeeSalary() < min) {

                min = employeeRecordsStorage[i].getEmployeeSalary();
            }
        }
        System.out.printf("Сотрудник с максимальной зарплатой: %.2f руб.%n", min);
        return min;
    }

    public static double findEmployeeMaxSalary() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i].getEmployeeSalary() != 0 && employeeRecordsStorage[i].getEmployeeSalary() > max) {
                max = employeeRecordsStorage[i].getEmployeeSalary();
            }
        }
        System.out.printf("Сотрудник с минимальной зарплатой: %.2f руб.%n", max);
        return max;
    }

    public static double calculateTheAverageValueOfSalaries() {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i].getEmployeeSalary() != 0) {
                sum += employeeRecordsStorage[i].getEmployeeSalary();
                count++;
            }
        }
        System.out.printf("Среднее значение зарплат: %.2f руб.%n", (double) sum / count);
        return (double) sum / count;
    }

    public static void printTheFullNamesOfAllEmployees() {
        System.out.println("ФИО всех сотрудников: ");
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i].getFullName() != null) {

            }
            System.out.println(employeeRecordsStorage[i].getId() + "." + employeeRecordsStorage[i].getFullName());
        }
    }
}
