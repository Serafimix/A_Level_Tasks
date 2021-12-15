package ua.rakhmail.Spring_tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.rakhmail.Spring_tasks.service.HorseService;
import ua.rakhmail.Spring_tasks.service.RaceService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("")
public class RaceController {
    @Autowired
    HorseService horseService;
    RaceService raceService;

    @GetMapping("/")
    public void getHelloInfo(){

    }


    @GetMapping("/race/{id}")
    public String getRaceInfo(@PathVariable(name = "id") int id) {
        return "raceInfo";
    }

    @PostMapping("race/start/{id}")
    public void startRace(@PathVariable(name = "count", value = "") int count) throws InterruptedException {

    }

    @GetMapping("/stats")
    public String getStats() {

        return "stats";
    }

}
