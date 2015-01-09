package poc.ide.gen;

import java.io.File;

public abstract class Filter
{
	public abstract boolean accepts(File file);
	
	
	
	public static final Filter ALL = new Filter()
	{
		@Override
		public boolean accepts(File file)
		{
			return true;
		}
	};
	
	public static final Filter CLASS_FILTER = new Filter()
	{

		@Override
		public boolean accepts(File file)
		{
			return file.getName().endsWith(".class");
		}
		
	};

	public static final Filter SOURCE_FILTER = new Filter()
	{

		@Override
		public boolean accepts(File file)
		{
			return file.getName().endsWith(".java");
		}
		
	};
}
