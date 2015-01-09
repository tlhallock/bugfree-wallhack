package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class DoWhile extends CodeTree
{
	private Block block;
	private Expression<Type.Primitive.BooleanType> whileExpr;
	
	public DoWhile(CodeTree parent)
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
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		returnValue.addAll(whileExpr.getInputs());
		
		return returnValue;
	}
}
