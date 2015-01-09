package poc.ide.code;

import java.util.Collections;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Viewer;

public class NoCode extends CodeTree
{

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder;
	}

	@Override
	protected void setParameter(String label, Object value) {}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs() { return Collections.emptyList(); }
	
	public void addViewer(Viewer v) {}

	@Override
	public String getUniqueNamespaceToken()
	{
		return "";
	}
}
