package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Window;

public class Label extends Code
{
	private Name name;
	
	public Label(Code parent, Name name)
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
	public List<InputMethod<? extends Code>> getInputs()
	{
		List<InputMethod<? extends Code>> list = new LinkedList<>();
		list.add(Window.getWindow().getGuiFactory().createNameInputMethod("Label Name: ", name));
		return list;
	}

}
