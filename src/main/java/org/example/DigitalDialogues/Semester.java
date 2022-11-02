package org.example.DigitalDialogues;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Semester extends ArrayList<Week> {
    SemesterType semesterType;
    LocalDate semesterStartDate;

    public Semester(int initialCapacity, SemesterType semesterType, LocalDate semesterStartDate) {
        super(initialCapacity);
        this.semesterType=semesterType;
        this.semesterStartDate=semesterStartDate;
        createWeeklySchedule();
    }

    public Semester(SemesterType semesterType, LocalDate semesterStartDate) {
        this.semesterType=semesterType;
        this.semesterStartDate=semesterStartDate;
        createWeeklySchedule();
    }

    public Semester(Collection<? extends Week> c, SemesterType semesterType, LocalDate semesterStartDate) {
        super(c);
        this.semesterType=semesterType;
        this.semesterStartDate=semesterStartDate;
        createWeeklySchedule();
    }

    public void createWeeklySchedule() {
        //The first day of the semester is a Monday, but the code expects weeks to start on a Sunday
        LocalDate weekStartDate = semesterStartDate.minusDays(1);

        this.add(new Week(weekStartDate));
        for (int i = 0; i < 14; i++) {
            weekStartDate = weekStartDate.plusDays(7);
            this.add(new Week(weekStartDate));
        }

        if (semesterType == SemesterType.FALL) {
            fixThanksgiving();
        }
        else if (semesterType == SemesterType.WINTER) {
            // Implement if ever needed for spring semester; basically there are three weeks which won't have DDs on both days,
            // which are the first week, the week of Presidents' Day (Monday Instruction), and the last week. Have a DD
            // on Thursday of the first and seventh week and delete the last week, because there is only instruction on Tuesday.
        }
        fixOffWeek();
    }

    // Both semesters will have two weeks when there is only one DD assigned, but the actual weeks change based on
    // which semester. For Fall, it's easy; just the first and last weeks. For Winter, it's the first week and the week
    // of Presidents' Day.
    private void fixOffWeek() {
        if (semesterType == SemesterType.FALL) {
            Week firstWeek = this.get(0);
            Week lastWeek = this.get(this.size() - 1);

            Day dayToMove = firstWeek.getDay(1);
            dayToMove = new Day(dayToMove.getGroups().get(0), dayToMove.getGroups().get(1), dayToMove.getDate());
            firstWeek.deleteDay(1);

            Day dayToUpdate = lastWeek.getDay(1);
            dayToUpdate.setGroups(dayToMove.getGroups());
            lastWeek.updateDay(1, dayToUpdate);
            lastWeek.deleteDay(2);
        } else if (semesterType == SemesterType.WINTER) {
            //Implement if needed for future class
        }
    }

    private void fixThanksgiving() {
        System.out.println("When is Thanksgiving? (Please enter your response as the date of the Sunday before Thanksgiving in the format MM/DD):");
        Scanner sc = new Scanner(System.in);
        String date = sc.next();
        int day = Integer.parseInt(date.substring(3));
        LocalDate thanksgiving = LocalDate.of(semesterStartDate.getYear(), Month.NOVEMBER, day);

        for (int i = 8; i < this.size(); i++) {
            if (this.get(i).getWeekOf().equals(thanksgiving)) {
                this.get(i).getDay(1).setGroups(new ArrayList<>(Arrays.asList(null, null)));
                this.get(i).getDay(2).setGroups(new ArrayList<>(Arrays.asList(null, null)));
                break;
            }
        }

//        Week lastWeek = this.get(this.size() - 1);
//        this.remove(this.size() - 1);
//        this.add(lastWeek);
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder("DD Schedule for " + semesterType + " " + semesterStartDate.getYear() + ":\n");
        for (Week week : this) {
            toReturn.append(week.toString());
        }
        return toReturn.toString();
    }
}
