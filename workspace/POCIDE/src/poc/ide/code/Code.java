package poc.ide.code;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import poc.ide.code.util.CodeGeneratorFilters;
import poc.ide.code.util.Observable;
import poc.ide.code.util.TreeStructure;
import poc.ide.code.util.CodeGeneratorFilters.CodeGeneratorFilter;
import poc.ide.gui.InputMethod;

public abstract class Code extends Observable implements Comparable<Code>, TreeStructure<Code> 
{
	@JsonIgnore 
	private Code parent;
	
	@JsonIgnore
	private List<Code> children = new LinkedList<>();
	
	private Comment comment;
	
	// something about the FsSource...

	public Code(Code parent)
	{
		setParent(parent);
	}
	
	void setParent(Code parent)
	{
		if (this.parent != null)
		{
			this.parent.getChildren().remove(this);
		}
		
		this.parent = parent;

		if (this.parent != null)
		{
			this.parent.getChildren().add(this);
		}
	}
	
	public Code getParent()
	{
		return parent;
	}
	
	public Collection<Code> getChildren()
	{
		return children;
	}
	
	
	
	
	
	public final String getNameSpaceUniqueKey()
	{
		return getUniqueNameSpaceKey(new StringBuilder()).toString();
	}
	
	public StringBuilder getUniqueNameSpaceKey(StringBuilder builder)
	{
		if (parent != null)
		{
			parent.getUniqueNameSpaceKey(builder);
		}
		return builder.append(getUniqueNamespaceToken());
	}
	
	public String getUniqueNamespaceToken() { return ""; }
	
	
	
	
	
	
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		appendText(builder, 0);
		
		return builder.toString();
	}
	
	
	public boolean canAccess(Code other)
	{
		return true;
	}
	
	
	
	
	
	
	public int hashCode()
	{
		return getUniqueNamespaceToken().hashCode();
	}
	
	public int compareTo(Code o)
	{
		return getUniqueNamespaceToken().compareTo(((Code) o).getUniqueNamespaceToken());
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof Code))
		{
			return false;
		}

		return compareTo((Code) o) < 0;
	}
	
	public CodeGeneratorFilter getFilter(Code prev)
	{
		return CodeGeneratorFilters.ANYTHING_FILTER;
	}
	
	public void newCodeAdded(Code prev, Code newCode)
	{
		throw new RuntimeException("Inserting code into " + getClass().getName() + " not implemented.");
	}
	
	public void save() throws IOException
	{
		CompilationUnit compilationUnit = getCompilationUnit();
		if (compilationUnit != null)
		{
			compilationUnit.save();
		}
	}
	
	public CompilationUnit getCompilationUnit()
	{
		Code tree = this;
		while (tree != null)
		{
			if (tree instanceof CompilationUnit)
			{
				return (CompilationUnit) tree;
			}
			
			tree = tree.getParent();
		}
		return null;
	}

//	public abstract void appendInputs(List<InputMethod<? extends CodeTree>> list);
	public abstract List<InputMethod<? extends Code>> getInputs();
	public abstract StringBuilder appendText(StringBuilder builder, int depth);
}
