package Audintel.service;

import Audintel.dao.TravelInfo;
import Audintel.repository.TravelInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TravelInfoService {

    @Autowired
    private TravelInfoRepository travelInfoRepository;
    @Autowired
    private PointsService pointsService;

    public TravelInfo saveTravelInfo(TravelInfo travelInfo) {
        return travelInfoRepository.save(travelInfo);
    }

    public TravelInfo getTravelInfo(int ticketId) {
        Optional<TravelInfo> travelInfo = travelInfoRepository.findById(ticketId);
        return travelInfo.orElse(null);
    }

    public TravelInfo updateTravelInfo(TravelInfo newTravelInfo) {
        if(getTravelInfo(newTravelInfo.getTicketId())==null){
            travelInfoRepository.save(newTravelInfo);
            pointsService.PointsCalculation(newTravelInfo);
            return newTravelInfo;
        }
        TravelInfo oldTravelInfo = getTravelInfo(newTravelInfo.getTicketId());
        oldTravelInfo.setMemberId(newTravelInfo.getMemberId());
        oldTravelInfo.setDestId(newTravelInfo.getDestId());
        oldTravelInfo.setDate(newTravelInfo.getDate());
        oldTravelInfo.setPersonTravelling(newTravelInfo.isPersonTravelling());
        oldTravelInfo.setTotalMembers(newTravelInfo.getTotalMembers());
        travelInfoRepository.save(oldTravelInfo);
        return oldTravelInfo;
    }

    public TravelInfo patchTravelInfo(TravelInfo newTravelInfo) {
        TravelInfo oldTravelInfo = getTravelInfo(newTravelInfo.getTicketId());
        if (!Objects.equals(newTravelInfo.getMemberId(), oldTravelInfo.getMemberId()))
            oldTravelInfo.setMemberId(newTravelInfo.getMemberId());
        if (!Objects.equals(newTravelInfo.getDestId(), oldTravelInfo.getDestId()))
            oldTravelInfo.setDestId(newTravelInfo.getDestId());
        if (!Objects.equals(newTravelInfo.getDate(), oldTravelInfo.getDate()))
            oldTravelInfo.setDate(newTravelInfo.getDate());
        if (!Objects.equals(newTravelInfo.isPersonTravelling(), oldTravelInfo.isPersonTravelling()))
            oldTravelInfo.setPersonTravelling(newTravelInfo.isPersonTravelling());
        if (!Objects.equals(newTravelInfo.getTotalMembers(), oldTravelInfo.getTotalMembers()))
            oldTravelInfo.setTotalMembers(newTravelInfo.getTotalMembers());
        travelInfoRepository.save(oldTravelInfo);
        return oldTravelInfo;
    }

    public String findAll() {
        List<TravelInfo> travelInfoList = (List<TravelInfo>) travelInfoRepository.findAll();
        StringBuilder json = new StringBuilder();
        for (TravelInfo travelInfo : travelInfoList) {
            Gson gson = new Gson();
            json.append(gson.toJson(travelInfo)).append("\n");
        }
        return json.toString();
    }

    public List<TravelInfo> findList() {
        return (List<TravelInfo>) travelInfoRepository.findAll();
    }

    public void delete(int ticketId) {
        TravelInfo travelInfo = getTravelInfo(ticketId);
        travelInfoRepository.delete(travelInfo);
    }
}
