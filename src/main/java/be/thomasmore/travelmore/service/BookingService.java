package be.thomasmore.travelmore.service;

import be.thomasmore.travelmore.domain.Booking;
import be.thomasmore.travelmore.repository.BookingRepository;
import javax.inject.Inject;
import java.util.List;

public class BookingService {

    @Inject
    private BookingRepository bookingRepository;

    public Booking findBookingById(int id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    public void insert(Booking booking){
    }
}