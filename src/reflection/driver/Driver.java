package reflection.driver;

import reflection.serDeser.Deserialize;
import reflection.serDeser.Serialize;
import reflection.util.Parser;
import reflection.util.Debug;

public class Driver 
{
	public static void main(String[] args) 
	{
		int debugValue = Integer.parseInt(args[2]);
		Debug.setDebugValue(debugValue);
		Parser p = new Parser();
		Deserialize d = new Deserialize(p, args[0]);
		d.findUnique();
		Serialize s = new Serialize(p, args[1]);
		s.serializeObject();
	}
}
