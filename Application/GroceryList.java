
package notes;

public class GroceryList {
    GetInfo getinfoObj = new GetInfo();
    private void getGroceryListDetails()
    {
        System.out.print("\t\tENTER THE TITLE >");
        String title = getinfoObj.getStringValue();
        System.out.println();
        
        String time = getinfoObj.getTime();
        
        String date = getinfoObj.getDate();
        
        System.out.print("\t\tENTER CONTENT TO EXIT TYPE ' exit ' >");
        String products=new String();
        String tempcont=new String();
        while(!( tempcont=getinfoObj.getStringValue() ).equals("exit"))products+=tempcont+"\n";
        System.out.println();
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="INSERT INTO `grocerylist` (`title`, `date`,`time`, `products`) VALUES ('"+title+"','"+time+"','"+date+"','"+products+"')";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/notesapplication?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    private void showGroceryListShow()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="SELECT * FROM grocerylist";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/notesapplication?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            java.sql.ResultSet r=ps.executeQuery();
            while(true)
            {
                if(r.next())
                {
                    System.out.println("-------------------------------------");
                    System.out.println("TITLE       : "+r.getString("title"));
                    System.out.println("DATE        : "+r.getString("date"));
                    System.out.println("TITLE       : "+r.getString("time"));
                    System.out.println("PRODUCTS    : "+r.getString("products"));
                    System.out.println("-------------------------------------");
                }
                else
                {
                    System.out.println("                       >>>   NOTHING MORE   <<<");
                    break;

                }
            }
        }catch(Exception e){}
    }
    void getGroceryProcess()
    {
        System.out.print(" ENTER ( ADD -> 1 ) ( DISPLAY -> 2 )   >");
        GetInfo getinfoObj =  new GetInfo();
        int n=n=getinfoObj.getIntegerValue();
        if(n==1)
        {
            getGroceryListDetails();
        }else if(n==2)
        {
            showGroceryListShow();
        }else 
        {
            System.out.println(">>>    INVAILD OPTION    <<<  ");
        }
        
    }
}
