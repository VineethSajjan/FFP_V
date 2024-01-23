package Audintel.controller;

import Audintel.dao.Destination;
import Audintel.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Destination")
public class DestinationController {
    @Autowired
    DestinationService service;
    @PostMapping("/save")
    public Destination save(@RequestBody Destination dest){
        return service.saveDestination(dest);
    }
    @PutMapping("/update")
    public Destination update(@RequestBody Destination dest){
        return  service.updateDestination(dest);
    }
    @PatchMapping ("/patch")
    public Destination patch(@RequestBody Destination dest){
        return  service.patchDestination(dest);
    }
    @GetMapping("/findAll")
    public String findAll(){
        return service.findAll();
    }

    @GetMapping("/list")
    public List<Destination> findList(){


        return service.findList();
    }
    @GetMapping("/{id}")
    public Destination get(@PathVariable Integer id){
        return service.getDestination(id);
    }
    @DeleteMapping("/delete/{id}")

    public void delete(@PathVariable Integer id){

        service.delete(id);
    }

}
