package org.example;

import org.example.GroupCreation.GroupNum;

import java.util.Random;

public class Randomizer {
    public static GroupNum newRandomGroupNum() {
        int rand = getRandInt();

        return GroupNum.parseInt(rand);
    }

    public static GroupNum newRandomGroupNum(GroupNum[] taken) {
        int rand = getRandInt();

        while (groupNumInArray(GroupNum.parseInt(rand), taken)) {
            rand = getRandInt();
        }
        return GroupNum.parseInt(rand);
    }

    private static int getRandInt() { return new Random().nextInt(1, 5); }

    private static boolean groupNumInArray(GroupNum rand, GroupNum[] taken) {
        for (GroupNum i : taken) {
            if (rand == i) {
                return true;
            }
        }
        return false;
    }

    public static GroupNum getLastGroupNum(GroupNum[] taken) {
        if (taken.length != 3) { return null; }
        if (groupNumInArray(GroupNum.ONE, taken)) {
            if (groupNumInArray(GroupNum.TWO, taken)) {
                if (groupNumInArray(GroupNum.THREE, taken)) {
                    return GroupNum.FOUR;
                } else { return GroupNum.THREE; }
            } else { return GroupNum.TWO; }
        } else { return GroupNum.ONE; }
    }
}
