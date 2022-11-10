package view;

import controller.ManagePassengerInfo;
import view.GetInformation;

public class PassengerInfo {
   
    GetInformation input = new GetInformation();
    private ManagePassengerInfo createNewFlightController;

    public PassengerInfo() {
        createNewFlightController = new ManagePassengerInfo(this);
        getPassengerData();
    }
    public void getPassengerData()
    {
        System.out.println("Enter ID ....:\n");
        int passengerId = Integer.parseInt(input.getString());
        
        System.out.print("\nEnter the name...:");
        String passengerName = input.getString();
        
        System.out.print("\n Enter the age...:");
        int passegerAge = Integer.parseInt(input.getString());
        
        System.out.println("Enter the Gender...:\n");
        String gender = input.getString();
       
    }
    public void show(int passengerId, String passengerName, int passengerAge, String gender)
    {
        System.out.println("Passenger ID          : "+ passengerId);
        System.out.println("Passenger Name        : "+ passengerName);
        System.out.println("Passenger Age         : "+ passengerAge);
        System.out.println("Passenger Gender      : "+ gender);
        
    }
}
