package poc.ide.gen;

import java.io.File;

import poc.ide.proj.CodeSet;

public class RecursiveGenerator extends CodeGenerator
{

	public boolean accepts(File file)
	{
		return file.isDirectory();
	}

	@Override
	public void generate(File file, CodeSet set)
	{
		
		
	}

	@Override
	public String[] getExensions() { return new String[0]; }
}
