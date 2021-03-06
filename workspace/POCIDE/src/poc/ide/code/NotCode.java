package poc.ide.code;

import java.util.List;

import poc.ide.gui.InputMethod;

public class NotCode extends Code
{
	public NotCode(Code parent)
	{
		super(parent);
	}
	
	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder;
	}

	@Override
	public void appendInputs(List<InputMethod<? extends Code>> list) {}
	
	@Override
	public String getUniqueNamespaceToken()
	{
		return "";
	}
}
