package org.example.GroupCreation;

public enum GroupNum {
    ONE, TWO, THREE, FOUR;

    public static GroupNum parseInt(int toParse) {
        return switch (toParse) {
            default -> GroupNum.ONE;
            case 2 -> GroupNum.TWO;
            case 3 -> GroupNum.THREE;
            case 4 -> GroupNum.FOUR;
        };
    }

    public static int parseToInt(GroupNum toParse) {
        return switch (toParse) {
            default -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
        };
    }
}