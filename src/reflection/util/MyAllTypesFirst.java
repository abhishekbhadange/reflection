package reflection.util;

public class MyAllTypesFirst 
{
	private int myInt;
	private String myString, name;
	private double myDouble;
	private long myLong;
	private char myChar;
	
	public MyAllTypesFirst()
	{
		if(Debug.getDebugValue()==2)
			System.out.println("Inside constructor of MyAllTypesFirst class");
	}
	
	public int getmyInt()
	{
		return myInt;
	}
	public void setmyInt(String ipInt)
	{
		myInt = Integer.parseInt(ipInt);
	}
	public String getmyString()
	{
		return myString;
	}
	public void setmyString(String ipString)
	{
		myString = ipString;
	}
	public double getmyDouble()
	{
		return myDouble;
	}
	public void setmyDouble(String ipDouble)
	{
		myDouble = Double.parseDouble(ipDouble);
	}
	public long getmyLong()
	{
		return myLong;
	}
	public void setmyLong(String ipLong)
	{
		myLong = Long.parseLong(ipLong);
	}
	public char getmyChar()
	{
		return myChar;
	}
	public void setmyChar(String ipChar)
	{
		myChar = ipChar.charAt(0);
	}
	public String toString()
	{
		return ("MyAllTypesFirst \nFirst Element: "+this.getmyInt()+"\nSecond Element: "+this.getmyString()+
				"\nThird Element: "+this.getmyDouble()+"\nFourth Element: "+this.getmyLong()+
				"\nFifth Element: "+this.getmyChar());
	}
	@Override
	public int hashCode() 
	{
		if(Debug.getDebugValue()==1)
			System.out.println("Inside Overrided hashcode method of MyAllTypesFirst class");
		final int prime = 31;
		int result = 1;
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if(Debug.getDebugValue()==1)
			System.out.println("Inside Overrided equals method of MyAllTypesFirst class");
		boolean returnValue = false; 
	    if (obj == null)
	    	returnValue = false;
	    if (!(obj instanceof MyAllTypesFirst))
	    	returnValue = false;
	    if(obj instanceof MyAllTypesFirst)
	    {
	    	MyAllTypesFirst matf = (MyAllTypesFirst)obj;
	    	returnValue = (this.getmyInt()==matf.getmyInt()) && (this.getmyString().equals(matf.getmyString())) && 
	    				  (this.getmyDouble()==matf.getmyDouble()) && (this.getmyLong()==matf.getmyLong()) && 
	    				  (this.getmyChar()==matf.getmyChar())  ;
	    }
	    return returnValue;
	}
}
