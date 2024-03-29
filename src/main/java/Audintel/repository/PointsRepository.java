package Audintel.repository;

import Audintel.dao.Points;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointsRepository extends CrudRepository<Points, Integer> {
    List<Points> findByMemberId(int memberId);

    Optional<Points> findByticketId(int ticketId);
}

