package org.example.app.views.employees;

import java.util.Scanner;

public class EmployeesCreateView {
    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter birth day: ");
        String birthDay = scanner.nextLine().trim();
        System.out.print("Enter position id: ");
        String posId = scanner.nextLine().trim();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter salary: ");
        String salary = scanner.nextLine().trim();
        return new String[]{lastName,firstName,birthDay,posId,phone,salary};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
