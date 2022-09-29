
package mailmanagementsystem;
public class Login extends EmailConsoleView
{
	private String email=new String();
	private int getIntegerValue()
	{
		int getintvalue=0;

		try {
			getintvalue=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
		}catch(java.io.IOException e){

		}catch(NumberFormatException e){
			System.out.println("ENTER THE VALID NUMBER...");
		}
		return getintvalue;
	}
	
	private String getStringValue()
	{
		String getstrvalue=new String();

		try {
			getstrvalue=(new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine();
		}catch(java.io.IOException e){

		}catch(NumberFormatException e){
			System.out.println("ENTER THE VALID NUMBER...");
		}
		return getstrvalue;
	}
	private void getSignIn()throws java.io.IOException
	{
            System.out.print("\n\t\tENTER NAME > ");
            String username=getStringValue();
            System.out.print("\n\t\tENTER MAILID > ");
            String emaill=getStringValue();
            System.out.print("\n\t\tENTER PASSWORD > ");
            String password=getStringValue();
                 
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String sql="INSERT INTO `login`(`username`, `emailid`, `password`) VALUES ('"+username+"','"+emaill+"','"+password+"')";
                java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mailmanagementsystem?zeroDateTimeBehavior=convertToNull","root","");
                java.sql.PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }	
            System.out.println(">>>> ENTER 1 TO LOGIN 2 EXIT");
            if(getIntegerValue()==1)
                call();
	}
	private boolean getLogIn()throws java.io.IOException
	{
            boolean f=false;
            System.out.print("\nENTER THE EMAIL ID >");
            email=getStringValue();
            System.out.print("\nENTER THE PASSWORD >");
            String password=getStringValue();
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                String sql="SELECT * FROM login WHERE emailid<>'"+email+"' AND password<>'"+password+"'";
                java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mailmanagementsystem?zeroDateTimeBehavior=convertToNull","root","");
                java.sql.PreparedStatement ps = conn.prepareStatement(sql);
                java.sql.ResultSet r=ps.executeQuery();
                if(r.next())
                {
                    EmailConsoleView em=new EmailConsoleView();
                    EmailConsoleView.emailid=email;
                    em.consoleFrontEndView();
                }
                else 
                {
                    System.out.println(">>>  ENTER THE VALID INPUT   <<<<");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return f;
	}
	private void call()throws java.io.IOException
	{
		while(getLogIn()==false)
		{
			System.out.print(">>>   ENTER VALID INFO  SELECT 1 TO AGAIN LOGIN (OR) 2 EXIT > ");
			if(getIntegerValue()==2)
			{
				if(getDetails()==true)
					break;
			}
		}
	}
	public boolean getDetails()throws java.io.IOException
	{
		boolean f=false;
		while(f==false)
		{
			System.out.print("ALREARY YOU HAVE A ACCOUNT ( YES -> 0 (OR)  NO  -> 1 EXIT -> 2)  > ");
			int number=getIntegerValue();
			if(number==0)
			{
				call();
				f=true;
			}
			else if(number==1) 
			{
				getSignIn();
				f=true;
			}
			if(number==2)
			{
				f=true;
				EmailConsoleView e=new EmailConsoleView();
				System.out.println(emailid);
				e.sendMail(emailid);
			} 
			if(f==false)
				System.out.print("\t\t>>> PLEASE ENTER VALID OPTION  <<<<");
		}
		return f;
	}
}
