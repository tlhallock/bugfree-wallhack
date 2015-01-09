package poc.ide.main;

import java.util.Collection;

public interface TreeStructure<T>
{
	T getParent();
	Collection<T> getChildren();
}