package Controller;

import View.FrontView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Process {
    public String getString()
    {
        String CommonInput = ""; 
        try {
             CommonInput = (new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine();
        }catch(java.io.IOException e){}
        return CommonInput;
    }
    private void errorHandle()
    {
        System.err.println(">>> (  INVALID USERNAME (OR) PASSWORD  ) AGAIN YOU LIKE TO LOGIN PRESS 1 (OR)  TO 0 EXIT  <<<");
          
        System.out.print("          >");
        try {
            int useroption=Integer.parseInt(getString());
            if(useroption==1)getLogin();
            else 
            if(useroption==0)System.exit(0);
            else 
            {
                System.out.println("Enter the Valid option ");
                errorHandle();
            }
        }
        catch(NumberFormatException e){
            System.err.print("  >>>    ENTER    VAILD NUMBER    <<<");
            errorHandle();
        }
    }
    static private String username=new String();
    static private String password=new String();
    private boolean isValid(String name, String password)
    {
        return name.equals("Sivarajavel")&&password.equals("One23456");
    }
    public void getLogin()
    {
        System.out.print("ENTER THE USER NAME >");
        username = ( getString() );
        System.out.println();

        System.out.print("ENTER THE PASSWORD >");
        password = ( getString() );
        System.out.println();
        if(isValid(username, password))
        new FrontView().display();
        else errorHandle();
    }
}
