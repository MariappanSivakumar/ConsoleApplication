
package notes;

public class GetInfo {
    public String getDate()
    {
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        java.time.LocalDateTime now = java.time.LocalDateTime.now();  
        return String.valueOf(dtf.format(now));
    }
    public String getTime()
    {
       java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("hh/mm/ss");  
       java.time.LocalDateTime now = java.time.LocalDateTime.now();  
       return String.valueOf(dtf.format(now));
    }
    public int getIntegerValue()
    {
        int number=0;
        try {
            number=Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
        }catch(java.io.IOException e){}
        return number;
    }
    public String getStringValue()
    {
        String strvalue=new String();
        try {
            strvalue=((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
        }catch(java.io.IOException e){}
        return strvalue;
    }
}
