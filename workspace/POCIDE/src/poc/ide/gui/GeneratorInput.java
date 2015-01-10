package poc.ide.gui;

import poc.ide.code.util.CodeGenerators.CodeGenerator;
import poc.ide.code.Code;

public abstract class GeneratorInput extends InputMethod<Code>
{
	private Code parent;
	private Code child;
	private CodeGenerator<? extends Code> generator;
	
	protected GeneratorInput(Code parent, Code child, CodeGenerator<? extends Code> generator)
	{
		super(generator.getLabel(), child);
		
		this.parent = parent;
		this.child = child;
		this.generator = generator;
	}

	@Override
	public void assign()
	{
		parent.newCodeAdded(child, generator.createCode(parent, null));
	}

	public boolean canInsert()
	{
		return false;
	}
}
