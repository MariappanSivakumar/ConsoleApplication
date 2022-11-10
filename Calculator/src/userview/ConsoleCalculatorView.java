
package userview;
import Controller.ArithimeticCalculation;
import Controller.StoreHistory;

public class ConsoleCalculatorView {
    private int display(){
        int useroption=0;
        System.out.println("\t\t====================================================================================");
        System.out.println("\n\t\t\t\t1. ARITHMETIC CALCULATION");
        System.out.println("\t\t\t\t2. SHOW CALCULATION HISTORY");
    	System.out.println("\t\t\t\t3. CLEAR HISTORY");
	System.out.println("\t\t\t\t4. EXIT\n");
        System.out.println("\t\t====================================================================================");
        
        
        System.out.println();
        System.out.print("ENTER THE OPTION >");
        try 
        {
            useroption=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
        }catch(java.io.IOException e){}
        catch(NumberFormatException e){useroption=0;}
        System.out.println();
        if(useroption >=1  &&  useroption <=4)return useroption;
        else System.err.println(">>> ENTER THE VALID OPTION  <<<");
        return 0;
    }
    public void consoleProcess()
    {
        int choosenoption=0,conformationvar=0;
        do{
            choosenoption=display();
            if(choosenoption == 1)
                new ArithimeticCalculation().inti();
            else if(choosenoption == 2)
               new StoreHistory().showHistory();
            else if(choosenoption == 3)
            {
                System.out.print("ARE YOU SURE TO DELETE TO PRESS 1 ELSE 0 TO EXIT >");
                try
                {
                    conformationvar=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
                }catch(java.io.IOException e){}
                catch(NumberFormatException e){
                    System.err.print(">>>  INVALID NUMBER   <<<");
                }
                if(conformationvar==1)
                new StoreHistory().clear();
                System.out.println();
            }
        }while(choosenoption!=4);
    }
}
