package view;

import controller.CreateNewFlight;

public class FlightInfo {

    GetInformation getInput = new GetInformation();
    private CreateNewFlight createNewFlightController;

    public FlightInfo() {
        createNewFlightController = new CreateNewFlight(this);
        getData();
    }

    public void getData() {
        System.out.print("\nEnter the FlightID ...:");
        int flightID = Integer.parseInt(getInput.getString());

        System.out.print("\nEnter the FlightName ...:");
        String flightName = getInput.getString();

        System.out.print("\nEnter the Starting Time ...:");
        int startPoint = Integer.parseInt(getInput.getString());

        System.out.print("\nEnter the Ending Time ...:");
        int endPoint = Integer.parseInt(getInput.getString());

        System.out.print("\nEnter the Which Place to Which Place ...:");
        String destination = getInput.getString();

        System.out.println("\n Enter the Number of seats");
        int totalSeats = Integer.parseInt(getInput.getString());
        
        createNewFlightController.createFlight(flightID, flightName, startPoint, endPoint, destination,totalSeats);
    }
    public void show(int flightID, String flightName, int startTime, int endTime, String destination, int totalSeats) {
       
       System.out.println("Flight ID            : "+flightID);
       System.out.println("Flight Name          : "+flightName);
       System.out.println("Flight StartTime     : "+startTime);
       System.out.println("Flight EndTime       : "+endTime);
       System.out.println("Flight Destination   : "+destination);
       System.out.println("Flight Total Seat    : "+totalSeats);
    }
    public int getFlightID()
    {
        System.out.print("\nEnter the FlightID ...:");
        int flightID = Integer.parseInt(getInput.getString());
        return flightID;
    }
    public int getTotalNoSeats()
    {
        System.out.print("\nEnter the FlightID ...:");
        int totalSeats = Integer.parseInt(getInput.getString());
        return totalSeats;
    }
}
