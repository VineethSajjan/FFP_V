package Audintel.service;

import Audintel.dao.Destination;
import Audintel.dao.Points;
import Audintel.dao.TravelInfo;
import Audintel.repository.DestinationRepository;
import Audintel.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PointsService {

    @Autowired
    private PointsRepository pointsRepository;
    @Autowired
    private DestinationService service;
    @Autowired
    private MemberService memberService;
    @Autowired
    private TravelInfoService travelInfoService;

    public Points savePoints(Points points) {
        return pointsRepository.save(points);
    }

    public Points getPoints(int pointsId) {
        Optional<Points> points = pointsRepository.findById(pointsId);
        return points.orElse(null);
    }

    public void PointsCalculation(TravelInfo newObj) {
        int calculated_points;
        boolean is_main_person = newObj.isPersonTravelling();
        int total_persons = newObj.getTotalMembers();
        int Distance;

        Distance = getDistance(newObj.getDestId());
        if(is_main_person) {
            calculated_points = Distance / 20 + (total_persons - 1) * Distance / 60;
        }
        else {
            calculated_points = total_persons * Distance / 60;
        }
        Insert(newObj.getMemberId(),newObj.getTicketId(),calculated_points);

    }



    private void Insert(int memberId, int ticketId, int calculatedPoints) {
        Points newPoints = new Points();
        newPoints.setMember(memberService.getMemberById(memberId));
        newPoints.setTravelInfo(travelInfoService.getTravelInfo(ticketId));
        newPoints.setPoints(calculatedPoints);
        pointsRepository.save(newPoints);
    }

    private int getDistance(int destId) {
        Destination Obj = service.getDestination(destId);
        return Obj.getKms();
    }

    public Points patchPoints(Points newPoints) {
        Points oldPoints = getPoints(newPoints.getPointsId());
        if (!Objects.equals(newPoints.getMember(), oldPoints.getMember()))
            oldPoints.setMember(newPoints.getMember());
        if (!Objects.equals(newPoints.getTravelInfo(), oldPoints.getTravelInfo()))
            oldPoints.setTravelInfo(newPoints.getTravelInfo());
        if (!Objects.equals(newPoints.getPoints(), oldPoints.getPoints()))
            oldPoints.setPoints(newPoints.getPoints());
        pointsRepository.save(oldPoints);
        return oldPoints;
    }

    public String findAll() {
        List<Points> pointsList = (List<Points>) pointsRepository.findAll();
        StringBuilder json = new StringBuilder();
        for (Points points : pointsList) {
            Gson gson = new Gson();
            json.append(gson.toJson(points)).append("\n");
        }
        return json.toString();
    }

    public List<Points> findList() {
        return (List<Points>) pointsRepository.findAll();
    }

    public void delete(int pointsId) {
        Points points = getPoints(pointsId);
        pointsRepository.delete(points);
    }

    public Points updatePoints(Points newPoints) {
        Points oldPoints = getPoints(newPoints.getPointsId());
        oldPoints.setTravelInfo(newPoints.getTravelInfo());
        oldPoints.setMember(newPoints.getMember());
        oldPoints.setPoints(newPoints.getPoints());
        pointsRepository.save(oldPoints);
        return oldPoints;
    }
}

