package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;

public class Import extends Code
{
	public static final Import implementation = new Import(null, null);
	
	private String reference;
	
	public Import(Code parent, String ref)
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
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> returnValue = new LinkedList<>();
		
		return returnValue;
	}
}
