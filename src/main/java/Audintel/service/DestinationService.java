package Audintel.service;

import Audintel.dao.Destination;
import Audintel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class DestinationService {
    @Autowired
    DestinationRepository repo;
    public Destination saveDestination(Destination dest) {
        return repo.save(dest);
    }

    public Destination getDestination(Integer id) {
        Optional<Destination> dest = repo.findById(id);
        return dest.orElse(null);
    }


    public Destination updateDestination(Destination newObj) {
        Destination oldObj = getDestination(newObj.getDest_Id());
       // Destination dest;
        oldObj.setOrigin(newObj.getOrigin());
        oldObj.setDestination(newObj.getDestination());
        oldObj.setKms(newObj.getKms());
        repo.save(oldObj);
        //Destination oldObj1 = getDestination(newObj.getDest_Id());
        return oldObj;
    }

    public Destination patchDestination(Destination newObj) {
        Destination oldObj = getDestination(newObj.getDest_Id());
        Destination dest;
        if(!Objects.equals(newObj.getOrigin(), oldObj.getOrigin()))
            oldObj.setOrigin(newObj.getOrigin());
        if(!Objects.equals(newObj.getDestination(), oldObj.getDestination()))
            oldObj.setDestination(newObj.getDestination());
        if(newObj.getDest_Id() != oldObj.getDest_Id())
            oldObj.setDest_Id(newObj.getDest_Id());
        repo.save(oldObj);
       // Destination oldObj1 = getDestination(newObj.getId());
        return oldObj;
    }

    public List<Destination> findAll() {
        List<Destination> dlist = (List<Destination>) repo.findAll();
        return dlist;
    }

    public List<Destination> findList() {
        List<Destination> dl = (List<Destination>) repo.findAll();
        return dl;
    }

    public void delete(Integer id) {
        Destination dest =  getDestination(id);
        repo.delete(dest);
    }
}
