package poc.ide.code;

import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Assignment<T extends Type> extends Expression<T>
{
	private Name variable;
	private Expression<T> expr;
	
	public Assignment(Code parent)
	{
		super(parent);
		variable = new Name(this);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append(variable.getName()).append(" = ");
		if (expr != null)
		{
			expr.appendText(builder, depth);
		}
		return builder;
	}


	@Override
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
	}

}
