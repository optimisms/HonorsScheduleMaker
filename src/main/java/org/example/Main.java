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

        List<Student> classRoll = createStudentList(sc);
        ScheduleMaker mySchedule = new ScheduleMaker();
        mySchedule.createGroups(classRoll);

        System.out.println(mySchedule);
    }

    private static List<Student> createStudentList(Scanner sc) {
        List<Student> classRoll = new ArrayList<>();
        while (sc.hasNextLine()) {
            classRoll.add(createStudent(sc.nextLine()));
        }
        return classRoll;
    }

    private static Student createStudent(String student) {
        Scanner sc = new Scanner(student);
        return new Student(sc.next(), sc.next());
    }
}