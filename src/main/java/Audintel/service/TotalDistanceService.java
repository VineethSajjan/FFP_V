package Audintel.service;

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
    @Autowired
    MemberService service;

    public TotalDistance saveTotalDistance(TotalDistance totalDistance) {
        return repo.save(totalDistance);
    }

    public TotalDistance updateTotalDistance(TotalDistance newObj) {
        TotalDistance oldObj = getTotalDistanceById(newObj.getId());
        if (!Objects.equals(newObj.getTotalDistance(), oldObj.getTotalDistance()))
            oldObj.setTotalDistance(newObj.getTotalDistance());
        if (!Objects.equals(newObj.getCode(), oldObj.getCode()))
            oldObj.setCode(newObj.getCode());
        if (!Objects.equals(newObj.getMemberId(), oldObj.getMemberId()))
            oldObj.setMemberId(newObj.getMemberId());
        repo.save(oldObj);
        return oldObj;
    }

    public TotalDistance patchTotalDistance(TotalDistance newObj) {
        TotalDistance oldObj = getTotalDistanceById(newObj.getId());
        if (!Objects.equals(newObj.getTotalDistance(), oldObj.getTotalDistance()))
            oldObj.setTotalDistance(newObj.getTotalDistance());
        if (!Objects.equals(newObj.getCode(), oldObj.getCode()))
            oldObj.setCode(newObj.getCode());
        if (!Objects.equals(newObj.getMemberId(), oldObj.getMemberId()))
            oldObj.setMemberId(newObj.getMemberId());
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

    public void CalculateTotalDistance(int distance,int memberId) {
        TotalDistance d = getTotalDistanceById(memberId);
        if(d==null){
            Insert(distance,memberId,0);
        }
        else{
            long TotalDistance = d.getTotalDistance();
            TotalDistance+=distance;
            int code = d.getCode();
            Bonus(TotalDistance,memberId,code);
            d.setTotalDistance(TotalDistance);
        repo.save(d);
        }
    }

    private void Bonus(long totalDistance, int memberId, int code) {
        int calculatedPoints=0;

        switch (code) {
            case 4:
                break;
            case 3:
                if (totalDistance >= 1000000) {
                    calculatedPoints = 10000;
                    code++;
                }
                break;
            case 2:
                if (totalDistance >= 500000) {
                    calculatedPoints = 5000;
                    code++;
                }
                break;
            case 1:
                if (totalDistance >= 100000) {
                    calculatedPoints = 1000;
                    code++;
                }
                break;
            case 0:
                if (totalDistance >= 10000) {
                    calculatedPoints = 500;
                    code++;
                }
                break;
        }
        TotalDistance d = getTotalDistanceById(memberId);
        d.setCode(code);
        repo.save(d);
        service.changePoints(calculatedPoints,memberId);
    }

    private void Insert(int distance, int memberId, int code) {
        TotalDistance d = new TotalDistance();
        d.setTotalDistance(distance);
        d.setMemberId(memberId);
        d.setCode(code);
        repo.save(d);
    }
}

