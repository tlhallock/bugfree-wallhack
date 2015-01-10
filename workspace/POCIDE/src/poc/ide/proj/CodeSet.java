package poc.ide.proj;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import poc.ide.code.Code;
import poc.ide.code.Type;

public class CodeSet
{
	private Set<Code> allCode;
	
	public CodeSet()
	{
		allCode = new HashSet<Code>();
	}
	
	public void add(Code code)
	{
		if (!allCode.contains(code))
		{
			allCode.add(code);
		}
	}
	
	public List<Code> search(Type t, Code scope)
	{
		List<Code> list = new LinkedList<Code>();
		
		return list;
	}

	public void clear()
	{
		allCode.clear();
	}

	public TreeSet<Code> filter(CodeFilter filter)
	{
		TreeSet<Code> set = new TreeSet<Code>();
		
		for (Code tree : allCode)
		{
			if (filter.accept(tree))
			{
				set.add(tree);
			}
		}
		
		return set;
	}

	public <T extends Code> TreeSet<T> filter(CodeFilter filter, Class<T> c)
	{
		TreeSet<T> set = new TreeSet<T>();
		
		for (Code tree : allCode)
		{
			if (!tree.getClass().isAssignableFrom(c))
			{
				continue;
			}
			if (!filter.accept(tree))
			{
				continue;
			}
			set.add((T) tree);
		}
		
		return set;
	}
	
	public interface CodeFilter
	{
		public boolean accept(Code tree);
	}
}
