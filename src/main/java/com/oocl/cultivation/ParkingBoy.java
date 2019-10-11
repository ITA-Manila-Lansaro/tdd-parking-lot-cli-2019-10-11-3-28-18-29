package com.oocl.cultivation;

import java.util.Map;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    private Car car;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
       return parkingLot.parkCar(car);
    }

    public Car fetch(ParkingTicket ticket) {
        return parkingLot.getCar(ticket);
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
