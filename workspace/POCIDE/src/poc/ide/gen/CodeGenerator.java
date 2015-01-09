package poc.ide.gen;


import java.io.File;

import poc.ide.proj.CodeSet;

public abstract class CodeGenerator
{
	public boolean accepts(File file)
	{
		for (String ext : getExensions())
		{
			if (file.getName().endsWith(ext))
			{
				return true;
			}
		}
		return false;
	}

	public abstract void generate(File file, CodeSet set);
	public abstract String[] getExensions();
}
