
package notes;

public class DeleteNotes {
   private void deletenotesList()
   {
        System.out.print("ENTER THE TITLE >");
        String title=new GetInfo().getStringValue();
        System.out.println();
        System.out.print("ARE YOU SURE DELETE THE INFO ( 1 -> DELETE / 0 -> EXIT )");
        if(new GetInfo().getIntegerValue() ==  1)
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="DELETE FROM `grocerylist` WHERE title=('"+title+"')";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/notesapplication?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(">>>    SUCCESSFULLY DELETED    <<<  ");
        }
        catch(Exception e)
        {
           System.out.println(">>>   NOT BE DELETED    <<<  ");
        } 
   }
   private void deletecontactList()
   {
       System.out.print("ENTER THE NAME >");
        String name=new GetInfo().getStringValue();
        System.out.println();
        System.out.print("ARE YOU SURE DELETE THE INFO (1 -> DELETE / 0 -> EXIT)>");
        if(new GetInfo().getIntegerValue() == 1 )
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="DELETE FROM `contactnumbers` WHERE title=('"+name+"')";
            java.sql.Connection conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/notesapplication?zeroDateTimeBehavior=convertToNull","root","");
            java.sql.PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(">>>    SUCCESSFULLY DELETED    <<<  ");
        }
        catch(Exception e)
        {
           System.out.println(">>>   NOT BE DELETED    <<<  ");
        } 
   }
public void getProperInfo()
   {
       System.out.println("SELECT ( 1 ) TO DELETE NOTES LIST ( 2 ) TO DELETE CONTACT LIST");
       switch(new GetInfo().getIntegerValue())
       {
           case 1:
               deletenotesList();
               break;
           case 2:
               deletecontactList();
               break;
           default:
               System.out.println(">>>   INVALID OPTION   <<<");
       }
   }
}
