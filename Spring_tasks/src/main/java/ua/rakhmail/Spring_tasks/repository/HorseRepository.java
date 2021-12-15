package ua.rakhmail.Spring_tasks.repository;

import org.springframework.data.repository.CrudRepository;
import ua.rakhmail.Spring_tasks.repository.entity.HorseEntity;

public interface HorseRepository extends CrudRepository<HorseEntity, Long> {

}
