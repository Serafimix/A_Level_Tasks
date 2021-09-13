package ua.rakhmail.hw14;

class Util implements Multiplier {
    Object value;

    public void printHashCode(Object e) {
        System.out.println("HashCode: " + e.hashCode());
    }

    public void save(Object value) {
        this.value = value;
    }

    public Object get() {
        return value;
    }

    @Override
    public Object[] doubleValueIn(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        return array;
    }

    public void sum(Object one, Object two) { // should work only with numbers
        System.out.println(one + two);
    }

    public double sumOfArray(List<Object> list) {
        double s = 0.0;
        for (Object n : list) {
            s += n;
        }
        return s;
    }

    public void addNumbers(List<Object> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }
}

interface Multiplier {
    Object[] doubleValueIn(Object[] array);
}

public class Test {
    public static void main(String[] args) {
        Util<String> util = new Util<>();
        util.printHashCode("Test");
        util.save("Value");
        System.out.println(util.get());
        Number[] arr = {1, 2, 3, 4, 0, 5, 6, 7};
        System.out.println(Arrays.toString(util.doubleValueIn(arr)));
        System.out.println(util.sumOfArray(Arrays.asList(arr)));
        List<Integer> list = new ArrayList<>();
        util.addNumbers(list);
        System.out.println(Arrays.toString(list.toArray()));
    }
}