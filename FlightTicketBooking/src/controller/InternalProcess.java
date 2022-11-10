package controller;

import view.FlightInfo;
import view.Login;
import view.ShowErrorMessage;
import view.ViewPanel;

public class InternalProcess {

    Login login = new Login();
    
    public void userProcess(int selectedOption)
    {
       if(selectedOption < 0 || selectedOption > 6 )
       {
           new ShowErrorMessage().error("Invalid Option Please Choose correct option");
       }else 
       {
           switch(selectedOption)
           {
               case 1:
                   new CreateNewFlight().ShowData();
                   break;
               case 2:
                   //new BookTicket();
                   break;
               case 3:
                   //new ShowTickets();
                   break;
               case 4:
                   //new CancelTickets();
                   break;
           }
       }
    }
     public void adminProcess(int selectedOption)
    {
       if(selectedOption < 0 || selectedOption > 3 )
       {
           new ShowErrorMessage().error("Invalid Option Please Choose correct option");
       }else 
       {
           switch(selectedOption)
           {
               case 1:
                   
                   break;
               case 2:
                   System.out.println("Control Comes inside");
                   new FlightInfo();
                   break;
           }
       }
    }
    public void init() {
  
       int useroption = login.getLogin();
       if(useroption == 1)
       {
          int userSelectedOption = new ViewPanel().userView();
          userProcess(userSelectedOption);
       }else
       {
           String[] usernameAndPassword = new Login().checkLogin().split(",");
           if(usernameAndPassword[0].equals("Sivarajavel") && usernameAndPassword[1].equals("One234567"))
           {
                int adminSelectedOption = new ViewPanel().adminView();
                adminProcess(adminSelectedOption);
                adminSelectedOption = new ViewPanel().callAgainLogin();
                if(adminSelectedOption == 1)
                init();
           }
       }
    }
}
