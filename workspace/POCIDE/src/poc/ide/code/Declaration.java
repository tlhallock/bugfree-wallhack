package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Declaration<T extends Type> extends Code
{
	private Name v;
	T t;
	
	public Declaration(Code parent, T t)
	{
		super(parent);
		this.t = t;
		v = new Name(this, "foobar");
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth);
		t.appendText(builder, depth).append(' ');
		v.appendText(builder, depth).append('\n');
		return builder;
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		returnValue.addAll(t.getInputs());
		returnValue.addAll(v.getInputs());
		
		return returnValue;
	}

}
