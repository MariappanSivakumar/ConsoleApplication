package Controller;

import View.EmailConsoleView;
import DBInformationProcess.PushLoginInformation;
import DBInformationProcess.SignInValidOrNot;
import View.GetInformation;
import View.GetSignInInformation;
import java.io.IOException;

public class Login extends EmailConsoleView {

    private String email = new String();
    private static String Username = new String();
    private static String Email = new String();
    private static String Password = new String();
    GetInformation getInfoObj = new GetInformation();
    public void getLoginDetails(String username, String email, String password)
    {
        Username = username;
        Email = email;
        Password = password;
    }
    public void getSignIn() {
        
        new GetSignInInformation().getInfo();
        
        PushLoginInformation  pushlogin = new PushLoginInformation();
        pushlogin.pushLogininfo(Username, Email, Password );
       
        
        System.out.println(">>>> ENTER 1 TO LOGIN 2 EXIT");
        try {
            int number = getInfoObj.getIntegerValue();
            if (number == 1) {
                call();
            } else if (number == 2) {
                System.exit(0);
            } else {
                System.err.println(">>>       ENTER THE VALID OPTION       <<<");
            }
        } catch (NumberFormatException e) {
            System.err.println(">>>  ENTER THE VALID OPTION    <<<");
        }catch(IOException e){}
    }

    private boolean getLogIn() throws java.io.IOException {
        boolean f = false;
        System.out.print("\nENTER THE EMAIL ID >");
        email = getInfoObj.getStringValue();
        System.out.print("\nENTER THE PASSWORD >");
        String password = getInfoObj.getStringValue();
        if ( new SignInValidOrNot().isSignInVaild( email, password ) == true) {
                EmailConsoleView em = new EmailConsoleView();
                EmailConsoleView.emailid = email;
                em.consoleFrontEndView();
            }
        return f;
    }

    private void call() {
        try {
            while (getLogIn() == false) {
                System.out.print(">>>   ENTER VALID INFO  SELECT 1 TO AGAIN LOGIN (OR) 2 EXIT (BY DEFALUT LOGIN)> ");
                if (getInfoObj.getIntegerValue() == 2) {
                    if (getDetails() == true) {
                        break;
                    }
                }
            }
        } catch (java.io.IOException e) {
        } catch (NumberFormatException e) {
            System.err.println(">>  ENTER THE VALID NUMBER  <<<");
        }
    }

    public boolean getDetails() {
        boolean f = false;
        try {
            while (f == false) {
                System.out.print("ALREARY YOU HAVE A ACCOUNT ( YES -> 0 (OR)  NO  -> 1 EXIT -> 2)  > ");
                int number=-1;
                try{
                number = getInfoObj.getIntegerValue();
                }catch(java.io.IOException e){}
                if (number == 0) {
                    // TO CALL A EXISTING ACCOUNT
                    call();
                    f = true;
                } else if (number == 1) {

                    // CREATE A NEW ACCOUNT
                    getSignIn();
                    f = true;
                }
                if (number == 2) {
                    f = true;
                    EmailConsoleView e = new EmailConsoleView();
                    e.sendMail(emailid);
                }
                if (f == false) {
                    System.err.print("\t\t\n>>> PLEASE ENTER VALID OPTION  <<<<");
                    System.out.println();
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("\t\t\t\t>>>  ENTER THE VALID DATA     <<<");
            getDetails();
        }
        return f;
    }
}
