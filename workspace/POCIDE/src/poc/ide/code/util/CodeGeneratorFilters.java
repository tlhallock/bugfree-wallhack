package poc.ide.code.util;

import java.util.LinkedList;
import java.util.List;

import poc.ide.code.Code;
import poc.ide.code.util.CodeGenerators.CodeGenerator;

public class CodeGeneratorFilters
{
	public interface CodeGeneratorFilter
	{
		boolean accept(CodeGenerator<? extends Code> gen);
	}
	
	public static <T extends Code> CodeGeneratorFilter getTypeFilter(final T t)
	{
		return new CodeGeneratorFilter()
		{
			@Override
			public boolean accept(CodeGenerator<? extends Code> gen)
			{
				return gen.getClass().isAssignableFrom(t.getClass());
			}
		};
	}

	public static final class OrFilter implements CodeGeneratorFilter
	{
		private List<CodeGeneratorFilter> filters;
		
		public OrFilter()
		{
			filters = new LinkedList<>();
		}
		
		public void add(CodeGeneratorFilter filter)
		{
			filters.add(filter);
		}
		
		@Override
		public boolean accept(CodeGenerator<? extends Code> gen)
		{
			for (CodeGeneratorFilter filter : filters)
			{
				if (filter.accept(gen))
				{
					return true;
				}
			}
			return false;
		}
	}
	
	public static final class AndFilter implements CodeGeneratorFilter
	{
		private List<CodeGeneratorFilter> filters;
		
		public AndFilter()
		{
			filters = new LinkedList<>();
		}

		public void add(CodeGeneratorFilter filter)
		{
			filters.add(filter);
		}
		
		@Override
		public boolean accept(CodeGenerator<? extends Code> gen)
		{
			for (CodeGeneratorFilter filter : filters)
			{
				if (!filter.accept(gen))
				{
					return false;
				}
			}
			return true;
		}
	}
	
	public static final CodeGeneratorFilter ANYTHING_FILTER = new CodeGeneratorFilter()
	{
		@Override
		public boolean accept(CodeGenerator<? extends Code> gen)
		{
			return true;
		}
	};
	
	public static final CodeGeneratorFilter NOTHING_FILTER = new CodeGeneratorFilter()
	{
		@Override
		public boolean accept(CodeGenerator<? extends Code> gen)
		{
			return false;
		}
	};
	
}
