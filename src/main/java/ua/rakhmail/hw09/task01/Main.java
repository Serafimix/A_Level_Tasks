package ua.rakhmail.hw09.task01;

public class Main {
    public static void main(String[] args) {
        CreaturePlanet[] planets = {new Earth("Earth", 510_072_000L, true),
                new Mars("Mars", 1_443_700_000L, true),
                new Uranus("Uranus", 811_560_000_000L, false),
                new Venus("Venus", 460_000_000_000L, false)};
        for (var info : planets) {
            System.out.println("Атмосфера планеты " + info.getName() + " " + info.isAtmosphere() +
                    ", а ускорение свободного падения = " + info.gravityAccel + " м/с²");
        }
    }
}
