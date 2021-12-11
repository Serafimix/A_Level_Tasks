package ua.rakhmail.Spring_tasks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rakhmail.Spring_tasks.dto.Visit;
import ua.rakhmail.Spring_tasks.repository.VisitRepository;
import ua.rakhmail.Spring_tasks.repository.entity.VisitEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {
    private final VisitRepository visitRepository;

    @Autowired
    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> getAllVisit() {
        List<Visit> visits = new ArrayList<>();
        visitRepository.findAll().forEach(it -> visits.add(new Visit(it.getId(), it.getName(),
                it.getDate(), it.getCity())));
        return visits;
    }

    public Visit saveVisit(Visit visit) {
        VisitEntity entity = visitRepository.save(new VisitEntity(null, visit.getName(),
                visit.getDate(), visit.getCity()));
        return new Visit(entity.getId(), entity.getName(), entity.getDate(), entity.getCity());
    }

    public void deleteVisit(long id) {
        visitRepository.deleteById(id);
    }

    public boolean isExists(long id) {
        return visitRepository.existsById(id);
    }

    public Optional<Visit> getVist(long id) {
        return visitRepository.findById(id).map(entity -> new Visit(entity.getId(), entity.getName(),
                entity.getDate(), entity.getCity()));
    }

}
