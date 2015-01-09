package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class Declaration<T extends Type> extends CodeTree
{
	private Name v;
	T t;
	
	public Declaration(CodeTree parent, T t)
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
	protected void setParameter(String label, Object value) {}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		returnValue.addAll(t.getInputs());
		returnValue.addAll(v.getInputs());
		
		return returnValue;
	}

}
