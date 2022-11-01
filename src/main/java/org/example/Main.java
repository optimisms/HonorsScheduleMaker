package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File studentList = new File(args[0]);
        Scanner sc = new Scanner(studentList);

        ScheduleMaker mySchedule;
        if (args[1].equals("sorted")) {
            Group group1 = createGroup(sc.nextLine(), 1);
            Group group2 = createGroup(sc.nextLine(), 2);
            Group group3 = createGroup(sc.nextLine(), 3);
            Group group4 = createGroup(sc.nextLine(), 4);

            mySchedule = new ScheduleMaker(group1, group2, group3, group4);
        }
        else {// if (args[1].equals("unsorted")) {
            mySchedule = new ScheduleMaker();

            List<Student> classRoll = createStudentList(sc);
            mySchedule.createGroups(classRoll);
        }

        System.out.println(mySchedule);
    }

    private static List<Student> createStudentList(Scanner sc) {
        List<Student> classRoll = new ArrayList<>();
        while (sc.hasNextLine()) {
            classRoll.add(createStudent(sc.nextLine()));
        }
        return classRoll;
    }

    private static Group createGroup(String nextLine, int groupNum) {
        Scanner sc = new Scanner(nextLine);
        sc.next();
        sc.next();
        Group students = new Group(groupNum);
        while (sc.hasNext()) {
            String firstName = sc.next();
            String lastName = sc.next();
            if (lastName.contains(",")) {
                lastName = lastName.substring(0, lastName.length() - 1);
            }
            students.add(createStudent(firstName, lastName));
        }
        return students;
    }

    private static Student createStudent(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }

    private static Student createStudent(String student) {
        Scanner sc = new Scanner(student);
        return createStudent(sc.next(), sc.next());
    }

}