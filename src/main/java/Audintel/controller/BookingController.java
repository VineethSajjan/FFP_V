package Audintel.controller;

import Audintel.repository.BookingRepository;
import Audintel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Booking")
@CrossOrigin(origins = "http://localhost:3000/")
public class BookingController {
    @Autowired
    private BookingService service;
}
