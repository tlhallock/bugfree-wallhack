package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.code.Type.Primitive.BooleanType;
import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class If extends Code
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

	public If(Code parent)
	{
		super(parent);
		
		condition = BooleanExpression.getTrue(this);
		then = new Block(this);
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
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		return returnValue;
	}
}
