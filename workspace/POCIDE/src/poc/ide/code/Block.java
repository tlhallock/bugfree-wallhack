package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.util.Indenter;
import poc.ide.gui.InputMethod;

public class Block extends Code
{
	private List<Code> code;
	
	public Block(Code parent)
	{
		super(parent);
		code = new LinkedList<>();
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		Indenter.indent(builder, depth).append("{\n");
		for (Code tree : code)
		{
			tree.appendText(builder, depth + 1);
		}
		Indenter.indent(builder, depth).append("}\n");
		
		return null;
	}

	@Override
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
		int i = 0;
		for (Code tree : code)
		{
			list.addAll(tree.getInputs());
		}
	}
}
