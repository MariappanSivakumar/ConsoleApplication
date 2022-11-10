package Controller;
public class ShowMail
{
	public void showAllMails(String mail)throws java.io.IOException
	{
            try
            {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="SELECT * FROM sendinginfo WHERE sendermailid='"+mail+"' OR receivermailid='"+mail+"'";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/maillinformation?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet r=ps.executeQuery();
            while(true)
            {
                if(r.next())
                {
                    System.out.println("-------------------------------------");
                    System.out.println("SENDER : "+r.getString("sendermailid"));
                    System.out.println("RECEIVER : "+r.getString("receivermailid"));
                    System.out.println("SUBJECT : "+r.getString("subject"));
                    System.out.println("CONTENT : "+r.getString("content"));
                    System.out.println("======================================");
                }
                else
                {
                    System.out.println("                             >>>   NOTHING MORE   <<<");
                    break;
                }
            }
            
        }catch(Exception e){
           System.err.println("Oops! Something Wrong");
        }
	}
}
