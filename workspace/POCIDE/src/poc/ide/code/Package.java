package poc.ide.code;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import poc.ide.gui.InputMethod;
import poc.ide.proj.FsLocation;

public class Package extends Code
{
	@JsonIgnore
	private FsLocation location;
	
	private Name[] name;
	
	
	public Package(FsLocation location)
	{
		// top level...
		super(null);
		this.location = location;
		name = new Name[0];
	}

	@Override
	public String getUniqueNamespaceToken()
	{
		return collect('.');
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
	public void appendInputs(List<InputMethod<? extends Code>> list)
	{
		//
	}

	public String collect(char c)
	{
		StringBuilder builder = new StringBuilder();
		
		for (Name n : name)
		{
			builder.append(n.getName()).append(c);
		}
		
		return builder.toString();
	}

	public String toFs()
	{
		return collect('/');
	}
}
