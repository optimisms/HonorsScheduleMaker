package org.example;

public class Week {
    Day tuesday;
    Day thursday;

    public Week(Day tuesday, Day thursday) {
        this.tuesday=tuesday;
        this.thursday=thursday;
    }

    public void randomizeDays() {
        GroupNum tuesdayGroup1 = Randomizer.newRandomGroupNum();
        GroupNum tuesdayGroup2 = Randomizer.newRandomGroupNum(new GroupNum[]{tuesdayGroup1});
        GroupNum thursdayGroup1 = Randomizer.newRandomGroupNum(new GroupNum[]{tuesdayGroup1, tuesdayGroup2});
        GroupNum thursdayGroup2 = Randomizer.getLastGroupNum(new GroupNum[]{tuesdayGroup1, tuesdayGroup2, thursdayGroup1});

        tuesday = new Day(tuesdayGroup1, tuesdayGroup2);
        thursday = new Day(thursdayGroup1, thursdayGroup2);
    }
}
