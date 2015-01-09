package poc.ide.gui;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.CodeTree;
import poc.ide.code.NotCode;

public abstract class Selector
{
	private LinkedList<CodeTree> stack;
	private Viewer viewer;
	
	public Selector(Viewer viewer)
	{
		this.viewer = viewer;
		stack = new LinkedList<>();
	}
	
	public void push(CodeTree c)
	{
		stack.push(c);
		edit(getCurrent());
	}
	
	public void pop()
	{
		if (!stack.isEmpty())
		{
			stack.pop();
		}
		
		edit(getCurrent());
	}
	
	public CodeTree getCurrent()
	{
		if (stack.isEmpty())
		{
			return new NotCode(null);
		}
		
		return stack.peek();
	}
	
	private void edit(CodeTree c)
	{
		edit(c.getInputs());
		viewer.setCode(c);
	}
	
	protected abstract void edit(List<InputMethod<? extends CodeTree>> inputs);
}
