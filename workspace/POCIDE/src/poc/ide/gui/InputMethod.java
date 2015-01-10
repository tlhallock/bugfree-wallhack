package poc.ide.gui;

import poc.ide.code.Code;

public abstract class InputMethod<T extends Code>
{
	private String label;
	protected T code;
	
	protected InputMethod(String label, T code)
	{
		this.label = label;
		this.code = code;
	}
	
	public abstract void assign();

	T getCode()
	{
		return code;
	}
	
	public boolean canInsert()
	{
		return true;
	}
	
	protected String getLabel()
	{
		return label;
	}
}
