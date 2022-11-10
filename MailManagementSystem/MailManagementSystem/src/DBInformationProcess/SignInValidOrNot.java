package DBInformationProcess;

public class SignInValidOrNot {
    public boolean isSignInVaild( String mail, String password)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "SELECT * FROM login WHERE emailid='" + mail + "' AND password='" + password + "'";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/maillinformation?zeroDateTimeBehavior=convertToNull", "root", "");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet r = ps.executeQuery();
            return r.next();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
