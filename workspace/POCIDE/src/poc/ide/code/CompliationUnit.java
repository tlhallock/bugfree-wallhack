package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;

public class CompliationUnit extends CodeTree
{
	private Package pack4ge;
	
	private List<Import> imports;
	private List<Type> types;
	
	public CompliationUnit(CodeTree parent)
	{
		super(parent);
		imports = new LinkedList<>();
		types = new LinkedList<>();
		pack4ge = new Package(this);
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder;
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		return returnValue;
	}

}
