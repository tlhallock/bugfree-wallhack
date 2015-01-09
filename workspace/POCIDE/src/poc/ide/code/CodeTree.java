package poc.ide.code;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

import poc.ide.gui.InputMethod;
import poc.ide.main.TreeStructure;

public abstract class CodeTree extends Observable implements Comparable<CodeTree>, TreeStructure<CodeTree> 
{
	private CodeTree parent;
	
	private List<CodeTree> children = new LinkedList<>();
	
	private Comment comment;
	
	// something about the FsSource...

	public CodeTree(CodeTree parent)
	{
		setParent(parent);
	}
	
	void setParent(CodeTree parent)
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
	
	public CodeTree getParent()
	{
		return parent;
	}
	
	public Collection<CodeTree> getChildren()
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
	
	
	public boolean canAccess(CodeTree other)
	{
		return true;
	}
	
	
	
	
	
	
	public int hashCode()
	{
		return getUniqueNamespaceToken().hashCode();
	}
	
	public int compareTo(CodeTree o)
	{
		return getUniqueNamespaceToken().compareTo(((CodeTree) o).getUniqueNamespaceToken());
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof CodeTree))
		{
			return false;
		}

		return compareTo((CodeTree) o) < 0;
	}
	

//	public abstract void appendInputs(List<InputMethod<? extends CodeTree>> list);
	public abstract List<InputMethod<? extends CodeTree>> getInputs();
	public abstract StringBuilder appendText(StringBuilder builder, int depth);
}
