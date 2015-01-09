package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;

public class Package extends CodeTree
{
	private Name[] name;
	
	public Package(CodeTree parent)
	{
		super(parent);
		name = new Name[0];
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return collect();
	}

	@Override
	public StringBuilder appendText(StringBuilder builder, int depth)
	{
		return builder.append(name);
	}

//	@Override
//	protected void setParameter(String label, Object value)
//	{
//		String[] split = ((String) value).split(".");
//		
//		name = new Name[split.length];
//		for (int i = 0; i < split.length; i++)
//		{
//			name[i] = new Name(this, split[i]);
//		}
//	}

	@Override
	public List<InputMethod<? extends CodeTree>> getInputs()
	{
		List<InputMethod<? extends CodeTree>> returnValue = new LinkedList<>();
		
		//
		
		return returnValue;
	}

	public String collect()
	{
		StringBuilder builder = new StringBuilder();
		
		for (Name n : name)
		{
			builder.append(n.getName()).append('.');
		}
		
		return builder.toString();
	}
}
