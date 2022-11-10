
package DBInformationProcess;
import Controller.Login; 

public class PushLoginInformation {
     public void pushLogininfo( String username,String email,String password )
    {
        System.out.println(username+" "+email+" "+password);
        String sql = "INSERT INTO `login`(`username`, `emailid`, `password`) VALUES ('" + username + "','" + email + "','" + password + "')";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/maillinformation?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps1 = conn.prepareStatement(sql);
            ps1.executeUpdate();
            System.err.print("\t\t\t>>>    PROFILE CREATED SUCCESSFULLY CREATED    <<<\n");
            System.out.println();
        } catch (Exception e) {
            System.err.println("\t\t\t>>>    EMAIL ALREADY EXIT   <<<\n");
            new Login().getSignIn();
        }
    }
}