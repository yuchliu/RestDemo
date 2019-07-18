package com.yuchen.spring.demo.controller;

import com.yuchen.spring.demo.entity.Elite;
import com.yuchen.spring.demo.service.EliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EliteRestController {

    private EliteService eliteService;

    public EliteRestController() {}

    @Autowired
    public EliteRestController(EliteService eliteService) {
        this.eliteService = eliteService;
    }

    @GetMapping("/elites")
    public List<Elite> getElites() {
        return eliteService.getElites();
    }

    @GetMapping("/elites/{id}")
    public Elite getElite(@PathVariable int id) {
        Elite elite = eliteService.getElite(id);
        if (elite == null) {
            throw new EliteNotFoundException("Elite Not Found Id - " + id);
        }
        return elite;
    }

    @PostMapping("/elites")
    public Elite saveElite(@RequestBody Elite elite) {
        elite.setId(0);
        eliteService.saveElite(elite);
        return elite;
    }

    @PutMapping("/elites")
    public Elite updateElite(@RequestBody Elite elite) {
        eliteService.saveElite(elite);
        return elite;
    }

    @DeleteMapping("/elites/{id}")
    public String deleteElite(@PathVariable int id) {
        Elite elite = eliteService.getElite(id);
        if (elite == null) {
            throw new EliteNotFoundException("Elite Not Found Id - " + id);
        }

        eliteService.deleteElite(id);
        return "Delete Elite --" + elite.getFirstName() + " " + elite.getLastName() + " from the harem, she is weeping!";
    }
}
