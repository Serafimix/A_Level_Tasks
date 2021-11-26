package ua.rakhmail.hw23;

import ua.rakhmail.hw23.creatorService.AddObjects;
import ua.rakhmail.hw23.creatorService.CreatorTable;
import ua.rakhmail.hw23.creatorService.TableService;


public class Main {
    public static void main(String[] args) {
        CreatorTable.createTable();
        AddObjects.addObjects();
        TableService.getListOfCreateFactory(1);
        TableService.getSumOfFactoryObject();
        TableService.getInfoObjectFromTable(7);
        TableService.changeTechniqueForHaving(1);
        TableService.deleteObjectFromTable(4);
    }
}
