package Model;

import java.io.PrintStream;

public class Billing {
    public void billingMyTickets(String username, String travelstate, int money, int noofpassenger)
    {
        System.out.println("\n\t\t\t***************************************");
        System.out.println("\t\t\t**        PASSENGER'S DETAILS        **");
        System.out.println("\t\t\t***************************************");
        System.out.println("\t\t\tPASSENGER'S DESTINATION : "+username);
        System.out.println("\t\t\tPASSENGER'S DESTINATION : "+travelstate);
        System.out.println("\t\t\tFARE PRICE              : RS "+money);
        System.out.println("\t\t\tNO. OF PASSENGERS       : " +noofpassenger);
        System.out.println("\t\t\t***************************************");
        
        
        try{
                Class.forName("com.mysql.jdbc.Driver");
                String sql="INSERT INTO `passengerdetails`(`username`, `travelstate`, `price`,`noofpassenger`) VALUES ('"+username+"','"+travelstate+"','"+money+"','"+noofpassenger+"')";
                java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/busticketmanagement?zeroDateTimeBehavior=convertToNull","root","");
                java.sql.PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        
        
    }
}
