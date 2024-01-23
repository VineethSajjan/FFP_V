package Audintel.controller;

import Audintel.dao.TotalDistance;
import Audintel.service.TotalDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import Audintel.dao.TotalDistance;
import Audintel.service.TotalDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/total-distance")
public class TotalDistanceController {

    @Autowired
    TotalDistanceService totalDistanceService;

    @GetMapping("/list")
    public List<TotalDistance> getAllTotalDistances() {
        return totalDistanceService.getAllTotalDistances();
    }

    @GetMapping("/{id}")
    public TotalDistance getTotalDistanceById(@PathVariable Integer id) {
        return totalDistanceService.getTotalDistanceById(id);
    }

    @PostMapping("/save")
    public TotalDistance saveTotalDistance(@RequestBody TotalDistance totalDistance) {
        return totalDistanceService.saveTotalDistance(totalDistance);
    }

    @PutMapping("/update")
    public TotalDistance updateTotalDistance(@RequestBody TotalDistance totalDistance) {
        return totalDistanceService.updateTotalDistance(totalDistance);
    }

    @PatchMapping("/patch")
    public TotalDistance patchTotalDistance(@RequestBody TotalDistance totalDistance) {
        return totalDistanceService.patchTotalDistance(totalDistance);
    }
    @GetMapping("/findAll")
    public String findAll(){
        return totalDistanceService.findAll();
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTotalDistance(@PathVariable Integer id) {
        totalDistanceService.deleteTotalDistance(id);
    }

}
