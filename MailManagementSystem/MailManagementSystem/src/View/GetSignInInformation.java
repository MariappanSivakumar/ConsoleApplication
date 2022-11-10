
package View;

import Controller.FairyMailValidation;
import Controller.Login;

public class GetSignInInformation {
    
    GetInformation getInfoObj = new GetInformation();
    public void getInfo()
    {
        boolean isInvalidInput=false;
        FairyMailValidation fmailObj = new FairyMailValidation();
        String username=new String();
        do
        {
            System.out.print("\n\t\tENTER NAME ( ONLY ALPHAPHETS ) > ");
            try {
                username = getInfoObj.getStringValue();
            }catch(java.io.IOException e){}
            if((isInvalidInput=fmailObj.usernameValidation( username ))==false)
              System.err.println("\n\t\t>>>     INVAILD INPUT   <<<");      
        }while(isInvalidInput!=true);
        
       String email=new String();
       do
       {
           System.out.print("\n\t\tENTER THE EMAIL ID(FORMAT : user@fairy.com )> ");
           try{
           email = getInfoObj.getStringValue();
           }catch(java.io.IOException e){}
           if((isInvalidInput=fmailObj.mailValidate(email))==false)
              System.err.println("\n\t\t>>>  INVAILD INPUT   <<<"); 
       }while(isInvalidInput!=true);
       
       
       
       String password=new String();
       do
       {
           System.out.print("\n\t\tENTER Password (MUST IN SIX CHARACTERS (OR) MORE) > ");
           try{
           password = getInfoObj.getStringValue();
           }catch(java.io.IOException e){}
           if((isInvalidInput=fmailObj.passwordValidation(password))==false)
              System.err.println("\n\t\t>>>  INVAILD INPUT   <<<"); 
       }while(isInvalidInput!=true);
       
       new Login().getLoginDetails(username, email, password);
    }
}
