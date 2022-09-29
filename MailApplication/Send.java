
package mailmanagementsystem;

public class Send extends GetInformation
{
    public void sendingInformation(String sender)
    {
        GetInformation getinformation=new GetInformation();
	String receiver=new String();
	String content=new String();
	String subject=new String();

		
	System.out.print("\nYOUR ID :"+sender);

	System.out.print("\nENTER THE RECEIVER EMAIL...:");
	try{
            receiver=getinformation.getStringValue();
	}catch(java.io.IOException e){}
	catch(NumberFormatException e){}

		


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
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="INSERT INTO `sender`(`senderemailid`, `receiveremailid`, `subject`,`content`) VALUES ('"+sender+"','"+receiver+"','"+subject+"','"+content+"')";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mailmanagementsystem?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(">>>   SUCCESFULLY SEND MESSAGE   <<<");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
