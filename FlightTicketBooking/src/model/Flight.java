package model;
public class Flight {
    private int flightID; 
    private String flightName;
    private int startTime;
    private int endTime;
    private String destination;
    private int totalSeats;
   public void sendFlightDetails(int flightID,String flightName,int startTime,int endTime,String destination, int totalSeats)
   {
       this.flightID = flightID;
       this.flightName = flightName;
       this.startTime = startTime;
       this.endTime = endTime;
       this.destination = destination;
       this.totalSeats = totalSeats;
   }
   public int getFlightID()
   {
       return flightID;
   }
   public String getFlightName()
   {
       return flightName;
   }
   public int getStartTime()
   {
       return startTime;
   }
   public int getEndTime()
   {
       return endTime;
   }
   public String getDestination()
   {
       return destination;
   }
   public int getTotalSeats()
   {
       return totalSeats;
   }
}
