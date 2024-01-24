package Audintel.repository;



import Audintel.dao.TotalDistance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TotalDistanceRepository extends CrudRepository<TotalDistance, Integer> {
    Optional<TotalDistance> findByMemberId(Integer memberId);
}
