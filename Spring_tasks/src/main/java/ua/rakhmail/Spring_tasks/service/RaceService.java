package ua.rakhmail.Spring_tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rakhmail.Spring_tasks.dto.Race;
import ua.rakhmail.Spring_tasks.repository.RaceRepository;
import ua.rakhmail.Spring_tasks.repository.entity.RaceEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        List<Race> races = new ArrayList<>();
        raceRepository.findAll().forEach(it -> races.add(new Race(it.getId(), it.getDate())));
        return races;
    }

    public Race saveRace(Race race) {
        RaceEntity entity = raceRepository.save(new RaceEntity(null, race.getDate()));
        return new Race(entity.getId(), entity.getDate());
    }

    public void deleteRace(long id) {
        raceRepository.deleteById(id);
    }

    public boolean isExists(long id) {
        return raceRepository.existsById(id);
    }

    public Optional<Race> getRace(long id) {
        return raceRepository.findById(id).map(entity -> new Race(entity.getId(), entity.getDate()));
    }

}
