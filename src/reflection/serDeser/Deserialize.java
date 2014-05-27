package reflection.serDeser;

import reflection.util.Debug;
import reflection.util.Parser;

public class Deserialize 
{
	Parser p;
	public Deserialize(Parser Pin, String arg0)
	{
		if(Debug.getDebugValue()==2)
			System.out.println("Inside constructor of Deserialize class");
		p = Pin;
		p.parse(arg0);
	}
	public void findUnique()
	{
		p.compare();
	}
}
