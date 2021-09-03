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
        int hashCode = 1;
        hashCode = hashCode * 13 + (atmosphere ? 1 : 0);
        hashCode = hashCode * 13 + (int) (square ^ (square >>> 32));
        long doubleToLongBits = Double.doubleToLongBits(gravityAccel);
        hashCode = hashCode * 13 + (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        hashCode = hashCode * 13 + name.length();
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CreaturePlanet) && !(this instanceof CreaturePlanet))
            return false;
        else
            return ((this.atmosphere == ((CreaturePlanet) obj).atmosphere) &&
                    (((CreaturePlanet) obj).atmosphere == this.atmosphere) &&
                    (this.name.equals(((CreaturePlanet) obj).name)) &&
                    (((CreaturePlanet) obj).name.equals(this.name)) &&
                    (this.square == ((CreaturePlanet) obj).square) &&
                    (((CreaturePlanet) obj).square == this.square) &&
                    (this.gravityAccel == ((CreaturePlanet) obj).gravityAccel) &&
                    (((CreaturePlanet) obj).gravityAccel == this.gravityAccel));
    }
}
