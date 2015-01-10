package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class DoWhile extends Code
{
	private Block block;
	private Expression<Type.Primitive.BooleanType> whileExpr;
	
	public DoWhile(Code parent)
	{
		super(parent);
		block = new Block(this);
		whileExpr = BooleanExpression.getTrue(this);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		block.appendText(builder, depth);
		Indenter.indent(builder, depth).append("while (");
		whileExpr.appendText(builder, depth).append(");");
		return builder.append('\n');
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		returnValue.addAll(whileExpr.getInputs());
		
		return returnValue;
	}
}
