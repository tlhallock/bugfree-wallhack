package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.main.Indenter;

public class Block extends CodeTree
{
	private List<CodeTree> code;
	
	public Block()
	{
		code = new LinkedList<>();
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("{\n");
		for (CodeTree tree : code)
		{
			tree.appendText(builder, depth + 1);
		}
		Indenter.indent(builder, depth).append("}\n");
		
		return null;
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		int i = 0;
		for (CodeTree tree : code)
		{
			returnValue.addAll(tree.getInputs());
		}
		
		return returnValue;
	}
}
