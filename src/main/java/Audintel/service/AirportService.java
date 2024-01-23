package Audintel.service;

import Audintel.dao.Airport;
import Audintel.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    AirportRepository repo;

    public Airport saveAirport(Airport airport) {
        return repo.save(airport);
    }

    public Airport getAirport(Integer id) {
        Optional<Airport> airport = repo.findById(id);
        return airport.orElse(null);
    }

    public Airport updateAirport(Airport newObj) {
        Airport oldObj = getAirport(newObj.getPortId());
        oldObj.setPortName(newObj.getPortName());
        oldObj.setPortCity(newObj.getPortCity());
        repo.save(oldObj);
        return oldObj;
    }

    public Airport patchAirport(Airport newObj) {
        Airport oldObj = getAirport(newObj.getPortId());
        if (!Objects.equals(newObj.getPortName(), oldObj.getPortName()))
            oldObj.setPortName(newObj.getPortName());
        if (!Objects.equals(newObj.getPortCity(), oldObj.getPortCity()))
            oldObj.setPortCity(newObj.getPortCity());
        repo.save(oldObj);
        return oldObj;
    }

    public String findAll() {
        List<Airport> airportList = (List<Airport>) repo.findAll();
        StringBuilder json = new StringBuilder();
        for (Airport airport : airportList) {
            Gson gson = new Gson();
            json.append(gson.toJson(airport)).append("\n");
        }
        return json.toString();
    }

    public List<Airport> findList() {
        return (List<Airport>) repo.findAll();
    }

    public void delete(Integer id) {
        Airport airport = getAirport(id);
        repo.delete(airport);
    }
}
