package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Return<T extends Type> extends Code
{
	private Expression<T> expr;
	
	public Return(Code p, T t) { super(p); }
	
	public void setValue(Expression<T> expr)
	{
		this.expr = expr;
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("return ");
		if (expr != null)
		{
			expr.appendText(builder, depth);
		}
		return builder.append(";\n");
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		if (expr != null)
		{
			returnValue.addAll(expr.getInputs());
		}
		
		return returnValue;
	}
}
