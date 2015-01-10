package poc.ide.code;

import java.util.List;

import poc.ide.gui.InputMethod;

public class Modifier extends Code
{
	// final
	// abstract
	// static
	// native
	// transient
	
	public Modifier(Code parent)
	{
		super(parent);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return null;
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		return null;
	}

}
