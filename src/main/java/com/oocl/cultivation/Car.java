package com.oocl.cultivation;

public class Car extends ParkingLot{
    private ParkingTicket ticket;

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
