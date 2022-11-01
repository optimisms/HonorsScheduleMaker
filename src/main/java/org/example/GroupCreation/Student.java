package org.example.GroupCreation;

public class Student implements Comparable<String> {
    private final String firstName;
    private final String lastName;

    public Student(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(String o) {
        return lastName.compareTo(o);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
