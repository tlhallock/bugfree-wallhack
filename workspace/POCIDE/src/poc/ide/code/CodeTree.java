package poc.ide.code;

import java.util.LinkedList;
import java.util.List;

import poc.ide.gui.InputMethod;
import poc.ide.gui.Viewer;

public abstract class CodeTree implements Comparable<CodeTree>
{
	private List<Viewer> viewers;
	private CodeTree parent;
	
	private String comment;
	
	// something about the FsSource...
	
	public CodeTree()
	{
		this.viewers = new LinkedList<Viewer>();
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
	
	public CodeTree(CodeTree parent)
	{
		this();
		this.parent = parent;
	}
	
	void setParent(CodeTree parent)
	{
		this.parent = parent;
	}

	public void addViewer(Viewer viewer)
	{
		viewers.add(viewer);
	}

	public void removeViewer(Viewer viewer)
	{
		viewers.remove(viewer);
	}
	
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		appendText(builder, 0);
		
		return builder.toString();
	}
	
	
	public void changed()
	{
		if (parent != null)
		{
			parent.changed();
		}
		for (Viewer viewer : viewers)
		{
			viewer.show(this);
		}
	}
	

	public void updateParameter(String label, Object value)
	{
		setParameter(label, value);
		changed();
	}

	public abstract StringBuilder appendText(StringBuilder builder, int depth);
	
	protected void setParameter(String label, Object value) {};
	
//	public abstract void appendInputs(List<InputMethod<? extends CodeTree>> list);
	public abstract List<InputMethod<? extends CodeTree>> getInputs();
	
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
}
