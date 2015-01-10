package poc.ide.code;

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
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
		list.add(Window.getWindow().getGuiFactory().createNameInputMethod("Name:", this));
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
