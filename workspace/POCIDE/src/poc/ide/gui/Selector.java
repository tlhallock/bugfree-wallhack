package poc.ide.gui;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.CodeTree;
import poc.ide.code.NotCode;

public abstract class Selector
{
	private Viewer viewer;
	private LinkedList<CodeTree> stack;
	
	public Selector()
	{
		viewer = Window.guiFactory.createViewer();
		stack = new LinkedList<>();
	}
	
	public void push(CodeTree c)
	{
		getCurrent().removeViewer(viewer);
		
		stack.push(c);
		edit(getCurrent());
		
		viewer.show(c);
		c.addViewer(viewer);
	}
	
	public void pop()
	{
		getCurrent().removeViewer(viewer);
		
		if (!stack.isEmpty())
		{
			stack.pop();
		}
		
		edit(getCurrent());
		viewer.show(getCurrent());
		getCurrent().addViewer(viewer);
	}
	
	public CodeTree getCurrent()
	{
		if (stack.isEmpty())
		{
			return new NotCode();
		}
		
		return stack.peek();
	}
	
	private void edit(CodeTree c)
	{
		edit(c.getInputs());
	}
	
	protected abstract void edit(List<InputMethod<? extends CodeTree>> inputs);
}
