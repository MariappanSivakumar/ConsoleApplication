class ShowHistory
{
	public String displayFileContant()
	{
		String fileContant=new String();
		try 
		{
			java.io.FileReader file=new java.io.FileReader("E:/JDK 11/bin/CalculatorHistory.txt");
			short i=0;
		
			while( (i=(short)file.read()) != -1 )
				fileContant+=String.valueOf((char)i);
		
			file.close();
		}catch(java.io.FileNotFoundException e){
			System.out.println("File not Found Exception");
		}
		catch(java.io.IOException e){
			System.out.println("Enter the valid input");
		}
		return fileContant;
	}
}
