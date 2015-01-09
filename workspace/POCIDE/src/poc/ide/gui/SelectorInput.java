package poc.ide.gui;

import poc.ide.code.CodeTree;

public class SelectorInput<T extends CodeTree> extends InputMethod<T> 
{
	private CodeTree child;
	
	protected SelectorInput(String label, T code)
	{
		super(label, code);
	}

	@Override
	public T getInput()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
