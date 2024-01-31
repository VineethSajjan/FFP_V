package Audintel.repository;

import Audintel.dao.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking,Integer> {

    Optional<Booking> findByBookingId(int bookingId);
}
