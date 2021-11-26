package ua.rakhmail.hw11;

public enum PlanetEnum {
    MERCURY(0), VENUS(1), EARTH(1), MARS(2), JUPITER(79), SATURN(82);

    private final int satellite;

    PlanetEnum(int satellite) {
        this.satellite = satellite;
    }

    public int getSatellite() {
        return satellite;
    }

    // testing is attending
}
