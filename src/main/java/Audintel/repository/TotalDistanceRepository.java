package Audintel.repository;



import Audintel.dao.TotalDistance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalDistanceRepository extends CrudRepository<TotalDistance, Integer> {

}
