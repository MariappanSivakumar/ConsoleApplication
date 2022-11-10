package controller;

import view.PassengerInfo;
import java.util.ArrayList;
import java.util.List;
import model.Passenger;
import view.FlightInfo;

public class ManagePassengerInfo {

    public static List<Passenger> passenger = new ArrayList();

    private PassengerInfo passengerInfoView;

    public ManagePassengerInfo(PassengerInfo passengerInfoView) {
        this.passengerInfoView = passengerInfoView;
    }
     public void ShowData()
    {
       for(Passenger passengerdetail : passenger)
       {
          new PassengerInfo().show(passengerdetail.getID(),passengerdetail.getPassengerName(), passengerdetail.getPassengerAge(), passengerdetail.getGender());
       }
    }

    ManagePassengerInfo() {}
    
    public void createPassenger(String passengerName,int ID,int passengerAge,String gender) {
      new Passenger(passengerName, ID, passengerAge, gender);
    }
}
