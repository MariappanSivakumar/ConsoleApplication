
package DBInformationProcess;

public class PushSendingInformation {
    public PushSendingInformation(String sender,String  receiver,String subject,String content)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="INSERT INTO `sendinginfo`(`sendermailid`, `receivermailid`, `subject`,`content`) VALUES ('"+sender+"','"+receiver+"','"+subject+"','"+content+"')";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/maillinformation?zeroDateTimeBehavior=convertToNull","root","");
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
