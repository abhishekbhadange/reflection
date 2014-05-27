package reflection.util;

public class MyAllTypesSecond 
{
	private int myIntS;
	private String myStringS, newname;
	private float myFloatS;
	private short myShortS;
	private char myCharS;
	
	public MyAllTypesSecond()
	{
		if(Debug.getDebugValue()==2)
			System.out.println("Inside constructor of MyAllTypesSecond class");
	}
	
	public int getmyIntS()
	{
		return myIntS;
	}
	public void setmyIntS(String ipIntS)
	{
		myIntS = Integer.parseInt(ipIntS);
	}
	public String getmyStringS()
	{
		return myStringS;
	}
	public void setmyStringS(String ipStringS)
	{
		myStringS = ipStringS;
	}
	public float getmyFloatS()
	{
		return myFloatS;
	}
	public void setmyFloatS(String ipFloatS)
	{
		myFloatS = Float.parseFloat(ipFloatS);
	}
	public short getmyShortS()
	{
		return myShortS;
	}
	public void setmyShortS(String ipShortS)
	{
		myShortS = Short.parseShort(ipShortS);
	}
	public char getmyCharS()
	{
		return myCharS;
	}
	public void setmyCharS(String ipCharS)
	{
		myCharS = ipCharS.charAt(0);
	}
	public String toString()
	{
		return ("MyAllTypesSecond \nFirst Element: "+this.getmyIntS()+"\nSecond Element: "+this.getmyStringS()+
				"\nThird Element: "+this.getmyFloatS()+"\nFourth Element: "+this.getmyShortS()+
				"\nFifth Element: "+this.getmyCharS());
	}
	@Override
	public int hashCode() 
	{
		if(Debug.getDebugValue()==1)
			System.out.println("Inside Overrided hashcode method of MyAllTypesFirst class");
		final int prime = 17;
		int result = 1;
	    result = prime * result + ((newname == null) ? 0 : newname.hashCode());
	    return result;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if(Debug.getDebugValue()==1)
			System.out.println("Inside Overrided equals method of MyAllTypesSecond class");
		boolean returnValue = false;
	    if (obj == null)
	    	returnValue = false;
	    if (!(obj instanceof MyAllTypesSecond))
	    	returnValue = false;
	    if(obj instanceof MyAllTypesSecond)
	    {
	    	MyAllTypesSecond mats = (MyAllTypesSecond)obj;
	    	returnValue = (this.getmyIntS()==mats.getmyIntS()) && (this.getmyStringS().equals(mats.getmyStringS()))  && 
	    				  (this.getmyFloatS()==mats.getmyFloatS()) && (this.getmyShortS()==mats.getmyShortS()) && 
		    			  (this.getmyCharS()==mats.getmyCharS());
	    }
	    return returnValue;
	}
}
