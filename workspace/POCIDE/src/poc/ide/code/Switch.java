package poc.ide.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Switch<T extends Type> extends Code
{
	private Expression<T> expr;
	private Map<Expression<T>, Block> cases;
	private Block otherwise;
	
	public Switch(Code parent)
	{
		super(parent);
		cases = new HashMap<>();
		otherwise = null;
	}
	
	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("switch (");
		expr.appendText(builder, depth);
		builder.append(")\n");
		
		for (Entry<Expression<T>, Block> entry : cases.entrySet())
		{
			Indenter.indent(builder, depth + 1).append("case ");
			entry.getKey().appendText(builder, depth).append(":");
			entry.getValue().appendText(builder, depth + 2);
		}
		
		if (otherwise != null)
		{
			Indenter.indent(builder, depth + 1).append("default:");
			otherwise.appendText(builder, depth + 2);
		}
		
		return builder;
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		return returnValue;
	}
}
