package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args[1].equals("unsorted")) {
            File studentList = new File(args[0]);
            Scanner sc = new Scanner(studentList);

            List<Student> classRoll = createStudentList(sc);
            ScheduleMaker mySchedule = new ScheduleMaker();
            mySchedule.createGroups(classRoll);

            System.out.println(mySchedule);
        }
        if (args[1].equals("sorted")) {
            File groupsList = new File(args[0]);
            Scanner sc = new Scanner(groupsList);

            List<Student> group1 = createGroup(sc.nextLine());
            List<Student> group2 = createGroup(sc.nextLine());
            List<Student> group3 = createGroup(sc.nextLine());
            List<Student> group4 = createGroup(sc.nextLine());

            ScheduleMaker mySchedule = new ScheduleMaker(group1, group2, group3, group4);

            System.out.println(mySchedule);
        }
    }

    private static List<Student> createStudentList(Scanner sc) {
        List<Student> classRoll = new ArrayList<>();
        while (sc.hasNextLine()) {
            classRoll.add(createStudent(sc.nextLine()));
        }
        return classRoll;
    }

    private static List<Student> createGroup(String nextLine) {
        Scanner sc = new Scanner(nextLine);
        sc.next();
        sc.next();
        List<Student> students = new ArrayList<>();
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

//    private static List<Student> parseNames(String nextLine) {
//        Scanner sc = new Scanner(nextLine);
//        sc.next();
//        sc.next();
//        List<Student> students = new ArrayList<>();
//        while (sc.hasNext()) {
//            String firstName = sc.next();
//            String lastName = sc.next();
//            if (lastName.contains(",")) {
//                lastName = lastName.substring(0, lastName.length() - 1);
//            }
//            students.add(createStudent(firstName, lastName));
//        }
//        return students;
//    }

    private static Student createStudent(String firstName, String lastName) {
        return new Student(firstName, lastName);
    }

    private static Student createStudent(String student) {
        Scanner sc = new Scanner(student);
        return createStudent(sc.next(), sc.next());
    }

}