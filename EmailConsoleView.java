package mailmanagementsystem;

public class EmailConsoleView
{
	static String emailid=new String();
	private void printMessage(String s)
	{
		System.out.println(s);
	}
	public void consoleFrontEndView() throws java.io.IOException
	{
		EmailConsoleView emailObj=new EmailConsoleView();
		int compareValue=0;
		do
		{
			emailObj.printMessage("\t\t====================================================\n");
			emailObj.printMessage("\t\t\t\t1. INBOX");
			emailObj.printMessage("\t\t\t\t2. SEND");
			emailObj.printMessage("\t\t\t\t3. SHOW EMAIL");
			emailObj.printMessage("\t\t\t\t4. LOGOUT"+"\n");
			emailObj.printMessage("\t\t=====================================================");
			emailObj.printMessage("\n");
			System.out.print("\t\t\t\tSELECT THE OPTION   >");

			GetInformation gi=new GetInformation();
			compareValue=gi.getIntegerValue();
			switch((int)compareValue)
			{
				case 1:
					Inbox inboxObj = new Inbox();
					inboxObj.showInbox(emailid);
					break;
				case 2:
					Send sendObj=new Send();
					sendObj.sendingInformation(emailid);
					break;
				case 3:
					ShowMail showmail=new ShowMail();
					showmail.showAllMails(emailid);
					break;
				case 4:
					compareValue=4;
					break;
				default:
					System.out.println("\n\t\t\t\t>>> ENTER VAILD OPTION  <<<");
			}
		}while(compareValue!=4);
	}
	public void sendMail(String mail)
	{
		emailid=mail;
	}
	public static void main(String ar[])throws java.io.IOException
	{
		Login loginObj=new Login();
		loginObj.getDetails();
	}
}
