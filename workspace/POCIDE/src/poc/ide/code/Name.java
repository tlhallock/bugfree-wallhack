package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public class Name extends CodeTree
{
	private String name;
	
	public Name()
	{
		this("unnamed");
	}
	
	public Name(String name)
	{
		this.name = name;
	}
	
	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append(name);
	}

	@Override
	protected void setParameter(String label, Object value)
	{
		name = ((Name) value).getName();
	}

	public String getName()
	{
		return name;
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		returnValue.add(Window.guiFactory.createNameInputMethod("Name:", this));
		return returnValue;
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return name;
	}
}
