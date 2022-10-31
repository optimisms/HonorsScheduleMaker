package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File studentList = new File(args[0]);
        Scanner sc = new Scanner(studentList);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}