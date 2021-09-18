package ua.rakhmail.hw15.Task02;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Box{
    private final int value;

    public static void main(String[] args) {
        Set<Box> boxSet = new TreeSet<>(new BoxComparator());
        fillSet(boxSet);
        for (var boxValue : boxSet) {
            System.out.println(boxValue.getValue());
        }
    }

    public Box(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static void fillSet(Set<Box> set) {
        set.add(new Box(5));
        set.add(new Box(4));
        set.add(new Box(1));
        set.add(new Box(0));
        set.add(new Box(2));
        set.add(new Box(2));
        set.add(new Box(0));
    }

    static class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box o1, Box o2) {
            if (o1.value == 0 || o2.value == 0) {
                if (o1.value == 0) {
                    return -1;
                } else return 1;
            }
            return Integer.compare(o2.value, o1.value);
        }
    }
}
