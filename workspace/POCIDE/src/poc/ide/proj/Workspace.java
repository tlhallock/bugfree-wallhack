package poc.ide.proj;

import java.util.HashSet;
import java.util.Set;

public class Workspace
{
	private FsLocation root;
	private Set<Project> projects;
	
	public Workspace()
	{
		projects = new HashSet<>();
	}
}

