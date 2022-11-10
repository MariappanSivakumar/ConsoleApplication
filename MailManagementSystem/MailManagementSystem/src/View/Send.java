
package View;

import Controller.FairyMailValidation;
import DBInformationProcess.PushSendingInformation;

public class Send extends GetInformation
{
    public void sendingInformation(String sender)
    {
        GetInformation getinformation=new GetInformation();
	String receiver=new String();
	String content=new String();
	String subject=new String();

		
	System.out.print("\nYOUR ID :"+sender);
        
        do
        {
            System.out.print("\nENTER THE RECEIVER EMAIL...:");
            try{
                receiver=getinformation.getStringValue();
            }catch(java.io.IOException e){}
            if(new FairyMailValidation().mailValidate(receiver)==true)break;
            else System.out.print("ENTER VALID INFOMATION");
        }while(true);
        
	System.out.print("\nENTER THE SUBJET ( OPTIONAL )...:");
	try{
            subject=getinformation.getStringValue();
	}catch(java.io.IOException e){}
	catch(NumberFormatException e){}
	
	System.out.print("\nENTER THE CONTANT...:");
	try{
            content=getinformation.getStringValue();
        }catch(java.io.IOException e){}
	catch(NumberFormatException e){}
        
        
        new PushSendingInformation( sender, receiver, subject, content);
    }
}
