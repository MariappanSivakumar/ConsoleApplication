package busticketbookingapplication;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Process {
    private boolean getValidate(String username, String password)
    {
        return username.equals("Sivarajavel")  &&  password.equals("One23456");
    }
    
    private void errorHandle()
    {
        System.err.println(">>> (  INVALID USERNAME (OR) PASSWORD  ) AGAIN YOU LIKE TO LOGIN PRESS 1 (OR)  TO 0 EXIT  <<<");
          
        System.out.print("          >");
        try 
        {
            int num=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
            if(num==1)getLogin();
            if(num==0)return;
        }catch(java.io.IOException e){}
        catch(NumberFormatException e)
        {
            System.err.print("  >>>    ENTER    VAILD NUMBER    <<<");
            errorHandle();
        }
    }
    static private String username=new String();
    static private String password=new String();
    void getLogin()
    {
      try {
          System.out.print("ENTER THE USER NAME >");
          username = ((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
          System.out.println();
          
          
          System.out.print("ENTER THE PASSWORD >");
          password = ((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
          System.out.println();
          display();
          
      } catch (IOException | NumberFormatException ex) {}
    }
    public boolean display()
    {
        boolean f=true;
      int number=0;
      if(getValidate(username, password))
      while( number != 4 )
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
                 new Destination().getUsername(username);
                 new Destination().accessDestination();
             break;
                 
             case 2:
                 Passengers passengerObj = new Passengers();
                 passengerObj.passdisplay();
             break;
             
             case 3:
                 ShowRoots viewObj=new ShowRoots();
             break;
             
             case 4:
                 f=false;
                 
         }
      }
      else {
         errorHandle();
      }
      return f;
  }
}
