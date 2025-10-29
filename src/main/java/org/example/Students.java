package org.example;

import java.util.Scanner;

public class Students {

    String name;
    double programmingMark;
    double mathsMark;
    static final int PASS_MARK = 60;

    public Students(String name, double programmingMark, double mathsMark) {
        this.name = name;
        this.programmingMark = programmingMark;
        this.mathsMark = mathsMark;
    }

    // Check pass/fail for a given mark
    public String getResult(double mark) {
        return (mark >= PASS_MARK) ? "Pass" : "Fail";
    }

    // Display specific subject info
    public void displaySubject(String subject) {
        if (subject.equalsIgnoreCase("programming")) {
            System.out.println(name + ": " + programmingMark + " - " + getResult(programmingMark));
        } else if (subject.equalsIgnoreCase("maths")) {
            System.out.println(name + ": " + mathsMark + " - " + getResult(mathsMark));
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        Students[] students = {
                new Students("Lelo", 58, 75),
                new Students("Zoe", 61, 73),
                new Students("Billy", 70, 66),
                new Students("Kuhle", 80, 90)
        };

        // marks to view
        System.out.println("Which subject marks would you like to see? (Programming/Maths)");
        String choice = input.nextLine().trim().toLowerCase();

        double total = 0;

        if (choice.equals("programming") || choice.equals("maths")) {
            System.out.println("\n=== " + choice.substring(0, 1).toUpperCase() + choice.substring(1) + " Marks ===");

            for (Students s : students) {
                s.displaySubject(choice);
                total += (choice.equals("programming")) ? s.programmingMark : s.mathsMark;
            }

            double average = total / students.length;
            System.out.println("-----------------------------");
            System.out.println("Class Average: " + average);
        } else {
            System.out.println("Invalid choice. Please enter either 'Programming' or 'Maths'.");
        }

        input.close();
    }
}
