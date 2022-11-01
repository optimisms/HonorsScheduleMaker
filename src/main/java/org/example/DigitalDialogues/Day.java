package org.example.DigitalDialogues;

import org.example.GroupCreation.GroupNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day {
    GroupNum assignedGroup1;
    GroupNum assignedGroup2;

    public Day(GroupNum assignedGroup1, GroupNum assignedGroup2) {
        this.assignedGroup1=assignedGroup1;
        this.assignedGroup2=assignedGroup2;
    }

    public List<GroupNum> getAssignedGroups() {
        return new ArrayList<GroupNum>(Arrays.asList(assignedGroup1, assignedGroup1));
    }
}
