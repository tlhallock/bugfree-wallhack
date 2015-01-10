package poc.ide.proj;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import poc.ide.code.CompilationUnit;
import poc.ide.gen.CodeAdder;
import poc.ide.gen.Filter;
import poc.ide.main.FileRecurser;
import poc.ide.main.FileRecurser.FileMethod;
import poc.ide.main.Serializer;

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

	// Needs to get this from the Gui...
	public FsLocation getDefaultSourceDir()
	{
		return srcDirs.iterator().next();
	}
	
	public static Map<poc.ide.code.Package, CompilationUnit> getCompilationUnits(FsLocation location)
	{
		final Map<poc.ide.code.Package, CompilationUnit> returnValue = new HashMap<>();
		
		FileRecurser.recurse(location.getFile(), new FileMethod()
		{
			@Override
			public void found(File file)
			{
				if (!file.getName().endsWith(".json"))
				{
					return;
				}
				
				try
				{
					CompilationUnit read = Serializer.read(file);
					returnValue.put(read.getPackage(), read);
				}
				catch(Exception ex)
				{
				}
				
			}});
		
		return returnValue;
	}
}
