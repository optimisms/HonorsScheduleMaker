package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScheduleMaker {
    enum GroupNum { ONE, TWO, THREE, FOUR }
    private final List<Student> group1;
    private final List<Student> group2;
    private final List<Student> group3;
    private final List<Student> group4;

    public ScheduleMaker(List<Student> group1, List<Student> group2, List<Student> group3, List<Student> group4) {
        this.group1 = group1;
        this.group2 = group2;
        this.group3 = group3;
        this.group4 = group4;
    }
    public ScheduleMaker() {
        group1 = new ArrayList<>();
        group2 = new ArrayList<>();
        group3 = new ArrayList<>();
        group4 = new ArrayList<>();
    }

    public void createGroups(List<Student> classRoll) {
        for (Student student : classRoll) {
            int maxNumMembers = classRoll.size() / 4;

            GroupNum groupNum = null;
            while (groupNum == null || groupIsFull(groupNum, maxNumMembers)) {
                groupNum = newRandomGroupNum();
            }

            switch (groupNum) {
                case ONE -> group1.add(student);
                case TWO -> group2.add(student);
                case THREE -> group3.add(student);
                case FOUR -> group4.add(student);
            }
        }
    }

    private GroupNum newRandomGroupNum() {
        int rand = new Random().nextInt(1, 5);

        return switch (rand) {
            default -> GroupNum.ONE;
            case 2 -> GroupNum.TWO;
            case 3 -> GroupNum.THREE;
            case 4 -> GroupNum.FOUR;
        };
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
