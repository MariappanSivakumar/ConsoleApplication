package controller;

import view.FlightInfo;

public class BookTicket {

    public void init() {
        new CreateNewFlight().ShowData();
        int flightID = new FlightInfo().getFlightID();
        int totalSeats = new FlightInfo().getFlightSeats();

    }
}
