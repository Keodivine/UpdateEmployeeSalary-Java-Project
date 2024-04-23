package keorapetse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateEmployeeSalary {
    public static void main(String[] args) {
        try {
            // Read the contents of the text file
            BufferedReader reader = new BufferedReader(new FileReader("employee.txt"));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");

                // Check if the line contains the expected number of elements
                if (parts.length != 4) {
                    System.out.println("Error: Invalid format in the file. Skipping line.");
                    continue;
                }

                String name = parts[0] + " " + parts[1];
                int yearsWorked = Integer.parseInt(parts[2]);
                double salary = Double.parseDouble(parts[3]);

                // Update salary based on years worked
                if (yearsWorked < 5) {
                    salary *= 1.05; // 5% increase
                } else if (yearsWorked >= 5 && yearsWorked <= 10) {
                    salary *= 1.15; // 15% increase
                } else {
                    salary *= 1.30; // 30% increase
                }

                // Append updated employee information to content
                content.append(name).append(" ").append(yearsWorked).append(" ").append(salary).append("\n");
            }
            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter("employee.txt"));
            writer.write(content.toString());
            writer.close();

            System.out.println("Employee salaries updated successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format in the file.");
            e.printStackTrace();
        }
    }
}