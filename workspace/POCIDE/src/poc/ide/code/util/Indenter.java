package poc.ide.code.util;

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
