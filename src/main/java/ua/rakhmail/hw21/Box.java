package ua.rakhmail.hw21;

@AutoCreate()
public class Box {
    @Multiplier
    private final String name = "hello";
    @Multiplier
    private final Double size = 3.0;
    private final Integer weight = 2;

    @Init
    public void printFields() {
        System.out.println(name + ", size= " + size + " weight= " + weight);
    }
}
