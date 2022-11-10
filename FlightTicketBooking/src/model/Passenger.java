package model;

public class Passenger {
    
    private String passengerName;
    private int ID;
    private int passengerAge;
    private String gender;

    public Passenger(String passengerName, int ID, int passengerAge, String gender) {
         this.passengerName = passengerName; 
         this.ID = ID;
         this.passengerAge = passengerAge;
         this.gender = gender;
    }
    
    public String getPassengerName() {
        return passengerName;
    }

    public int getID() {
        return ID;
    }

    public int getPassengerAge() {
        return passengerAge;
    }


    public String getGender() {
        return gender;
    }

}
