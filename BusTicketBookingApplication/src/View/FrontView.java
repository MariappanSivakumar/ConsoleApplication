package View;
import Controller.Process;
import Controller.Destination;
import Model.Passengers;
import java.io.IOException;

public class FrontView {
    static private String username=new String();
    static private String password=new String();
    public void agianLogin()
    {
        System.out.print("ENTER THE ( 1 ) AGAIN LOGIN ( 0 ) EXIT >");
        try {
            if(Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine())==1)
                new Process().getLogin();
            else System.exit(0);
        } catch (IOException ex) {}
     catch(NumberFormatException e){}       
    }
    public void display()
    {
      boolean f=false;
      int number=0;
      while( true )
      {
         System.out.println("********************************************");
         System.out.println("**        BUS TICKETING SYSTEM        **");
         System.out.println("********************************************");
         System.out.println("** 1 -> Destination                   **");
         System.out.println("** 2 -> Passengers                    **");
         System.out.println("** 3 -> Bus Stop                      **");
         System.out.println("** 4 -> Exit                          **");
         System.out.println("***************************************");
          
         System.out.print("SELECT THE IF YOU LIKE  >");
         try {
              number=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
          } catch (IOException ex) {}
         catch(NumberFormatException e){
             System.err.println("  >>>   INVALID INPUT   <<<");
         }
         switch(number)
         {
             case 1:
                 new Destination().accessDestination();
             break;
                 
             case 2:
                 Passengers passengerObj = new Passengers();
                 passengerObj.passdisplay();
             break;
             
             case 3:
                 ShowRoots viewObj=new ShowRoots();
                 viewObj.showroots( );
             break;
             
             case 4:
                 System.exit(0);
                 break;
             
            case 5:
                 agianLogin();
                break;
             default:
                 System.err.print("     >>  INVALID  INPUT   <<");
         }
         if(f)break;
      }
    }
}
