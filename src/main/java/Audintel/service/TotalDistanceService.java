package Audintel.service;

import Audintel.dao.Destination;
import Audintel.dao.TotalDistance;
import Audintel.repository.TotalDistanceRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TotalDistanceService {

    @Autowired
    TotalDistanceRepository repo;

    public TotalDistance saveTotalDistance(TotalDistance totalDistance) {
        return repo.save(totalDistance);
    }

    public TotalDistance updateTotalDistance(TotalDistance newObj) {
        TotalDistance oldObj = getTotalDistanceById(newObj.getId());
        if (!Objects.equals(newObj.getTotalDistance(), oldObj.getTotalDistance()))
            oldObj.setTotalDistance(newObj.getTotalDistance());
        if (!Objects.equals(newObj.getCode(), oldObj.getCode()))
            oldObj.setCode(newObj.getCode());
        if (!Objects.equals(newObj.getMember(), oldObj.getMember()))
            oldObj.setMember(newObj.getMember());
        repo.save(oldObj);
        return oldObj;
    }

    public TotalDistance patchTotalDistance(TotalDistance newObj) {
        TotalDistance oldObj = getTotalDistanceById(newObj.getId());
        if (!Objects.equals(newObj.getTotalDistance(), oldObj.getTotalDistance()))
            oldObj.setTotalDistance(newObj.getTotalDistance());
        if (!Objects.equals(newObj.getCode(), oldObj.getCode()))
            oldObj.setCode(newObj.getCode());
        if (!Objects.equals(newObj.getMember(), oldObj.getMember()))
            oldObj.setMember(newObj.getMember());
        repo.save(oldObj);
        return oldObj;
    }

    public String findAllTotalDistances() {
        List<TotalDistance> list = (List<TotalDistance>) repo.findAll();
        String json = "";
        for (TotalDistance td : list) {
            Gson g = new Gson();
            json += g.toJson(td) + "\n";
        }
        return json;
    }

    public TotalDistance getTotalDistanceById(Integer id) {
        Optional<TotalDistance> totalDistance = repo.findById(id);
        return totalDistance.orElse(null);
    }

    public void deleteTotalDistance(Integer id) {
        TotalDistance td = getTotalDistanceById(id);
        repo.delete(td);
    }

    public List<TotalDistance> getAllTotalDistances() {
        return (List<TotalDistance>) repo.findAll();
    }

    public String findAll() {
        List<TotalDistance> dlist = (List<TotalDistance>) repo.findAll();
        StringBuilder json = new StringBuilder();
        System.out.println(dlist);
        for(TotalDistance d: dlist){
            //System.out.println(d.getDest_Id());
            Gson g = new Gson();
            json.append(g.toJson(d)).append("\n");
        }
        return json.toString();
    }
}

