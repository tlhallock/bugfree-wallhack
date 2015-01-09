package poc.ide.gui;

import java.util.TreeSet;

import poc.ide.code.CodeTree;
import poc.ide.code.Type.Clazz;
import poc.ide.proj.CodeSet.CodeFilter;
import poc.ide.proj.Project;

public abstract class ClassViewer implements CodeFilter
{
	private String text;
	private Project project;
	
	public ClassViewer(Project project)
	{
		this.project = project;
		text = "";
	}
	
	public void showClasses()
	{
		if (project == null)
		{
			return;
		}
		showClasses(project.getCodeSet().filter(this, Clazz.class));
	}
	
	@Override
	public boolean accept(CodeTree tree)
	{
		return tree.getNameSpaceUniqueKey().contains(text);
	}
	
	public void setFilterText(String text)
	{
		this.text = text;
		showClasses();
	}

	public abstract void showClasses(TreeSet<Clazz> types);
	
	protected Project getProject()
	{
		return project;
	}
}
