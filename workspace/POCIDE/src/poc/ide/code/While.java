package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class While extends CodeTree
{
	private Block block;
	private Expression<Type.Primitive.BooleanType> whileExpr;
	
	public While()
	{
		block = new Block();
		whileExpr = BooleanExpression.FALSE;
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
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		returnValue.addAll(whileExpr.getInputs());
		
		return returnValue;
	}
}
