package View;

import Controller.Inbox;
import Controller.Login;
import Controller.ShowMail;

public class EmailConsoleView {

    public static String emailid = new String();

    public void consoleFrontEndView() {
        int compareValue = 0;
        do {
            System.out.println("\t\t====================================================\n");
            System.out.println("\t\t\t\t1. INBOX");
            System.out.println("\t\t\t\t2. SEND");
            System.out.println("\t\t\t\t3. SHOW EMAIL");
            System.out.println("\t\t\t\t4. LOGOUT" + "\n");
            System.out.println("\t\t=====================================================");
            System.out.println("\n");
            System.out.print("\t\t\t\tSELECT THE OPTION   >");

            GetInformation gi = new GetInformation();
            try {
                compareValue = gi.getIntegerValue();

                switch ((int) compareValue) {
                    case 1:
                        Inbox inboxObj = new Inbox();
                        inboxObj.showInbox(emailid);
                        break;
                    case 2:
                        Send sendObj = new Send();
                        sendObj.sendingInformation(emailid);
                        break;
                    case 3:
                        ShowMail showmail = new ShowMail();
                        showmail.showAllMails(emailid);
                        break;
                    case 4:
                        break;
                    default:
                        System.err.println("\n\t\t\t\t>>> ENTER VAILD OPTION  <<<");
                }
            } catch (java.io.IOException e) {
            } catch (NumberFormatException e) {
                System.err.println(">>>  ENTER THE VALID INFOMATION   <<<");
            }
        } while (compareValue != 4);
    }

    public void sendMail(String mail) {
        emailid = mail;
    }

    public static void main(String ar[]) throws java.io.IOException {
        Login loginObj = new Login();
        loginObj.getDetails();
    }
}
