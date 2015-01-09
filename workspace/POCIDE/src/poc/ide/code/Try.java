package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class Try extends CodeTree
{
	private static final class Catch
	{
		String type;
		Block code;
	}
	
	private List<Declaration> resources;
	private Block attempt;
	private List<Catch> catches;
	private Block atLast;
	
	public Try()
	{
		resources = new LinkedList<>();
		attempt = new Block();
		catches = new LinkedList<>();
		atLast = null;
	}
	

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("try\n");
		
		attempt.appendText(builder, depth);
		
		if (atLast != null)
		{
			Indenter.indent(builder, depth).append("finally");
			atLast.appendText(builder, depth);
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
