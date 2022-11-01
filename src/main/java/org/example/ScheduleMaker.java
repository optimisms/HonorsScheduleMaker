package org.example;

import org.example.GroupCreation.Group;
import org.example.GroupCreation.GroupNum;
import org.example.GroupCreation.Student;

import java.util.List;

public class ScheduleMaker {

    private final Group group1;
    private final Group group2;
    private final Group group3;
    private final Group group4;

    public ScheduleMaker(Group group1, Group group2, Group group3, Group group4) {
        this.group1 = group1;
        this.group2 = group2;
        this.group3 = group3;
        this.group4 = group4;
    }
    public ScheduleMaker() {
        group1 = new Group(1);
        group2 = new Group(2);
        group3 = new Group(3);
        group4 = new Group(4);
    }

    public void createGroups(List<Student> classRoll) {
        for (Student student : classRoll) {
            int maxNumMembers = classRoll.size() / 4;

            GroupNum groupNum = null;
            while (groupNum == null || groupIsFull(groupNum, maxNumMembers)) {
                groupNum = Randomizer.newRandomGroupNum();
            }

            switch (groupNum) {
                case ONE -> group1.add(student);
                case TWO -> group2.add(student);
                case THREE -> group3.add(student);
                case FOUR -> group4.add(student);
            }
        }
    }

    private boolean groupIsFull(GroupNum groupNum, int maxNumMembers) {
        return switch (groupNum) {
            case ONE -> group1.size() == maxNumMembers;
            case TWO -> group2.size() == maxNumMembers;
            case THREE -> group3.size() == maxNumMembers;
            case FOUR -> group4.size() == maxNumMembers;
        };
    }

    @Override
    public String toString() {
        return "Group 1: " + group1 +
                "\nGroup 2: " + group2 +
                "\nGroup 3: " + group3 +
                "\nGroup 4: " + group4;
    }
}
