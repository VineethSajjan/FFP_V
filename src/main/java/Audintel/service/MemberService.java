package Audintel.service;
import Audintel.dao.Member;
import Audintel.repository.MemberRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    MemberRepository repo;
    public Member saveMember(Member member) {

        return repo.save(member);
    }

    public Member updateMember(Member newObj) {
        Member oldObj = getMemberById(newObj.getMemberId());
        oldObj.setMemberCode(newObj.getMemberCode());
        oldObj.setFirstName(newObj.getFirstName());
        oldObj.setLastName(newObj.getLastName());
        oldObj.setDob(newObj.getDob());
        oldObj.setEmail(newObj.getEmail());
        oldObj.setPhno(newObj.getPhno());
        oldObj.setPswd(newObj.getPswd());
        oldObj.setPoints(newObj.getPoints());
        oldObj.setHno(newObj.getHno());
        oldObj.setStreet(newObj.getStreet());
        oldObj.setVillage(newObj.getVillage());
        oldObj.setCity(newObj.getCity());
        oldObj.setState(newObj.getState());
        oldObj.setPincode(newObj.getPincode());
        oldObj.setCreatedAt(newObj.getCreatedAt());
        oldObj.setCreatedBy(newObj.getCreatedBy());
        oldObj.setUpdatedAt(newObj.getUpdatedAt());
        oldObj.setUpdatedBy(newObj.getUpdatedBy());
        oldObj.setIsActive(newObj.getIsActive());
        repo.save(oldObj);
        //Destination oldObj1 = getDestination(newObj.getDest_Id());
        return oldObj;
    }

    public Member patchMember(Member newObj) {

        Member oldObj = getMemberById(newObj.getMemberId());
        if (!Objects.equals(newObj.getMemberCode(), oldObj.getMemberCode()))
            oldObj.setMemberCode(newObj.getMemberCode());
        if (!Objects.equals(newObj.getFirstName(), oldObj.getFirstName()))
            oldObj.setFirstName(newObj.getFirstName());
        if (!Objects.equals(newObj.getLastName(), oldObj.getLastName()))
            oldObj.setLastName(newObj.getLastName());
        if (!Objects.equals(newObj.getDob(), oldObj.getDob()))
            oldObj.setDob(newObj.getDob());
        if (!Objects.equals(newObj.getEmail(), oldObj.getEmail()))
            oldObj.setEmail(newObj.getEmail());
        if (!Objects.equals(newObj.getPhno(), oldObj.getPhno()))
            oldObj.setPhno(newObj.getPhno());
        if (!Objects.equals(newObj.getPswd(), oldObj.getPswd()))
            oldObj.setPswd(newObj.getPswd());
        if (!Objects.equals(newObj.getPoints(), oldObj.getPoints()))
            oldObj.setPoints(newObj.getPoints());
        if (!Objects.equals(newObj.getHno(), oldObj.getHno()))
            oldObj.setHno(newObj.getHno());
        if (!Objects.equals(newObj.getStreet(), oldObj.getStreet()))
            oldObj.setStreet(newObj.getStreet());
        if (!Objects.equals(newObj.getVillage(), oldObj.getVillage()))
            oldObj.setVillage(newObj.getVillage());
        if (!Objects.equals(newObj.getCity(), oldObj.getCity()))
            oldObj.setCity(newObj.getCity());
        if (!Objects.equals(newObj.getState(), oldObj.getState()))
            oldObj.setState(newObj.getState());
        if (!Objects.equals(newObj.getPincode(), oldObj.getPincode()))
            oldObj.setPincode(newObj.getPincode());
        if (!Objects.equals(newObj.getCreatedAt(), oldObj.getCreatedAt()))
            oldObj.setCreatedAt(newObj.getCreatedAt());
        if (!Objects.equals(newObj.getCreatedBy(), oldObj.getCreatedBy()))
            oldObj.setCreatedBy(newObj.getCreatedBy());
        if (!Objects.equals(newObj.getUpdatedAt(), oldObj.getUpdatedAt()))
            oldObj.setUpdatedAt(newObj.getUpdatedAt());
        if (!Objects.equals(newObj.getUpdatedBy(), oldObj.getUpdatedBy()))
            oldObj.setUpdatedBy(newObj.getUpdatedBy());
        if (!Objects.equals(newObj.getIsActive(), oldObj.getIsActive()))
            oldObj.setIsActive(newObj.getIsActive());
        repo.save(oldObj);

        return oldObj;
    }

    public String findAllMembers() {
        List<Member> list = (List<Member>) repo.findAll();
        String json = "";
        for(Member m: list){
            Gson g = new Gson();
            json += g.toJson(m)+"\n";
        }
        return json;
    }

    public Member getMemberById(Integer id) {
        Optional<Member> member = repo.findById(id);
        return member.orElse(null);
    }

    public void deleteMember(Integer id) {
        Member mem =  getMemberById(id);
        repo.delete(mem);
    }

    public List<Member> getListMembers() {
        List<Member> ml = (List<Member>) repo.findAll();
        return ml;
    }

    public void changePoints(int memberId, int calculatedPoints) {
        Member oldObj = getMemberById(memberId);
        int points = oldObj.getPoints();
        points =points+calculatedPoints;
        oldObj.setPoints(points);
        repo.save(oldObj);
    }

    public Member getMemberByEmail(String email) {
        return repo.findByEmail(email);
    }
}
