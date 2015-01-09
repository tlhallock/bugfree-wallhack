package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class Break extends CodeTree
{
	private Label label;
	
	public Break(CodeTree parent)
	{
		super(parent);
	}
	
	public Break(CodeTree parent, Label label)
	{
		this(parent);
		this.label = label;
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("break");
		if (label != null)
		{
			builder.append(' ');
			builder.append(label.getName());
		}
		return builder.append(";\n");
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		// Almost certainly not right...
		returnValue.addAll(label.getInputs());
		
		return returnValue;
	}
}
