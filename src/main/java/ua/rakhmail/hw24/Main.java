package ua.rakhmail.hw24;

import ua.rakhmail.hw24.services.FactoryHService;
import ua.rakhmail.hw24.services.TechniqueHService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final TechniqueHService TECHNIQUE_H_SERVICE = new TechniqueHService();
    private static final FactoryHService FACTORY_H_SERVICE = new FactoryHService();

    private static final Map<String, String> MAPS_OF_TECHNIQUE = new HashMap<>();
    private static final Map<String, String> MAPS_OF_FACTORIES = new HashMap<>();

    public static void main(String[] args) {
        final String guid = FACTORY_H_SERVICE.save("Factorio", "USA");
        MAPS_OF_FACTORIES.put("Factorio", guid);
    }
}
