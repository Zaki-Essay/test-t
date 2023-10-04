package com.sophatel;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        List<Employee> employees = initializeEmployees();
        List<Salary> salaries = initializeSalaries();

        List<EmployeeAnnualSalary> employeeAnnualSalaries = calculateAverageAnnualSalaries(employees, salaries);

        displayEmployeeAnnualSalaries(employeeAnnualSalaries);

        EmployeeAnnualSalary minEmployee = findMinAnnualSalary(employeeAnnualSalaries);
        EmployeeAnnualSalary maxEmployee = findMaxAnnualSalary(employeeAnnualSalaries);

        displayMinMaxSalaries(minEmployee, maxEmployee);
    }

    private static List<Employee> initializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", "Doe"));
        employees.add(new Employee(2, "Jane", "Doe"));
        employees.add(new Employee(3, "Bob", "Smith"));
        employees.add(new Employee(4, "Bob", "Marley"));
        return employees;
    }

    private static List<Salary> initializeSalaries() {
        List<Salary> salaries = new ArrayList<>();
        salaries.add(new Salary(1, 2021, 1, 3000));
        salaries.add(new Salary(1, 2021, 2, 3000));
        salaries.add(new Salary(1, 2021, 3, 3000));
        salaries.add(new Salary(1, 2021, 4, 3000));
        salaries.add(new Salary(1, 2022, 1, 3000));
        salaries.add(new Salary(1, 2022, 2, 3000));
        salaries.add(new Salary(1, 2022, 3, 3000));
        salaries.add(new Salary(1, 2022, 4, 3000));
        salaries.add(new Salary(1, 2022, 5, 3000));
        salaries.add(new Salary(1, 2022, 6, 3000));
        salaries.add(new Salary(1, 2022, 7, 3000));
        salaries.add(new Salary(1, 2022, 8, 3000));
        salaries.add(new Salary(2, 2021, 1, 4000));
        salaries.add(new Salary(2, 2021, 2, 4000));
        salaries.add(new Salary(2, 2021, 3, 4000));
        salaries.add(new Salary(2, 2021, 4, 4000));
        salaries.add(new Salary(2, 2021, 5, 4000));
        salaries.add(new Salary(2, 2021, 6, 4000));
        salaries.add(new Salary(2, 2021, 7, 5000));
        salaries.add(new Salary(2, 2021, 8, 5000));
        salaries.add(new Salary(2, 2021, 9, 5000));
        salaries.add(new Salary(2, 2021, 10, 5000));
        salaries.add(new Salary(2, 2021, 11, 5500));
        salaries.add(new Salary(2, 2021, 12, 5000));
        salaries.add(new Salary(2, 2022, 1, 5500));
        salaries.add(new Salary(3, 2021, 8, 5000));
        return salaries;
    }

    private static List<EmployeeAnnualSalary> calculateAverageAnnualSalaries(List<Employee> employees, List<Salary> salaries) {
        Map<Integer, Map<Integer, Double>> yearlySalariesMap = salaries.stream()
                .collect(Collectors.groupingBy(Salary::getEmployeeId,
                        Collectors.groupingBy(Salary::getYear, Collectors.summingDouble(Salary::getMonthlySalary))));

        return employees.stream()
                .flatMap(employee -> yearlySalariesMap.getOrDefault(employee.getEmployeeId(), Collections.emptyMap()).entrySet().stream()
                        .map(entry -> new EmployeeAnnualSalary(employee.getEmployeeId(), employee.getFirstName(),
                                employee.getLastName(), entry.getKey(), entry.getValue() / 12)))
                .collect(Collectors.toList());
    }

    private static void displayEmployeeAnnualSalaries(List<EmployeeAnnualSalary> employeeAnnualSalaries) {
        System.out.println("List of employees with average annual salary:");
        for (EmployeeAnnualSalary employeeAnnualSalary : employeeAnnualSalaries) {
            System.out.println(employeeAnnualSalary.getEmployeeId() + ": " +
                    employeeAnnualSalary.getFirstName() + " " +
                    employeeAnnualSalary.getLastName() + " - Year: " +
                    employeeAnnualSalary.getYear() + " - Average Annual Salary: " +
                    employeeAnnualSalary.getAnnualSalary());
        }
    }

    private static EmployeeAnnualSalary findMinAnnualSalary(List<EmployeeAnnualSalary> employeeAnnualSalaries) {
        return Collections.min(employeeAnnualSalaries, Comparator.comparingDouble(EmployeeAnnualSalary::getAnnualSalary));
    }

    private static EmployeeAnnualSalary findMaxAnnualSalary(List<EmployeeAnnualSalary> employeeAnnualSalaries) {
        return Collections.max(employeeAnnualSalaries, Comparator.comparingDouble(EmployeeAnnualSalary::getAnnualSalary));
    }

    private static void displayMinMaxSalaries(EmployeeAnnualSalary minEmployee, EmployeeAnnualSalary maxEmployee) {
        System.out.println("Minimum Annual Salary: " + minEmployee.getAnnualSalary() + " - Employee: " +
                minEmployee.getEmployeeId() + " - " +
                minEmployee.getFirstName() + " " + minEmployee.getLastName());
        System.out.println("Maximum Annual Salary: " + maxEmployee.getAnnualSalary() + " - Employee: " +
                maxEmployee.getEmployeeId() + " - " +
                maxEmployee.getFirstName() + " " + maxEmployee.getLastName());
    }
    }
