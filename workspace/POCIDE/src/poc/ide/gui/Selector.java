package poc.ide.gui;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import poc.ide.code.util.CodeGenerators;
import poc.ide.code.util.CodeGeneratorFilters.CodeGeneratorFilter;
import poc.ide.code.util.CodeGenerators.CodeGenerator;
import poc.ide.code.Code;
import poc.ide.code.CompilationUnit;
import poc.ide.code.NotCode;
import poc.ide.proj.FsLocation;
import poc.ide.proj.Project;

public abstract class Selector
{
	private LinkedList<Code> stack;
	private Viewer viewer;
	
	public Selector(Viewer viewer)
	{
		this.viewer = viewer;
		stack = new LinkedList<>();
	}
	
	public void push(Code c)
	{
		stack.push(c);
		edit(getCurrent());
	}
	
	public void pop()
	{
		if (!stack.isEmpty())
		{
			try
			{
				stack.peek().save();
			}
			catch (Exception e)
			{
				System.err.println("Unable to Save");
				e.printStackTrace();
			}
			stack.pop();
		}
		
		if (stack.isEmpty())
		{
			showEmptyStack();
		}
		else
		{
			edit(getCurrent());
		}
	}
	
	private void showEmptyStack()
	{
		List<InputMethod<? extends Code>> list = new LinkedList<>();
		
		Project currentProject = Window.getWindow().getCurrentProject();
		if (currentProject == null)
		{
			Collections.emptyList();
			edit(list);
			return;
		}
		FsLocation defaultSourceDir = currentProject.getDefaultSourceDir();
		
		GuiFactory guiFactory = Window.getWindow().getGuiFactory();
		for (CompilationUnit unit : Project.getCompilationUnits(defaultSourceDir).values())
		{
			list.add(guiFactory.createChildInputMethod(unit.getNameSpaceUniqueKey(),unit));
		}
		edit(list);
	}
	
	public Code getCurrent()
	{
		if (stack.isEmpty())
		{
			return new NotCode(null);
		}
		
		return stack.peek();
	}
	
	private void edit(Code c)
	{
		edit(c.getInputs());
		viewer.setCode(c);
	}

	protected void generatorPrompt(InputMethod<? extends Code> location)
	{
		Code child = location.getCode();
		Code parent = child.getParent();
		if (parent == null)
		{
			System.err.println("No parent");
			return;
		}
		
		CodeGeneratorFilter filter = parent.getFilter(child);
		
		List<InputMethod<? extends Code>> generators = new LinkedList<>();
		for (CodeGenerator<? extends Code> gen : CodeGenerators.getGenerators(filter))
		{
			generators.add(Window.getWindow().getGuiFactory().
					createGeneratorInputMethod(parent, child, gen));
		}
		edit(generators);
	}
	

	protected abstract void edit(List<InputMethod<? extends Code>> inputs);
}
