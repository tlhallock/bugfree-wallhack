package poc.ide.code;

import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Throw extends Code
{
	private Expression expr;
	
	public Throw(Code parent)
	{
		super(parent);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth);
		builder.append(" throw ");
		expr.appendText(builder, depth);
		return builder;
	}

	@Override
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
	}
}
