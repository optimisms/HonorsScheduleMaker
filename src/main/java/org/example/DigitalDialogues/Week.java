package org.example.DigitalDialogues;

import org.example.GroupCreation.GroupNum;
import org.example.Randomizer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Week {
    Day tuesday;
    Day thursday;
    LocalDate weekOf;

    public Week(LocalDate startDate) {
        randomizeDays();
        setDates(startDate);
    }

    private void randomizeDays() {
        GroupNum tuesdayGroup1 = Randomizer.newRandomGroupNum();
        GroupNum tuesdayGroup2 = Randomizer.newRandomGroupNum(new GroupNum[]{tuesdayGroup1});
        GroupNum thursdayGroup1 = Randomizer.newRandomGroupNum(new GroupNum[]{tuesdayGroup1, tuesdayGroup2});
        GroupNum thursdayGroup2 = Randomizer.getLastGroupNum(new GroupNum[]{tuesdayGroup1, tuesdayGroup2, thursdayGroup1});

        tuesday = new Day(tuesdayGroup1, tuesdayGroup2);
        thursday = new Day(thursdayGroup1, thursdayGroup2);
    }

    private void setDates(LocalDate startDate) {
        this.weekOf = startDate;
        tuesday.setDate(startDate.plusDays(2));
        thursday.setDate(startDate.plusDays(4));
    }

    public LocalDate getWeekOf() {
        return weekOf;
    }

    public void updateDay(int whichDay, Day replacement) {
        if (whichDay == 1) { tuesday = replacement; }
        else { thursday = replacement; }
    }

    public void deleteDay(int whichDay) {
        if (whichDay == 1) { tuesday.setGroups(new ArrayList<>(Arrays.asList(null, null))); }
        else { thursday.setGroups(new ArrayList<>(Arrays.asList(null, null))); }
    }

    public Day getDay(int whichDay) {
        if (whichDay == 1) { return tuesday; }
        return thursday;
    }

//    public void changeGroupsForDays(int whichDay, GroupNum group1, GroupNum group2) {
//        if (whichDay == 1) { tuesday.setGroups(group1, group2); }
//        else { thursday.setGroups(group1, group2); }
//    }

    @Override
    public String toString() {
        StringBuilder weekString = new StringBuilder("Week of " + weekOf.getMonthValue() + "/" + weekOf.getDayOfMonth() + ":\n");
        if (tuesday.getGroups() == null) {
            String dayOfWeek = tuesday.getDate().getDayOfWeek().toString().toLowerCase();
            dayOfWeek = dayOfWeek.substring(0,1).toUpperCase() + dayOfWeek.substring(1);
            weekString.append("\t").append(dayOfWeek).append(" (").append(tuesday.getDate().getMonthValue()).append("/").append(tuesday.getDate().getDayOfMonth()).append("): No DD\n");
        } else { weekString.append("\t").append(tuesday); }
        if (thursday.getGroups() == null) {
            String dayOfWeek = thursday.getDate().getDayOfWeek().toString().toLowerCase();
            dayOfWeek = dayOfWeek.substring(0,1).toUpperCase() + dayOfWeek.substring(1);
            weekString.append("\t").append(dayOfWeek).append(" (").append(thursday.getDate().getMonthValue()).append("/").append(thursday.getDate().getDayOfMonth()).append("): No DD\n");
            //weekString.append("\t").append(thursday.getDate().getMonthValue()).append("/").append(thursday.getDate().getDayOfMonth()).append(": No DD\n");
        } else { weekString.append("\t").append(thursday); }
        return weekString.toString();
    }
}
