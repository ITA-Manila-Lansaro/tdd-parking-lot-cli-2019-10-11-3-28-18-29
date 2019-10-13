package com.oocl.cultivation;

public class SuperSmartParkingBoy {
    private final ParkingLot parkingLot;
    private ParkingLot parkingLot2;
    private String lastErrorMessage;
    private Car car;

    public ParkingLot getParkingLot2() {
        return parkingLot2;
    }

    public ParkingLot getParkingLot(){
        return parkingLot;
    }

    public void setLastErrorMessage(String lastErrorMessage) {
        this.lastErrorMessage = lastErrorMessage;
    }

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        ParkingTicket parkingTicket;

        if (parkingLot2 == null){
            ParkingLot parkingLot = new ParkingLot();
            this.parkingLot2 = parkingLot;
        }
        if(parkingLot.getAvailableParkingPosition() > parkingLot2.getAvailableParkingPosition()) {
            parkingTicket = parkingLot2.parkCar(car);
        }else
        {
            parkingTicket = parkingLot.parkCar(car);
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
