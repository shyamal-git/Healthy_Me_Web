package com.healthyme.practo.controller;

import com.healthyme.practo.payload.BookingDto;
import com.healthyme.practo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
            @Autowired
            private BookingService bookingService;

     @PostMapping
    public ResponseEntity<String> bookAnAppointment(@RequestBody BookingDto bookingDto){
        bookingService.bookAnAppointment(bookingDto);
        return new ResponseEntity<>("Booing is confirmed", HttpStatus.CREATED);
    }
}
