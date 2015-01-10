package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Try extends Code
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
	
	public Try(Code parent)
	{
		super(parent);
		resources = new LinkedList<>();
		attempt = new Block(this);
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
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
	}
}
