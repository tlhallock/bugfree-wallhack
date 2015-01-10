package poc.ide.gui;

import java.util.Collections;
import java.util.Set;

import poc.ide.code.Clazz;
import poc.ide.code.Code;
import poc.ide.proj.CodeSet.CodeFilter;
import poc.ide.proj.Project;

public abstract class ClassViewer implements CodeFilter
{
	private String text;
	private Project project;
	
	public ClassViewer()
	{
		text = "";
		project = null;
	}
	
	public void showClasses()
	{
		Set<Clazz> classes;
		
		if (project == null)
		{
			classes = Collections.emptySet();
		}
		else
		{
			classes = project.getCodeSet().filter(this, Clazz.class);
		}
		
		showClasses(classes);
	}
	
	@Override
	public boolean accept(Code tree)
	{
		return tree.getNameSpaceUniqueKey().contains(text);
	}
	
	public void setFilterText(String text)
	{
		this.text = text;
		showClasses();
	}

	protected Project getProject()
	{
		return project;
	}

	public void setProject(Project project2)
	{
		this.project = project2;
		showClasses();
	}

	public abstract void showClasses(Set<Clazz> types);
	
}
