package Controller;


public class ArithimeticCalculation {
    private String getString()
    {
        String expression=new String();
        try {
            System.out.print("ENTER THE EXPRESSION >");
            expression=((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
        }catch(java.io.IOException e){}
        System.out.println();
        return expression;
    }
    private boolean expressionValidate(String expression)
    {
        for(int i=0;i<expression.length();i++)
        {
            if(expression.charAt(i)>='0' && expression.charAt(i)<='9'  || expression.charAt(i)=='+' || expression.charAt(i)=='-' || expression.charAt(i)=='*' || expression.charAt(i)=='/'){}
            else return false;
        }
        return true;
    }
    private String getExpression()
    {
        String operators[]={"/*","+-"};
        String content=new String();
        String expression=new String();
        expression=getString();
        if(expressionValidate(expression)==true  )
        {
            System.out.print("\n\n");
            content="\t\t\tEXPRESSION : ( "+expression+" )";
            for(int i=0;i<operators.length;i++)
            {
                java.util.ArrayList<String> arrayListObj=new java.util.ArrayList<>(new ExpressionSpliter().split(expression));
                expression = new Evaluate().process(arrayListObj,operators[i]);
            }
            content+="\tANSWER :"+expression+"\n";
	}
        else 
	{
            System.err.println(">>>  ENTER THE VALID EXPRESSION   <<<");
	}
        return content;
    }
   
    public void inti()
    {
        String value=getExpression();
        System.out.println(value);
        if(!value.equals(("")))
          new StoreHistory().history(value);
    }
}
