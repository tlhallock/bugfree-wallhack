package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class Assignment<T extends Type> extends Expression<T>
{
	private Name variable;
	private Expression<T> expr;
	
	public Assignment()
	{
		variable = new Name();
		
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
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		
		return returnValue;
	}

}
