
package Controller;

public class Evaluate {
    public String process(java.util.ArrayList<String> operatorandnumbers,String operators)
    {
        String value=new String();
        try 
        {
            for( int i=0;i<operatorandnumbers.size();i++ )
            {
		if(operators.indexOf(operatorandnumbers.get(i))!=-1)
                {
                    if(operatorandnumbers.get(i).equals(" ")==false && operatorandnumbers.get(i-1).equals(" ")==false && operatorandnumbers.get(i+1).equals(" ")==false)
                    {
			operatorandnumbers.set(i+1,""+sum(Double.parseDouble(operatorandnumbers.get(i-1)),Double.parseDouble(operatorandnumbers.get(i+1)),operatorandnumbers.get(i).charAt(0))); 
                        operatorandnumbers.set(i," ");
                        operatorandnumbers.set(i-1," ");
                    }
		}
            }

            for( String val : operatorandnumbers )
                if(val.equals(" ")==false)
                    value+=val;
        }catch(Exception e)
        {
            value="";
            System.out.println("\t\t\t>>>>   INVAILD ARGUMENT    <<<<");
        }
        return value;
    }
    
    private double sum(double n1,double n2,char c)
    {
	double sum=0;
	try {
            sum=(c=='%'?n1%n2:(c=='/'?n1/n2:(c=='*'?n1*n2:(c=='+'?n1+n2:(c=='-'?n1-n2:0)))));
	}catch(NumberFormatException e){
            System.out.println("INVAILD EXPRESSION");
	}
	return sum;
    }
}
