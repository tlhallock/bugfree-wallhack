package poc.ide.code;

import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Break extends Code
{
	private Label label;
	
	public Break(Code parent)
	{
		super(parent);
	}
	
	public Break(Code parent, Label label)
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
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
		// Almost certainly not right...
		list.addAll(label.getInputs());
	}
}
