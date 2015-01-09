package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Expression.BooleanExpression;
import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class For extends CodeTree
{
	// Needs to be an assignment list...
	private Assignment initlizer;
	private Expression<Type.Primitive.BooleanType> condition;
	private Statement increment;
	
	private Block block;
	
	public For()
	{
		condition = BooleanExpression.FALSE;
		block = new Block();
		increment= new EmptyStatement();
		block = new Block();
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
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		return returnValue;
	}
	
	

}
