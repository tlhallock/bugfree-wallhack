package poc.ide.code;

import java.util.Collections;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Viewer;

public class NotCode extends CodeTree
{
	public NotCode(CodeTree parent)
	{
		super(parent);
	}
	
	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder;
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs() { return Collections.emptyList(); }
	
	@Override
	public String getUniqueNamespaceToken()
	{
		return "";
	}
}
