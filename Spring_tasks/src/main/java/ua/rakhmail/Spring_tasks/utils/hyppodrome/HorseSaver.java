package ua.rakhmail.Spring_tasks.utils.hyppodrome;

import ua.rakhmail.Spring_tasks.repository.entity.HorseEntity;
import ua.rakhmail.Spring_tasks.repository.entity.RaceEntity;
import ua.rakhmail.Spring_tasks.service.HorseService;

import java.util.ArrayList;
import java.util.List;

public class HorseSaver {
    private final HorseService horseService;

    public HorseSaver(HorseService horseService) {
        this.horseService = horseService;
    }

    public synchronized void addNewRace(int horse, int chose) {

        List<HorseEntity> horses = new ArrayList<>();

        Hippodrome hippodrome = new Hippodrome();

        hippodrome.startRace(horse, chose);

        RaceEntity race = new RaceEntity();

        hippodrome.getList().forEach(x -> {
            if (x.getNumber() == chose) {
                horses.add(new HorseEntity(null, x.getName(), x.getPlaceInRace(), true, race));

            } else {
                horses.add(new HorseEntity(null, x.getName(), x.getPlaceInRace(), false, race));
            }
        });
        horses.forEach(x->horseService.saveHorse(x));

        hippodrome.getList().clear();
        HorseThread.placeCount.set(0);
    }

}
