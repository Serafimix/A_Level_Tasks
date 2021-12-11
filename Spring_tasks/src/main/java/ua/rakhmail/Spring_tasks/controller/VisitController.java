package ua.rakhmail.Spring_tasks.controller;

import org.springframework.web.bind.annotation.*;
import ua.rakhmail.Spring_tasks.dto.Visit;
import ua.rakhmail.Spring_tasks.service.VisitService;

import java.util.List;

@RestController
@RequestMapping("")
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visit")
    public List<Visit> getAllVisit() {
        return visitService.getAllVisit();
    }

    @DeleteMapping("/visit/{visitId}")
    public void deleteUser(@PathVariable long visitId) {
        if (visitService.isExists(visitId)) {
            visitService.deleteVisit(visitId);
        }
    }

    @PostMapping("/visit")
    public void createUser(@RequestBody Visit visit) {
        visitService.saveVisit(visit);
    }

}
