package poc.ide.proj;

import java.io.File;

public class FsLocation
{
	private String path;
	private boolean relative;
	
	public FsLocation(String path)
	{
		this.path = path;
		relative = path.charAt(0) != '/';
	}

	public boolean equals(Object o)
	{
		return o instanceof FsLocation && ((FsLocation) o).path.equals(path);
	}
	
	public int hashCode()
	{
		return path.hashCode();
	}
	
	public File getFile()
	{
		return new File(path);
	}
	
	public String toString()
	{
		return path;
	}
}
