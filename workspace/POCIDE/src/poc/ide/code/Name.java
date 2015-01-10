package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public class Name extends Code
{
	private String name;
	
	public Name(Code parent)
	{
		this(parent, "unnamed");
	}
	
	public Name(Code parent, String name)
	{
		super(parent);
		this.name = name;
	}
	
	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append(name);
	}

	public String getName()
	{
		return name;
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		returnValue.add(Window.getWindow().getGuiFactory().createNameInputMethod("Name:", this));
		return returnValue;
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return name;
	}

	public void setName(String text)
	{
		name = text;
		notifyObservers();
	}
}
