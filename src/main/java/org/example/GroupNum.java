package org.example;

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
}