package ua.rakhmail.Spring_tasks.utils.hyppodrome;

import ua.rakhmail.Spring_tasks.repository.HorseRepository;
import ua.rakhmail.Spring_tasks.service.HorseService;

import java.util.ArrayList;
import java.util.List;

public class SaveEntity {


    HorseDao horseDao = new HorseDao();
    RaceDao raceDao = new RaceDao();
    List<Horse> horses = new ArrayList<>();
    Hippodrome hippodrome = new Hippodrome();

    Race race = new Race();
        raceDao.create(race);

        hippodrome.startRace(horse, chose);
        hippodrome.getList().forEach(x -> {
        if (x.getNumber() == chose) {
            horses.add(new Horse(x.getName(), x.getPlaceInRace(), true, race));

        } else {
            horses.add(new Horse(x.getName(), x.getPlaceInRace(), false, race));
        }
    });
        race.setHorses(horses);

        horses.forEach(horseDao::create);
        hippodrome.getList().clear();
        HorseThread.placeCount.set(0);
}
