package poc.ide.code;

import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class For extends Code
{
	// Needs to be an assignment list...
	private Assignment initlizer;
	private Expression<Type.Primitive.BooleanType> condition;
	private Statement increment;
	
	private Block block;
	
	public For(Code parent)
	{
		super(parent);
		condition = BooleanExpression.getFalse(this);
		block = new Block(this);
		increment= new EmptyStatement(this);
		block = new Block(this);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("for (");
		initlizer.appendText(builder, depth).append(";");
		condition.appendText(builder, depth).append(";");
		increment.appendText(builder, depth).append(")");

		block.appendText(builder, depth);
		
		return builder.append('\n');
	}

	@Override
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
	}
	
	

}
