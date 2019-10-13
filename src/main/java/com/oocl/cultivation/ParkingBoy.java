package com.oocl.cultivation;

import java.util.Map;

public class ParkingBoy {

    private final ParkingLot parkingLot;

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    private String lastErrorMessage;
    private Car car;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket = parkingLot.parkCar(car);

        if(parkingTicket == null){
            setLastErrorMessage("Not enough position.");
        }
        return parkingTicket;

    }

    public Car fetch(ParkingTicket ticket) {

        Car fetchedCar = parkingLot.getCar(ticket);

        if (fetchedCar==null){
            setLastErrorMessage("Unrecognized parking ticket.");
            return null;
        }
        return fetchedCar;
    }

    public void fetch(){
        setLastErrorMessage("Please Provide your Parking ticket");
    }

    public String getLastErrorMessage() {
        return lastErrorMessage;
    }
}
