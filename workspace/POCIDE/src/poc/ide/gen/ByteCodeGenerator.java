package poc.ide.gen;

import java.io.File;

import poc.ide.proj.CodeSet;

public class ByteCodeGenerator extends CodeGenerator
{
	@Override
	public void generate(File file, CodeSet set)
	{
	}

	@Override
	public String[] getExensions()
	{
		return new String[] {".class"};
	}

}
