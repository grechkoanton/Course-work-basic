public class Main {
    private static final Employee[] employeeRecordsStorage = new Employee[10];

    public static void main(String[] args) {
        employeeRecordsStorage[0] = new Employee("Иванов Иван Иванович", 1, 53_000);
        employeeRecordsStorage[1] = new Employee("Федоров Федор Федорович", 2, 125_000);
        employeeRecordsStorage[2] = new Employee("Алексеев Алексей Алексеевич", 3, 91_000);
        employeeRecordsStorage[3] = new Employee("Николаев Николай Николаевич", 4, 55_000);
        employeeRecordsStorage[4] = new Employee("Андреев Андрей Андреевич", 5, 250_000);
        employeeRecordsStorage[5] = new Employee("Антонов Антон Антонович", 1, 72_000);
        employeeRecordsStorage[6] = new Employee("Кириллов Кирилл Кириллович", 2, 27_000);
        employeeRecordsStorage[7] = new Employee("Артемов Артем Артемович", 3, 63_000);
        employeeRecordsStorage[8] = new Employee("Романов Роман Романович", 4, 88_000);
        employeeRecordsStorage[9] = new Employee("Александров Александр Александрович", 5, 110_000);

        printTask("ЗАДАЧИ БАЗОВОЙ СЛОЖНОСТИ.");
        System.out.println("Список всех сотрудников со всеми данными:");
        printAllEmployeesWithAllData();
        System.out.println("Сумма затрат компании на ЗП в месяц: " + calculateTheAmountOfSalaryCosts() + " руб.");
        System.out.println("Сотрудник с минимальной ЗП: " + findEmployeeMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + findEmployeeMaxSalary());
        System.out.println("Среднее значение ЗП в компании: " + calculateTheAverageValueOfSalaries() + " руб.");
        System.out.println("ФИО всех сотрудников:");
        printTheFullNamesOfAllEmployees();

        printTask("ЗАДАЧИ ПОВЫШЕННОЙ СЛОЖНОСТИ.");
        int department1 = 1;
        int department2 = 2;
        int department3 = 3;
        int department4 = 4;
        int department5 = 5;
        double percent = 0.15;
        int salaryNumberLimit = 100_000;
        System.out.println("Изменение (повышение) ЗП у всех сотрудников на величину аргумента в %:");
        indexSalaryAllEmployees();
        System.out.println("Минимальная ЗП сотрудника " + department4 +" отдела: " + findMinSalaryDepartment(department4));
        System.out.println("Максимальная ЗП сотрудника " + department2 +" отдела: " + findMaxSalaryDepartment(department2));
        System.out.println("Сумма затрат на ЗП по " + department5 + " отделу: " + calculateAmountOfSalaryDepartment(department5) + " руб.");
        System.out.println("Среднее ЗП по " + department3 + " отделу " + calculateTheAverageValueOfSalariesDepartment(department3, 2) + " руб.");
        System.out.println("Индексация (повышение) ЗП всех сотрудников " + department3 + " отдела на " + percent + " %:");
        indexSalaryDepartment(department3, percent);
        System.out.println("Данные всех сотрудников " + department1 + " отдела (все данные, кроме отдела:");
        printEmployeesDataWithoutDepartment(department1);
        System.out.println("Все сотрудники с ЗП меньше " + salaryNumberLimit + " руб." + " (распечатать id, ФИО, ЗП):");
        printAllEmployeesSalaryLessThanNumber(salaryNumberLimit);
        System.out.println("Все сотрудники с ЗП больше " + salaryNumberLimit + " руб." + " (распечатать id, ФИО, ЗП):");
        printAllEmployeesSalaryMoreThanNumber(salaryNumberLimit);
    }

    public static void printTask(String task) {
        System.out.println(task);
    }

    public static void printAllEmployeesWithAllData() {
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null) {
                System.out.println(employeeRecordsStorage[i]);
            }
        }
    }

    public static double calculateTheAmountOfSalaryCosts() {
        double sum = 0;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null) {
                sum += employeeRecordsStorage[i].getEmployeeSalary();
            }
        }
        return sum;
    }

    public static Employee findEmployeeMinSalary() {
        Employee minSalary = null;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (minSalary == null || employeeRecordsStorage[i].getEmployeeSalary() < minSalary.getEmployeeSalary()) {
                minSalary = employeeRecordsStorage[i];
            }
        }
        return minSalary;
    }

    public static Employee findEmployeeMaxSalary() {
        Employee maxSalary = null;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (maxSalary == null || employeeRecordsStorage[i].getEmployeeSalary() > maxSalary.getEmployeeSalary()) {
                maxSalary = employeeRecordsStorage[i];
            }
        }
        return maxSalary;
    }

    public static double calculateTheAverageValueOfSalaries() {
        double averageSalary = (double) calculateTheAmountOfSalaryCosts() / employeeRecordsStorage.length;
        return averageSalary;
    }

    public static void printTheFullNamesOfAllEmployees() {
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i].getFullName() != null) {
                System.out.println(employeeRecordsStorage[i].getFullName());
            }
        }
    }

    public static void indexSalaryAllEmployees() {
        double percent = 0.1;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null) {
                employeeRecordsStorage[i].setEmployeeSalary(employeeRecordsStorage[i].getEmployeeSalary() + employeeRecordsStorage[i].getEmployeeSalary() * percent);
                System.out.println(employeeRecordsStorage[i]);
            }
        }
    }

    public static Employee findMinSalaryDepartment(int department) {
        Employee minSalary = null;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i].getDepartment() == department) {
                if (minSalary == null || employeeRecordsStorage[i].getEmployeeSalary() < minSalary.getEmployeeSalary()) {
                    minSalary = employeeRecordsStorage[i];
                }
            }
        }
        return minSalary;
    }

    public static Employee findMaxSalaryDepartment(int department) {
        Employee maxSalary = null;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i].getDepartment() == department) {
                if (maxSalary == null || employeeRecordsStorage[i].getEmployeeSalary() > maxSalary.getEmployeeSalary()) {
                    maxSalary = employeeRecordsStorage[i];
                }
            }
        }
        return maxSalary;
    }

    public static double calculateAmountOfSalaryDepartment(int department) {
        double sum = 0;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null && employeeRecordsStorage[i].getDepartment() == department) {
                sum += employeeRecordsStorage[i].getEmployeeSalary();
            }
        }
        return sum;
    }

    public static double calculateTheAverageValueOfSalariesDepartment(int department, int employees) {
        double sum = 0;
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null && employeeRecordsStorage[i].getDepartment() == department) {
                sum += employeeRecordsStorage[i].getEmployeeSalary();
            }
        }
        sum = (double) sum / employees;
        return sum;
    }

    public static void indexSalaryDepartment(int department, double prc) {
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null && employeeRecordsStorage[i].getDepartment() == department) {
                employeeRecordsStorage[i].setEmployeeSalary(employeeRecordsStorage[i].getEmployeeSalary() + employeeRecordsStorage[i].getEmployeeSalary() * prc);
                System.out.println(employeeRecordsStorage[i]);
            }
        }
    }

    public static void printEmployeesDataWithoutDepartment(int department) {
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null && employeeRecordsStorage[i].getDepartment() == department) {
                System.out.println(employeeRecordsStorage[i].toStringDataWithoutDepartment());
            }
        }
    }

    public static void printAllEmployeesSalaryLessThanNumber(double salaryNumber) {
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null && employeeRecordsStorage[i].getEmployeeSalary() < salaryNumber) {
                System.out.println(employeeRecordsStorage[i].toStringDataWithoutDepartment());
            }
        }
    }
    public static void printAllEmployeesSalaryMoreThanNumber(double salaryNumber) {
        for (int i = 0; i < employeeRecordsStorage.length; i++) {
            if (employeeRecordsStorage[i] != null && employeeRecordsStorage[i].getEmployeeSalary() >= salaryNumber) {
                System.out.println(employeeRecordsStorage[i].toStringDataWithoutDepartment());
            }
        }
    }
}

