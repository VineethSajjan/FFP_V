package Audintel.repository;

import Audintel.dao.TravelInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelInfoRepository extends CrudRepository<TravelInfo,Integer> {
}
