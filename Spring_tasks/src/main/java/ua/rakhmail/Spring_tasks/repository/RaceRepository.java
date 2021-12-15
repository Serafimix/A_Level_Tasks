package ua.rakhmail.Spring_tasks.repository;


import org.springframework.data.repository.CrudRepository;
import ua.rakhmail.Spring_tasks.repository.entity.HorseEntity;
import ua.rakhmail.Spring_tasks.repository.entity.RaceEntity;

import java.util.List;

public interface RaceRepository extends CrudRepository<RaceEntity, Long> {
}