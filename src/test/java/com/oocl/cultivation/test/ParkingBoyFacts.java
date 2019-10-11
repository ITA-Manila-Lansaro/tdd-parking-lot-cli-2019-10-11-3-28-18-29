package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_return_ticket_when_parking_boy_parts_at_the_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);

        assertNotNull(parkingLot.getCars(parkingTicket));
    }

    @Test
    void should_return_car_when_parking_boy_fetch_car_from_parking_lot() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);

        assertEquals(car, parkingBoy.fetch(parkingTicket));
    }

    @Test
    void should_return_no_car_when_customer_gives_wrong_ticket(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);
        ParkingTicket wrongParkingTicket = parkingBoy.park(new Car());

        assertNotEquals(wrongParkingTicket, parkingBoy.fetch(parkingTicket));
    }

    @Test
    void should_fetch_no_car_if_customer_gives_ticket_that_has_already_been_used(){
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        ParkingTicket parkingTicket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(parkingTicket);
        assertEquals(car, fetchedCar);

        Car fetchCarAgain = parkingBoy.fetch(parkingTicket);
        assertNull(fetchCarAgain);
    }

    @Test
    void should_return_no_ticket_if_the_park_is_full(){

        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        IntStream.rangeClosed(0,10).forEach( a ->
                parkingBoy.park(new Car())
                );

        ParkingTicket excessCar = parkingBoy.park(new Car());

        assertNull(excessCar);
    }
}
