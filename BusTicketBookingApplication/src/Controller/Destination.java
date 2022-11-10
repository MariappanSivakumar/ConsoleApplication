
package Controller;

import View.FrontView;
import Model.Billing;
import java.io.IOException;

public class Destination {
  
    private int seats=0;
    private int booking=0;
    private String travelstate=new String();
    private int money=0;
    private String username=new String();
    private static int avaliableSeats[] = new int[]{20, 20, 20, 20, 20};
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
    private boolean usernameValidate(String username)
    {
        boolean f=false;
        
        for(int i=0;i<username.length();i++)
        {
            if( ! (username.charAt(i)>='a' &&  username.charAt(i)<='z') )
               if( ! (username.charAt(i) >='A') && username.charAt(i)<='Z' )
                   return true;
        }
        
        return f;
    }
    private boolean bookMyTicket()
    {
        boolean f=false;
        booking=0;
        int n=0;
        while(true)
        {
            System.out.print("ENTER THE PASSENGER NAME >");
            try 
            {
                username = (new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine();
                if(usernameValidate(username))
                    n=Integer.parseInt("g");
                break;
            } catch (IOException ex ) {}
            catch(NumberFormatException e){
                System.out.print("                                   >>>>> INVALID USERNAME   <<<<");
                System.out.println();
            }
        }
        
        while(true)
        {
            System.out.print("SELECT DISTINATION >");
            try 
            {
                booking = Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
                if(booking>=1  && booking<=5)
                    break;
                else booking=Integer.parseInt("u");
            } catch (IOException ex) {}
            catch(NumberFormatException e)
            {
                System.err.print(">>>   INVALID NUMBER   <<<");
            }
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
            new Billing().billingMyTickets(username,travelstate, money,  seats);
        }
        return f;
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
                    new FrontView().display();
                    break;
                    
                default: 
                    System.err.println("\n\t\t>>>    INVALID OPTION   <<<");
            }         
        }while(num!=3);
    }
}
