package mailmanagementsystem;

public class Inbox
{
    public void showInbox(String mail)throws java.io.IOException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="SELECT * FROM sender WHERE receiveremailid='"+mail+"'";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mailmanagementsystem?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet r=ps.executeQuery();
            while(true)
            {
                if(r.next())
                {
                    System.out.println("-------------------------------------");
                    System.out.println("SENDER : "+r.getString("senderemailid"));
                    System.out.println("RECEIVER : "+r.getString("receiveremailid"));
                    System.out.println("SUBJECT : "+r.getString("subject"));
                    System.out.println("CONTENT : "+r.getString("content"));
                    System.out.println("======================================");
                }
                else
                {
                    System.out.println("                             >>>   NOTHING DETECT   <<<");
                    break;

                }
            }
            
        }catch(Exception e){}
    }
}
