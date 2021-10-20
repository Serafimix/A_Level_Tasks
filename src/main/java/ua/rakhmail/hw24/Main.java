package ua.rakhmail.hw24;

import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;
import ua.rakhmail.hw24.service.FactoryService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        FactoryService factoryService = new FactoryService();
        Factory factory = new Factory();
        factory.setName("asd");
        factory.setCountry("USA");
        factoryService.saveFactory(factory);
        Technique technique = new Technique();
        technique.setFactory(factory);
        factory.getTechniques().add(technique);
    }
}
