
package busticketbookingapplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Destination {
    
    private int seats=0;
    private int booking=0;
    private String travelstate=new String();
    private int money=0;
    private int avaliableSeats[] = new int[]{20, 20, 20, 20, 20};
    public void display()
    {
        System.out.println("*********************************************************************************");
    	System.out.println("**         DESTINATION                    |  FARE  |            SEAT           **");
        System.out.println("*********************************************************************************");
        System.out.println("** 1.) TENKASI TO TIRUNELVELI             | RS 70  |   "+avaliableSeats[0]+"   **");
        System.out.println("** 2.) TENKASI TO THOOTHUKUDI             | RS 100 |   "+avaliableSeats[1]+"   **");
    	System.out.println("** 3.) TENKASI TO MADHURAI                | RS 200 |   "+avaliableSeats[2]+"   **");
        System.out.println("** 4.) TENKASI TO TIRUCHI                 | RS 300 |   "+avaliableSeats[3]+"   **");
    	System.out.println("** 5.) TENKASI TO THANJAVUR               | RS 600 |   "+avaliableSeats[4]+"   **");
        System.out.println("*********************************************************************************");
    }
    private void showAvaliableTicket()
    {
        display();
        
        accessDestination();
    }
    private boolean bookMyTicket()
    {
        boolean f=false;
        booking=0;
        
        while(true)
        {
            System.out.print("SELECT DISTINATION >");
            try 
            {
                booking = Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
                break;
            } catch (IOException ex) {}
            catch(NumberFormatException e){}
        }
        while(true)
        {
            System.out.print("ENTER HOW MANY TICKETS TO NEED >");
            seats=0;
            try {
                seats=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
                break;
            } catch (IOException ex) {}
            catch(NumberFormatException e){
                   System.err.print(">>>   INVALID NUMBER   <<<");
            }
        }
        if(booking == 1)
        {
            if( avaliableSeats[0] >= seats  && avaliableSeats[0]!=0 )
            {
                avaliableSeats[0] -= seats;
                travelstate="TENKASI TO TIRUNELVELI";
                money=seats*70;
                f=true;
            }
            else 
                System.err.print("\n\t\tSORRY ONLY AVALIABLE >"+avaliableSeats[0]);
        }else if( booking == 2 )
        {
            if( avaliableSeats[1] >= seats && avaliableSeats[1]!=0 )
            {
                f=true;
                avaliableSeats[1] -= seats;
                travelstate="TENKASI TO THOOTHUKUDI";
                money=seats*100;
            }
            else 
                System.err.print("\n\t\tSORRY ONLY AVALIABLE >"+avaliableSeats[1]);
            
        }else if( booking == 3  )
        {
            if( avaliableSeats[2] >= seats && avaliableSeats[2]!=0 )
            {
                f=true;
                avaliableSeats[2] -= seats;
                travelstate="TENKASI TO MADHURAI";
                money=seats*200;
            }
            else 
                System.err.print("\n\t\tSORRY ONLY AVALIABLE >"+avaliableSeats[2]);
            
        }else if( booking == 4  )
        {
            if( avaliableSeats[3] >= seats && avaliableSeats[3]!=0 )
            {
                f=true;
                travelstate="TENKASI TO TIRUCHI";
                avaliableSeats[3] -= seats;
                money=seats*300;
            }
            else 
                System.err.print("\n\t\tSORRY ONLY AVALIABLE >"+avaliableSeats[3]);
        }else if( booking == 5 )
        {
            if( avaliableSeats[4] >= seats && avaliableSeats[4]!=0 )
            {
                f=true;
                travelstate="TENKASI TO THANJAVUR";
                avaliableSeats[4] -= seats;
                money=seats*600;
            }
            else 
                System.err.print("\n\t\tSORRY ONLY AVALIABLE >"+avaliableSeats[4]);
            System.out.println();
        }else
        {
            System.err.print(" \n\t\t >>>   INVALID OPTION     <<<");
        }
        if(f)
        {
            System.err.println("\t\t>>>     TICKET IS SUCCESSFULLY BOOKED    <<<");
            new Billing().billingMyTickets(travelstate, money,  seats);
        }
        return f;
    }
    
    static private String username=new String();
    public void getUsername(String username)
    {
        this.username=username;
    }
    
    public void accessDestination()
    {
       int num=0;
        do
        {
            System.out.print("\n\n\tSHOW -> 1 BOOK -> 2 EXIT ->3  >");
            try {
                num=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
                } catch (IOException ex) {
                System.err.print("\n\t\t>>>   INVALID OPTION   <<<");
            }
            catch(NumberFormatException e){
                System.err.print("\n\t\t>>> INVALID OPTION   <<<");
            }
            switch(num)
            {
                case 1:
                    showAvaliableTicket();
                break;
                    
                case 2:
                    display();
                    bookMyTicket();
                break;
                
                case 3:
                    System.out.println();
                    System.out.println();
                        if(new Process().display()==false)
                            break;
                    break;
                default: 
                    System.err.println("\n\t\t>>>    INVALID OPTION   <<<");
            }         
        }while(num!=3);
    }
}
