package controller;

import model.Flight;
import view.FlightInfo;
import java.util.List;
import java.util.ArrayList;

public class CreateNewFlight {

    public static List<Flight> flights = new ArrayList();

    private FlightInfo flightDetailsView;

    public CreateNewFlight(FlightInfo flightDetailsView) {
        this.flightDetailsView = flightDetailsView;
    }

    public void ShowData() {
        for (Flight create : flights) {
            new FlightInfo().show(create.getFlightID(), create.getFlightName(), create.getStartTime(), create.getEndTime(), create.getDestination(), create.getTotalSeats());
        }
    }

    CreateNewFlight() {
    }

    public void createFlight(int flightID, String flightName, int startTime, int endTime, String destination, int totalSeats) {
        Flight create = new Flight();
        create.sendFlightDetails(flightID, flightName, startTime, endTime, destination, totalSeats);
        flights.add(create);
    }

    boolean ticketAvaliable(int flightID, int seats) {
        for (Flight create : flights) {
            if (create.getFlightID() == flightID && seats>0 && seats <= create.getTotalSeats()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
