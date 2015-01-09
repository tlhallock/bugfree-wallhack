package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;

public class Import extends CodeTree
{
	private String reference;
	
	private Import(CodeTree parent, String ref)
	{
		super(parent);
		reference = ref;
	}
	
	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append("import ").append(reference).append(";\n");
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		return returnValue;
	}
}
