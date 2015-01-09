package poc.ide.code;

import java.util.Collections;
import java.util.List;

import poc.ide.gui.InputMethod;

public class EmptyStatement extends Statement
{

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder;
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		return Collections.emptyList();
	}

}
