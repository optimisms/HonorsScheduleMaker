package org.example.GroupCreation;

import java.util.ArrayList;
import java.util.Collection;

public class Group extends ArrayList<Student> {
    private int groupNum;

    public Group(int initialCapacity, int groupNum) {
        super(initialCapacity);
        this.groupNum=groupNum;
    }

    public Group(int groupNum) {
        this.groupNum=groupNum;
    }

    public Group(Collection<? extends Student> c, int groupNum) {
        super(c);
        this.groupNum=groupNum;
    }

    public int getGroupNum() {
        return groupNum;
    }
}
