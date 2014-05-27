package reflection.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.lang.Class;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Method;


public class Parser 
{
	public List<Object> objects = new ArrayList<Object>();
	public String substr1 = "DPSerialization";
	public String substr2 = "MyAllTypesFirst";
	public String substr3 = "MyAllTypesSecond";
	public String substr4 = "complexType"; 
	Class<?> cls = null;
	public Parser()
	{
		if(Debug.getDebugValue()==2)
			System.out.println("Inside constructor of Parser class");
	}
	public void parse(String arg0)
	{
		int flag = 0, b1, b2, b3, flg = 0;
		Object obj;
		List<String> types = new ArrayList<String>();
		types.add("int");
		types.add("string");
		types.add("double");
		types.add("long");
		types.add("char");
		types.add("float");
		types.add("short");
		String sub = null, part1, part2, subpart2, superpart2, value = null; 
		Method method;
		String[] parts = null, subparts = null, superparts = null;
		try
		{
			FileReader fr = new FileReader(arg0);
			BufferedReader reader = new BufferedReader(fr);
			String line = null;
			line = reader.readLine();
			while(line!=null)
			{
				if(line.contains(substr1))
				{
					flag = 1;
					line = reader.readLine();
					if(line.contains(substr4))
					{
						flg = 1;
						if(line.contains(substr2))
						{
							cls = Class.forName("reflection.util."+substr2);
							obj = cls.newInstance();
						}
						else
						{
							cls = Class.forName("reflection.util."+substr3);
							obj = cls.newInstance();
						}
						line = reader.readLine();
						do
						{
							b1 = line.indexOf('<');
							b2 = line.indexOf('>');
							b3 = line.indexOf('<', b2);
							value = line.substring(b2+1, b3);
							sub = line.substring(b1+1, b2);	
							parts = sub.split(" ");
							part1 = parts[0];
							part2 = parts[1];
							subparts = part2.split("=");
							subpart2 = subparts[1];
							superparts = subpart2.split(":");
							superpart2 = superparts[1];
							superpart2 = superpart2.substring(0, superpart2.length()-1);
							if(types.contains(superpart2))
							{
								Class[] params = new Class[1];
								params[0] = String.class;
								method = cls.getDeclaredMethod("set"+part1, params);
								method.invoke(obj, value);
							}
							line = reader.readLine();
						}while(!line.contains("/"+substr4));
						objects.add(obj);
					}
				}
				line = reader.readLine();
				line = reader.readLine();
			}
			reader.close();
			if(flg==0)
			{
				System.out.println("Error: No "+substr4+" tag found, exiting...");
				System.exit(0);
			}
			if(flag==0)
			{
				System.out.println("Error: No "+substr1+" tag found, exiting...");
				System.exit(0);		
			}
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("FileNotFoundException occured: "+fnfe.getMessage());
			System.exit(0);
		}
		catch(NoSuchMethodException nsme)
		{
			System.out.println("NoSuchMethodException occured: "+nsme.getMessage());
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
			System.exit(0);
		}
	}
	public void compare()
	{
		Class<?> cl2 = null;
		try
		{
			int i, j, k, counter1 = 0, counter2 = 0;
			Object obj1, obj2, objx;
			for(k=0; k<objects.size(); k++)
			{
				objx = objects.get(k);
				if (objx instanceof MyAllTypesFirst)
				{
					counter1++;
				}
				else if (objx instanceof MyAllTypesSecond)
				{
					counter2++;
				}
			}
			for(i=0; i<objects.size(); i++)
			{
				obj1 = objects.get(i);
				cl2 = obj1.getClass();
				for(j=i+1; j<objects.size(); j++)
				{
					obj2 = objects.get(j);
					if(cl2==obj2.getClass())
					{
						if(obj1.equals(obj2))
						{
							if(obj1 instanceof MyAllTypesFirst)
							{
								counter1--;
								break;
							}
							else
							{
								counter2--;
								break;
							}
						}
					}		
				}
			}
			if(Debug.getDebugValue()>=0)
				System.out.println("Unique MyAllTypesFirst = "+counter1+
				"\nUnique MyAllTypesSecond = "+counter2);
		}
		catch(Exception e)
		{
			System.out.println("NoSuchMethodException occured: "+e.getMessage());
			System.exit(0);
		}
	}
}
