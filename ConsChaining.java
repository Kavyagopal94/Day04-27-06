package basics;

public class ConsChaining
{
	ConsChaining()
	{
		this(10,20);
	}
	ConsChaining(int x,int y)
	{
		System.out.println(x+" "+ y);
	}
	
	public static void main(String[] args) 
	{
		ConsChaining c=new ConsChaining();
	}
}
