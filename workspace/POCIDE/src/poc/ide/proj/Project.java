package poc.ide.proj;

import java.util.HashSet;
import java.util.Set;

import poc.ide.code.CodeTree;
import poc.ide.gen.CodeAdder;
import poc.ide.gen.Filter;

public class Project
{
	private FsLocation root;
	
	private FsLocation jdk;
	
	private Set<FsLocation> jars;
	private Set<FsLocation> srcDirs;
	
	private CodeSet code;
	
	private Set<Project> dependencies;
	
	public Project(FsLocation root)
	{
		this.root = root;
		jdk = null;
		
		jars = new HashSet<>();
		srcDirs = new HashSet<>();
		srcDirs.add(new FsLocation("./"));
		
		code = new CodeSet();
		
		dependencies = new HashSet<>();
	}
	
	public void synchronize()
	{
		code.clear();
		for (FsLocation loc : jars)
		{
//			CodeAdder.addCode(`, code, filter);
		}

		for (FsLocation loc : srcDirs)
		{
			CodeAdder.addCode(loc, code, Filter.SOURCE_FILTER);
		}
	}

	public boolean equals(Object o)
	{
		return o instanceof Project && ((Project) o).root.equals(root);
	}
	
	public int hashCode()
	{
		return root.hashCode();
	}

	public CodeSet getCodeSet()
	{
		return code;
	}
	
	public Set<FsLocation> getSources()
	{
		return srcDirs;
	}
}
