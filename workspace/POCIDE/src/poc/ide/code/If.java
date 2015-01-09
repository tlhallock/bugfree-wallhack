package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.code.Type.Primitive.BooleanType;
import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class If extends CodeTree
{
	private static final class ElseIf
	{
		private Expression<BooleanType> condition;
		private Block block;
	}
	
	private Expression<BooleanType> condition;
	private Block then;
	private List<ElseIf> elseIfs;
	private Block otherwise;

	public If()
	{
		condition = BooleanExpression.TRUE;
		then = new Block();
		elseIfs = new LinkedList<>();
		otherwise = null;
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("if (");
		condition.appendText(builder, depth).append(")\n");
		then.appendText(builder, depth);
		
		for (ElseIf elseif : elseIfs)
		{
			Indenter.indent(builder, depth).append(" else if (");
			elseif.condition.appendText(builder, depth).append(")\n");
			elseif.block.appendText(builder, depth);
		}
		
		if (otherwise != null)
		{
			Indenter.indent(builder, depth).append("else\n");
			otherwise.appendText(builder, depth);
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
