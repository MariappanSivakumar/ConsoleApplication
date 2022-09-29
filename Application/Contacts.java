package notes;
public class Contacts {
    private String username=new String();
    private String usernumber=new String();
    GetInfo getinfoObj=new GetInfo();
    public void getContantDetails(){
        
        System.out.print("ENTER NAME >");
        username=getinfoObj.getStringValue();
        System.out.println();
        
        System.out.print("ENTER NUMBER >");
        usernumber=getinfoObj.getStringValue();
        System.out.println();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="INSERT INTO `contactnumbers`(`name`, `phonenumber`) VALUES ('"+username+"','"+usernumber+"')";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/notesapplication?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(">>>    SUCCESSFULLY ADDED    <<<  ");
        }
        catch(Exception e)
        {
           System.out.println(">>>   USER ALREADY EXIST    <<<  ");
        }        
    }
    public void showContant()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="SELECT * FROM contactnumbers";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/notesapplication?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet r=ps.executeQuery();
            while(true)
            {
                if(r.next())
                {
                    System.out.println("\t\t-------------------------------------");
                    System.out.println("\t\tNAME   : "+r.getString("name"));
                    System.out.println("\t\tNUMBER : "+r.getString("phonenumber"));
                    System.out.println("\t\t-------------------------------------");
                }
                else
                {
                    System.out.println("                       >>>   NOTHING MORE   <<<");
                    break;

                }
            }
        }catch(Exception e){}
    }
    
    public void addContant()
    {
        System.out.print(" ENTER ( ADD -> 1 ) ( DISPLAY -> 2 )   >");
        GetInfo getinfoObj =  new GetInfo();
        int n=0;
        if((n=getinfoObj.getIntegerValue())==1)
        {
            getContantDetails();
        }else if(n==2)
        {
            showContant();
        }else 
        {
            System.out.println(">>>    INVAILD OPTION    <<<  ");
        }
    }
}
