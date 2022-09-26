class UpdateHistory
{
	public void changeFileContant(String fileContant)
	{
		try 
		{
			java.io.FileWriter file=new java.io.FileWriter("E:/JDK 11/bin/CalculatorHistory.txt");
			file.append(fileContant);
			file.flush();
		}
		catch(java.io.IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void clearHistory()
	{
		try 
		{
			java.io.FileWriter file=new java.io.FileWriter("E:/JDK 11/bin/CalculatorHistory.txt");
			file.write(" ");
			file.flush();
			System.out.println("\n\t\t\t>>>  SUCCESSFULLY CLEAR THE HISTORY  <<<<");
		}
		catch(java.io.IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
