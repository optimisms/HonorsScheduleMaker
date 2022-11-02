package org.example.DigitalDialogues;

import org.example.GroupCreation.GroupNum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day {
    private GroupNum assignedGroup1;
    private GroupNum assignedGroup2;
    private LocalDate date;

    public Day(GroupNum assignedGroup1, GroupNum assignedGroup2) {
        this.assignedGroup1=assignedGroup1;
        this.assignedGroup2=assignedGroup2;
    }

    public Day(GroupNum assignedGroup1, GroupNum assignedGroup2, LocalDate date) {
        this(assignedGroup1, assignedGroup2);
        this.date=date;
    }

    public void setDate(LocalDate date) {
        this.date=date;
    }

    public void setGroups(List<GroupNum> groups) {
        if (groups == null) {
            assignedGroup1 = null;
            assignedGroup2 = null;
            return;
        }
        if (groups.get(0) != null) {assignedGroup1 = groups.get(0);}
        else { assignedGroup1 = null; }
        if (groups.get(1) != null) { assignedGroup2 = groups.get(1); }
        else { assignedGroup2 = null; }
    }

    public List<GroupNum> getGroups() {
        if (assignedGroup1 == null && assignedGroup2 == null) { return null; }//new ArrayList<>(Arrays.asList(null, null)); }
        return new ArrayList<>(Arrays.asList(assignedGroup1, assignedGroup2));
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        int group1 = GroupNum.parseToInt(assignedGroup1);
        int group2 = GroupNum.parseToInt(assignedGroup2);
        int printFirst, printSecond;
        if (group1 < group2) {
            printFirst = group1;
            printSecond = group2;
        } else {
            printFirst = group2;
            printSecond = group1;
        }
        String dayOfWeek = date.getDayOfWeek().toString().toLowerCase();
        dayOfWeek = dayOfWeek.substring(0,1).toUpperCase() + dayOfWeek.substring(1);
        return dayOfWeek + " (" + date.getMonthValue() + "/" + date.getDayOfMonth() + "): Groups " + printFirst + " & " + printSecond + "\n";
    }
}
