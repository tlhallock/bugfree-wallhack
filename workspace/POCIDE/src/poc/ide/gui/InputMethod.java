package poc.ide.gui;

import poc.ide.code.CodeTree;

public abstract class InputMethod<T extends CodeTree>
{
	private String label;
	protected T code;
	
	protected InputMethod(String label, T code)
	{
		this.label = label;
		this.code = code;
	}
	
	public abstract void assign();

}
