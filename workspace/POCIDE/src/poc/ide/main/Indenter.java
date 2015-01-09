package poc.ide.main;

public class Indenter
{
	public static StringBuilder indent(StringBuilder builder, int n)
	{
		for (int i = 0; i < n; i++)
		{
			builder.append('\t');
		}
		return builder;
	}

}
