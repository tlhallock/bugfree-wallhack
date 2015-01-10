package poc.ide.code;

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
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
	}
}
