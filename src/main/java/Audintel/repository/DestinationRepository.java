package Audintel.repository;

import Audintel.dao.Destination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends CrudRepository<Destination,Integer> {
}
