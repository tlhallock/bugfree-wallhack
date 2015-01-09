package poc.ide.code;

import java.util.Collections;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class Continue extends CodeTree
{
	public Continue(CodeTree parent)
	{
		super(parent);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return Indenter.indent(builder, depth).append("continue;\n");
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		return Collections.emptyList();
	}
}
