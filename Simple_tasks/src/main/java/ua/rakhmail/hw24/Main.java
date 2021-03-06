package ua.rakhmail.hw24;

import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;
import ua.rakhmail.hw24.service.FactoryService;
import ua.rakhmail.hw24.service.TechniqueService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final FactoryService factoryService = new FactoryService();
    private static final TechniqueService techniqueService = new TechniqueService();
    private static final String decor = "**************************************************************************" +
            "***************" + System.lineSeparator();

    public static void main(String[] args) throws SQLException {
        createTenTechniquesAndFourfactory();
        System.out.println(factoryService.findAllFactories());
        System.out.println(techniqueService.findAllTechniques());
        System.out.println(decor + "Get Info for Technique and his Factory #5");
        System.out.println(techniqueService.findTechniqueById(5));
        Technique technique = techniqueService.findTechniqueById(5);
        technique.setHave(true);
        techniqueService.updateTechnique(technique);
        System.out.println(decor + "Change isHaving for technique #5" + System.lineSeparator()
                + techniqueService.findTechniqueById(5));
        System.out.println(decor + "Delete technique from ID 5");
        techniqueService.deleteTechnique(5);
        System.out.println(techniqueService.findTechniqueById(5));
        System.out.println(decor + "GetAllTechnique from factory #2");
        Factory factory = factoryService.findFactoryById(2);
        techniqueService.getTechniquesFromFactoryId(2);
        System.out.println(decor + "Get count and Sum of prices from all Factories");
        factoryService.getCountAndSumFromAllFactories();
    }


    public static void createTenTechniquesAndFourfactory() {
        Factory factory1 = new Factory("Factory1", "USA");
        Factory factory2 = new Factory("Factory2", "China");
        Factory factory3 = new Factory("Factory3", "UK");
        Factory factory4 = new Factory("Factory4", "RUSSIA");
        factoryService.saveFactory(factory1);
        factoryService.saveFactory(factory2);
        factoryService.saveFactory(factory3);
        factoryService.saveFactory(factory4);

        Technique technique1 = new Technique("telephone", "LG150", 300, "2012-02-13", "some text1", factory1);
        techniqueService.saveTechnique(technique1);
        Technique technique2 = new Technique("television", "AOC32", 700, "2011-03-15", "some text2", factory2);
        techniqueService.saveTechnique(technique2);
        Technique technique3 = new Technique("telephone", "iPhone10", 600, "2010-04-21", "some text3", factory3);
        techniqueService.saveTechnique(technique3);
        Technique technique4 = new Technique("television", "Berezka", 250, "1994-05-22", "some text4", factory4);
        techniqueService.saveTechnique(technique4);
        Technique technique5 = new Technique("telephone", "Nokian73Me", 400, "2018-06-24", "some text5", factory1);
        techniqueService.saveTechnique(technique5);
        Technique technique6 = new Technique("television", "SAMSUNGWatch", 1111, "2011-07-11", "some text6", factory2);
        techniqueService.saveTechnique(technique6);
        Technique technique7 = new Technique("telephone", "SiemensA50", 120, "2013-08-01", "some text7", factory3);
        techniqueService.saveTechnique(technique7);
        Technique technique8 = new Technique("television", "iWatchPro", 1100, "2018-09-14", "some text8", factory4);
        techniqueService.saveTechnique(technique8);
        Technique technique9 = new Technique("telephone", "SAMSUNGg15", 700, "2020-12-17", "some text9", factory1);
        techniqueService.saveTechnique(technique9);
        Technique technique10 = new Technique("television", "ChinaTV", 300, "2005-11-30", "some text10", factory2);
        techniqueService.saveTechnique(technique10);
    }
}
