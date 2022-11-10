
package View;

import Controller.Destination;


public class ShowRoots {
    public void showroots( )
    {
        new Destination().display();
        java.util.Map<Integer, String> mapObj = new java.util.HashMap<>();
        mapObj.put( 1, "\n->Tirunelveli \n\t\t-->Cheranmahadevi \n\t\t-->Ambasamduram \n\t\t-->tpapanasam \n\t\t-->kasayam \n->Tenkasi");
        mapObj.put( 2, "\n->Thoothukudi \n\t\t-->Ayyanadaippu \n\t\t-->Vagaikulam \n\t\t-->Kotulur \n\t\t-->Tirunelveli \n\t\t-->Pettai \n\t\t-->Mukkudal \n\t\t-->Kadayam \n->Tenkasi");
        mapObj.put( 3, "\n->Madurai \n\t\t-->Tirumangalam \n\t\t-->Srivilliputhur \n\t\t-->Rajapalayam \n\t\t-->Dhalavipuram \n\t\t-->Sivagiri \n\t\t-->Vasudevanally \n\t\t-->Puliyangudi \n\t\t-->Kadayanallur  \n\t\t-->Kadayam \n->Tenkasi ");
        mapObj.put( 4, "\n->Tiruchi \n\t\t-->Manapparai \n\t\t-->Tirumangalam \n\t\t-->Rajapalayam \n->Tenkasi ");
        mapObj.put( 5, "\n->Thanjavur \n\t\t-->Karaikudi \n\t\t-->Sivaganga \n\t\t-->Madhurai \n\t\t-->Sivakasi \n->Tenkasi");
        int n=0;
        try 
        {
            System.out.print("ENTER THE NUMBER >>");
            n=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader (System.in) )).readLine());
            System.out.println();
        }catch( java.io.IOException e ){}
        catch(NumberFormatException e){
            System.err.println(">>>   INVALID INPUT   <<<");
        }
            
        if ( n>=1 && n<=5 )
        {
            System.out.println(mapObj.get(n));
        }
        else 
        {
            System.err.println(">>>    INVALID OPTION    <<<");
        }
    }
}
