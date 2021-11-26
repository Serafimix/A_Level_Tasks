package ua.rakhmail.hw11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlanetEnumTest {
    @Mock
    PlanetEnum mercury;
    @Mock
    PlanetEnum venus;
    @Mock
    PlanetEnum earth;
    @Mock
    PlanetEnum mars;
    @Mock
    PlanetEnum jupiter;
    @Mock
    PlanetEnum saturn;
    @Mock
    PlanetEnum planet;


    @BeforeEach
    void setUp() {
        mercury = PlanetEnum.MERCURY;
        venus = PlanetEnum.VENUS;
        earth = PlanetEnum.EARTH;
        mars = PlanetEnum.MARS;
        jupiter = PlanetEnum.JUPITER;
        saturn = PlanetEnum.SATURN;
        planet = PlanetEnum.EARTH;
    }

    @Test
    void main() {
        assertEquals(0, mercury.getSatellite());
        assertEquals(1, venus.getSatellite());
        assertEquals(1, earth.getSatellite());
        assertEquals(2, mars.getSatellite());
        assertEquals(79, jupiter.getSatellite());
        assertEquals(82, saturn.getSatellite());
    }


    @Test
    void testWithSwitchCaseAndGetName() {
        String string = "This is EARTH";
        String string1;
        switch (planet) {
            case MERCURY -> string1 = "This is " + mercury.name();
            case VENUS -> string1 = "This is " + venus.name();
            case EARTH -> string1 = "This is " + earth.name();
            case MARS -> string1 = "This is " + mars.name();
            case JUPITER -> string1 = "This is " + jupiter.name();
            case SATURN -> string1 = "This is " + saturn.name();
            default -> throw new IllegalStateException("Unexpected value: " + planet);
        }
        assertEquals(string, string1);
    }
}