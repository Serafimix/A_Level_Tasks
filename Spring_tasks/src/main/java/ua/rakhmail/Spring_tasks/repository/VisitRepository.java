package ua.rakhmail.Spring_tasks.repository;


import org.springframework.data.repository.CrudRepository;
import ua.rakhmail.Spring_tasks.repository.entity.VisitEntity;

public interface VisitRepository extends CrudRepository<VisitEntity, Long> {
}