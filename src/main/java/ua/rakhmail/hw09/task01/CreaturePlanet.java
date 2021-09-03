package ua.rakhmail.hw09.task01;

public class CreaturePlanet implements Planet {
    private final String name;
    private final long square;
    protected double gravityAccel;
    private final boolean atmosphere;

    public CreaturePlanet(String name, long square, boolean atmosphere) {
        this.name = name;
        this.square = square;
        gravityAccel = getGOfPlanet();
        this.atmosphere = atmosphere;
    }

    public String getName() {
        return name;
    }

    public boolean isAtmosphere() {
        return atmosphere;
    }

    @Override
    public double getGOfPlanet() {
        double g;
        return g = Math.abs(square * square / square); // расчет условный, а так g =
        // гравитационная постоянная ( 6,67430[15] * 10-11 m*s*kg ) умноженная на
        // массу планеты деленную на радиус планеты в квадрате.
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
