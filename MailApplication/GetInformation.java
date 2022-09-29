
package mailmanagementsystem;

class GetInformation
{
	public int getIntegerValue()throws java.io.IOException
	{
		return Integer.parseInt((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
	}
	public String getStringValue()throws java.io.IOException
	{
		return ((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
	}  
}
