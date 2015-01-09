package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public class Label extends CodeTree
{
	private Name name;
	
	public Label(CodeTree parent, Name name)
	{
		super(parent);
		this.name = name;
		name.setParent(this);
	}

	public String getName()
	{
		return name.getName();
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append(name.getName()).append(":");
	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> list = new LinkedList<>();
		list.add(Window.getWindow().getGuiFactor().createNameInputMethod("Label Name: ", name));
		return list;
	}

}
