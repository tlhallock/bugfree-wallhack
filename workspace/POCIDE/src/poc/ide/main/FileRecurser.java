package poc.ide.main;

import java.io.File;

public class FileRecurser
{
	public static void recurse(File file, FileMethod method)
	{
		if (file.isDirectory())
		{
			for (File child : file.listFiles())
			{
				recurse(child, method);
			}
		}
		else if (file.isFile())
		{
			method.found(file);
		}
	}
	
	public interface FileMethod
	{
		void found(File file);
	}
}
