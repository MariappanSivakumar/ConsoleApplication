
package view;

public class Login {
    GetInformation input = new GetInformation();
    public int getLogin()
    {
        System.out.print("\nIf You Are 1 ---> User    2----> Admin  3---->exit\n\t\t > ");
        int n = Integer.parseInt(input.getString());
        return n;
    }
    public String checkLogin()
    {
        System.out.print("\nEnter the username...: ");
        String username = new GetInformation().getString();
        System.out.println("\n Enter the password...:");
        String password =  new GetInformation().getString();
        return username + ","+ password;
    }
}
