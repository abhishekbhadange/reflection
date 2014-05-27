package reflection.serDeser;

import reflection.util.Debug;
import reflection.util.Parser;
import reflection.util.MyAllTypesFirst;
import reflection.util.MyAllTypesSecond;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Serialize implements checkStrategy 
{
	Parser p;
	String path;
	public Serialize(Parser Pin, String args1)
	{
		if(Debug.getDebugValue()==2)
			System.out.println("Inside constructor of Serialize class");
		p = Pin;
		path = args1;
	}
	public void serializeObject()
	{
		try
		{
			int i;
			Class<?> c1 = null;
			Object obj;
			File file = new File(path);
			if (!file.exists()) 
				file.createNewFile();
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(i=0; i<((p.objects).size()); i++)
			{	
				obj = p.objects.get(i);
				c1 = obj.getClass();
				bw.write("<"+p.substr1+">\n");
				bw.write(" <"+p.substr4+" xsi:type=\""+c1.getName()+"\">\n");
				if(obj instanceof MyAllTypesFirst)
				{
					bw.write("  <myInt xsi:type=\"xsd:int\">"+(((MyAllTypesFirst) obj).getmyInt())+"</myInt>\n");
					bw.write("  <myString xsi:type=\"xsd:string\">"+(((MyAllTypesFirst) obj).getmyString())+"</myString>\n");
					bw.write("  <myDouble xsi:type=\"xsd:double\">"+(((MyAllTypesFirst) obj).getmyDouble())+"</myDouble>\n");
					bw.write("  <myLong xsi:type=\"xsd:long\">"+(((MyAllTypesFirst) obj).getmyLong())+"</myLong>\n");
					bw.write("  <myChar xsi:type=\"xsd:char\">"+(((MyAllTypesFirst) obj).getmyChar())+"</myChar>\n");
				}
				else if(obj instanceof MyAllTypesSecond)
				{
					bw.write("  <myIntS xsi:type=\"xsd:int\">"+(((MyAllTypesSecond) obj).getmyIntS())+"</myIntS>\n");
					bw.write("  <myStringS xsi:type=\"xsd:string\">"+(((MyAllTypesSecond) obj).getmyStringS())+"</myStringS>\n");
					bw.write("  <myFloatS xsi:type=\"xsd:float\">"+(((MyAllTypesSecond) obj).getmyFloatS())+"</myFloatS>\n");
					bw.write("  <myShortS xsi:type=\"xsd:short\">"+(((MyAllTypesSecond) obj).getmyShortS())+"</myShortS>\n");
					bw.write("  <myCharS xsi:type=\"xsd:char\">"+(((MyAllTypesSecond) obj).getmyCharS())+"</myCharS>\n");
				}
				bw.write(" </"+p.substr4+">\n");
				bw.write("</"+p.substr1+">\n");
			}
			bw.close();
		}
		catch(IOException io)
		{
			System.out.println("NoSuchMethodException occured: "+io.getMessage());
			System.exit(0);
		}
		catch(Exception e)
		{
			System.out.println("Exception occured: "+e.getMessage());
			System.exit(0);
		}
	}
}
