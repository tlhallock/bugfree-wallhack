package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class While extends Code
{
	private Block block;
	private Expression<Type.Primitive.BooleanType> whileExpr;
	
	public While(Code parent)
	{
		super(parent);
		block = new Block(this);
		whileExpr = BooleanExpression.getFalse(this);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("while (");
		whileExpr.appendText(builder, depth).append(")\n");
		block.appendText(builder, depth);
		return builder;
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		returnValue.addAll(whileExpr.getInputs());
		
		return returnValue;
	}
}
