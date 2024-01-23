package Audintel.controller;


import Audintel.dao.Airport;
import Audintel.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Airport")
public class AirportController {
    @Autowired
    AirportService service;

    @PostMapping("/save")
    public Airport save(@RequestBody Airport airport) {
        return service.saveAirport(airport);
    }

    @PutMapping("/update")
    public Airport update(@RequestBody Airport airport) {
        return service.updateAirport(airport);
    }

    @PatchMapping("/patch")
    public Airport patch(@RequestBody Airport airport) {
        return service.patchAirport(airport);
    }

    @GetMapping("/findAll")
    public String findAll() {
        return service.findAll();
    }

    @GetMapping("/list")
    public List<Airport> getList() {
        return service.findList();
    }

    @GetMapping("{id}")
    public Airport get(@PathVariable Integer id) {
        return service.getAirport(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAirport(@PathVariable Integer id) {
        service.delete(id);
    }
}

