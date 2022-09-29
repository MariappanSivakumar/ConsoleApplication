
package notes;
public class Process extends GetInfo {
    public Process()
    {
        GetInfo getinfoObj =  new GetInfo();
        int justusetocompare = 0;
        while( justusetocompare != 4)
        {
            System.out.println("\t\t================================================================================");
            System.out.println("\t\t\t1. NOTES LIST ");
            System.out.println("\t\t\t2. CONTACT ");
            System.out.println("\t\t\t3. DELETE NOTES");
            System.out.println("\t\t\t4. EXIT");
            System.out.println("\t\t================================================================================");
            
            System.out.print("\t\t\tSELECT ANY ONE OPTION >");
            justusetocompare=getinfoObj.getIntegerValue();
            switch( justusetocompare )
            {
                case 1:
                    new GroceryList().getGroceryProcess();
                break;
                
                case 2:
                    new Contacts().addContant();
                break;
                
                case 3:
                    new deleteNotes().getProperInfo();
                break;
                
                case 4:
                    System.out.println(">>>  EXIT SUCCUSFULLY  <<<");
                    break;
                default:
                    System.out.println("    >>>   SELECT VALID OPTION    <<<<");
            }
        }
    }
}
