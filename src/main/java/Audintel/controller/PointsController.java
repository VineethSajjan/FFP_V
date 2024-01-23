package Audintel.controller;

import Audintel.dao.Points;
import Audintel.dao.TravelInfo;
import Audintel.service.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Points")
public class PointsController {

    @Autowired
    private PointsService pointsService;

    @PostMapping("/save")
    public Points savePoints(@RequestBody Points points) {
        return pointsService.savePoints(points);
    }

   /* @PutMapping("/update")
    public Points updatePoints(@RequestBody TravelInfo travel) {
        return pointsService.updatePoints(travel);
    }*/

    @PatchMapping("/patch")
    public Points patchPoints(@RequestBody Points points) {
        return pointsService.patchPoints(points);
    }

    @GetMapping("/findAll")
    public String findAll() {
        return pointsService.findAll();
    }

    @GetMapping("/list")
    public List<Points> getList() {
        return pointsService.findList();
    }

    @GetMapping("/{pointsId}")
    public Points get(@PathVariable int pointsId) {
        return pointsService.getPoints(pointsId);
    }

    @DeleteMapping("/delete/{pointsId}")
    public void delete(@PathVariable int pointsId) {
        pointsService.delete(pointsId);
    }
}
