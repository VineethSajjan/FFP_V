package Audintel.controller;

import Audintel.dao.TravelInfo;
import Audintel.service.TravelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TravelInfo")
public class TravelInfoController {

    @Autowired
    private TravelInfoService travelInfoService;


    @PostMapping("/save")
    public TravelInfo save(@RequestBody TravelInfo travelInfo) {
        return travelInfoService.saveTravelInfo(travelInfo);
    }

    @PutMapping("/update")
    public TravelInfo update(@RequestBody TravelInfo travelInfo) {
        return travelInfoService.updateTravelInfo(travelInfo);
    }

    @PatchMapping("/patch")
    public TravelInfo patch(@RequestBody TravelInfo travelInfo) {
        return travelInfoService.patchTravelInfo(travelInfo);
    }

    @GetMapping("/findAll")
    public String findAll() {
        return travelInfoService.findAll();
    }

    @GetMapping("/list")
    public List<TravelInfo> getList() {
        return travelInfoService.findList();
    }

    @GetMapping("/{ticketId}")
    public TravelInfo get(@PathVariable int ticketId) {
        return travelInfoService.getTravelInfo(ticketId);
    }

    @DeleteMapping("/delete/{ticketId}")
    public void delete(@PathVariable int ticketId) {
        travelInfoService.delete(ticketId);
    }
}
