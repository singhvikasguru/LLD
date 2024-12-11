import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', salary=" + salary + "}";
    }
}

public class StreamPractice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "IT", 60000),
                new Employee("David", "Finance", 80000),
                new Employee("Eve", "HR", 55000)
        );

        // Group employees by department
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(emp-> emp.getDepartment()));

        // Print the result
        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ": " + employeeList.toString());
        });

        Map<String, Long> employeeCountByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));

        System.out.println(employeeCountByDepartment);

        Map<String, Double> employeeCountByDepartmentSal = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingDouble(e->e.getSalary())
                ))
                .entrySet().stream()
                .filter(e->e.getValue()>80000)
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));

        System.out.println(employeeCountByDepartmentSal);

        /*Map<String, Double> qres= employees.stream()
                .filter(e->e.getSalary()>60000)
//                .map(e->(e.getName(), e.getSalary())
                .collect(Collectors.toMap(
                        e-> e.getName(),
                        e->e.getSalary(),
                        (existing, replacement) -> existing));
        System.out.print(qres.toString());

        Map<String, Double> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary) // Average salary per department
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 7000) // HAVING AVG(salary) > 7000
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        result.forEach(((dept, salary)->System.out.println(dept+": "+salary)));*/


    }
}
