package poc.ide.gen;

import java.io.File;

import poc.ide.proj.CodeSet;

public class JarGenerator extends CodeGenerator
{

	@Override
	public void generate(File file, CodeSet set)
	{
		
	}

	@Override
	public String[] getExensions()
	{
		return new String[] {".jar"};
	}

}
