package Audintel.repository;

import Audintel.dao.Points;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsRepository extends CrudRepository<Points, Integer> {
}

