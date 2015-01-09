package poc.ide.proj;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import poc.ide.code.CodeTree;
import poc.ide.code.Type;

public class CodeSet
{
	private Set<CodeTree> allCode;
	
	public CodeSet()
	{
		allCode = new HashSet<CodeTree>();
	}
	
	public void add(CodeTree code)
	{
		if (!allCode.contains(code))
		{
			allCode.add(code);
		}
	}
	
	public List<CodeTree> search(Type t, CodeTree scope)
	{
		List<CodeTree> list = new LinkedList<CodeTree>();
		
		return list;
	}

	public void clear()
	{
		allCode.clear();
	}

	public TreeSet<CodeTree> filter(CodeFilter filter)
	{
		TreeSet<CodeTree> set = new TreeSet<CodeTree>();
		
		for (CodeTree tree : allCode)
		{
			if (filter.accept(tree))
			{
				set.add(tree);
			}
		}
		
		return set;
	}

	public <T extends CodeTree> TreeSet<T> filter(CodeFilter filter, Class<T> c)
	{
		TreeSet<T> set = new TreeSet<T>();
		
		for (CodeTree tree : allCode)
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
		public boolean accept(CodeTree tree);
	}
}
