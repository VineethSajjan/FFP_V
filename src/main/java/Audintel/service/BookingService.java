package Audintel.service;

import Audintel.dao.Booking;
import Audintel.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingService {
    @Autowired
    BookingRepository repo;
    public boolean validate(int BookingId) {
        if(repo.findByBookingId(BookingId).isPresent()){
            return true;
        }
        else{
            return false;
        }
    }

    public Booking getObject(int BookingId) {
        Optional<Booking> obj =repo.findByBookingId(BookingId);
        return obj.orElse(null);
    }
}
