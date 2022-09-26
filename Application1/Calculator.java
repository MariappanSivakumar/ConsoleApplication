class Calculator
{
	public String getString()throws java.io.IOException
	{
		System.out.print("\n\n\tENTER THE EXPRESSION  >  ");
		return ((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
	}
	public int getValue()throws java.io.IOException
	{
		System.out.print("\n\n\t\tSELECT THE OPTION TO PROCESS > ");
		return Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
	}
	public java.util.ArrayList<String> split(String expression)
	{
		//The function to retrun string to ArrayList type 
		java.util.ArrayList<String> al=new java.util.ArrayList<String>();
		String s=new String();
		for(int i=0;i<expression.length();i++)
		{
			if(expression.charAt(i)>=48&&expression.charAt(i)<=57)
				s+=expression.charAt(i);
			else 
			{
				al.add(s);
				s="";
				s+=expression.charAt(i);
				al.add(s);
				s="";
			}
			if(i==(expression.length()-1))
				al.add(s);
		}
		return al;
	} 
	public String process(java.util.ArrayList<String> arrayList,char c)
	{
		String value=new String();
		try 
		{
			for( int i=0;i<arrayList.size();i++ )
			{
				if(arrayList.get(i).equals(""+c))
				{
					if(arrayList.get(i).equals(" ")==false && arrayList.get(i-1).equals(" ")==false && arrayList.get(i+1).equals(" ")==false)
					{
						arrayList.set(i+1,""+sum(Integer.parseInt(arrayList.get(i-1)),Integer.parseInt(arrayList.get(i+1)),c)); 
						arrayList.set(i," ");
						arrayList.set(i-1," ");
					}
				}
			}

			for( String val : arrayList )
				if(val.equals(" ")==false)
					value+=val;
		}catch(NumberFormatException e)
		{
			System.out.println("\t\t\t>>>>   INVAILD ARGUMENT    <<<<");
		}
		return value;
	}
	public static int sum(int n1,int n2,char c)
	{
		//To evaluvate the expression 
		int sum=0;
		try {
			sum=(c=='%'?n1%n2:(c=='/'?n1/n2:(c=='*'?n1*n2:(c=='+'?n1+n2:(c=='-'?n1-n2:0)))));
		}catch(NumberFormatException e){
			System.out.println("INVAILD EXPRESSION");
		}
		return sum;
	}
	public static void main(String ar[])
	{
		Calculator calculatorObj=new Calculator();
		int n=0;
		do 
		{
			System.out.println("\t\t====================================================================================");
			System.out.println("\n\t\t\t\t1. ARITHMETIC CALCULATION");
			System.out.println("\t\t\t\t2. SHOW CALCULATION HISTORY");
			System.out.println("\t\t\t\t3. CLEAR HISTORY");
			System.out.println("\t\t\t\t4. EXIT\n");
			System.out.println("\t\t====================================================================================");

			try 
			{
				n=calculatorObj.getValue();
			}catch(java.io.IOException e){}
			catch(NumberFormatException e){}

			switch(n)
			{
				case 1:
					char c[]={'%','/','*','+','-'};
					String contant=new String();
					String expression=new String();
					try
					{
						expression=calculatorObj.getString();
					}
					catch(java.io.IOException e){}
					catch(NumberFormatException e){}
					System.out.print("\n\n");
					contant="\t\t\tEXPRESSION : ( "+expression+" )";
					UpdateHistory updatehistoryObj=new UpdateHistory();
					ShowHistory show=new ShowHistory();
					for(int i=0;i<c.length;i++)
					{
						java.util.ArrayList<String> arrayListObj=new java.util.ArrayList<>(calculatorObj.split(expression));
						expression = calculatorObj.process(arrayListObj,c[i]);
					}
					System.out.print("\n\t\t\t\tANSWER >  "+expression+"\n");
					contant+="\tANSWER :"+expression+"\n";
					updatehistoryObj.changeFileContant(show.displayFileContant()+contant);
					break;
				case 2:
					ShowHistory showhistory=new ShowHistory();
					System.out.print("\n"+showhistory.displayFileContant());
					break;
				case 3:
					UpdateHistory clearhistoryObj=new UpdateHistory();
					clearhistoryObj.clearHistory();
					break;
				default:
					if(n!=4)
						System.out.println("\n\n\t\t\t>>>    PLEASE SELECT IN VALID OPTION    <<<");
			}
		}while(n!=4);
	}
}
