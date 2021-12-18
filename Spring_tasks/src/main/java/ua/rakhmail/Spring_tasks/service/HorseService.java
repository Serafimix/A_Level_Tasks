package ua.rakhmail.Spring_tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rakhmail.Spring_tasks.dto.Horse;
import ua.rakhmail.Spring_tasks.repository.HorseRepository;
import ua.rakhmail.Spring_tasks.repository.entity.HorseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HorseService {
    private final HorseRepository horseRepository;

    @Autowired
    public HorseService(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    public List<Horse> getAllHorses() {
        List<Horse> horses = new ArrayList<>();
        horseRepository.findAll().forEach(it -> horses.add(new Horse(it.getId(), it.getName(), it.getPlace(),
                it.isChosen(), it.getRace())));
        return horses;
    }

    public Horse saveHorse(Horse horse) {
        HorseEntity entity = horseRepository.save(new HorseEntity(null, horse.getName(), horse.getPlace(),
                 horse.isChosen(), horse.getRace()));
        return new Horse(entity.getId(), entity.getName(), entity.getPlace(), entity.isChosen());
    }

    public void deleteVisit(long id) {
        horseRepository.deleteById(id);
    }

    public boolean isExists(long id) {
        return horseRepository.existsById(id);
    }

    public Optional<Horse> getHorse(long id) {
        return horseRepository.findById(id).map(entity -> new Horse(entity.getId(), entity.getName(),
                entity.getPlace(), entity.isChosen()));
    }

}
