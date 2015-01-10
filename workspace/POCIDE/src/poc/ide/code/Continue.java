package poc.ide.code;

import java.util.Collections;
import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Continue extends Code
{
	public Continue(Code parent)
	{
		super(parent);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return Indenter.indent(builder, depth).append("continue;\n");
	}

	@Override
	public List<InputMethod<? extends Code>> getInputs()
	{
		return Collections.emptyList();
	}
}
