package basics;

class A
{
	A(int n)
	{
		this();
		System.out.println("A1");
	}
	A()
	{
		this("ABC");
		System.out.println("A2");
	}
	A(String s)
	{
		System.out.println("A3");
	}
}

class B extends A
{
	B()
	{
		super(10);
		System.out.println("B1");
	}
}
public class SuperCallingStatement
{
	public static void main(String[] args) 
	{
		new B();
	}
}
